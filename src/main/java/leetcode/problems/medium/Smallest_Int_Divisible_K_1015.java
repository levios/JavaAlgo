package leetcode.problems.medium;

import java.util.*;

public class Smallest_Int_Divisible_K_1015 {
    /**
     * Runtime: 24 ms, faster than 5.88%
     * Memory Usage: 46 MB, less than 5.88%
     */
    public int smallestRepunitDivByK(int k) {
        Set<Integer> modulos = new HashSet<>();
        int modulo = 1 % k;
        modulos.add(modulo);
        boolean found = modulo == 0;
        int length = 1;
        while (!found) {
            modulo = (10*modulo+1) % k;
            found = modulo == 0;
            length++;
            if (modulos.contains(modulo)) break;
            modulos.add(modulo);
        }
        return found ? length : -1;
    }
    public static void main(String[] args) {
        Smallest_Int_Divisible_K_1015 x = new Smallest_Int_Divisible_K_1015();
        System.out.println(x.smallestRepunitDivByK(1));
        System.out.println(x.smallestRepunitDivByK(2));
        System.out.println(x.smallestRepunitDivByK(3));
        System.out.println(x.smallestRepunitDivByK(37));
        System.out.println(x.smallestRepunitDivByK(39));
    }
}
