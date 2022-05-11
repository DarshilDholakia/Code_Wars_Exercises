object ArrayDif extends App {
  def arrayDiff(a: Seq[Int], b: Seq[Int]): Seq[Int] = {
    a.filter(eA => b.contains(eA))
  }
  println(arrayDiff(Seq(1, 3, 4, 5, 5, 7), Seq(4, 5, 7)))
}
