#!/usr/bin/env python

__author__ = 's.novgorodcev'
import os
import re
from xml.dom.minidom import getDOMImplementation
from datetime import datetime

JAVA_HPROF_FILE_NAME = "java.hprof.txt"

def create_site(rank, percent_self, percent_accum, live_bytes, live_objs, allocated_bytes, allocated_objs, stack_trace,
                class_name):
    site = memory_usage_doc.createElement("site")
    site.setAttribute('rank', rank)
    site.setAttribute('percent_self', percent_self)
    site.setAttribute('percent_accum', percent_accum)
    site.setAttribute('live_bytes', live_bytes)
    site.setAttribute('live_objs', live_objs)
    site.setAttribute('allocated_bytes', allocated_bytes)
    site.setAttribute('allocated_objs', allocated_objs)
    site.setAttribute('stack_trace', stack_trace)
    site.setAttribute('class_name', class_name)
    return site


def runTest(class_name):
    print str.format("test \"{}\" is starting", class_name)

    memory_usage = memory_usage_doc.documentElement
    test = memory_usage_doc.createElement("test")
    test.setAttribute("class_name", class_name)
    test.setAttribute("time", datetime.now().isoformat())
    memory_usage.appendChild(test)

    os.system("java -agentlib:hprof=heap=sites -cp " +
              "memory-usage-benchmarks/target/memory-usage-benchmarks-1.0-SNAPSHOT-jar-with-dependencies.jar " +
              class_name)

    sites = memory_usage_doc.createElement("sites")
    test.appendChild(sites)

    f = open(JAVA_HPROF_FILE_NAME, 'r')
    m = re.search(r'\b\s*rank\s*self\s*accum\s*bytes\s*objs\s*bytes\s*objs\s*trace\s*name\b(.+)\bSITES END\b', f.read(),
                  re.DOTALL)
    table = m.group(1)

    for m in re.finditer(r'\b\s*(\d+)\s*(\d+,\d+%)\s*(\d+,\d+%)\s*(\d+)\s*(\d+)\s*(\d+)\s*(\d+)\s*(\d+)\s*(.+)\s*\b',
                         table):
        sites.appendChild(create_site(m.group(1), m.group(2), m.group(3), m.group(4), m.group(5), m.group(6),
                                      m.group(7), m.group(8), m.group(9)))


os.system("ant")
os.system("mvn install:install-file -Dfile=./build/pack/lib/scala-library.jar -DgroupId=com.softage " +
          "-DartifactId=scala-library -Dversion=2.11.SNAPSHOT -Dpackaging=jar")
os.chdir("./memory-usage-benchmarks")
os.system("mvn -U clean install")
os.chdir("..")

memory_usage_doc = getDOMImplementation().createDocument(None, "memory-usage", None)

runTest("ManyOldMutableSets")
runTest("ManyNewMutableSets")
runTest("BigOldMutableSet")
runTest("BigNewMutableSet")

os.remove(JAVA_HPROF_FILE_NAME)

with open("memory-usage-output.xml", "w") as f:
    f.write(memory_usage_doc.toprettyxml())