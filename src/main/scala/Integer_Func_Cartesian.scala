object Integer_Func_Cartesian {
  def sumin(n: Int): BigInt = {
    // your code: f(x, y) = min(x, y)
    val x_list = List.range(1, n+1)
    val y_list = List.range(1, n+1)
    (x_list.map(x => {
      y_list.map(y => Math.min(x,y))
    }.sum)).sum

  }
  def sumax(n: Int): BigInt = {
    // your code: g(x, y) = max(x, y)
    val x_list = List.range(1, n+1)
    val y_list = List.range(1, n+1)
    (x_list.map(x => {
      y_list.map(y => Math.max(x,y))
    }.sum)).sum

  }
  def sumsum(n: Int): BigInt = {
    // your code: h(x, y) = x + y
    val x_list = List.range(1, n+1)
    val y_list = List.range(1, n+1)
    (x_list.map(x => {
      y_list.map(y => x+y)
    }.sum)).sum
  }
}
