// First Download this pdf and try by yourself then you can take help from solutions
// --> https://drive.google.com/file/d/17rPrQN9DC1SjLmRPR3JGjwAvbjrpAvke/view?usp=sharing


// Desclaimer - I am still a learner, so there may be bugs in my solutions or opportunities for optimization.

//If you come across any improvements, I would greatly appreciate it if you could submit a pull request with the updated code, as it will be helpful for both me and others

package Sorting;


import java.util.Arrays;

public class SelectionSort{
    public static void main(String[] args){

    }


    // Question - 1
    static void sort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int min = i;
            for(int j = i +1; j < nums.length; j++){
                if(nums[min] > nums[j]){
                    min = j;
                }
            }

            if(min != i){
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }

        }
    }



    // Question - 2
    static void sort2(int[] nums){

        for(int i = 0; i < nums.length; i++){
            int min = i;
            for(int j = i +1; j < nums.length; j++){
                if(nums[min] < nums[j]){
                    min = j;
                }
            }

            if(min != i){
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }

        }
    }



    // Question - 3
    static int countSwaps(int[] arr){
        if (arr.length <= 1) {
            return 0;
        }

        int swaps = 0;
        int[] nums = Arrays.copyOf(arr,arr.length);

        for(int i = 0; i < nums.length; i++){
            int min = i;
            for(int j = i +1; j < nums.length; j++){
                if(nums[min] > nums[j]){
                    min = j;
                }
            }

            if(min != i){
                // System.out.println(nums[min]);
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
                swaps++;
            }

        }

        return swaps;
    }



    // Question - 4
    static void SortLexico(String[] s){
        for(int i = 0; i < s.length; i++){
            int min = i;
            for(int j = 1+i; j < s.length; j++){
                if(s[min].compareTo(s[j]) > 0){
                    min = j;
                }
            }

            if(min != i){
                String temp = s[min];
                s[min] = s[i];
                s[i] = temp;
            }
        }
    }



    // Question - 5
    static void sortLength(String[] s){
        for(int i = 0; i < s.length; i++){
            int min = i;
            for(int j = i+1; j < s.length; j++){
                if(s[j].length() < s[min].length()){
                    min = j;
                }
            }

            if(min != i){
                String temp = s[min];
                s[min] = s[i];
                s[i] = temp;
            }
        }
    }



    // Question - 6
    static void sortEven(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] %2 == 1){
                continue;
            }
            int min = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] % 2 == 1){
                    continue;
                }
                if(nums[min] > nums[j] && min != j){
                    min = j;
                }
            }

            if(min != i){
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }



    // Question - 7
    static void SortCharacter(char[] c){
        for(int i = 0; i < c.length; i++){
            int min = i;
            for(int j = i+1; j < c.length; j++){
                if(c[j] < c[min]){
                    min = j;
                }
            }
            if(min != i){
                char temp = c[i];
                c[i] = c[min];
                c[min] = temp;
            }
        }
    }



    // Question - 8
    static void stableSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int min = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[min] > nums[j]){
                    min = j;
                }
            }
            if(min != i){
                stableHelper(min,i, nums);
            }
        }
    }
    static void stableHelper(int min , int i, int[] nums){
        for(int j = min;j>i;j--){
            int temp = nums[j];
            nums[j] = nums[j-1];
            nums[j-1] = temp;
        }
    }



    // Question - 9
    static void sortAlternate(int[] nums){
        for(int i = 0; i < nums.length; i+=2){
            int min = i;
            for(int j = i+2; j < nums.length; j+=2){
                if(nums[min] > nums[j]){
                    min = j;
                }
            }

            if(min != i){
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

 

    // Question - 10
    static void sortDigits(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int min = i;
            for(int j = i+1; j < nums.length; j++){
                int e1 = helper(nums[min]);
                int e2 = helper(nums[j]);
                if(e1 > e2){
                    min = j;
                }
                else if (e1 == e2){
                    if(nums[min] > nums[j]){
                        min  = j;
                    }
                }
            }
            if(min != i){
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }

    static int helper(int n){
        int sum = 0;
        int sign = 1;
        if (n < 0) {
            sign *= -1;
            n *= -1;
        }
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }

        return sign * sum;
    }



    // Question - 11
    static void sortNearly(int[] nums, int k){
        for(int i = 0; i < nums.length; i++){
            int min = i;
            for(int j = i+1; j <= i +k && j < nums.length; j++){
                if(nums[min] > nums[j]){
                    min = j;
                }
            }
            if(min != i){
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }



    // Question - 12
    static void  selection(int[] nums){
        selection(nums, 0, 1, 0);
    }

    private static void selection(int[] nums, int row, int col,int min){
        if (row == nums.length) {
            return;
        }

        if (col < nums.length) {
            if (nums[min] > nums[col]) {
                min = col;
            }

            selection(nums, row, col + 1, min);
        }
        if (min != row) {
            int temp = nums[min];
            nums[min] = nums[row];
            nums[row] = temp;
        }

        selection(nums, ++row, row +1, row);
    }



    // Question - 13
    static int movedMost(int[] nums){
        int max_dis = 0;
        int index = -1;
        for(int i = nums.length -1 ; i >= 0; i--){
            int max = i;
            for(int j = i - 1; j >= 0; j--){
                if(nums[max] < nums[j]){
                    max = j;
                }
            }

            if (max != i) {
                int temp = nums[max];
                nums[max] = nums[i];
                nums[i] = temp;

                int distance = i - max;
                if (distance > max_dis) {
                    max_dis = distance;
                    index = i;
                }
            }
        }
        if (index != -1) {
            return nums[index];
        }

        return - 1;
    }



    // Question - 14
    static int[] trackIndex(int[] nums){
        int n = nums.length;
        if (n <= 1) {
            return new int[] {0};
        }
        int[] index = new int[n];
        for(int i = 0; i < n; i++){
            index[i] = i;
        }

        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }


            if (min != i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;

                temp = index[min];
                index[min] = index[i];
                index[i] = temp;
            }
        }

        int[] result = new int[n];
        for(int ind = 0; ind < n; ind++){
            result[index[ind]] = ind;
        }

        return result;
    }
}