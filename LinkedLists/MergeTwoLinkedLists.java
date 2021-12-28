public class MergeTwoLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){return null;}
        if(list1 == null){return list2;}
        if(list2 == null){return list1;}

        ListNode starter = null;
        ListNode other = null;
        if(list1.info <= list2.info)
        {
            starter = list1;
            other = list2;
        }
        else
        {
            starter = list2;
            other = list1;
        }

        ListNode start = starter;

        while(other != null)
        {
            if(start.next == null)
            {
                ListNode next = other.next;
                start.next = other;
                other.next = null;
                other = next;
            }
            else if (other.info <= start.next.info)
            {
                ListNode next = start.next;
                ListNode other_next = other.next;
                start.next = other;
                other.next = next;
                other = other_next;
            }
            else
            {
                start = start.next;
            }
        }
        return starter;
    }
}
