package util;

import org.junit.*;
import org.junit.Test;
import util.TupleUtil.*;

import static org.junit.Assert.*;

public class TupleUtilTest {

    @Test
    public void test1() {
        T3<Integer, Integer, Integer> t1 = new T3<>(1,2,3);
        T3<Integer, Integer, Integer> t2 = new T3<>(
                Integer.valueOf(1),
                Integer.valueOf(2),
                Integer.valueOf(3)
        );
        assertEquals(t1, t2);
    }

    @Test
    public void test2() {
        T3<Integer, Integer, String> t1 = new T3<>(1,2,"ciao");
        T3<Integer, Integer, String> t2 = new T3<>(
                Integer.valueOf(1),
                Integer.valueOf(2),
                new String("ciao")
        );
        assertEquals(t1, t2);
    }
}
