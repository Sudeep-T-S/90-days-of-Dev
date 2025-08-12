class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;
        
        ListNode fast =  head,
                 slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) 
            slow = slow.next;

        slow = reverseList(slow);
        fast = head;

        while (slow != null) {

            if (fast.val != slow.val)
                return false;

            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
