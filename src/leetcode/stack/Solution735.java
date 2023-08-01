package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution735 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution735().asteroidCollision(new int[]{-2, -2, 1, -2})));;
    }

    public int[] asteroidCollision(int[] asteroids) {
        // 空的话直接进栈，运动方向相反则不断的碰撞直到一方爆炸
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                // 只有想冲的方向需要特殊处理
                if (stack.peek() > 0 && asteroid < 0) {
                    // 要么栈中的全爆炸，这个星球留下
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        stack.push(asteroid);
                        continue;
                    }
                    // 要么同归于尽
                    if (stack.peek() + asteroid == 0) {
                        stack.pop();
                        continue;
                    }
                    // 要么共生
                    if (stack.peek() < 0) {
                        stack.push(asteroid);
                    }
                } else {
                    // 方向不相冲直接进栈
                    stack.push(asteroid);
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
