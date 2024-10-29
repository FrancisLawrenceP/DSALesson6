public class linkedlist2 
{
    Node head;

    static class Node 
    {
        int data;
        Node next;

        Node(int d) 
        {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) 
    {
        linkedlist2 llist = new linkedlist2();
        llist.head = new Node(12);
        Node second = new Node(15);
        Node third = new Node(24);

        llist.head.next = second;
        second.next = third;

        llist.printList();
    }

    public void printList() 
    {
        Node n = head;
        while (n != null) 
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
