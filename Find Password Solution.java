31. WTN-MS1-Find Password-6
Detective Buckshee Junior has been approached by the ARVIJAYAKUMAR Kids Society for help in finding the password to the games complex. After hearing the scenario, detective Buckshee Junior realises that he will need a programmer’s support. He contacts you and requests your help. Please help the detective by writing a function to generate the password.
The scenario is below:
Five numbers are available with the kids.
These numbers are either stable or unstable.
A number is stable if each of its digits occur the same number of times, i.e. the frequency of each digit in the number is the same. For e.g. 2277, 4004, 11, 23, 583835, 1010 are examples of stable numbers.
Similarly, a number is unstable if the frequency of each digit in the number is NOT the same. For e.g. 221, 4314, 101, 233, 58135, 101 are examples of unstable numbers.
The password can be found as below:
i.e. password = Sum of ODD unstable numbers + Sum of EVEN stable numbers
 
Assuming that the five numbers are passed to a function as input1, input2, input3, input4 and input5, complete the function to find and return the password.
For example:
If input1 = 12, input2 = 1313, input3 = 122, input4 = 678 and input5 = 898, we see that there are:
THREE stable numbers i.e. 12, 1313 and 678 and
TWO unstable numbers i.e. 122 and 898
So, the password should be = Sum of ODD unstable numbers + Sum of EVEN `stable numbers 	= (0) + (12+678) = 690
Note: If no ODD unstable number & EVEN stable in the list you have to return -1.
TEST CASE -1
INPUT:
12 1313 122 678 898
 
OUTPUT:
690
 
TEST CASE -2
INPUT:
1122 1232 1234 8764 1112
 
OUTPUT:
11120

------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------- S O L U T I O N ------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int Password[] = new int[5];
        for(int i = 0; i < Password.length; i++){
            Password[i] = scanner.nextInt();
        }
        int input1 = Password[0];
        int input2 = Password[1];
        int input3 = Password[2];
        int input4 = Password[3];
        int input5 = Password[4];
        int sumOfStable = 0;
        int sumOfUnstable = 0;
        
        if (isStable(input1) && input1%2 == 0) sumOfStable += input1;
        else if (!isStable(input1) && input1%2 != 0) sumOfUnstable += input1;
        
        if (isStable(input2) && input2%2 == 0) sumOfStable += input2;
        else if (!isStable(input2) && input2%2 != 0)sumOfUnstable += input2;
        
        if (isStable(input3) && input3%2 == 0) sumOfStable += input3;
        else if (!isStable(input3) && input3%2 != 0)sumOfUnstable += input3;
        
        if (isStable(input4) && input4%2 == 0) sumOfStable += input4;
        else if (!isStable(input4) && input4%2 != 0)sumOfUnstable += input4;
        
        if (isStable(input5) && input5%2 == 0) sumOfStable += input5;
        else if (!isStable(input5) && input5%2 != 0)sumOfUnstable += input5;
 
        if((sumOfStable + sumOfUnstable)>0){
            System.out.println(sumOfStable + sumOfUnstable);
        }
        else System.out.print(-1);
    }
    public static boolean isStable(int number){ 
        boolean isStable = true;
        int[] frequency = new int[10];
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            frequency[Integer.parseInt(String.valueOf(numberString.charAt(i)))]++;
        }    
        int firstFrequency = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                firstFrequency = frequency[i];
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (frequency[i] != 0 && frequency[i] != firstFrequency) {
                isStable = false;
                break;
            }
        }
        return isStable;
    }  
}

