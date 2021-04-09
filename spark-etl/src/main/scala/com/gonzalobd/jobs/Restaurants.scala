package com.gonzalobd.jobs

import com.gonzalobd.starter.StartJob
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.explode


/**
  * Created by gbautista on 4/09/17.
  */
object Restaurants extends StartJob {

  override def runETL(df: DataFrame, ss:SparkSession): DataFrame = {
    import ss.implicits._
    /**
     * For example, we want a great Pizza place in Queens!
     * Grades column is an Array with all grades. We explode it, extract the score and sort by value to get the best restaurants
     */

    df.where(df("borough")==="Queens" && df("cuisine")==="Pizza")
      .withColumn("grades",explode($"grades"))
      .withColumn("score",$"grades".getItem("score"))
      .drop("grades")
      .drop("address")
      .sort($"score".desc)
  }
}
