package q50;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 贡献者
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public double myPow(double x, int n) {
        long m = n;
        if (n < 0) {
            x = 1 / x;
            //当取最小值-2147483648时，取相反数会溢出
            m = -m;
        }
        //x5次方可以拆分x1*x4；1、4在二进制里刚好就是2的0次方和2的2二次方；
        double pow = 1;
        while (m > 0) {
            if ((m & 1) > 0) pow *= x;
            x *= x;
            m >>= 1;
        }
        return pow;
    }

    /**
     * -1, -2147483648时为负数，有问题
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            //当取最小值-2147483648时，取相反数会溢出
            n = n == Integer.MIN_VALUE ? Integer.MAX_VALUE : -n;
        }
        //x5次方可以拆分x1*x4；1、4在二进制里刚好就是2的0次方和2的2二次方；
        double pow = 1;
        while (n > 0) {
            System.out.println(n +" & 1 = " + (n & 1));
            if ((n & 1) > 0) {
                pow *= x;
            }
            x *= x;
            System.out.print(n + " >> 1 = ");
            n >>= 1;
            System.out.println(n);
            System.out.println("x:" + x + "/ pow:" + pow + "\n");
        }
        return pow;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, 8));
    }
}
