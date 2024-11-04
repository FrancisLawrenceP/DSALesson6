#include <iostream>
#include <string>

struct Node 
{
    std::string data;
    Node* next;
};

class LinkedList 
{
public:
    LinkedList() : head(nullptr) {}

    void append(const std::string& data) 
    {
        Node* newNode = new Node{data, nullptr};

        if (!head) 
        {
            head = newNode;
        } 
        else 
        {
            Node* temp = head;

            while (temp->next) 
            {
                temp = temp->next;
            }
            temp->next = newNode;
        }
    }

    void prepend(const std::string& data) 
    {
        Node* newNode = new Node{data, head};
        head = newNode;
    }

    void insertAfter(const std::string& after, const std::string& data) 
    {
        Node* temp = head;

        while (temp && temp->data != after) 
        {
            temp = temp->next;
        }

        if (temp) 
        {
            Node* newNode = new Node{data, temp->next};
            temp->next = newNode;
        }
    }

    void replace(const std::string& oldData, const std::string& newData) 
    {
        Node* temp = head;

        while (temp && temp->data != oldData) 
        {
            temp = temp->next;
        }

        if (temp) 
        {
            temp->data = newData;
        }
    }

    void replaceLast(const std::string& data) 
    {
        if (!head) return;
        Node* temp = head;

        while (temp->next) 
        {
            temp = temp->next;
        }
        temp->data = data;
    }

    void insertMiddle(const std::string& data) 
    {
        if (!head) return;
        Node* slow = head;
        Node* fast = head;
        Node* prev = nullptr;

        while (fast && fast->next) 
        {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }

        Node* newNode = new Node{data, slow};

        if (prev) 
        {
            prev->next = newNode;
        } 
        else 
        {
            head = newNode;
        }
    }

    int count() const 
    {
        int count = 0;
        Node* temp = head;

        while (temp) 
        {
            count++;
            temp = temp->next;
        }

        return count;
    }

    void display() const 
    {
        Node* temp = head;
        while (temp) 
        {
            std::cout << temp->data;

            if (temp->next) 
            {
                std::cout << " → ";
            }

            temp = temp->next;
        }
        std::cout << std::endl;
    }

private:
    Node* head;
};

int main() 
{
    LinkedList carList;
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

    std::cout << "Total number of cars in the list: " << carList.count() << std::endl;
    carList.display();

    return 0;
}