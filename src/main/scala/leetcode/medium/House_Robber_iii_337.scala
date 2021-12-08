package leetcode.medium

import scala.collection.mutable

case class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object House_Robber_iii_337 extends App {
  val cache = mutable.Map.empty[TreeNode, Int]
  def rob(root: TreeNode): Int = {
    if (root == null) {
      0
    } else if (cache.contains(root)) {
      cache(root)
    } else {
      var ll = 0
      var lr = 0
      var rr = 0
      var rl = 0
      if (root.left != null) {
        if (!cache.contains(root.left)) {
          cache.put(root.left, rob(root.left))
        }
        if (root.left.left != null) {
          if (!cache.contains(root.left.left)) {
            cache.put(root.left.left, rob(root.left.left))
          }
          ll = cache(root.left.left)
        }
        if (root.left.right != null) {
          if (!cache.contains(root.left.right)) {
            cache.put(root.left.right, rob(root.left.right))
          }
          lr = cache(root.left.right)
        }
      }
      if (root.right != null) {
        if (!cache.contains(root.right)) {
          cache.put(root.right, rob(root.right))
        }
        if (root.right.left != null) {
          if (!cache.contains(root.right.left)) {
            cache.put(root.right.left, rob(root.right.left))
          }
          rl = cache(root.right.left)
        }
        if (root.right.right != null) {
          if (!cache.contains(root.right.right)) {
            cache.put(root.right.right, rob(root.right.right))
          }
          rr = cache(root.right.right)
        }
      }
      val result = Math.max(
        cache.getOrElse(root.left, 0) + cache.getOrElse(root.right, 0),
        root.value + ll + lr + rr + rl
      )
      cache.put(root, result)
      result
    }
  }

  println(rob(TreeNode(3, TreeNode(2, null, TreeNode(3)), TreeNode(3, null, TreeNode(1)))))
}
