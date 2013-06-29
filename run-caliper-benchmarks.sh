git fetch origin
git checkout origin/new-hashset-impl
ant
mvn install:install-file -Dfile=./build/pack/lib/scala-library.jar -DgroupId=com.softage -DartifactId=scala-library -Dversion=2.11.SNAPSHOT -Dpackaging=jar
cd ./caliper_benchmarks
mvn -U clean install
