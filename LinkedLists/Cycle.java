import java.util.*;

public class Cycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null){return null;}
        HashSet<ListNode> set = new HashSet<>();
        set.add(head);

        while(head.next != null)
        {
            if(set.contains(head.next))
            {
                return head.next;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
