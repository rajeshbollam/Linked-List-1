//The approach here is to start a pointer from the head once a cycle is detected, and traverse both fast and slow pointers to their next nodes. They both meet at the node where the cycle begins.
//Time Complexity: O(n)
//Space Complexity: O(1)
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }
        if(!flag) return null; // no cycle detected
        fast = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}