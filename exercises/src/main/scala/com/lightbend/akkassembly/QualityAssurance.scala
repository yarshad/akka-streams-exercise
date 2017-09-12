package com.lightbend.akkassembly

import akka.NotUsed
import akka.stream.scaladsl.Flow

class QualityAssurance {

val inspect : Flow[UnfinishedCar, Car, NotUsed] =

  Flow[UnfinishedCar].collect{
    case x if (x.engine !=None && !x.wheels.isEmpty && x.color != None) =>
      Car(SerialNumber(),x.color.get,x.engine.get,x.wheels,None)
  }
}
