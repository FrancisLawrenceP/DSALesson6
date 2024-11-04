#include <iostream>

int findNthTerm(int firstTerm, int difference, int n) 
{
    return firstTerm + (n - 1) * difference;
}

int main() 
{
    // part a
    int firstTermA = 3;
    int commonDifferenceA = 6;
    int termA = findNthTerm(firstTermA, commonDifferenceA, 35);
    std::cout << "Term 35 is: " << termA << std::endl;

    // part b
    int firstTermB = 4;
    int commonDifferenceB = -5;
    int termB = findNthTerm(firstTermB, commonDifferenceB, 125);
    std::cout << "Term 125 is: " << termB << std::endl;

    // part c
    int term5C = -8;
    int term25C = 72;
    int n1 = 5;
    int n2 = 25;
    int commonDifferenceC = (term25C - term5C) / (n2 - n1);
    int firstTermC = term5C - (n1 - 1) * commonDifferenceC;
    int termC = findNthTerm(firstTermC, commonDifferenceC, 100);
    std::cout << "Term 100 is: " << termC << std::endl;

    // part d
    int term5D = -32;
    int term18D = 85;
    n1 = 5;
    n2 = 18;
    int commonDifferenceD = (term18D - term5D) / (n2 - n1);
    int firstTermD = term5D - (n1 - 1) * commonDifferenceD;
    int termD = findNthTerm(firstTermD, commonDifferenceD, 36);
    std::cout << "Term 36 is: " << termD << std::endl;

    return 0;
}
