package mt;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
}


public class LinkSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{4,2,1,3};
        int[] arr = new int[]{-1,5,3,4,0};
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i=0; i<arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }


        LinkSort sort = new LinkSort();
        ListNode sortHead = sort.sortList(head.next);
        while (sortHead != null) {
            System.err.println(sortHead.val);
            sortHead = sortHead.next;
        }

    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while(fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);

        return mergeNode(list1, list2);
    }

    public ListNode mergeNode(ListNode head1, ListNode head2) {
        ListNode mergeHead = new ListNode();
        ListNode l1 = head1;
        ListNode l2 = head2;
        ListNode cur = mergeHead;
        while(l1 != null && l2 != null) {
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

        return mergeHead.next;
    }
}






















