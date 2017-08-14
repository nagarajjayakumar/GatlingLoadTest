package com.hortonworks.gc.gatling.simulations

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import scala.collection.JavaConverters._


object LivyRestClient {


  private val BATCH_TYPE = "batches"
  private val INTERACTIVE_TYPE = "sessions"

  object AppInfo {
    val DRIVER_LOG_URL_NAME = "driverLogUrl"
    val SPARK_UI_URL_NAME = "sparkUiUrl"
  }

  case class AppInfo(var driverLogUrl: Option[String] = None, var sparkUiUrl: Option[String] = None) {
    import AppInfo._
    def asJavaMap: java.util.Map[String, String] =
      Map(DRIVER_LOG_URL_NAME -> driverLogUrl.orNull, SPARK_UI_URL_NAME -> sparkUiUrl.orNull).asJava
  }

  // TODO Define these in production code and share them with test code.
  @JsonIgnoreProperties(ignoreUnknown = true)
  case class StatementResult(id: Int, state: String, output: Map[String, Any])

  @JsonIgnoreProperties(ignoreUnknown = true)
  case class StatementError(ename: String, evalue: String, stackTrace: Seq[String])

  @JsonIgnoreProperties(ignoreUnknown = true)
  case class SessionSnapshot(
                              id: Int,
                              appId: Option[String],
                              state: String,
                              appInfo: AppInfo,
                              log: IndexedSeq[String])


}
