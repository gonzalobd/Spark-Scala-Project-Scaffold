package com.gonzalobd.utils

import org.apache.spark.sql.{DataFrame}

/**
  * Created by gbautista on 1/09/17.
  */
class DataFrameSaver(df:DataFrame){

  def saveDataFrame(path:String, format:String): Unit  ={
    val writer = df.write
    format.toLowerCase match {
      case "csv" => writer.csv(path)
      case "json" => writer.json(path)
      case "text" => writer.text(path)
      case "parquet" => writer.text(path)
    }
  }

}
