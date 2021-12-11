package leetcode.problems.easy;


/**
 * 58. Length of Last Word
 */
class Length_of_Last_Word_58 {
    public int lengthOfLastWord(String s) {
        String[] sp = s.trim().split(" ");
        return sp[sp.length-1].length();
    }
}