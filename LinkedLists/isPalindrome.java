public class isPalindrome {
    int myLength;
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){return true;}
        myLength = 0;

        ListNode rev = reverse(head);
        for(int i = 0; i < myLength/2; i++)
        {
            if(head.info != rev.info){return false;}
            head = head.next;
            rev = rev.next;
        }
        return true;

    }

    public ListNode reverse(ListNode head)
    {

        ListNode rev = new ListNode(head.info, null);
        myLength++;
        head = head.next;

        while(head != null)
        {
            ListNode temp = rev;
            rev = new ListNode(head.info, rev);
            head = head.next;
            myLength++;

        }
        return rev;
    }
}
