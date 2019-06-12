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

    /**
     * <ul>
     *     思想：
     *     <li>重新构建一个新链表，用新链表跟踪结果</li>
     *     <li>两个节点称为一对（pair），发现有pair存在则进行交换，每次循环移动两个位置；</li>
     *     <li>边界情况的考虑：链表为奇数节点或偶数节点的情况，链表只有一个节点时</li>
     * </ul>
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = null, pair;
        while (head != null) {
            // -> 业务实现
            if(head.next == null){//奇数情况时
                if(newHead == null){//链表只有一个节点时
                    return head;
                }
                last(newHead).next = new ListNode(head.val);
                break;
            }
            //得到互换位置的pair
            pair = new ListNode(head.next.val);
            pair.next = new ListNode(head.val);
            //初始化新链表或将新链表的最后一个节点指向新pair
            if (newHead == null) {
                newHead = pair;
            } else {
                last(newHead).next = pair;
            }
            // -> 循环的移动
            head = head.next.next;//当前节点移动两个位置
        }
        return newHead;
    }

    static ListNode last(ListNode listNode){
        while (listNode.next != null){
            listNode = listNode.next;
        }
        return  listNode;
    }

    public ListNode swapPairsOfficial(ListNode head) {
        ListNode p1 = new ListNode(0);
        p1.next = head;
        head = p1;
        while(p1.next != null && p1.next.next != null){
            ListNode p = p1.next;
            p1.next = p1.next.next;
            p.next = p1.next.next;
            p1.next.next = p;
            p1 = p;
        }
        return head.next;
    }
}