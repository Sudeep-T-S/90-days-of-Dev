class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        tail.next = head;

        k %= n;

        ListNode new_tail = head;
        for(int i = 0; i < n - k - 1; i++)
            new_tail = new_tail.next;

        ListNode new_head = new_tail.next;
        new_tail.next = null;

        return new_head;
    }
}
