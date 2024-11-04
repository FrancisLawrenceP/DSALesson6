/* 
 *This is not working in CodeSpace. 
 *Please go to the Php or C++ code to check.
 * Otherwise, download the file andn run it locally.
 * The error here is:
 * Exception in thread "main" java.lang.Error: Unresolved compilation problem: 

        at ElaborateAndEvaluation.Java.number1.main(number1.java:17)
*/
public class Number1 
{
    static int findNthTerm(int firstTerm, int difference, int n) 
    {
        return firstTerm + (n - 1) * difference;
    }

    public static void main(String[] args)
    {
        // part a
        int firstTermA = 3;
        int commonDifferenceA = 6;
        int termA = findNthTerm(firstTermA, commonDifferenceA, 35);
        System.out.println("Term 35 is: " + termA);

        // part b
        int firstTermB = 4;
        int commonDifferenceB = -5;
        int termB = findNthTerm(firstTermB, commonDifferenceB, 125);
        System.out.println("Term 125 is: " + termB);

        // part c
        int term5C = -8;
        int term25C = 72;
        int n1 = 5;
        int n2 = 25;
        int commonDifferenceC = (term25C - term5C) / (n2 - n1);
        int firstTermC = term5C - (n1 - 1) * commonDifferenceC;
        int termC = findNthTerm(firstTermC, commonDifferenceC, 100);
        System.out.println("Term 100 is: " + termC);

        // part d
        int term5D = -32;
        int term18D = 85;
        n1 = 5;
        n2 = 18;
        int commonDifferenceD = (term18D - term5D) / (n2 - n1);
        int firstTermD = term5D - (n1 - 1) * commonDifferenceD;
        int termD = findNthTerm(firstTermD, commonDifferenceD, 36);
        System.out.println("Term 36 is: " + termD);
    }
}