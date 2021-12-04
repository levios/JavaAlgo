package leetcode.medium

import scala.collection.mutable

/**
 * https://leetcode.com/problems/house-robber/
 * 198. House Robber
 */
object House_Robber_198 extends App {
    var max = 0

    def rob(nums: Array[Int]): Int = {
        dp(0, nums, Set.empty[Int])
    }

    /**
     * @param sum current sum
     * @param nums original array
     * @param not buffer containing all the indices that are either visited or neighbors of visited
     * @return max value
     */
    def dp(sum: Int, nums: Array[Int], not: Set[Int]): Int = {
        if (nums.indices.forall(i => not.contains(i))) {
            sum
        } else {
            val idx = nums.indices.filterNot(not.contains).head
            val item = nums(idx)
            Math.max(
                dp(sum + item, nums, Set[Int](idx, idx - 1, idx + 1) ++ not),
                dp(sum, nums, Set[Int](idx) ++ not)
            )
        }
    }

//    println(
//        rob(Array(1,2,3,1))
//    )
//    println(
//        rob(Array(2,7,9,3,1))
//    )
    println(
        rob(Array(183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211))
    )
}