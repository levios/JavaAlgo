package leetcode.medium

import scala.collection.mutable

/**
 * https://leetcode.com/problems/accounts-merge/submissions/
 * 721. Accounts Merge
 */
object Accounts_Merge_721 extends App {
  /**
   * Runtime: 1936 ms, faster than 56.00% of Scala online submissions
   * Memory Usage: 63.1 MB, less than 80.00% of Scala online submissions
   */
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    val m = mutable.Map.empty[String, mutable.ListBuffer[mutable.SortedSet[String]]]
    accounts.foreach { account: List[String] =>
      val name = account.head
      val emails = account.tail
      m.get(name) match {
        case Some(sets: mutable.ListBuffer[mutable.SortedSet[String]]) =>
          val intersections: mutable.ListBuffer[mutable.SortedSet[String]] = sets.filter(_.intersect(emails.toSet).nonEmpty)
          intersections match {
            case seq if seq.size == 1 =>
              // add emails to that single set
              emails.foreach(email => intersections.head += email)
            case seq if seq.nonEmpty =>
              // combine interactions into 1 single set
              val union: mutable.SortedSet[String] = mutable.TreeSet.empty[String]
              intersections.foreach { set =>
                set.foreach(email => union += email)
                // clear it out
                set.clear()
              }
              // add emails to union
              emails.foreach(email => union += email)
              // add union
              sets += union
            case _ =>
              // add a new Set to the List
              val set: mutable.SortedSet[String] = mutable.TreeSet.empty[String]
              emails.foreach(email => set += email)
              sets += set
          }
        case None =>
          val set: mutable.SortedSet[String] = mutable.TreeSet.empty[String]
          emails.foreach(email => set += email)
          val buffer = new mutable.ListBuffer[mutable.SortedSet[String]]
          buffer += set
          m += name -> buffer
      }
    }

    val result = new mutable.ListBuffer[List[String]]()
    m.foreach { case (key: String, emails: mutable.Seq[mutable.SortedSet[String]]) =>
      emails foreach { emailSorted: mutable.Set[String] =>
        if (emailSorted.nonEmpty) {
          result += (key :: emailSorted.toList)
        }
      }
    }
    result.toList
  }

  println(accountsMerge(List(
    List("David","David0@m.co","David1@m.co"),
    List("David","David3@m.co","David4@m.co"),
    List("David","David4@m.co","David5@m.co"),
    List("David","David1@m.co","David2@m.co"),
    List("David","David2@m.co","David3@m.co")
  )))

}
