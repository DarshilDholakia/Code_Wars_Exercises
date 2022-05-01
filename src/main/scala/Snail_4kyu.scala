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
      while (!row.isEmpty) {
        resultList = resultList :+ row(0)
        row = row.patch(0, Nil, 1)
        input = input.updated(upRowIndex, row)
        upRowIndex -= 1
        row = input(upRowIndex)
      }
//      rightFunc(upRowIndex + 1)
    }

    val leftFunc = (rowIndex: Int) => {
      var leftRowIndex = rowIndex
      var row = input(leftRowIndex)
      while (row.length > 0) {
        resultList = resultList :+ row(row.length - 1)
        row = row.patch(row.length - 1, Nil, 1) // remove 1 element at index = right_index within row of input with number row_index
        input = input.updated(leftRowIndex, row)
      }
      upFunc(leftRowIndex - 1)
    }

    val downFunc = (rowIndex: Int) => {
      var downRowIndex = rowIndex
      var row = input(downRowIndex)
      while (downRowIndex < input.length) {
        row = input(downRowIndex)
        resultList = resultList :+ row(row.length - 1)
        row = row.patch(row.length - 1, Nil, 1)
        input = input.updated(downRowIndex, row)
        downRowIndex += 1
      }
      leftFunc(downRowIndex - 1)
    }

    val rightFunc = (rowIndex: Int) => {
      var rightRowIndex = rowIndex
      var row = input(rightRowIndex)
      while (row.length > 0) {
        resultList = resultList :+ row(0)
        row = row.patch(0, Nil, 1) // remove 1 element at index = right_index within row of input with number row_index
        input = input.updated(rightRowIndex, row)
      }
      rightRowIndex += 1
      downFunc(rightRowIndex)
    }

    rightFunc(0)
    resultList
  }


println(snail(List(
List(1, 2, 3),
List(4, 5, 6),
List(7, 8, 9))))

  println(snail(List(
List(1, 2, 3, 4),
List(5, 6, 7, 8),
List(9, 10, 11, 12),
    List(13, 14, 15, 16))))
}
