package com.gonzalobd

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith
import org.junit.{AfterClass, BeforeClass}

import scala.sys.process._

object CucumberMain {

  @BeforeClass
  def startDockerCompose : Unit = {
    val startClusterScriptPath = ClassLoader.getSystemResource("dockercompose/start-cluster.sh").getPath
    "chmod +x " + startClusterScriptPath.!
    startClusterScriptPath.!
  }

  @AfterClass
  def stopDockerCompose : Unit = {
    val stopClusterScriptPath = ClassLoader.getSystemResource("dockercompose/stop-cluster.sh").getPath
    "chmod +x " + stopClusterScriptPath.!
    stopClusterScriptPath.!
  }

}

@RunWith(classOf[Cucumber])
@CucumberOptions(features = Array(
  "src/test/resources/features/spark.feature"
),
  plugin = Array(
    "pretty"
  ),
  tags = Array("~@ignore")
)
class CucumberMain
