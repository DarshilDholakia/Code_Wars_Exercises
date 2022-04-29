object Two_To_One_7kyu {
  def longest(s1: String, s2: String): String = {
    var resultString = ""
    for (s1Letter <- s1) {
      if (!resultString.contains(s1Letter)) {
        resultString+=(s1Letter)
      }
    }

    for (s2Letter <- s2) {
      if (!resultString.contains(s2Letter)) {
        resultString+=(s2Letter)
      }
    }
    resultString.sorted
  }
}
