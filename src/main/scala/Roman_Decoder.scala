import scala.collection.mutable.HashMap

object Roman_Decoder extends App {
  def decode(roman: String): Int = {
    var keyMap = HashMap("I" -> 1, "V" -> 5, "X" -> 10, "L" -> 50, "C" -> 100, "D" -> 500, "M" -> 1000)
    var firstPoint = 0
    var secondPoint = 1
    var reversedRoman = roman.reverse // MMVIII = 2008 OR XCVIII = 98 OR XC || CX = 90 OR CIX || XIC = 99
    var subtractSum = 0
    var totalSum = 0
    println(reversedRoman(0))

    if (reversedRoman.length == 1) {
      totalSum += keyMap(reversedRoman(0).toString)
      return totalSum
    }

    while (firstPoint < reversedRoman.length) {
      if (keyMap(reversedRoman(secondPoint).toString) < keyMap(reversedRoman(firstPoint).toString)) {
        subtractSum = keyMap(reversedRoman(firstPoint).toString) - keyMap(reversedRoman(secondPoint).toString)
        totalSum += subtractSum
        firstPoint += 2
        secondPoint += 2
      } else {
        totalSum += keyMap(reversedRoman(firstPoint).toString)
        firstPoint += 1
        secondPoint += 1
      }

      if (firstPoint == reversedRoman.length - 1) {
        totalSum += keyMap(reversedRoman(firstPoint).toString)
        firstPoint += 1
      }

    }
    totalSum
  }

  println(Roman_Decoder.decode("I"))
}

