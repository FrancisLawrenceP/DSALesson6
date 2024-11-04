<?php

function findNthTerm($firstTerm, $difference, $n) 
{
    return $firstTerm + ($n - 1) * $difference;
}

// part a
$firstTermA = 3;
$commonDifferenceA = 6;
$termA = findNthTerm($firstTermA, $commonDifferenceA, 35);
echo "Term 35 is: " . $termA . PHP_EOL;

// part b
$firstTermB = 4;
$commonDifferenceB = -5;
$termB = findNthTerm($firstTermB, $commonDifferenceB, 125);
echo "Term 125 is: " . $termB . PHP_EOL;

// part c
$term5C = -8;
$term25C = 72;
$n1 = 5;
$n2 = 25;
$commonDifferenceC = ($term25C - $term5C) / ($n2 - $n1);
$firstTermC = $term5C - ($n1 - 1) * $commonDifferenceC;
$termC = findNthTerm($firstTermC, $commonDifferenceC, 100);
echo "Term 100 is: " . $termC . PHP_EOL;

// part d
$term5D = -32;
$term18D = 85;
$n1 = 5;
$n2 = 18;
$commonDifferenceD = ($term18D - $term5D) / ($n2 - $n1);
$firstTermD = $term5D - ($n1 - 1) * $commonDifferenceD;
$termD = findNthTerm($firstTermD, $commonDifferenceD, 36);
echo "Term 36 is: " . $termD . PHP_EOL;

?>