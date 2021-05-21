package demo;

class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val) {this.val = val;}
}

public class DLinkSort {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 5, 3, 4, 0};

        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i=0; i<arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        head = head.next;

        head = linkSort(head, null);
        while (head != null) {
            System.err.print(head.val + "  ");
            head = head.next;
        }
    }

    public static ListNode linkSort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        //找中点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode h1 = linkSort(head, mid);
        ListNode h2 = linkSort(mid, tail);

        return merge(h1, h2);
    }

    public static ListNode merge(ListNode h1, ListNode h2) {
        ListNode tmp = new ListNode();
        ListNode cur = tmp;
        ListNode l1 = h1, l2 = h2;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return tmp.next;
    }


}
