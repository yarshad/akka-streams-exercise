package com.lightbend.akkassembly

import akka.NotUsed
import akka.stream.scaladsl.Source

class EngineShop(shipmentSize: Int) {

  val shipments : Source[Shipment, NotUsed] = Source.fromIterator{
    val z = Iterator.continually(() => Iterator.fill(shipmentSize))
  }

}
