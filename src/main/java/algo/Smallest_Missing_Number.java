package algo;

/*
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.
Assume that:

N is an integer within the range [1..100,000]; each element of array A is an integer within the range [−1,000,000..1,000,000]. Complexity:

 */
public class Smallest_Missing_Number {

    int missing(int[] array) {
        if (array == null) return -1;
        int[] a = new int[array.length];

        for (int j : array) {
            if (j <= array.length && j > 0) {
                a[j-1] = 1;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i + 1;
            }
        }
        return array.length + 1;
    }

    public static void main(String[] args) {
        Smallest_Missing_Number s = new Smallest_Missing_Number();
        System.out.println(s.missing(new int[]{1, 3, 6, 4, 1, 2})); // 5
        System.out.println(s.missing(new int[]{1, 2, 3})); // 4
        System.out.println(s.missing(new int[]{-1, -3})); // 1
    }

}
