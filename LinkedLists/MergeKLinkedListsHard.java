public class MergeKLinkedListsHard {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){return null;}
        if(lists.length == 1){return lists[0];}

        ListNode iterator = lists[0];

        for(int i = 1; i < lists.length; i++)
        {
            iterator = mergeTwoLists(iterator, lists[i]);
        }
        return iterator;
    }

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
