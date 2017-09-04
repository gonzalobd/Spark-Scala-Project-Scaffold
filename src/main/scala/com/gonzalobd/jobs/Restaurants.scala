package com.gonzalobd.jobs

import com.gonzalobd.starter.StartJob
import com.gonzalobd.utils.SparkSessionLoader
import org.apache.spark.sql.{DataFrame, SparkSession}


/**
  * Created by gbautista on 4/09/17.
  */
object Restaurants extends StartJob {

  override def startJob(df: DataFrame,ss:SparkSession) = {

    println(df.printSchema())

    import ss.implicits._
    import org.apache.spark.sql.functions.explode

    // For example, we can search a Pizza restaurant in Queens
    // grades column is an Array with all grades. We explode it, extract the score and sort by value to get the best restaurants

    df.where(df("borough")==="Queens" && df("cuisine")==="Pizza")
      .withColumn("grades",explode($"grades"))
      .withColumn("score",$"grades".getItem("score"))
      .sort($"score".desc).
      show

  }

}
