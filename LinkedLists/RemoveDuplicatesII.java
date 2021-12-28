import java.util.*;

public class RemoveDuplicatesII {
    public ListNode deleteDuplicates(ListNode head) {
        TreeSet<Integer> set = new TreeSet<>();
        HashSet<Integer> seen = new HashSet<>();
        while(head != null)
        {
            if(set.contains(head.info))
            {
                set.remove(head.info);
                seen.add(head.info);
            }
            else if (!seen.contains(head.info))
            {
                set.add(head.info);
            }
            head = head.next;
        }
        ListNode start = new ListNode(-999, null);
        ListNode iterator = start;
        for(int i : set)
        {
            iterator.next = new ListNode(i, null);
            iterator = iterator.next;
        }
        return start.next;
    }
}
