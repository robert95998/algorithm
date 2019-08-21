import base.ListNode;
import q24.Solution;

public class Test {

    public static void main(String[] args) {
        ListNode head = ListNode.initListNode();
        System.out.println(head);

        System.out.println("==============================");
        ListNode listNode = new Solution().swapPairsOfficial(head);
        System.out.println(listNode);
    }
}
