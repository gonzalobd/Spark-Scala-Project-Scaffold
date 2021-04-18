package com.gonzalobd

import cucumber.api.scala.{EN, ScalaDsl}
import scala.sys.process._

class Steps extends  ScalaDsl with EN{

  var configFile: String = _
  val SPARK_HOME = "/usr/spark-2.2.1"

  Given("""^a config file (.*)$""") {
    (configFile: String) =>
      this.configFile = configFile
  }

  When("""^execute in spark$""") {
    () =>
      val command = s"$SPARK_HOME/bin/spark-submit --class com.gonzalobd.jobs.Restaurants  --master spark://master:7077 /spark-etl-*-jar-with-dependencies.jar /" + configFile
      val sparkSubmit = Seq("docker", "exec", "-i", "spark_master", "sh", "-c", command).!
      sparkSubmit

  }


  Then("""^should produce an output in (.*)$""") {
    (pathOutput: String) =>
    true
  }

}

