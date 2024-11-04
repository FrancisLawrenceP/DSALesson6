/* 
 *This is not working in CodeSpace. 
 *Please go to the Php or C++ code to check.
 * Otherwise, download the file andn run it locally.
 * The error here is:
 * Exception in thread "main" java.lang.Error: Unresolved compilation problem: 

        at ElaborateAndEvaluation.Java.number1.main(number1.java:12)
*/


public class Number2 
{

    static class Node 
    {
        String data;
        Node next;

        Node(String data) 
        {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList 
    {
        private Node head;

        public LinkedList() 
        {
            this.head = null;
        }

        public void append(String data) 
        {
            Node newNode = new Node(data);

            if (head == null) 
            {
                head = newNode;
            } 
            else 
            {
                Node temp = head;
                while (temp.next != null) 
                {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        public void prepend(String data) 
        {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public void insertAfter(String after, String data) 
        {
            Node temp = head;
            while (temp != null && !temp.data.equals(after)) 
            {
                temp = temp.next;
            }

            if (temp != null) 
            {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }

        public void replace(String oldData, String newData) 
        {
            Node temp = head;
            while (temp != null && !temp.data.equals(oldData)) 
            {
                temp = temp.next;
            }

            if (temp != null) 
            {
                temp.data = newData;
            }
        }

        public void replaceLast(String data) 
        {
            if (head == null) return;
            Node temp = head;
            while (temp.next != null) 
            {
                temp = temp.next;
            }
            temp.data = data;
        }

        public void insertMiddle(String data) 
        {
            if (head == null) return;
            Node slow = head;
            Node fast = head;
            Node prev = null;

            while (fast != null && fast.next != null) 
            {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            Node newNode = new Node(data);
            newNode.next = slow;

            if (prev != null) 
            {
                prev.next = newNode;
            } 
            else 
            {
                head = newNode;
            }
        }

        public int count() 
        {
            int count = 0;
            Node temp = head;
            while (temp != null) 
            {
                count++;
                temp = temp.next;
            }
            return count;
        }

        public void display() 
        {
            Node temp = head;
            while (temp != null) 
            {
                System.out.print(temp.data);
                if (temp.next != null) 
                {
                    System.out.print(" → ");
                }
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) 
    {
        LinkedList carList = new LinkedList();
        carList.append("Lexus");
        carList.append("Porsche");
        carList.append("Lincoln");
        carList.append("Toyota");
        carList.append("Mercedes-Benz");

        carList.append("Kia");
        carList.prepend("BMW");
        carList.insertAfter("Porsche", "Honda");
        carList.replace("Lincoln", "Hyundai");
        carList.replaceLast("Subaru");
        carList.insertMiddle("Audi");

        System.out.println("Total number of cars in the list: " + carList.count());
        carList.display();
    }
}