package q20;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    static char[] pair1 = {'(', ')'}, pair2 = {'{', '}'}, pair3 = {'[', ']'};

    /**
     * 业务分析（脑回路，考虑问题的思路）：
     * 1、一个元素要么入栈要么消除：入栈的只能是左括号，消除的一定是右括号；
     * 2、能全部完成消除，便有效；
     * 代码设计（工程实现）：
     * 1、一个元素要么是左括号，要第是右括号；你可以基于左括号的先入为主进行编程，也可以基于右括号的假设为前提
     * 2、假设这是右括号，那么它必须找到栈里的头元素进行消除，否则便是无效字符串
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char aChar : s.toCharArray()) {
            //入栈元素
            final char in = aChar;
            boolean rightBracket = in == pair1[1] || in == pair2[1] || in == pair3[1];
            //右括号只能消除
            if (rightBracket) {
                if (stack.isEmpty()) return false;
                //如果是组合那么就消掉
                Character peek = stack.peek();
                if ((peek == pair1[0] && in == pair1[1])
                        || (peek == pair2[0] && in == pair2[1])
                        || (peek == pair3[0] && in == pair3[1])) {
                    stack.pop();
                    peek = null;
                    continue;
                }
                return false;
            }
            stack.push(in);
        }
        return stack.isEmpty();
    }

    /**
     * 上面以右括号为前提判断，这以左括号为前提
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack();
        for (char aChar : s.toCharArray()) {
            //入栈元素
            final char in = aChar;
            boolean leftBracket = in == pair1[0] || in == pair2[0] || in == pair3[0];
            //左括号直接入栈
            if (leftBracket) {
                stack.push(in);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            //如果是组合那么就消掉
            Character peek = stack.peek();
            if ((peek == pair1[0] && in == pair1[1])
                    || (peek == pair2[0] && in == pair2[1])
                    || (peek == pair3[0] && in == pair3[1])) {
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }


    /*static 并发时数据会串*/Stack<Character> stack = new Stack();
    static HashMap<Character, Character> map = new HashMap(4) {{
        this.put('(', ')');
        this.put('{', '}');
        this.put('[', ']');
    }};

    public boolean isValid3(String s) {
        Set<Character> lefts = new HashSet<>(map.keySet());
        for (char in : s.toCharArray()) {
            if (lefts.contains(in) && stack.add(in)) continue;
            if (!stack.isEmpty() && in == map.get(stack.pop())) continue;
            return false;
        }
        return stack.isEmpty();
    }

    /**
     *  *
     *  * 输入: "()"
     *  * 输出: true
     *  * 示例 2:
     *  *
     *  * 输入: "()[]{}"
     *  * 输出: true
     *  * 示例 3:
     *  *
     *  * 输入: "(]"
     *  * 输出: false
     *  * 示例 4:
     *  *
     *  * 输入: "([)]"
     *  * 输出: false
     *  * 示例 5:
     *  *
     *  * 输入: "{[]}"
     *  * 输出: true
     * @param args
     */
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(new Solution().isValid3(s));

        Stack<Character> stack = new Stack();
        stack.push('a');
        Character peek = stack.peek();
        System.out.println(peek);
        peek = null;
        System.out.println(stack.peek());
    }
}
