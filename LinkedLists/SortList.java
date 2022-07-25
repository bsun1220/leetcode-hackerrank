public class SortList {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode iter = head;
        while(iter != null){
            list.add(iter.val);
            iter = iter.next;
        }
        Collections.sort(list);
        iter = head;

        for(int i = 0; i < list.size(); i++){
            iter.val = list.get(i);
            iter = iter.next;
        }
        return head;
    }
}
