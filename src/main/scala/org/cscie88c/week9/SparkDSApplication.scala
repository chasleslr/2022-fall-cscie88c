package org.cscie88c.week9

import org.apache.spark.sql.{Dataset, Encoder, Encoders, SparkSession}
import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.api.java.function.ReduceFunction
import org.cscie88c.config.ConfigUtils
import org.cscie88c.utils.SparkUtils
import pureconfig.generic.auto._


case class SparkDSConfig(name: String, masterUrl: String, transactionFile: String)


object SparkDSApplication {

  val SPARK_DS_CONFIG_PATH = "org.cscie88c.spark-ds-application"

  // application main entry point
  def main(args: Array[String]): Unit = {
    implicit val conf:SparkDSConfig = readConfig()
    val spark = SparkUtils.sparkSession(conf.name, conf.masterUrl)
    val transactionDS = loadData(spark)

    val totalsByCategoryDS = transactionTotalsByCategory(spark,transactionDS)
    printTransactionTotalsByCategory(totalsByCategoryDS)
    spark.stop()
  }

  def readConfig(): SparkDSConfig = {
    ConfigUtils.loadAppConfig[SparkDSConfig](SPARK_DS_CONFIG_PATH)
  }
  
  def loadData(spark: SparkSession)(implicit conf: SparkDSConfig): Dataset[CustomerTransaction] = {
    import spark.implicits._

    spark
      .read
      .schema(Encoders.product[CustomerTransaction].schema)
      .format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(conf.transactionFile)
      .as[CustomerTransaction]
  }

  def transactionTotalsByCategory(spark: SparkSession, transactions: Dataset[CustomerTransaction]): Dataset[(String, Double)] = {
    import spark.implicits._
    transactions
      .map(f => (f.transactionCategory, f.transactionAmount))
      .groupByKey(c => c._1)
      .reduceGroups((a, b) => (a._1, a._2 + b._2))
      .map(_._2)
  }

  def printTransactionTotalsByCategory(ds: Dataset[(String, Double)]): Unit = {
    ds.foreach(println)
  }
}
