class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
        return head;
        }

        ListNode pre = head;
        ListNode temp = pre.next;
        while (temp != null) {

            if (temp.val == pre.val) {
                temp = temp.next;
                continue;
            }

            pre.next = temp;
            pre = temp;
            temp = temp.next;
        }

        pre.next = null;
        return head;
    }
}
