object Twice_Linear extends App {
  def dblLinear(n: Int): Int = {
    // y = 2 x + 1
    // z = 3 x + 1
    var u = List(1)
    var pointer = 0
    var y = 0
    var z = 0

    while (u.size <= 2*n) {
      y = 2 * u(pointer) + 1
      z = 3 * u(pointer) + 1
      if (!u.contains(y)) {
        u = u :+ y
      }
      if (!u.contains(z)) {
        u = u :+ z
      }
      u = u.sorted

      pointer += 1
    }
    println(u.length)
    println(u)
    u(n)
  }
  println(dblLinear(10))
}
//    for (index <- 0 to n - 1) yield {
//      y = 2 * u(index) + 1
//      z = 3 * u(index) + 1
//      if (!u.contains(y)) {
//        u = u :+ y
//      }
//      if (!u.contains(z)) {
//        u = u :+ z
//      }
//      u = u.sorted
//    }