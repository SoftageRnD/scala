#!/bin/bash

BENCHMARK_LIST=('AddHashSetBenchmark' 'ContainsHashSetBenchmark')

set -e
ant
mvn install:install-file -Dfile=./build/pack/lib/scala-library.jar -DgroupId=com.softage -DartifactId=scala-library -Dversion=2.11.SNAPSHOT -Dpackaging=jar
cd ./caliper_benchmarks
mvn -U clean install

for benchmark in "${BENCHMARK_LIST[@]}"
do
	echo "-- Start benchmark: $benchmark --"
	java -jar target/benchmark-0.0.1-SNAPSHOT-jar-with-dependencies.jar $benchmark -l 0
	echo "-- End benchmark --"
done
