<?php

class Node
{
    public $data;
    public $next;

    public function __construct($data, $next = null)
    {
        $this->data = $data;
        $this->next = $next;
    }
}

class LinkedList
{
    private $head;

    public function __construct()
    {
        $this->head = null;
    }

    public function append($data)
    {
        $newNode = new Node($data);

        if (!$this->head) 
        {
            $this->head = $newNode;
        } 
        else 
        {
            $temp = $this->head;

            while ($temp->next) 
            {
                $temp = $temp->next;
            }
            $temp->next = $newNode;
        }
    }

    public function prepend($data)
    {
        $newNode = new Node($data, $this->head);
        $this->head = $newNode;
    }

    public function insertAfter($after, $data)
    {
        $temp = $this->head;

        while ($temp && $temp->data != $after) 
        {
            $temp = $temp->next;
        }

        if ($temp) 
        {
            $newNode = new Node($data, $temp->next);
            $temp->next = $newNode;
        }
    }

    public function replace($oldData, $newData)
    {
        $temp = $this->head;

        while ($temp && $temp->data != $oldData) 
        {
            $temp = $temp->next;
        }

        if ($temp) 
        {
            $temp->data = $newData;
        }
    }

    public function replaceLast($data)
    {
        if (!$this->head) return;
        $temp = $this->head;

        while ($temp->next) 
        {
            $temp = $temp->next;
        }
        $temp->data = $data;
    }

    public function insertMiddle($data)
    {
        if (!$this->head) return;
        $slow = $this->head;
        $fast = $this->head;
        $prev = null;

        while ($fast && $fast->next) 
        {
            $prev = $slow;
            $slow = $slow->next;
            $fast = $fast->next->next;
        }

        $newNode = new Node($data, $slow);

        if ($prev) 
        {
            $prev->next = $newNode;
        } 
        else 
        {
            $this->head = $newNode;
        }
    }

    public function count()
    {
        $count = 0;
        $temp = $this->head;

        while ($temp) 
        {
            $count++;
            $temp = $temp->next;
        }

        return $count;
    }

    public function display()
    {
        $temp = $this->head;
        while ($temp) 
        {
            echo $temp->data;

            if ($temp->next) 
            {
                echo " → ";
            }

            $temp = $temp->next;
        }
        echo PHP_EOL;
    }
}

$carList = new LinkedList();
$carList->append("Lexus");
$carList->append("Porsche");
$carList->append("Lincoln");
$carList->append("Toyota");
$carList->append("Mercedes-Benz");

$carList->append("Kia");
$carList->prepend("BMW");
$carList->insertAfter("Porsche", "Honda");
$carList->replace("Lincoln", "Hyundai");
$carList->replaceLast("Subaru");
$carList->insertMiddle("Audi");

echo "Total number of cars in the list: " . $carList->count() . PHP_EOL;
echo "<br>";
$carList->display();
?>