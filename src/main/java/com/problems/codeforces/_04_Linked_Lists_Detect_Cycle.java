package cracking.coing.interview.ds;

public class _04_Linked_Lists_Detect_Cycle {

    class Node {
        int data;
        Node next;
    }

    /**
     * Double pointer solution.
     * 
     * @param head
     * @return true if linked list is cyclic
     */
    boolean hasCycle(Node head) {
        if (head == null || head.next == null)
            return false;
        Node move1 = head;
        Node move2 = head.next;
        while (true) {
            if (move1 == move2) {
                return true;
            }
            if (move2 == null || move1 == null)
                return false;

            move1 = move1.next;
            if (move2.next != null)
                move2 = move2.next.next;
            else
                return false;
        }
    }
}