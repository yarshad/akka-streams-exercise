package com.lightbend.akkassembly

import akka.NotUsed
import akka.stream.scaladsl.Source

class WheelShop {

  val wheels : Source[Wheel,NotUsed] = Source.repeat(Wheel())
}
