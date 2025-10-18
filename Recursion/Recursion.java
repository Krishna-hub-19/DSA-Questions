// Question Pdf 
// --> https://drive.google.com/file/d/1Dw69BNQglMuLhXvgw2o0-Q8vgRD2D-H9/view?usp=sharing

// First Download this pdf and try by yourself then you can take help from solutions

// Desclaimer - I am still in the learning phase, so there may be bugs in my solutions or opportunities for optimization.
//If you come across any improvements, I would greatly appreciate it if you could submit a pull request with the updated code, as it will be helpful for both me and others

package Recursion;

import java.util.ArrayList;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(ProductOfDigits(2356));
    }


    // Question - 1
    static void Print1ToN(int n){
        if(n == 0){
            return;
        }

        Print1ToN(n-1);

        System.out.print(n + " ");
    }





    // Question - 2
    static void PrintNTo1(int n){
        if(n == 0){
            return;
        }

        System.out.print(n + " ");
        PrintNTo1(n -1);
    }

    



    // Question - 3
    static int facotorial(int n){
        if(n <= 1){
            return 1;
        }

        return n*(facotorial(n-1));
    }





    // Question - 4 --> if you pass 0000 as a n, it still returns 0
    static int SumOfNaturalNo(int n){
        if(n == 1){
            return 0;
        }

        return n+(SumOfNaturalNo(n-1));
    }





    // Question - 5
    static boolean isArraySorted(int[] arr,int n){
        if(n == arr.length - 1){
            return true;
        }

        if(arr[n] > arr[n+1]){
            return false;
        }

        return isArraySorted(arr, n+1);
    }





    // Question - 6
    static int countDigits(int n){
        if(n == 0){
            return 1;
        }

        return 1+ countDigits(n/10);
    }





    // Question - 7
    static String ReverseString(String s){
        StringBuilder sb = new StringBuilder(s);

        sb.reverse();

        return sb.toString();
    }





    // Question - 8
    static int FindPower(int n,int pow){
        if(pow == 1){
            return n;
        }

        return n*(FindPower(n,pow-1));
    }





    // Question - 9
    static void PrintElementOfArray(int[] arr,int index){
        if(arr.length == index){
            return;
        }
 
        System.out.print(arr[index] + " ");

        PrintElementOfArray(arr, index+1);
    }





    // Question - 10
    static int countZeros(int n){
        int sum = 0;
        return countZerosHelper(n, sum);
    }
    static int countZerosHelper(int n,int sum){

        if(n == 0){
            return sum;
        }

        if(n%10 == 0){
            sum++;
        }

        return countZerosHelper(n/10,sum);
    }




    
    // Question - 11
    static boolean isStringPalindrome(String s){
        return isStringPalindromeHelper("", s,s.length()-1).equals(s);
    }

    static String isStringPalindromeHelper(String p,String s,int index){

        if(index == -1){
            return p;
        }

        p += s.charAt(index);
        return isStringPalindromeHelper(p, s, index-1);
    }





    // Question - 12
    static int Fibo(int n){
        if(n < 2){
            return n;
        }
        return Fibo(n-2) + Fibo(n-1);
    }






    // Question - 13
    static String BinaryRepresentation(int n,String p){

        if(n == 1 || n == 0){
            return (n%2 + "");
        }

        p += BinaryRepresentation(n/2, p);

        p += n%2;
        return p;
    }





    // Question - 14
    static int ProductOfDigits(int n){
        if(n == 0){
            return 1;
        }
        return n%10*(ProductOfDigits(n/10));
    }






    // Question - 15
    static String RemoveA(String a,String b,int index){
        if(index == b.length()){
            return a;
        }

        char c = b.charAt(index);
        if(c != 'a'){
            a += c;
        }

        return RemoveA(a, b, index+1);
    }





    // Question - 16
    static int firstIndex(int[] arr,int target,int index){
        if(index == arr.length){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return firstIndex(arr, target, index+1);
    }





    // Question - 17
    static ArrayList<Integer> AllIndices(int[] arr, int target){
        ArrayList<Integer> l = new ArrayList<>();
        AllIndicesHelper(arr,target,0,l);
        return l;
    }


    static ArrayList<Integer> AllIndicesHelper(int[] arr,int target, int index,ArrayList<Integer> l){
        if(index == arr.length){
            return l;
        }

        if(arr[index] == target){
            l.add(index);
        }

        return AllIndicesHelper(arr,target,index+1,l);
    }






    // Question - 18
    static boolean isPrime(int n,int no){

        if(no > (int)Math.sqrt(n)){
            return true;
        }

        if(n%no == 0){
            return false;
        }
        return isPrime(n, no+1);
    }

 



    // Question - 19
    static int SumOfDigits(int n,int sum){
        if(n == 0){
            return sum;
        }
        
        sum += n%10;
        
        return SumOfDigits(n/10, sum);
    }





    // Question - 20
    static int CountSteps(int n,int steps){
        if(n == 0){
            return steps;
        }

        if(n%2 == 1){
            n--;
        }
        else{
            n /= 2;
        }

        return CountSteps(n, ++steps);
    }

}