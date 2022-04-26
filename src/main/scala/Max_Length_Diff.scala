object Max_Length_Diff extends App {
  def mxdiflg(a1: List[String], a2: List[String]): Int = {
    var list = List[Int]()
    if (a1.isEmpty || a2.isEmpty) return -1

    (a1.map(x => {
      a2.map(y => Math.abs(x.length - y.length))
    }.max)).max
  }
}
