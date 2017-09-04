package com.gonzalobd.starter

import com.gonzalobd.utils.{ConfigLoader, DataFrameLoader, SparkSessionLoader}
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * Created by gbautista on 4/09/17.
  */
trait StartJob {

  def startJob(df:DataFrame,ss:SparkSession): Unit

  def main(args: Array[String]): Unit = {

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

    startJob(df,spark)



  }


}
