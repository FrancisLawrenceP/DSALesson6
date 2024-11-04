class Node 
{
    String data;
    Node next;
    Node prev;

    Node(String val) 
    {
        data = val;
        next = null;
        prev = null;
    }
}

class DoublyLinkedList 
{
    private Node head;
    private Node tail;

    DoublyLinkedList() 
    {
        head = null;
        tail = null;
    }

    void append(String data) 
    {
        Node newNode = new Node(data);
        if (head == null) 
        {
            head = tail = newNode;
        } 
        else 
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void printFromHeadToTail() 
    {
        Node current = head;
        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    void printFromTailToHead() 
    {
        Node current = tail;

        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    void printFromCarToEnd(String car) 
    {
        Node current = head;

        while (current != null && !current.data.equals(car)) 
        {
            current = current.next;
        }
        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    void sortAlphabetically() 
    {
        if (head == null) return;

        java.util.List<String> carList = new java.util.ArrayList<>();
        Node current = head;
        while (current != null)
         {
            carList.add(current.data);
            current = current.next;
        }

        java.util.Collections.sort(carList);

        current = head;
        for (String car : carList) 
        {
            current.data = car;
            current = current.next;
        }
    }

    public static void main(String[] args) 
    {
        DoublyLinkedList carList = new DoublyLinkedList();
        carList.append("BMW");
        carList.append("Lexus");
        carList.append("Porsche");
        carList.append("Honda");
        carList.append("Audi");
        carList.append("Hyundai");
        carList.append("Toyota");
        carList.append("Mercedes-Benz");
        carList.append("Subaru");

        System.out.print("List from head to tail: ");
        carList.printFromHeadToTail();

        System.out.print("List from tail to head: ");
        carList.printFromTailToHead();

        System.out.print("List from Hyundai to tail: ");
        carList.printFromCarToEnd("Hyundai");

        carList.sortAlphabetically();
        System.out.print("List in alphabetical order: ");
        carList.printFromHeadToTail();
    }
}