package com.hortonworks.gc.gatling.simulations

import java.util.concurrent.{Executors, TimeUnit}
import javax.servlet.http.HttpServletResponse

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.ObjectMapper
import com.ning.http.client.{AsyncHttpClient, AsyncHttpClientConfig, Response}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

import scala.concurrent.duration._
import scala.collection.JavaConverters._
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.util.{Either, Left, Random, Right}
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.hortonworks.gc.gatling.simulations.LivyRestClient.StatementResult

class InteractiveSparkCommandSimulation extends Simulation {
  /* Place for arbitrary Scala code that is to be executed before the simulation begins. */

  val mapper = new ObjectMapper()
    .registerModule(DefaultScalaModule)

  val executorService = Executors.newFixedThreadPool(10)

  val httpClientConfig =
    new AsyncHttpClientConfig.Builder()
      .setConnectTimeout(5 * 60 * 1000)
      .setReadTimeout(5 * 60 * 1000)
      .setWebSocketTimeout(5 * 60 * 1000)
      .setRequestTimeout(10 * 60 * 1000)
      .setPooledConnectionIdleTimeout(10 * 60 * 1000)
      .setExecutorService(executorService)
      .setMaxConnections(10)
      .build()

  val httpClient: AsyncHttpClient = new AsyncHttpClient(httpClientConfig)

  val url = "http://127.0.0.1:8080"

  val numOfContainer = 3

  var getAllIdleLivySessionIds :List [Int] = List (79,80,81)
  val rnd = new Random

  before {
    /*println("***** My simulation is about to begin! *****")

    println(httpClient.getConfig.getConnectTimeout)
    println(httpClient.getConfig.getRequestTimeout)
    println(httpClient.getConfig.get)

    val createContainerResp = httpClient
      .prepareGet(s"$url/createLivyContainer/$numOfContainer")
      .addHeader("Content-type", "application/json")
      .addHeader("X-Requested-By", "spark")
      .execute()
      .get()

    assertStatusCode(createContainerResp, HttpServletResponse.SC_OK)

    val createContainer =
      mapper.readValue(createContainerResp.getResponseBodyAsStream,
                       classOf[String])

    println(createContainer)

    println("Going to Sleep for 1 min")
    Thread sleep 1000 * 60 * 1
    println("Done Sleeping .. work to do !!!")

    val getAllIdleLivySessionIdsResp = httpClient
      .prepareGet(s"$url/getAllIdleLivySessionIds")
      .addHeader("Content-type", "application/json")
      .addHeader("X-Requested-By", "spark")
      .execute()
      .get()

    assertStatusCode(getAllIdleLivySessionIdsResp, HttpServletResponse.SC_OK)

    getAllIdleLivySessionIds =
      mapper.readValue(getAllIdleLivySessionIdsResp.getResponseBodyAsStream,
                       classOf[List[Int]])

    println(getAllIdleLivySessionIds)

    getAllIdleLivySessionIds.foreach(sessionId => {

      println("About to Import Init statements for Session ID "+ sessionId)

      val initLivySessionIdsResp = httpClient
        .prepareGet(s"$url/initSession?sessionId=$sessionId")
        .addHeader("Content-type", "application/json")
        .addHeader("X-Requested-By", "spark")
        .execute()
        .get()

      assertStatusCode(initLivySessionIdsResp, HttpServletResponse.SC_OK)
      val initLivySessionOutput =
        mapper.readValue(initLivySessionIdsResp.getResponseBodyAsStream,
                         classOf[String])
      Thread sleep 1000 * 30 * 1
      println(initLivySessionOutput + s"Session ID $sessionId")

    })
    */

  }

  /* Place for arbitrary Scala code that is to be executed after the simulation has ended. */
  after {
    println("***** My simulation has ended! ******")
  }

  /*
   * A HTTP protocol builder is used to specify common properties of request(s) to be sent,
   * for instance the base URL, HTTP headers that are to be enclosed with all requests etc.
   */
  val theHttpProtocolBuilder = http
    .baseURL(url)


  /*
   * A scenario consists of one or more requests. For instance logging into a e-commerce
   * website, placing an order and then logging out.
   * One simulation can contain many scenarios.
   */
  /* Scenario1 is a name that describes the scenario. */

  val randomElementFeeder =
    Iterator.continually(Map("sessionId" -> getRandomElement(getAllIdleLivySessionIds, rnd)))

  def getRandomElement(list: List[Int], random: Random): Int =
    list(random.nextInt(list.length))

  val theScenarioBuilder =
    scenario("Interactive Spark Command Scenario Using LIVY Rest Services")
      .feed(randomElementFeeder)
      .exec(
        /* myRequest1 is a name that describes the request. */
        http("Interactive Spark Command Simulation")
          .get("/insrun?sessionId=${sessionId}&statement=dataFrame.show(5)")
      )


  private def assertStatusCode(r: Response, expected: Int): Unit = {
    def pretty(r: Response): String = {
      s"${r.getStatusCode} ${r.getResponseBody}"
    }
    assert(r.getStatusCode() == expected,
      s"HTTP status code != $expected: ${pretty(r)}")
  }

  /*
   * Define the load simulation.
   * Here we can specify how many users we want to simulate, if the number of users is to increase
   * gradually or if all the simulated users are to start sending requests at once etc.
   * We also specify the HTTP protocol builder to be used by the load simulation.
   */
  setUp(
    theScenarioBuilder.inject(atOnceUsers(4))
  ).protocols(theHttpProtocolBuilder)
}
