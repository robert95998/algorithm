package base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode initListNode() {
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