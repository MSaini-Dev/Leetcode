// First, define the ListNode class (correct implementation)
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummyHead.next;
    }

    // Helper method to create a list from array
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: 342 + 465 = 807
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.print("Test 1: ");
        printList(result);  // Should print: 7 0 8
        
        // Test case 2: 0 + 0 = 0
        l1 = createList(new int[]{0});
        l2 = createList(new int[]{0});
        result = solution.addTwoNumbers(l1, l2);
        System.out.print("Test 2: ");
        printList(result);  // Should print: 0 
        
        // Test case 3: 9999999 + 9999 = 10009998
        l1 = createList(new int[]{9,9,9,9,9,9,9});
        l2 = createList(new int[]{9,9,9,9});
        result = solution.addTwoNumbers(l1, l2);
        System.out.print("Test 3: ");
        printList(result);  // Should print: 8 9 9 9 0 0 0 1
    }
}