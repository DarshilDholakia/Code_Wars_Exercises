object Exes_Ohs_7kyu extends App {
  def xo(str: String): Boolean = {
    str.toLowerCase.count(_ == 'x') == str.toLowerCase.count(_ == 'o')
  }
  println(xo("xoooxx"))
}
