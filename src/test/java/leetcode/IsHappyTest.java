package leetcode;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsHappyTest {
    @Test
    public void test100() {
        boolean actual = IsHappy.isHappy(100);
        assertTrue(actual);
    }
    @Test
    public void test19() {
        boolean actual = IsHappy.isHappy(19);
        assertTrue(actual);
    }
}