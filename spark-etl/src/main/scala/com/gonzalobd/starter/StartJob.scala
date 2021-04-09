package com.gonzalobd.starter

import com.gonzalobd.utils.{ConfigLoader, DataFrameLoader, DataFrameSaver, SparkSessionLoader}
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * Created by gbautista on 4/09/17.
  */
trait StartJob {

  def runETL(df:DataFrame, ss:SparkSession): DataFrame

  def main(args: Array[String]): Unit = {

    // First we load config file from the first args
    val confLoader = new ConfigLoader
    val config= confLoader.loadConfig(args(0))
    val options = config.getConfig("options")
    val master = options.getString("master")
    val inputPath = options.getString("input_path")
    val inputFormat = options.getString("input_format")
    val outPath = options.getString("output_path")
    val outFormat = options.getString("output_format")

    // Now we initialize a sparkSession
    val sp = new SparkSessionLoader
    val spark = sp.loadSparkSession(master)

    // with the sparkSession we load a Dataframe from a json specified in config file
    val dataFrameLoader = new DataFrameLoader(spark)
    val df = dataFrameLoader.loadDataFrame(inputPath, inputFormat)
    val dfOut = runETL(df, spark)
    val dataFrameSaver = new DataFrameSaver(dfOut)
    dataFrameSaver.saveDataFrame(outPath, outFormat)
  }
}
