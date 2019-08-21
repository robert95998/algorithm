/*
* 四川生学教育科技有限公司
* Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
*
* This software is the confidential and proprietary information of
* Founder. You shall not disclose such Confidential Information
* and shall use it only in accordance with the terms of the agreements
* you entered into with Founder.
*
*/
package q22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    List<String> res = new ArrayList<>();
    int n;

    public static void main(String[] args) {
//        System.out.println(new Solution().generateParenthesis(2));
        String str = "1234567890";
        int segments = str.length() / 5;
        for (int i = 0; i <= segments; i++) {
            System.out.println("v: " + (

                    i == segments ? str.substring(i * 5) : str.substring(i * 5, (i + 1) * 5)
            ));
        }

        HashMap<String, String> map = new HashMap<String, String>() {{
            this.put("1", "1");
        }};
        System.out.println(map.getOrDefault("2", "2323"));
    }

    private static void append1(StringBuilder candidate, int n, String str) {
        int leftUsed = 0;
        int rightUsed = 0;

        if (leftUsed == n && rightUsed == n) return;
        if (leftUsed < rightUsed) return;

        if (leftUsed <= n) candidate.append(str);
        if (rightUsed <= n) candidate.append(str);
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;

        _gen(0, 0, "");
        return res;
    }

    /**
     * 这个方法就是添加括号，在解读这个方法的时候leftUsed、rightUsed可以忽略释义；
     * leftUsed、rightUsed只是通过形参（方法参数）方式来传递变量，因为不然不好传（成员变量和方法内局部变量都不好控制在递归中）
     *
     * @param leftUsed
     * @param rightUsed
     * @param str
     */
    private void _gen(int leftUsed, int rightUsed, String str) {
        if (leftUsed == n && rightUsed == n) {
            res.add(str);
            return;
        }

        if (leftUsed < n) {
            _gen(leftUsed + 1, rightUsed, str + "(");
        }
        if (rightUsed < n && rightUsed < leftUsed) {
            _gen(leftUsed, rightUsed + 1, str + ")");
        }
    }
}