#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

struct Node 
{
    std::string data;
    Node* next;
    Node* prev;
    Node(std::string val) : data(val), next(nullptr), prev(nullptr) {}
};

class DoublyLinkedList 
{
private:
    Node* head;
    Node* tail;

public:
    DoublyLinkedList() : head(nullptr), tail(nullptr) {}

    void append(std::string data) 
    {
        Node* newNode = new Node(data);
        if (!head) 
        {
            head = tail = newNode;
        } 
        else 
        {
            tail->next = newNode;
            newNode->prev = tail;
            tail = newNode;
        }
    }

    void printFromHeadToTail()
    {
        Node* current = head;
        while (current) 
        {
            std::cout << current->data << " ";
            current = current->next;
        }
        std::cout << std::endl;
    }

    void printFromTailToHead() 
    {
        Node* current = tail;
        while (current) {
            std::cout << current->data << " ";
            current = current->prev;
        }
        std::cout << std::endl;
    }

    void printFromCarToEnd(std::string car) 
    {
        Node* current = head;
        while (current && current->data != car) 
        {
            current = current->next;
        }
        while (current) 
        {
            std::cout << current->data << " ";
            current = current->next;
        }
        std::cout << std::endl;
    }

    void sortAlphabetically() 
    {
        if (!head) return;

        std::vector<std::string> carList;
        Node* current = head;
        while (current) 
        {
            carList.push_back(current->data);
            current = current->next;
        }

        std::sort(carList.begin(), carList.end());

        current = head;
        for (const auto& car : carList) 
        {
            current->data = car;
            current = current->next;
        }
    }
};

int main() 
{
    DoublyLinkedList carList;
    carList.append("BMW");
    carList.append("Lexus");
    carList.append("Porsche");
    carList.append("Honda");
    carList.append("Audi");
    carList.append("Hyundai");
    carList.append("Toyota");
    carList.append("Mercedes-Benz");
    carList.append("Subaru");

    std::cout << "List from head to tail: ";
    carList.printFromHeadToTail();

    std::cout << "List from tail to head: ";
    carList.printFromTailToHead();

    std::cout << "List from Lexus to tail: ";
    carList.printFromCarToEnd("Lexus");

    carList.sortAlphabetically();
    std::cout << "List in alphabetical order: ";
    carList.printFromHeadToTail();

    return 0;
}