package leetcode;

import leetcode.problems.easy.Maximum_Subarray_Problem_53;
import org.junit.Test;

import static org.junit.Assert.*;

public class Max_SubarrayTest {
    @Test
    public void test4() {
        int actual = Maximum_Subarray_Problem_53.maxSubArray(new int[] {2,3,0});
        assertEquals(5, actual);
    }
    @Test
    public void test3() {
        int actual = Maximum_Subarray_Problem_53.maxSubArray(new int[] {1, 2});
        assertEquals(3, actual);
    }
    @Test
    public void test0() {
        int actual = Maximum_Subarray_Problem_53.maxSubArray(new int[] {-3,-2,-1});
        assertEquals(-1, actual);
    }
    @Test
    public void test1() {
        int actual = Maximum_Subarray_Problem_53.maxSubArray(new int[] {-2, -1});
        assertEquals(-1, actual);
    }
    @Test
    public void test2() {
        int actual = Maximum_Subarray_Problem_53.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        assertEquals(6, actual);
    }
}