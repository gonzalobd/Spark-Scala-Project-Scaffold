# Spark-Scala-Project-Scaffold

This is a template project for Spark jobs with Scala. Including an acceptance tests module with a dockerized spark cluster

It uses separate classes for start the spark session, load the config file and create dataframes from json files.
Includes one example job reading a json file with the list of all NYC restaurants

You can add new jobs in com.gonzalobd.jobs and override startJob function

To run your job just generate the jar and include it in the spark-submit with the application.conf as the first argument
You can find the application.conf in src/main/resources

```
/Spark-Scala-Project-Structure$ mvn clean package
$SPARK_HOME/bin/spark-submit --class com.gonzalobd.jobs.Restaurants /path-to-jar /path-to/application.conf 
 ```

## Versions: 

Tested with versions:
* Java 1.8.0_252
* Scala 2.11.8
* Docker version 20.10.5, build 55c4c88 
* docker-compose version 1.28.5, build c4eb3a1f

### IMPORTANT
For running testAT is required docker and docker-compose executables accessible without sudo 

