/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = head;
        for (int i = 0; i < k - 1; i++) {
            newHead = newHead.next;
            if (newHead == null) return head;
        }

        int i = 0;
        ListNode prevGrpTail = null, grpTail = null;
        ListNode cur = head, prev = null;

        a: while (cur != null) {
            if (i == 0) {
                // start of new group
                prevGrpTail = grpTail;
                grpTail = cur;

                // exit if this group is not full
                ListNode temp = cur;
                for (int j = 0; j < k - 1; j++) {
                    temp = temp.next;
                    if (temp == null) {
                        if (prevGrpTail != null) prevGrpTail.next = cur;
                        break a;
                    }
                }
            }

            // reverse
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

            if (++i == k) {
                if (prevGrpTail != null) prevGrpTail.next = prev;
                prev = null;
                i = 0;
            }
        }

        return newHead;
    }
}
