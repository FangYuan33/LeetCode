package leetcode.stack;

import java.util.*;

public class Solution726 {

    public static void main(String[] args) {
        System.out.println(new Solution726().countOfAtoms("H50"));
    }

    /**
     * 定义节点，保存对应的字母和出现的次数
     */
    static class Node implements Comparable<Node> {

        String name;

        int num;

        public Node(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return Character.compare(this.name.charAt(0), o.name.charAt(0));
        }

        @Override
        public String toString() {
            if (num == 1) {
                return name;
            } else {
                return name + num;
            }
        }
    }

    public String countOfAtoms(String formula) {
        // 遇到字母判断后边是否有小写字母，再判断完是否有数字，之后入栈
        // 遇到左括号直接入栈，遇到右括号则计算
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < formula.length();) {
            char c = formula.charAt(i);

            if (c == '(') {
                stack.push(new Node("("));
                i++;
            } else if (c >= 'A' && c <= 'Z') {
                // 遇到字母开始处理
                int nameBeginIndex = i;
                i++;
                // 是小写字母的话则不断向后匹配
                while (i < formula.length() && formula.charAt(i) >= 'a' && formula.charAt(i) <= 'z') {
                    i++;
                }
                // 匹配完名字创建该节点
                Node node = new Node(formula.substring(nameBeginIndex, i));

                // 开始匹配数字
                int num = 0;
                while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                num = num == 0 ? 1 : num;
                node.num = num;

                // 入栈
                stack.push(node);
            } else if (c == ')') {
                ArrayList<Node> temp = new ArrayList<>();
                i++;
                // 右括号开始计算，直到碰到左括号则停止
                int multi = 0;
                while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                    multi = multi * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                multi = multi == 0 ? 1 : multi;

                while (!"(".equals(stack.peek().name)) {
                    Node pop = stack.pop();
                    pop.num = pop.num * multi;
                    temp.add(pop);
                }
                // 计算完成后左括号出栈
                stack.pop();

                // 将节点重新添加到栈中
                for (Node node : temp) {
                    stack.push(node);
                }
            }
        }

        TreeMap<String, Node> treeMap = new TreeMap<>();
        while (!stack.isEmpty()) {
            Node pop = stack.pop();

            if (treeMap.containsKey(pop.name)) {
                Node node = treeMap.get(pop.name);
                node.num += pop.num;
            } else {
                treeMap.put(pop.name, pop);
            }
        }

        StringBuilder res = new StringBuilder();
        for (Node node : treeMap.values()) {
            res.append(node.toString());
        }

        return res.toString();
    }
}
