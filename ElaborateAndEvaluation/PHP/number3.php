<?php

class Node 
{
    public $data;
    public $next;
    public $prev;

    public function __construct($val) 
    {
        $this->data = $val;
        $this->next = null;
        $this->prev = null;
    }
}

class DoublyLinkedList 
{
    private $head;
    private $tail;

    public function __construct() 
    {
        $this->head = null;
        $this->tail = null;
    }

    public function append($data) 
    {
        $newNode = new Node($data);
        if (!$this->head) 
        {
            $this->head = $this->tail = $newNode;
        } 
        else 
        {
            $this->tail->next = $newNode;
            $newNode->prev = $this->tail;
            $this->tail = $newNode;
        }
    }

    public function printFromHeadToTail() 
    {
        $current = $this->head;

        while ($current) 
        {
            echo $current->data . " ";
            $current = $current->next;
        }
        echo PHP_EOL;
    }

    public function printFromTailToHead() 
    {
        $current = $this->tail;

        while ($current) 
        {
            echo $current->data . " ";
            $current = $current->prev;
        }
        echo PHP_EOL;
    }

    public function printFromCarToEnd($car) 
    {
        $current = $this->head;
        while ($current && $current->data != $car) 
        {
            $current = $current->next;
        }
        while ($current) 
        {
            echo $current->data . " ";
            $current = $current->next;
        }
        echo PHP_EOL;
    }

    public function sortAlphabetically() 
    {
        if (!$this->head) return;

        $carList = [];
        $current = $this->head;
        while ($current) 
        {
            $carList[] = $current->data;
            $current = $current->next;
        }

        sort($carList);

        $current = $this->head;
        foreach ($carList as $car) 
        {
            $current->data = $car;
            $current = $current->next;
        }
    }
}

$carList = new DoublyLinkedList();
$carList->append("BMW");
$carList->append("Lexus");
$carList->append("Porsche");
$carList->append("Honda");
$carList->append("Audi");
$carList->append("Hyundai");
$carList->append("Toyota");
$carList->append("Mercedes-Benz");
$carList->append("Subaru");

echo "List from head to tail: ";
$carList->printFromHeadToTail();

echo "List from tail to head: ";
$carList->printFromTailToHead();

echo "List from Hyundai to tail: ";
$carList->printFromCarToEnd("Hyundai");

$carList->sortAlphabetically();
echo "List in alphabetical order: ";
$carList->printFromHeadToTail();

?>