package leetcode.problems.hard;

public class Kth_Smallest_Number_in_Multiplication_Table_668 {

    public int findKthNumber(int m, int n, int k) {
        if (k == 1) return 1;
        int level = 0;
        int sum = 0;
        int count = 0;
        while (sum < k) {
            level++;
            count = Math.min(level, Math.min(m,n));
            sum += count;
        }
        // at this point we know that we found the level.


        return -1; // TODO
    }

    static int mat(int m, int n) {
        return m * n;
    }

    public static void main(String[] args) {
        Kth_Smallest_Number_in_Multiplication_Table_668 app = new Kth_Smallest_Number_in_Multiplication_Table_668();
        System.out.println(app.findKthNumber(3,3,5)); // 3
        System.out.println(app.findKthNumber(2,3,6)); // 6
    }
}
