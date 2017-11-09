

public class LinkedList {
	protected Node head;

	public LinkedList() {
	}

	public void append(int item) {
		if (head == null) {
			head = new Node(item, head);
		} else {
			Node tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;

			tmp.next = new Node(item, null);
		}
	}

	
	private void deleteNode(Node node) {
		Node temp = head;
		Node preNode = null;
		if (temp != null && temp.data == node.data) {
			head = temp.next;
			return;
		}
		while (temp != null && temp.data != node.data) {
			preNode = temp;
			temp = temp.next;
		}

		if (temp == null) {
			return;
		}
		preNode.next = temp.next;
	}
	public Node deleteTail() {

		if (head == null || head.next == null)
			return null;
		Node node = head;
		while (node.next.next != null) {
			node = node.next;
		}

		node.next = null;
		return head;
	}

	public void removeGreaterThan(int item) {
		
		if (head == null || head.next == null) {
			return;
		}
		Node node = head;
		while (node != null) {
			if (node.data > item) {
				this.deleteNode(node);
				node = node.next;
			} else {
				node = node.next;
			}
		}
	}	

	public void print() {
		Node node = head;
		StringBuilder sb = new StringBuilder();
		sb.append(node.getData()).append(" --> ");
		while (node.next != null) {
			node = node.next;
			sb.append(node.getData()).append(" --> ");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(10);
		list.append(3);
		list.append(4);
		list.append(8);
		list.append(5);
		list.append(2);
		list.print();
		list.removeGreaterThan(2);
		list.print();

	}

	private static class Node {

		protected int data;
		protected Node next;
		public Node() {}
		public Node(int d, Node n) {
			data = d;
			next = n;
		}


		public int getData() {
			return data;
		}

	}

}
