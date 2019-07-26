package q239;

import java.util.*;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 注意：
 * <p>
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * nums.length >= k,不然题就出错了
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length == 0 || nums.length < k) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> window = new ArrayDeque<>();
        for (int i = 1; i <= nums.length; i++) {
            try {
                int cur = nums[i - 1];
                Integer first = window.peekFirst();
                if (first == null) {
                    window.offer(cur);
                    continue;
                }
                if (first >= cur) continue;
                //干掉比自己小的，独立为王
                window.clear();
                window.offer(cur);
            } finally {
                //滑动窗口工作后开始记录
                if (i >= k) {
                    result[i - k] = window.peekFirst();
                }
            }
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length == 0 || nums.length < k) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        //滑动窗口，用于存放在nums的原始下标
        ArrayList<Integer> window = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            try {
                if (!window.isEmpty()) {
                    ArrayList<Integer> good = new ArrayList<>();
                    for (int j = 0; j < window.size(); j++) {
                        Integer index = window.get(j);
                        //自然退休
                        if (index < i - k) {
                            continue;
                        }
                        //长江后浪推前浪
                        if (nums[index] < nums[i - 1]) {
                            continue;
                        }
                        good.add(index);
                    }
                    window = good;
                }

                //自己入队
                window.add(i-1);
            } finally {
                //滑动窗口工作后开始记录
                if (i >= k) {
                    result[i - k] = nums[window.get(0)];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] ={1,3,-1,-3,5,3,6,7};
        int[] x = new Solution().maxSlidingWindow2(arr, 3);
        for (int i : x) {
            System.out.println(i);
        }
    }
}
