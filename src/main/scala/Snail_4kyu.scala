object Snail_4kyu extends App {
  def snail(argArray: List[List[Int]]): List[Int] = {
    var input = argArray

    val n = input.length
    var resultList = List[Int]()
//    var test = List(1,2,3,4)
//    test = test.patch(2,Nil,1)
//    println(test)
//    println(test.length)
//    var testList = List[Int]()
//    val test2 = List(List(1,2),List(3,4),List(5,6))
//    println(test2(2)(1))

      val upFunc = (rowIndex: Int) => {
        var upRowIndex = rowIndex
        var row = input(upRowIndex)
        while (upRowIndex > input.length) {
          row = input(upRowIndex)
          resultList = resultList :+ row(0)
          row = row.patch(0, Nil, 1)
          upRowIndex -= 1
        }
        rightFunc(upRowIndex+1)
      }

      val leftFunc = (rowIndex: Int) => {
        var leftRowIndex = rowIndex
        var row = input(leftRowIndex)
        row = row.patch(row.length - 1, Nil, 1) // since this element has already been accounted for by downFunc()
        println(row)
        while (row.length > 0) {
          resultList = resultList :+ row(row.length - 1)
          row = row.patch(row.length - 1, Nil, 1) // remove 1 element at index = right_index within row of input with number row_index
          println(row)
        }
        leftRowIndex -= 1
        upFunc(leftRowIndex)
      }

      val downFunc = (rowIndex: Int) => {
        var downRowIndex = rowIndex
        var row = input(downRowIndex)
        while (downRowIndex < input.length) {
          row = input(downRowIndex)
          resultList = resultList :+ row(row.length - 1)
          row = row.patch(row.length - 1, Nil, 1)
          downRowIndex += 1
//          println(row)
        }
        leftFunc(downRowIndex - 1)
      }

      val rightFunc = (rowIndex: Int) => {
        var rightRowIndex = rowIndex
        var row = input(rightRowIndex)
        while (row.length > 0) {
          resultList = resultList :+ row(0)
          row = row.patch(0, Nil, 1) // remove 1 element at index = right_index within row of input with number row_index
        }
        rightRowIndex += 1
        downFunc(rightRowIndex)
      }

    rightFunc(0)
    println(input)
    resultList
  }

  println(snail(List(
    List(1, 2, 3),
    List(4, 5, 6),
    List(7, 8, 9))))
}
