class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftPre = dummy;
        ListNode curNode = head;

        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
            curNode = curNode.next;
        }

        ListNode subList = curNode;

        ListNode preNode = null;

        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        leftPre.next = preNode;
        subList.next = curNode;

        return dummy.next;
    }
}
