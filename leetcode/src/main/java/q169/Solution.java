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
package q169;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {6, 5, 5};
        System.out.println(new Solution().majorityElement(nums));
        List<Object> list = Collections.singletonList(null);
        System.out.println(list);
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, (map.get(num) == null ? 0 : map.get(num)) + 1);
            if (map.get(num) > nums.length / 2) return num;
        }
        throw new RuntimeException("无预期结果");
    }

    /**
     * 力扣不允许使用AtomicInteger，直接报编译错误
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, AtomicInteger> map = new HashMap<>();
        for (int num : nums) {
            if (map.computeIfAbsent(num, v -> new AtomicInteger(0)).incrementAndGet() > nums.length / 2) return num;
        }
        return 0;
    }

    /**
     * 从力扣上摘的，耗时2ms；关键是简洁，代码很取巧
     * <ul>
     * <li>一个占了一半以上的数字，最中间那个位置一定有它</li>
     * </ul>
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}