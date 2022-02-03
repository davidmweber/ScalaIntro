package demo

@main def fizzbuzz(): Unit =
  (1 to 100).map { i =>
    (i % 3, i % 5) match
      case (0, 0) => "FizzBuzz"
      case (0, _) => "Fizz"
      case (_, 0) => "Buzz"
      case _ => i.toString
  }.foreach(println)
