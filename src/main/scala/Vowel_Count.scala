object Vowel_Count extends App {
  def getCount(inputStr: String): Int = {
    var counter = 0
    for {
      character <- inputStr.toCharArray
    } yield {
      character match {
        case 'a'|'e'|'i'|'o'|'u' => counter+=1
        case _ => counter
      }
    }
    counter
  }
}
