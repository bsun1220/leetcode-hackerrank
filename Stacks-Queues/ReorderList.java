import java.util.*;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){return;}
        ListNode start = new ListNode(-999, head);

        ListNode slow = head;
        ListNode fast = head;
        Stack<ListNode> s = new Stack<>();

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;
        slow = temp;

        while(slow != null)
        {
            s.push(slow);
            slow = slow.next;
        }
        start = start.next;

        while(!s.isEmpty())
        {
            ListNode next = start.next;
            start.next = s.pop();
            start.next.next = next;
            start = start.next.next;
        }
    }
}
