class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1️⃣ Insert copied nodes after each original node
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // 2️⃣ Assign random pointers for copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 3️⃣ Separate original and copied lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;

            curr.next = copy.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}