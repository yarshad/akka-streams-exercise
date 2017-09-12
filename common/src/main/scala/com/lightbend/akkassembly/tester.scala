package com.lightbend.akkassembly

import akka.stream.scaladsl.Source

import scala.collection.immutable.Seq

object tester extends App {


  val completeCar = UnfinishedCar(
    color = Some(Color("000000")),
    engine = Some(Engine()),
    wheels = Seq.fill(4)(Wheel())
  )
  val incompleteCar = UnfinishedCar()

  val cars = Seq(completeCar, completeCar, incompleteCar, completeCar)

  var result = cars.collect{
    case c if c.color != None => c
  }

  println(result)


}
