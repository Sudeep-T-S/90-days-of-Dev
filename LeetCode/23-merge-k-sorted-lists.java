class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //Optimised Merge One by One(Divide and Conquer)

        int k = lists.length;
        int interval = 1;
        while (interval < k) {

            for (int i = 0; i + interval < k; i += interval * 2) 
               lists[i] = mergeTwoLists (lists[i], lists[i + interval]);
            
            interval = interval * 2;            
        }
        return lists.length == 0 ? null : lists[0];

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
    }
}
