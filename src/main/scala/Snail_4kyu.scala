import scala.util.control.Breaks.break

object Snail_4kyu extends App {
  def snail(argArray: List[List[Int]]): List[Int] = {
    var input = argArray

    val n = input.length
    var resultList = List[Int]()
    var globalRowIndex = 0;

    if (input(n-1).isEmpty) {
      resultList = List()
      return resultList
    } else if (n == 1 && !input(n-1).isEmpty) {
      resultList = List(input(globalRowIndex)(0))
      return resultList
    }

    while (resultList.length < n*n) {

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
        globalRowIndex = upRowIndex + 1
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
        globalRowIndex = leftRowIndex - 1
        upFunc(globalRowIndex)
      }

      val downFunc = (rowIndex: Int) => {
        var downRowIndex = rowIndex
        var row = input(downRowIndex)
        var counter = 0
        while (counter < input.filter(e => e != Nil).length) {
          row = input(downRowIndex)

          println(row)
          println(resultList)
          println(s"this is global index: $globalRowIndex and this is down row index: $downRowIndex")

          resultList = resultList :+ row(row.length - 1)
          row = row.patch(row.length - 1, Nil, 1)
          input = input.updated(downRowIndex, row)
          downRowIndex += 1
          counter += 1
        }
        globalRowIndex = downRowIndex - 1
        leftFunc(globalRowIndex)
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
        globalRowIndex = rightRowIndex
        downFunc(globalRowIndex)
      }

      rightFunc(globalRowIndex)
    }
    resultList
  }

  // ========= TESTING THE 3 X 3 GRID =============
//println(snail(List(
//List(1, 2, 3),
//List(4, 5, 6),
//List(7, 8, 9))))

  // ========= TESTING THE 4 X 4 GRID =============
//  println(snail(List(
//List(1, 2, 3, 4),
//List(5, 6, 7, 8),
//List(9, 10, 11, 12),
//    List(13, 14, 15, 16))))

  // ========= TESTING THE 5 X 5 GRID =============
//  println(snail(List(
//    List(1,2,3,4,5),
//    List(6,7,8,9,10),
//    List(11,12,13,14,15),
//    List(16,17,18,19,20),
//    List(21,22,23,24,25)
//  )))

  // ========= TESTING THE 0 X 0 GRID =============
//  println(snail(List(
//    List()
//  )))

  // ========= TESTING THE 1 X 1 GRID =============
  println(snail(List(
    List(1)
  )))

}
