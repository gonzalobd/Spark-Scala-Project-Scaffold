package com.gonzalobd.utils

/**
  * Created by gbautista on 1/09/17.
  */

import org.apache.spark.sql.SparkSession

class SparkSessionLoader {

  def loadSparkSession(master:String): SparkSession ={

    SparkSession.builder()
      .master(master)
      .appName("DataFrame Example")
      .getOrCreate()

  }



}
