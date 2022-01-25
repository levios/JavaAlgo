package leetcode.problems.medium;

import java.util.Arrays;

/**
 * 875. Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 *
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and
 * eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and
 * will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * Constraints:
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 */
public class Koko_Eating_Bananas_875 {
    //// BINARY SEARCH
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canEatInTime(piles, mid, h)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    public boolean canEatInTime(int piles[], int k, int h){
        int hours = 0;
        for(int pile : piles){
            int div = pile / k;
            hours += div;
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        Koko_Eating_Bananas_875 x = new Koko_Eating_Bananas_875();
        //System.out.println(x.minEatingSpeed(new int[]{3,6,7,11}, 8));
//        System.out.println(x.minEatingSpeed(new int[] {
//                332484035,524908576,855865114,632922376,222257295,690155293,
//                112677673,679580077,337406589,290818316,877337160,901728858,
//                679284947,688210097,692137887,718203285, 629455728,941802184
//        }, 823855818));
        //System.out.println(x.minEatingSpeed(new int[]{312884470}, 968709470));
        System.out.println(x.minEatingSpeed(new int[]{1000000000,1000000000}, 3));
    }
}
