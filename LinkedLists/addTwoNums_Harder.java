public class addTwoNums_Harder {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode ret = new ListNode(0, null);
        ListNode start = ret;

        int sum = 0;
        int left = 0;
        int right = 0;
        boolean isGreat = false;
        while(l1 != null || l2 != null)
        {
            left = l1 == null ? 0 : l1.info;
            right = l2 == null ? 0 : l2.info;
            sum = left + right;

            if(isGreat)
            {
                sum++;
                isGreat = false;
            }
            if(sum >= 10)
            {
                sum = sum % 10;
                isGreat = true;
            }

            ret.next = new ListNode(sum, null);
            ret = ret.next;

            if(l1 != null)
            {
                l1 = l1.next;
            }
            if(l2 != null)
            {
                l2 = l2.next;
            }
        }
        if (isGreat)
        {
            ret.next = new ListNode(1, null);
        }

        start = start.next;
        return reverse(start);
    }

    public ListNode reverse (ListNode node)
    {
        ListNode ret = new ListNode(node.info, null);
        node = node.next;

        while(node != null)
        {
            ListNode temp = ret;
            ret = new ListNode(node.info, temp);
            node = node.next;
        }
        return ret;
    }
}
