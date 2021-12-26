public class RemoveKthFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next == null){return null;}

        ListNode begin = head;
        ListNode end = head;

        for(int i = 0; i < n + 1; i++)
        {
            if(end == null)
            {
                return head.next;
            }
            end = end.next;
        }

        while(end != null)
        {
            begin = begin.next;
            end = end.next;
        }

        if(begin != null && begin.next != null)
        {
            begin.next = begin.next.next;
        }

        return head;
    }
}
