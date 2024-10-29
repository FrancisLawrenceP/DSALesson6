public class linkedlist3 
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
        linkedlist3 llist = new linkedlist3();
        llist.head = new Node(7);
        Node second = new Node(12);
        Node third = new Node(15);
        Node fourth = new Node(18);
        Node fifth = new Node(24);
        Node sixth = new Node(30);

        llist.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

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
