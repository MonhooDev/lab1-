package lab1Alpha;
import java.util.Scanner;

public class LinkedList<G>
{
	Node<G> head; 
	class Node<G>
	{
		G data;
		Node<G> next;
		Node(G d) {data = d; next = null; }
	}

	public void push(G new_data)
	{
		Node<G> new_node = new Node<G>(new_data);
		new_node.next = head;
		head = new_node;
	}

	public void insertAfter(Node<G> prev_node, G new_data)
	{
		if (prev_node == null)
		{
			System.out.println("aldaa NULL");
			return;
		}

		Node<G> new_node = new Node<G>(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}

	public void append(G new_data)
	{
		Node<G> new_node = new Node<G>(new_data);
		if (head == null)
		{
			head = new Node<G>(new_data);
			return;
		}

		new_node.next = null;
		Node<G> last = head;
		while (last.next != null)
			last = last.next;

		last.next = new_node;
		return;
	}
	
	void deleteNode(G key)
    {
        Node<G> temp = head, prev = null;
 
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
		Node<G> tnode = head;
		while (tnode != null)
		{
			System.out.println(tnode.data+" ");
			tnode = tnode.next;
		}
	}

	public static void main(String[] args)
	{
		LinkedList<Integer> llist = new LinkedList<Integer>();
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
		
		System.out.println("1-Ustgah, 2-Nemeh, 0-Garah");
		Boolean quit = false;
		while(!quit)
		{
			int action = listNumber.nextInt();
			switch (action) {
			case 1:
				System.out.println("Ustgah linked list-iig oruulna uu: ");
				int deleteNumber = listNumber.nextInt();
				llist.deleteNode(deleteNumber);
				System.out.println("Ustgasnii dra linked list:");
				llist.printList();
				System.out.println("Draagiin uildlee songono uu '1' '2' '0':");
				break;
			case 2:
				System.out.println("Nemeh list:");
				int plusList = listNumber.nextInt();
				llist.append(plusList);
				System.out.println("Nemsnii dra linked list:");
				llist.printList();
				System.out.println("Draagiin uildlee songono uu '1' '2' '0':");
				break;
			case 0:
				quit = true;		
			}	 
		}
		System.out.println("Etssiin list:");
		llist.printList();					
	}
}
/* public class LinkedList
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
			System.out.println(tnode.data+" ");
			tnode = tnode.next;
		}
	}

	public static void main(String[] args)
	{
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
		
		System.out.println("1-Ustgah, 2-Nemeh, 0-Garah");
		Boolean quit = false;
		while(!quit)
		{
			int action = listNumber.nextInt();
			switch (action) {
			case 1:
				System.out.println("Ustgah linked list-iig oruulna uu: ");
				int deleteNumber = listNumber.nextInt();
				llist.deleteNode(deleteNumber);
				System.out.println("Ustgasnii dra linked list:");
				llist.printList();
				break;
			case 2:
				System.out.println("Nemeh list:");
				int plusList = listNumber.nextInt();
				llist.append(plusList);
				System.out.println("Nemsnii dra linked list:");
				llist.printList();
				break;
			case 0:
				quit = true;		
			}	 
		}
		System.out.println("Ur dun list:");
		llist.printList();					
	}
}
*/


