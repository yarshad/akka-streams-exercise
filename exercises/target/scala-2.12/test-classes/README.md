building-streams

# Exercise 4 > Building Streams

In this exercise, we will look at how the various graph components can be put
together to create streams.

## Auditor

Now that our Auditor has all the tools in place to perform an Audit, it's time
to start checking the numbers.

- Add an implicit constructor parameter to `Auditor` of type `Materializer`
- Create a method in `Auditor` called `audit` that takes a parameter `cars` of 
  type `Source`[`Car`, `NotUsed`] and a parameter `sampleSize` of type 
  `FiniteDuration`. It should return a `Future`[`Int`].
- Implement `audit` such that it performs a **count** of the cars in the provided
  source within the **sample** duration provided and returns the result.
- **HINT** Use the `sample` and `count` members defined previously. 

## Factory

With all the components in place to build a car, it's time to start production.

- Create a class called `Factory` that has constructor parameters for
  `BodyShop`, `PaintShop`, `EngineShop`, `WheelShop`, and `QualityAssurance`.
  It will also need an implicit constructor parameter of type `Materializer`
- Create a method named `orderCars` with a single parameter `quantity` of type
  `Int`. It should return a `Future`[`Seq`[`Car`]]
- Implement `orderCars` so that it **takes** the cars from the `BodyShop` and
  performs the following steps.
  - Paint the cars
  - Install an engine
  - Install wheels
  - Inspect the cars
  - **take** the requested quantity from the stream and return the resulting
    **sequence** of cars.

Use the `test` command to verify the solution works as expected.  
Use the `nextExercise` command to move to the next exercise.
