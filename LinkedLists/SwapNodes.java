public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){return head;}
        ListNode start = new ListNode(-999, head);
        ListNode iterator = start;

        while(iterator.next != null && iterator.next.next != null)
        {
            ListNode begin = iterator.next;
            ListNode end = iterator.next.next.next;

            iterator.next = iterator.next.next;
            iterator.next.next = begin;
            begin.next = end;
            iterator = iterator.next.next;
        }

        return start.next;

    }
}
