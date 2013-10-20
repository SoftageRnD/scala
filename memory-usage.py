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


def create_test_sum(allocated_bytes_sum, allocated_objs_sum, class_name, live_bytes_sum, live_objs_sum, test_time):
    test_sum = memory_usage_doc.createElement("test_sum")
    test_sum.setAttribute("allocated_bytes", str(allocated_bytes_sum))
    test_sum.setAttribute("allocated_objs", str(allocated_objs_sum))
    test_sum.setAttribute("live_bytes", str(live_bytes_sum))
    test_sum.setAttribute("live_objs", str(live_objs_sum))
    test_sum.setAttribute("time", test_time)
    test_sum.setAttribute("class_name", class_name)
    return test_sum


def run_test(class_name):
    print str.format("test \"{}\" is starting", class_name)

    test_time = datetime.now().isoformat()

    test = memory_usage_doc.createElement("test")
    test.setAttribute("class_name", class_name)
    test.setAttribute("time", test_time)
    tests.appendChild(test)

    os.system("java -agentlib:hprof=heap=sites -cp " +
              "memory-usage-benchmarks/target/memory-usage-benchmarks-1.0-SNAPSHOT-jar-with-dependencies.jar " +
              class_name)

    sites = memory_usage_doc.createElement("sites")
    test.appendChild(sites)

    f = open(JAVA_HPROF_FILE_NAME, 'r')
    m = re.search(r'\b\s*rank\s*self\s*accum\s*bytes\s*objs\s*bytes\s*objs\s*trace\s*name\b(.+)\bSITES END\b', f.read(),
                  re.DOTALL)
    table = m.group(1)

    allocated_bytes_sum = 0
    allocated_objs_sum = 0
    live_bytes_sum = 0
    live_objs_sum = 0

    for m in re.finditer(r'\b\s*(\d+)\s*(\d+,\d+%)\s*(\d+,\d+%)\s*(\d+)\s*(\d+)\s*(\d+)\s*(\d+)\s*(\d+)\s*(.+)\s*\b',
                         table):
        live_bytes = m.group(4)
        live_objs = m.group(5)
        allocated_bytes = m.group(6)
        allocated_objs = m.group(7)
        sites.appendChild(create_site(m.group(1), m.group(2), m.group(3), live_bytes, live_objs, allocated_bytes,
                                      allocated_objs, m.group(8), m.group(9)))
        allocated_bytes_sum += int(allocated_bytes)
        allocated_objs_sum += int(allocated_objs)
        live_bytes_sum += int(live_bytes)
        live_objs_sum += int(live_objs)

    tests_sum.appendChild(
        create_test_sum(allocated_bytes_sum, allocated_objs_sum, class_name, live_bytes_sum, live_objs_sum, test_time))

    return test


os.system("ant")
os.system("mvn install:install-file -Dfile=./build/pack/lib/scala-library.jar -DgroupId=com.softage " +
          "-DartifactId=scala-library -Dversion=2.11.SNAPSHOT -Dpackaging=jar")
os.chdir("./memory-usage-benchmarks")
os.system("mvn -U clean install")
os.chdir("..")

memory_usage_doc = getDOMImplementation().createDocument(None, "memory-usage", None)
memory_usage = memory_usage_doc.documentElement

tests_sum = memory_usage_doc.createElement("tests-sum")
memory_usage.appendChild(tests_sum)

tests = memory_usage_doc.createElement("tests")
memory_usage.appendChild(tests)

run_test("ManyOldMutableSets")
run_test("ManyNewMutableSets")
run_test("BigOldMutableSet")
run_test("BigNewMutableSet")

os.remove(JAVA_HPROF_FILE_NAME)

with open("memory-usage-output.xml", "w") as f:
    f.write(memory_usage_doc.toprettyxml())