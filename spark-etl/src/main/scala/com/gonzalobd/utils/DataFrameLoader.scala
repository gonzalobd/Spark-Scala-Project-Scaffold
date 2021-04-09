package com.gonzalobd.utils

import org.apache.spark.sql.{Dataset, Row, SparkSession}
/**
  * Created by gbautista on 1/09/17.
  */
class DataFrameLoader(sp:SparkSession){

  def loadDataFrame(path:String, format:String): Dataset[Row]   ={
    val reader = sp.read
    format.toLowerCase match {
      case "csv" => reader.csv(path)
      case "json" => reader.json(path)
      case "text" => reader.text(path)
      case "parquet" => reader.text(path)
    }
  }

}
