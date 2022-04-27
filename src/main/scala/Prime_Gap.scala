object Prime_Gap extends App {
  def gap(g: Int, m: Long, n: Long): String = {
    def isPrime(input: Int): Boolean = {
      if (input <= 1) {
        false
      } else {
        for (divisors <- 2 to Math.floor(Math.sqrt(input)).toInt) yield {
          if (input % divisors == 0) return false
        }
      }
      true
    }

    var oldPrime = 0

    val primeList = for {
      element <- m to n
      if (isPrime(element.toInt))
    } yield {
      if (oldPrime == 0) oldPrime = element.toInt
      else if (element.toInt - oldPrime == g) return s"($oldPrime,${element.toInt})"
      else oldPrime = element.toInt

    }
    ""
  }
  println(gap(2,3,5))
}




