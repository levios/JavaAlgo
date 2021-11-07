package combi;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermuteTest {

    @Test
    public void test1() {
        Permute pg = new Permute(new int[]{2, 3, 7, 9});
        int counter = 0;
        while (pg.hasMore()) {
            int[] temp =  pg.getNext();
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i] + " ");
            }
            counter++;
            System.out.println();
        }
        assertEquals(counter, 24);
    }
}
