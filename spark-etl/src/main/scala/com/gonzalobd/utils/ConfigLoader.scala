package com.gonzalobd.utils

/**
  * Created by gbautista on 1/09/17.
  */

import java.io.File

import com.typesafe.config.{Config, ConfigFactory}

class ConfigLoader {

  def loadConfig(args:String): Config ={
    ConfigFactory.parseFile(new File(args))
  }
}
