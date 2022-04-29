object Snail_4kyu extends App {
  def snail(inputArr: List[List[Int]]): Array[Array[Int]] = {
    // create 2d array using input
    val n = inputArr.length
    val matrix = Array.ofDim[Int](n,n)
    val flattenList = inputArr.flatten

    for (i <- 0 until matrix.length; j <- 0 until matrix(0).length) {
      for (index <- 0 until flattenList.length) {
        matrix(i)(j) = flattenList(index)
      }
    }
    matrix

    val traversingRecursion = () => {

    }
    matrix
    // use pointer to go right, down, left, up - fill resultArray as you go
    // then use recursion to repeat
    // stop when no numbers left
  }

  println(snail(List(
    List(1, 2, 3),
    List(4, 5, 6),
    List(7, 8, 9))))
}
