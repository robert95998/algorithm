package q703;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。

 示例:

 int k = 3;
 int[] arr = [4,5,8,2];
 KthLargest kthLargest = new KthLargest(3, arr);
 kthLargest.add(3);   // returns 4
 kthLargest.add(5);   // returns 5
 kthLargest.add(10);  // returns 5
 kthLargest.add(9);   // returns 8
 kthLargest.add(4);   // returns 8
 说明:
 你可以假设 nums 的长度≥ k-1 且k ≥ 1。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
public class KthLargest {

    int k;
    PriorityQueue<Integer> queue = null;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() == k){
                this.add(num);
                continue;
            }
            queue.add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k){
            queue.add(val);
            return queue.element();
        }

        Integer first = queue.element();
        if (val <= first){
            return first;
        }

        queue.remove(first);
        queue.add(val);
        return queue.element();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.queue);
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(4));
    }
}
