object Accum extends App {
  def accum(s: String) = {
    val sArr = s.toLowerCase.split("")
    var result = ""
    var substring = ""
    for (i <- sArr.indices) yield {
      substring = (s"${sArr(i)}" * (i+1)).capitalize
//      if (i < sArr.length - 1) result += s"${substring}-"
//      else if (i == sArr.length - 1) result += s"${substring}"
      result += substring + "-"
    }
    result.substring(0, result.length-1)
  }

  println(accum("abcdef"))
}
