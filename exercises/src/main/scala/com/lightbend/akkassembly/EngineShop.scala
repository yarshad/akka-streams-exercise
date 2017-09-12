package com.lightbend.akkassembly

import akka.NotUsed
import akka.stream.scaladsl.{Flow, Source}

import scala.collection.immutable._

class EngineShop(shipmentSize: Int) {

  def shipment = Seq.fill(shipmentSize)(Engine())

  val shipments : Source[Shipment, NotUsed] = Source.fromIterator{

    () => Iterator.continually{Shipment(shipment)}
  }

  val engines : Source[Engine, NotUsed] = shipments.flatMapConcat(i => Source(i.engines))

  val installEngine: Flow[UnfinishedCar, UnfinishedCar, NotUsed]=
    Flow[UnfinishedCar].zip(engines).map(p => p._1.installEngine(p._2))
}
