class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        int n = length(head);
        if(n < k) {
            fill(head, arr, 0, n, 1); // Fill arr[0 to n-1] with 1 node each
        }
        else {
            head = fill(head, arr, 0, n%k, n/k+1);   // Fill arr[0 to n%k-1] with n/k+1 nodes each
            head = fill(head, arr, n%k, k, n/k);     // Fill arr[n%k to k-1] with n/k nodes each
        }
        return arr;
    }
    private int length(ListNode head) {
        // Find length of list starting at head
        int n = 0;
        while(head != null) {
            n++;
            head = head.next;
        }
        return n;
    }
    private ListNode fill(ListNode head, ListNode[] arr, int l, int r, int m) {
        // Fill arr[l to r-1] with m nodes each starting at head
        for(int i = l; i < r && head != null; i++) {
            arr[i] = head;
            for(int j = 0; j < m-1 && head != null; j++) {
                head = head.next;
            }
            if(head != null) {
                ListNode tmp = head.next;
                head.next = null;
                head = tmp;
            }
        }
        return head;
    }
}