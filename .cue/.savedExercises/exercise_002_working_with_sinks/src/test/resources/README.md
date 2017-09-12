working-with-sinks

# Exercise 2 > Working with Sinks

In this exercise, we will work with `Sink`s. We will look at a couple of
different `Sink`s and how they can be used.

## Auditor

In order to ensure the factory is meeting it's quotas, we need to count how many
of a particular item is being produced. This job falls to the `Auditor` who will
monitor the flow of the assembly line and perform random counts on the
production floor.
 
- Create a class called `Auditor` with an empty constructor.
- Create a val in `Auditor` named `count` that returns a
  `Sink`[`Any`, `Future`[`Int`]].
- Implement the `count` such that it counts the number of elements in a stream
  and materializes the result.  

- Create a def in `Auditor` named `log` with an implicit parameter for
  `LoggingAdapter` that returns a `Sink`[`Any`, `Future`[`Done`]].
- Implement the `log` such that it logs **each** element in the stream to the
  `LoggingAdapter` at `DEBUG`.

Use the `test` command to verify the solution works as expected.  
Use the `nextExercise` command to move to the next exercise.
