import java.util.*;

public class Remove_Duplicates {

    public static void main(String[] args)
    {
        ListNode start = new ListNode(-1, null);
        ListNode iterator = start;
        for(int i = 0; i < 10; i++)
        {
            ListNode n = new ListNode(i, null);
            ListNode l = new ListNode(i, n);
            iterator.next = l;
            iterator = iterator.next.next;
        }
        print_list_node(start);
        start = new ListNode(1, null);
        start.next = new ListNode(1, null);
        print_list_node(removeDuplicates(start));
    }

    public static ListNode removeDuplicates(ListNode node)
    {
        if(node == null){return null;}

        ListNode start = node;
        HashSet<Integer> seen = new HashSet<>();
        seen.add(node.info);

        while(node != null && node.next != null)
        {
            if(seen.contains(node.next.info))
            {
                node.next = node.next.next;
            }
            else
            {
                node = node.next;
                seen.add(node.info);
            }
        }
        return start;
    }

    public static void print_list_node(ListNode start)
    {
        if(start == null){
            System.out.println(" ");
            return;
        }
        System.out.print("" + start.info + " ");
        print_list_node(start.next);
    }
}
