package q239;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;

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

    public static void main(String[] args) {
        int arr[] = {1, -1};
        int[] x = new Solution().maxSlidingWindow(arr, 1);
        for (int i : x) {
            System.out.println(i);
        }
    }

    /**
     * nums.length >= k,不然题就出错了
     * <p>
     * nums.length == 0 为了解决案例：[] 0
     * <p>
     * 自然退休后可能window又变为空，案例：[1,-1] 1
     * Geek_21da8b
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length == 0) return new int[0];

        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (!window.isEmpty()) {
                //自然退休
                if (i >= k && window.peekFirst() <= i - k) window.pop();
                //长江后浪推前浪；等同于写法：window.removeAll(window.stream().filter(e -> e < cur).collect(Collectors.toSet()))
                window.removeIf(e -> nums[e] < cur);
            }
            window.offer(i);
            //有第一个窗口最大值后开始记录
            if (i >= k - 1) result[i - k + 1] = nums[window.peekFirst()];
        }
        return result;
    }

    /**
     * 摘自https://time.geekbang.org/discuss/detail/70695
     * 即https://time.geekbang.org/course/detail/130-41561的评论 web Java 版本答案
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 删除队列中小于窗口左边下标的元素
            if (i >= k && i - k + 1 > deque.peek()) deque.remove();

            // 从队列右侧开始, 删除小于nums[i] 的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.removeLast();

            deque.add(i);

            // 队列左侧是最大值,加入结果
            if (i - k + 1 >= 0)
                res[i - k + 1] = nums[deque.peek()];
        }
        return res;
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
                window.add(i - 1);
            } finally {
                //滑动窗口工作后开始记录
                if (i >= k) {
                    result[i - k] = nums[window.get(0)];
                }
            }
        }
        return result;
    }
}
