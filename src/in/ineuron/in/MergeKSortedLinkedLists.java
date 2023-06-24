package in.ineuron.in;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeKSortedLinkedLists {

	    public ListNode mergeKLists(ListNode[] lists) {
	        // Create a priority queue to store the nodes
	        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

	        // Add all the nodes to the priority queue
	        for (ListNode node : lists) {
	            if (node != null) {
	                queue.offer(node);
	            }
	        }

	        // Create a dummy node to build the result
	        ListNode dummy = new ListNode(0);
	        ListNode curr = dummy;

	        // Merge the nodes until the priority queue is empty
	        while (!queue.isEmpty()) {
	            // Get the node with the smallest value
	            ListNode minNode = queue.poll();
	            curr.next = minNode;
	            curr = curr.next;

	            // Move to the next node in the list
	            if (minNode.next != null) {
	                queue.offer(minNode.next);
	            }
	        }

	        return dummy.next;
	    }

	    // Helper method to create a linked list from an array
	    public static ListNode createLinkedList(int[] arr) {
	        ListNode dummy = new ListNode(0);
	        ListNode curr = dummy;
	        for (int num : arr) {
	            curr.next = new ListNode(num);
	            curr = curr.next;
	        }
	        return dummy.next;
	    }

	    // Helper method to print a linked list
	    public static void printLinkedList(ListNode head) {
	        while (head != null) {
	            System.out.print(head.val + " ");
	            head = head.next;
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        // Create example input
	        ListNode[] lists = new ListNode[3];
	        lists[0] = createLinkedList(new int[]{1, 4, 5});
	        lists[1] = createLinkedList(new int[]{1, 3, 4});
	        lists[2] = createLinkedList(new int[]{2, 6});

	        // Merge the linked lists
	        MergeKSortedLinkedLists merger = new MergeKSortedLinkedLists();
	        ListNode mergedList = merger.mergeKLists(lists);

	        // Print the result
	        printLinkedList(mergedList);
	    }
	}

