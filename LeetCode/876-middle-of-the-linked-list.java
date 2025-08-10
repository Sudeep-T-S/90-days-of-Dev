class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode one = head;
        ListNode two = head;

        while (two != null && two.next!= null) {
            one = one.next;
            two = two.next.next;
        }
        
        return one;
    }
}
