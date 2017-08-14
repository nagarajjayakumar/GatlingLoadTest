package com.hortonworks.gc.gatling.simulations

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object InteractiveSparkCommandSimulationRunner {

  def main(args: Array[String]) {


    // This sets the class for the simulation we want to run.
    val simClass = classOf[InteractiveSparkCommandSimulation].getName

    val props = new GatlingPropertiesBuilder
    props.sourcesDirectory("./src/main/scala")
    props.binariesDirectory("./target/scala-2.11/classes")
    props.simulationClass(simClass)
    props.runDescription("InteractiveSparkCommandSimulation")
    props.outputDirectoryBaseName("InteractiveSparkCommandSimulationID")
    Gatling.fromMap(props.build)

  }

}
