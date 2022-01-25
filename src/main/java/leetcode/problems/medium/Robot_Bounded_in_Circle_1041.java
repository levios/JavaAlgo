package leetcode.problems.medium;

/**
 * 1041. Robot Bounded In Circle
 * https://leetcode.com/problems/robot-bounded-in-circle/
 */
public class Robot_Bounded_in_Circle_1041 {
    public boolean isRobotBounded(String instructions) {
        int face = 0; // 0 = North, 1 = EAST, 2 = SOUTH, 3 = WEST
        int x = 0;
        int y = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                if (face == 0) {
                    y+=1;
                } else if (face == 1) {
                    x+=1;
                } else if (face == 2) {
                    y-=1;
                } else {
                    x-=1;
                }
            } else if (c == 'L') {
                // turn left
                face-=1;
                if (face<0) face+=4;
                if (face>3) face-=4;
            } else {
                // turn right
                face = (face+1) % 4;
                if (face<0) face+=4;
                if (face>3) face-=4;
            }
        }
        // The robot stays in the circle if and only if (looking at the final vector)
        // it changes direction (ie. doesn't stay pointing north), or it moves 0.
        if (x == 0 && y == 0) return true;
        if (face != 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Robot_Bounded_in_Circle_1041 x = new Robot_Bounded_in_Circle_1041();
        System.out.println(x.isRobotBounded("GLRLLGLL"));
    }
}
