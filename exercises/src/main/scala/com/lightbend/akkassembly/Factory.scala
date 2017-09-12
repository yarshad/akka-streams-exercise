package com.lightbend.akkassembly

import akka.stream.Materializer
import akka.stream.scaladsl.Sink

import scala.concurrent.Future

class Factory(bodyShop: BodyShop,
               paintShop: PaintShop,
               engineShop: EngineShop,
               wheelShop: WheelShop,
               qualityAssurance: QualityAssurance)(implicit materializer: Materializer) {

  def orderCars(quantity : Int): Future[Seq[Car]]={

     val cars = bodyShop.cars
     val engines = engineShop.engines

    val completedOrder =
      cars.zip(engines).map(c => c._1.installEngine(c._2))
        .via(paintShop.paint)
      .via(wheelShop.installWheels)
      .via(qualityAssurance.inspect)
      .take(quantity).runWith(Sink.seq)

    completedOrder
  }



}
