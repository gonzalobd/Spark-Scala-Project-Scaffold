package com.gonzalobd.utils

import org.apache.spark.sql.{Dataset, Row, SparkSession}
/**
  * Created by gbautista on 1/09/17.
  */
class DataFrameLoader (){

  def loadJson(sp:SparkSession, path:String): Dataset[Row]   ={

    val df = sp.read.json(path)
    df
  }

}
