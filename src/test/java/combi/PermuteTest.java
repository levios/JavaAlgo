package combi;

import leetcode.problems.medium.Permutations_46;
import org.junit.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PermuteTest {

    @Test
    public void test1() {
        Permute<Integer> pg = new Permute<>(Arrays.asList(2, 3, 7, 9));
        int counter = 0;
        for (List<Integer> s : pg) {
            System.out.println(s);
            counter++;
        }
        assertEquals(counter, 24);
    }
}
