package leetcode

import scala.annotation.tailrec

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, return the Hamming distance between them.
 *
 * >>> EASY
 *
 * Constraints: 0 <= x, y <= 2^31 - 1
 */
object Hamming_Distance_461 extends App {

  /**
   * Runtime: 396 ms, faster than 38.89% of Scala online submissions.
   * Memory Usage: 48.9 MB, less than 100.00% of Scala online submissions.
   */
  def hammingDistance(x: Int, y: Int): Int = {
    @tailrec
    def hamming(xx:Int, yy:Int, counter: Int): Int = {
      if (xx == 0 && yy == 0) {
        counter
      } else {
        hamming(xx/2, yy/2, counter + (if (xx % 2 != yy % 2) 1 else 0))
      }
    }
    hamming(x,y,0)
  }

  println(hammingDistance(1,4)) // 2
  println(hammingDistance(3,1)) // 1


  /**
   * Runtime: 388 ms, faster than 61.11% of Scala online submissions.
   * Memory Usage: 49.2 MB, less than 77.78% of Scala online submissions.
   */
  def hammingDistance0(x: Int, y: Int): Int = {
    var xx = x
    var yy = y
    var counter = 0
    while (xx > 0 || yy > 0) {
      val rx = xx % 2
      val ry = yy % 2
      if (rx != ry) {
        counter += 1
      }
      yy /= 2
      xx /= 2
    }
    counter
  }

}