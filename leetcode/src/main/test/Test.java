import base.ListNode;
import q24.Solution;

public class Test {

    public static void main(String[] args) {
        ListNode head = initListNode();
        System.out.println(head);

        System.out.println("==============================");
        ListNode listNode = new Solution().swapPairsError(head);
        System.out.println(listNode);
    }

    private static ListNode initListNode() {
        ListNode firstNode = new ListNode(1);

        int count = firstNode.val;
        ListNode cur = firstNode;
        while (count < 7) {
            cur.next = new ListNode(++count);
            cur = cur.next;
        }
        return firstNode;
    }
}
