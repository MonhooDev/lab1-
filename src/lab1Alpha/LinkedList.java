package lab1Alpha;
import java.util.Scanner;

public class LinkedList
{
	Node head; 
	class Node
	{
		int data;
		Node next;
		Node(int d) {data = d; next = null; }
	}

	public void push(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public void insertAfter(Node prev_node, int new_data)
	{
		if (prev_node == null)
		{
			System.out.println("aldaa NULL");
			return;
		}

		Node new_node = new Node(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}

	public void append(int new_data)
	{
		Node new_node = new Node(new_data);
		if (head == null)
		{
			head = new Node(new_data);
			return;
		}

		new_node.next = null;
		Node last = head;
		while (last.next != null)
			last = last.next;

		last.next = new_node;
		return;
	}
	
	void deleteNode(int key)
    {
        Node temp = head, prev = null;
 
        if (temp != null && temp.data == key) { //if head needs to be deleted
            head = temp.next; 
            return;
        }
 
        while (temp != null && temp.data != key) {         // Search for the key to be deleted, keep track of       	
            prev = temp;                                   // the previous node as we need to change temp.next
            temp = temp.next;
        }
 
        if (temp == null)      // If key was not present in linked list
            return;
 
        prev.next = temp.next;     // Unlink the node from linked list
    }

	public void printList()
	{
		Node tnode = head;
		while (tnode != null)
		{
			System.out.print(tnode.data+" ");
			tnode = tnode.next;
		}
	}

	public static void main(String[] args)
	{
		/* Start with the empty list */
		LinkedList llist = new LinkedList();
		Scanner listNumber = new Scanner(System.in);
		int i = 0;

		System.out.println("Linked list iin toog oruulna uu: ");
		int listMax = listNumber.nextInt();
		
		while(i < listMax) {
			int listItemPush;
			i++;
			System.out.println("Linked list-d oroh toog oruulna uu: ");
			listItemPush = listNumber.nextInt();
			llist.append(listItemPush);		
		}
		llist.printList();
		
		System.out.println("Ustgah linked list-iig oruulna uu: ");
		int deleteNumber = listNumber.nextInt();
		llist.deleteNode(deleteNumber);
		System.out.println("/nUstgasnii dra linked list:");
		llist.printList();
/*		// Insert 6. So linked list becomes 6->NUllist
		llist.append(6);

		// Insert 7 at the beginning. So linked list becomes
		// 7->6->NUllist
		llist.push(7);

		// Insert 1 at the beginning. So linked list becomes
		// 1->7->6->NUllist
		llist.push(1);

		// Insert 4 at the end. So linked list becomes
		// 1->7->6->4->NUllist
		llist.append(4);

		// Insert 8, after 7. So linked list becomes
		// 1->7->8->6->4->NUllist
		llist.insertAfter(llist.head.next, 8);

		System.out.println("Linked list: ");
		llist.printList();
		
		llist.deleteNode(1); // Delete node with data 1
		 
        System.out.println("Linked list:");
        llist.printList();
        */
	}
}



