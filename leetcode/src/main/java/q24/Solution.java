package q24;

import base.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = head, cur;
        ListNode left, right, prePair = head;
        int count = 0;
        while (head != null && head.next != null) {
            // -> 业务实现
            ListNode node1 = new ListNode(head.val);
            ListNode node2 = new ListNode(head.next.val);
            cur = node2;
            cur.next = node1;
            if (++count == 1) {
                newHead = cur;
            } else {
                newHead.next.next = cur;
            }
            // -> 循环的移动
            head = head.next.next;//当前节点移动两个位置
        }
        return newHead;
    }
}