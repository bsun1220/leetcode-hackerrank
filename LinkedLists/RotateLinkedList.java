public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){return head;}
        if(k == 0){return head;}

        ListNode start = new ListNode(-999, head);

        ListNode slow = start;
        ListNode fast = start;

        int length = 0;
        while(fast.next != null)
        {
            fast = fast.next;
            length++;
        }

        int rotation = k % length;

        if(rotation == 0){return head;}

        for(int i = 0; i < length - rotation; i++)
        {
            slow = slow.next;
        }

        ListNode temp = slow.next;
        slow.next = null;
        fast.next = start.next;

        return temp;

    }
}
