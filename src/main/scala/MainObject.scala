/**
  * Created by gbautista on 1/09/17.
  */

import com.gonzalobd.utils.{ConfigLoader, DataFrameLoader, SparkSessionLoader}

object MainObject {

  def main (args:Array[String]):Unit ={

    // First we load config file from the first args
    val confLoader = new ConfigLoader
    val config= confLoader.loadConfig(args(0))
    val master = config.getConfig("options").getString("master")
    val jsonPath = config.getConfig("options").getString("input_path")

    // Now we initialize a sparkSession
    val sp = new SparkSessionLoader
    val spark = sp.loadSparkSession(master)

    // with the sparkSession we load a Dataframe from a json specified in config file
    val dataFrame = new DataFrameLoader
    val df = dataFrame.loadJson(spark,jsonPath)



    println(df.printSchema())

    import spark.implicits._
    import org.apache.spark.sql.functions.explode

    // For example, we can search a Pizza restaurant in Queens
    // grades column is an Array with all grades. We explode it, extract the score and sort by value to get the best restaurants

    println(df.where(df("borough")==="Queens" && df("cuisine")==="Pizza")
      .withColumn("grades",explode($"grades"))
      .withColumn("score",$"grades".getItem("score"))
      .sort($"score".desc).
      show)



  }

}
