package com.lightbend.akkassembly

import akka.NotUsed
import akka.stream.scaladsl.{Flow, Source}

import scala.concurrent.Future

class PaintShop(colorSet: Set[Color]) {

  val colors : Source[Color, NotUsed] = Source.cycle(() => colorSet.iterator)

  val paint : Flow[UnfinishedCar, UnfinishedCar, NotUsed] = {
    Flow[UnfinishedCar].zip(colors).map(i => i._1.paint(i._2))
  }
}
