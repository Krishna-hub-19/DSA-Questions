// Question Pdf 
// --> https://www.linkedin.com/posts/krishna-garg-32bb59303_30-essential-array-questions-in-java-of-activity-7369387540925059075-cNAZ?

// First Download this pdf and try by yourself then you can take help from solutions

// Desclaimer - I am still in the learning phase, so there may be bugs in my solutions or opportunities for optimization.
//If you come across any improvements, I would greatly appreciate it if you could submit a pull request with the updated code, as it will be helpful for both me and others.

package Searching;

import java.util.ArrayList;
import java.util.Arrays;
public class ArrayQuestion {

    public static void main(String[] args) {
        
    }




    // Question - 1
    static int find_Index(int[] nums,int target){
        for(int i = 0;i <nums.length;i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }



    // Question - 2
    static boolean Exist(int[] numes,int target){
        return find_Index(numes, target) != -1;
    }



    // Question - 3
    static int count(int[] nums,int target){
        int count = 0;
        for(int i:nums){
            if(i == target){
                count++;
            }
        }

        return count;
    }


    // Question - 4
    static int[] first_last_index(int[] nums,int target){
        int[] index = {-1,-1};
        int first = 0;
        int last = nums.length -1;

        // 1st method
        while (first<=last) {
            if(nums[first] == target && index[0] == -1){
                index[0] = first;
            }
            if(nums[last] == target && index[1] == -1){
                index[1] = last;
            }

            if(index[0] != -1 && index[1] != -1){ // early check
                break;
            }
            first++;
            last--;
        }

        
        // 2nd method
        for(int i = 0; i<nums.length; i++){ // Here if we don't find the last element then first will also count as the last one (means only one element is present)
            if(nums[i] == target){
                if(index[0] == -1){
                    index[0] = i;
                }
                index[1] = i;
            }
        }
        return index;
    }



    //Question - 5
    static int SearchChar(String s,char c){
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == c){
                return i;
            }
        }
        return -1;
    }



    //Question - 6
    static int[] min_max(int[] nums){
        int min = nums[0];
        int max = nums[0];
        
        for(int i:nums){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }

        return new int[]{min,max};
    }



    // Question - 7
    static int sum(int[] nums){
        int sum = 0;
        for(int i :nums){
            sum += i;
        }

        return sum;
    }



    
    // Question - 8
    static int first_even(int[] nums){
        for(int i :nums){
            if(i%2 == 0){
                return i;
            }
        }
        return -1;
    }




    // Question - 9
    static int[] Search_2d(int[][] nums, int target){
        for(int row = 0;row<nums.length;row++){
            for(int col = 0;col<nums[row].length;col++){
                if(nums[row][col] == target){
                    return new int[]{row,col};
                }
            }
        }

        return new int[]{-1,-1};

    }




    //Quetion - 10
    static int in_indices(int[] nums,int target,int start, int end){
        while (start <= end) {
            if (nums[start] == target) {
                return start;
            }
            start++;
        }
        return -1;
    }


    

    // Question - 11
    static int first_neg(int[] nums){
        for(int i :nums){
            if(i < 0) {
                return i;
            }
        }

        return -1; // no negative no. is present
    }




    //Question - 12
    static ArrayList<Integer> all_index(int[] nums,int target){
        ArrayList<Integer> l = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            if(nums[i] == target){
                l.add(i);
            }
        }

        return l;
    }



    // Question - 13
    static int prime(int[] nums){
        for(int i :nums){

            if(i < 2) continue;

            boolean flag = true;
            for(int j = 2;j<=Math.sqrt(i);j++){
                if(i %j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }

        return -1; // no prime no. present in array
    }




    // Question - 14
    static int closet(int[] nums,int target){
        if(nums.length == 0) return -1;
        int close = nums[0];
        int mindiff = Math.abs(nums[0] - target);

        for(int i = 1;i<nums.length;i++){
            int diff1 = Math.abs(nums[i] - target);
            if(diff1 < mindiff){
                close = nums[i];
                mindiff = diff1;
            }
            else if(mindiff == diff1 && (nums[i] < close)){ // works only when two no are have same different but we want smaller one. ig: target = 7, arr = 5,9,8 --> here 9 and 8 both have same difference from our target but we want smaller one but if you don't mind by smaller or greater you just want a closet no. then you can remove this line completely
                close = nums[i];
            }
        }

        return close;
    }



    // Question - 15
    static int second_max(int[] nums){

        int first_max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;

        for(int i:nums){
            if(i > first_max){
                second_max = first_max;
                first_max = i;
            }
            else if(i > second_max && i!= first_max){
                second_max = i;
            }
        }

        return second_max == Integer.MIN_VALUE ? -1:second_max;
    }




    // Question - 16
    static int[] count_odd_even(int[] nums){
        int[] n = {0,0};
        for(int i:nums){
            if(i %2 == 0){
                n[0]++;
            }
            else{
                n[1]++;
            }
        }
        return n;
    }




    // Question - 17
    static ArrayList<String> count_freq(int[] nums){
        ArrayList<String> l = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        for(int i:nums){
            int count = 0;
            if(l1.contains(i)){
                continue;
            }
            l1.add(i);
            for(int j:nums){
                if(i == j){
                    count++;
                }
            }
            l.add(i + ":" + count);
        }

        return l;
    }




    // Question - 18
    static void replace_all(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                nums[i] = -1;
            }
        }
    }




    // Question - 19  & 27 - Only valid for a particular range, and with sorted array
    static int kthMissing(int[] nums, int k){
        for(int i = 0;i<nums.length;i++){
            if(nums[i] < k){
                k++;
            }
        }
        return k;
    }




    // Question - 20
    static ArrayList<ArrayList<Integer>> target_sum(int[] nums,int target){
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    ArrayList<Integer> k = new ArrayList<>();
                    k.add(nums[i]);
                    k.add(nums[j]);
                    l.add(k);
                }
            }
        }
        return l;
    }





    // Question - 21
    static void reverse_Array(int[] nums){

        int len = nums.length;
        for(int i = 0; i < len/2; i++){
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
    }



    
    // Question - 22
    static void k_Last(int[] nums, int k){

        if(nums.length == 0 || k == 0) return;

        int n = nums.length - 1;

        for(int i = n; i > n - k; i--){

            int temp = nums[n];
            moved(nums);

            nums[0] = temp;
        }
    }

    static void moved(int[] nums){
        
        int n = nums.length - 1;
        for(int i = n; i > 0; i-- ){
            nums[i] = nums[i - 1];
        }
    }  




    // Question - 23
    static int[] Merge_Sorted(int[] nums, int[] arr){

        int n = nums.length;
        int n1 = arr.length;

        int[] temp = new int[n + n1];

        int j = 0;
        int i = 0;
        int indx = 0;

        while (i < n && j < n1) {
            if(nums[i] < arr[j]){
                temp[indx] = nums[i++];
            }
            else{
                temp[indx] = arr[j++];
            }

            indx++;
        }


        while (i < n) {
            temp[indx++] = nums[i++];
        }

        while (j < n1) {
            temp[indx++] = arr[j++];
        }

        return temp;
    }




    // Question - 24
    static ArrayList<Integer> InterSection(int[] nums, int[] arr){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(nums[i] == arr[j]){
                    list.add(nums[i]);
                }
            }
        }

        return list;
    }




    // Question - 25
    static ArrayList<Integer> Union(int[] nums, int[] arr){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
            }
        }


        return list;
    }




    // Question - 26
    static boolean sorted(int[] nums){

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]) return false;
        }

        return true;    
    }





    // Question - 28
    static int highest_freq(int[] nums){
        int[] n = new int[nums.length];
        
        int indx = 0;
        for(int i:nums){
            int count = 0;
            for(int j:nums){
                if(i == j){
                    count++;
                }
            }
            n[indx++] = count;
        }

        int max = n[0];
        for(int i = 1;i<n.length;i++){
            if(n[i] > max){
                max = n[i];
            }
        }
        return max;
    }





    // Question - 29
    static int First_reapeating(int[] temp){

        int n = temp.length;

        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = temp[i];
        }

        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]) return nums[i];
        }

        return -1;
    }


    

    // Question - 30
    static int kth_Largest(int[] nums, int k){

        int n = nums.length;
        int[] temp = new int[n];

        for(int i = 0; i < n; i++){
            temp[i] = nums[i];
        }

        Arrays.sort(temp);

        return temp[n - k];
    }
}
