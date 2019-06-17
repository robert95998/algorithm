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

    /**
     * <ul>思想：
     *     <li>虚拟节点对原链表保持引用</li>
     *     <li>将pair的1节点取出后重新插入支持，，国，国，国，，忆寺大肱须在。，轧   国，册</li>
     *     <li>每一对pair（如果存在）的两个节点同时对后续节点进行引用，保持了两个起始位置不同的相同链表</li>
     * </ul>
     * @param head
     * @return
     */
    public ListNode swapPairsOfficial(ListNode head) {
        ListNode p1 = new ListNode(0);//虚拟节点（因为头节点是要变动的，因为要交换嘛，所以搞个虚拟节点来指向原链表）
        p1.next = head;
        head = p1;//head等于最初的p1，这样保持对头节点的引用；head.next就是原链表
        while(p1.next != null && p1.next.next != null){
            ListNode p = p1.next;//将1节点从链表里单独摘出来，记下来（可以视为临时链表）
            p1.next = p1.next.next;//将1节点（从原链表里）踢掉
            p.next = p1.next.next;//摘出来的临时链表1指向3

            p1.next.next = p;//原链表节点2指向临时链表（也可以理解为将1节点重新插入原链表，位置为2与3之间）
            p1 = p;//p1指向新链表1节点，等于向前移动了两个位置
        }
        return head.next;
    }

    /**
     * 会形成循环链表，导致stackOverFlow
     *
     * @param head
     * @return
     */
    public ListNode swapPairsError(ListNode head) {
        while (head != null && head.next != null) {
            // -> 业务实现
            ListNode temp = head;
            head = head.next;
            head.next = temp;
            // -> 循环的移动
            head = head.next.next;//当前节点移动两个位置
        }
        return null;
    }
}