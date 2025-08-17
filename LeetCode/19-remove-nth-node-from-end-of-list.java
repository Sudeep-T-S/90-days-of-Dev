class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p1 = dummy,
                 p2 = dummy;

        for (int i = 0; i < n; i++)
            p2 = p2.next;

        while (p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        p1.next = p1.next.next;

        return dummy.next;
    }
}
