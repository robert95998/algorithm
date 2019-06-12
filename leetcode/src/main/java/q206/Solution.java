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
package q206;

import base.ListNode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 循环实现
     * <ul>
     * <li>思想：循环列表，将新的当前节点指向上一个反转好的链表</li>
     * </ul>
     *
     * @param head
     * @return
     */
    public ListNode reverseListIterable(ListNode head) {
        if (head == null) {
            return head;
        }
        /*输入: 1->2->3->4->5->NULL*/
        ListNode pre = null;
        while (head != null) {
            // -> 业务实现
            ListNode curNode = new ListNode(head.val);
            add(curNode, pre);
            pre = curNode;//暂存上一个节点

            // -> 循环的移动
            head = head.next;
        }
        return pre;
    }

    /**
     * 递归实现
     * <ul>
     * <li>思想：循环列表，将新的当前节点指向上一个反转好的链表</li>
     * </ul>
     *
     * @param head
     * @return
     */
    public ListNode reverseListRecursive(ListNode head) {

        return null;
    }

    /**
     * 将新节点newNode添加到原链表的头部
     */
    private static void add(ListNode newNode, ListNode old) {
        if (newNode == null) {
            return;
        }
        newNode.next = old;
    }
}


