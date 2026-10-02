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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode res = dummy;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int n = 0;
      if (l1 == null) {
        n = l2.val;
        l2 = l2.next;
      } else if (l2 == null) {
        n = l1.val;
        l1 = l1.next;
      } else {
        n = l1.val + l2.val;
        l2 = l2.next;
        l1 = l1.next;
      }
      n += carry;
      res.next = new ListNode(n % 10);
      n = n / 10;
      res = res.next;
      if (n > 0) {
        carry = n;
      }
    }
    if (carry > 0)
      res.next = new ListNode(carry);

    return dummy.next;
  }
}
