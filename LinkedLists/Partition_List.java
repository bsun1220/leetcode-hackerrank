public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){return head;}

        ListNode greater = new ListNode(-999, head);
        boolean check = true;

        while(greater.next != null && greater.next.val < x)
        {
            greater = greater.next;
        }
        if(greater.next == null)
        {
            return head;
        }
        if(greater.val == -999)
        {
            check = false;
        }

        ListNode lesser = greater;
        ListNode iterator = greater;

        while(lesser != null && lesser.next != null)
        {
            if(lesser.next.val < x)
            {
                ListNode temp1 = lesser.next.next;
                ListNode temp2 = iterator.next;
                iterator.next = new ListNode(lesser.next.val, temp2);
                lesser.next = temp1;
                iterator = iterator.next;
            }
            else
            {
                lesser = lesser.next;
            }
        }
        if(check)
        {
            return head;
        }
        else
        {
            if(greater.val == -999)
            {
                greater = greater.next;
            }
            return greater;
        }


    }
}
