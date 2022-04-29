object Twice_Linear_4kyu extends App {
  def dblLinear(n: Int): Int = {
    // y = 2 x + 1
    // z = 3 x + 1
    var u = List(1)
    var pointer = 0
    var y = 0
    var z = 0

    //

    //    while (u.size <= 2*n) {
    //      y = 2 * u(pointer) + 1
    //      z = 3 * u(pointer) + 1
    //      if (!u.contains(y)) {
    //        u = u :+ y
    //      }
    //      if (!u.contains(z)) {
    //        u = u :+ z
    //      }
    ////      u = u.sorted
    //
    //      pointer += 1
    //    }

    var z_index = 0
    var y_index = 0
    while (u.size <= n) {
      y = 2 * u(y_index) + 1
      z = 3 * u(z_index) + 1
      if (y > z) {

        u = u :+ z
        z_index += 1
      } else if (y == z) {
        u = u :+ y
        z_index += 1
        y_index += 1
      }
      else {
        u = u :+ y
        y_index += 1
      }

      //      if (!u.contains(y)) {
      //        u = u :+ y
      //      }
      //      if (!u.contains(z)) {
      //        u = u :+ z
      //      }
      //      u = u.sorted
    }
//    println(u.length)
//    println(u)
    u(n)
  }

  println(dblLinear(60000))
}
