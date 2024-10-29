public class linkedlist4
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
        linkedlist4 llist = new linkedlist4();
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
        int count = 0;

        while (n != null && count < 4) 
        {
            System.out.println(n.data);
            n = n.next;
            count++;
        }
    }
}