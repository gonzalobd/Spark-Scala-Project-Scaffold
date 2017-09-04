# Spark-Scala-Project-Structure

This is a template project for Spark jobs with Scala.

It uses separate classes for start the spark session, load the config file and create dataframes from json files.

Includes one example job in the Main class reading a json file with the list of all NYC restaurants

You can add new jobs in com.gonzalobd.jobs and override startJob function

To run your job just generate the jar and include it in the spark-submit with the application.conf as the first argument
You can find the application.conf in src/main/resources

```
/Spark-Scala-Project-Structure$ mvn clean package
$SPARK_HOME/bin/spark-submit --class com.gonzalobd.jobs.Restaurants /path-to-jar /path-to/application.conf 
 ```

### Note: 
Use spark v2.0.0 or higher (The job is using SparkSession as entry point)