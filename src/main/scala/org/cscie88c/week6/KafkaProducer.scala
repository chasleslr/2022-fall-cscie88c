package org.cscie88c.week6

// define trait KafkaProducer below
trait KafkaProducer {
  def send(message: String): String
}

// define the companion object KafkaProducer below
object KafkaProducer {
  implicit val defaultKafkaProducer = SimpleKafkaProducer("default-topic")
}

// define the case class SimpleKafkaProducer below
case class SimpleKafkaProducer(topic: String) extends KafkaProducer {
  override def send(message: String): String = {
    s"Sending message '$message' to topic '$topic'"
  }
}

// uncomment the lines below once you have implemented KafkaProducer and SimpleKafkaProducer
object KafkaClient {
  // sends a status message to kafka
  def sendStatusEvent(status: String)(implicit kafkaProducer: KafkaProducer) = {
    kafkaProducer.send(status) // use the implicit KafkaProducer provided
  }
}

