// Question Pdf 
// --> https://www.linkedin.com/posts/krishna-garg-32bb59303_dsa-journey-update-binary-search-patterns-activity-7372261940284530688-Ies2?
// First Download this pdf and try by yourself then you can take help from solutions if you want

// Desclaimer - I am still in the learning phase, so there may be bugs in my solutions or opportunities for optimization.
//If you come across any improvements, I would greatly appreciate it if you could submit a pull request with the updated code, as it will be helpful for both me and others.


package Searching
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        
     }

    // Question - 1
    static int binary(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }

        return -1;
    }




    // Question - 2
    static int first_occurence_binary(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] >= target){
                end = mid -1;
            }
            else{
                start = mid +1;
            }
            if(nums[mid] == target){
                ans = mid;
            }
        }

        return ans;
    }




    // Question -3
    static int last_occurence_binary(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] <= target){
                start = mid+1;
            }
            else{
                end = mid -1;
            }
            if(nums[mid] == target){
                result = mid;
            }
            // else{
            //     start = mid +1;
            // }
        }
        return result;
    }




    // Question - 4
    static int count_freq(int[] nums, int target){
        int first = first_occurence_binary(nums, target); // since it is sorted we can calculate freq by finding first and last occurence and take difference of them
        int last = last_occurence_binary(nums, target);

        if(first == -1){
            return -1;
        }
        
        return last+1 - first; // since array started from 0 so we add 1 in last
    }




    // Question - 5
    static int binary_decending(int[] nums,int target){
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }

        return -1;
    }


   

    // Question no - 6
    static boolean IsExst(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid] < target){
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }

        return false;
    }




    // Question - 7
    static int SquareRoot(int num){
        int start = 0;
        int end = num;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if((long)mid * mid == num){
                return mid;
            }
            else if(mid*mid > num){
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return end;
    }




    // Question - 8
    static int peak(int[] nums){
        int start = 0;
        int end = nums.length -1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if(mid < end && nums[mid]>nums[mid+1]){
                end = mid;
            }
            else if(mid > start && nums[mid] < nums[mid -1]){
                end = mid;
            }
            else{
                start = mid +1;
            }
        }

        return end;
    }




    // Question - 9
    static int RotatedBinary(int[] nums,int target){
        int pivot  = pivot(nums);
        if(nums[pivot] == target){
            return pivot;
        }
        if(pivot == -1){
            return binary2(nums,0,nums.length -1,target);
        }
        if(nums[0] <= target && target <= nums[pivot]){
            return binary2(nums,0,pivot,target);
        }
        return binary2(nums,pivot+1,nums.length-1,target);
    }



    static int binary2(int[] num,int start,int end,int target){
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(num[mid] == target){
                return mid;
            }
            else if(num[mid] < target){
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }

        return -1;
    }




    // Question - 10
    static int pivot(int[] nums){
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(mid < end && nums[mid] > nums[mid +1]){
                return mid;
            }
            else if(mid > start && nums[mid] < nums[mid -1]){
                return mid -1;
            }
            else if(nums[0] > nums[mid]){
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        
        return -1;        
    }
        



    // Question - 11
    static int[] Binary2d(int[][] nums,int target){
        int[] result = {-1,-1};
        int end = nums.length -1;
        int row = 0;
        for(int[] i:nums){
            if(i[end] >= target){
                return new int[]{row,binary2(i,0,end,target)};
            }
            row++;
        }

        return result;


    }




    //Question - 12
    static int floor(int[] nums,int target){
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return end >= 0? end:-1;
    }




    //Question - 13 
    // 19  --> start is the point where the element should be present and if the element is not present then start is the value where element should be
    static int ceil(int[] nums,int target){
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return start< nums.length?start:-1;
    }




    // Question - 14
    static int RoatedMin(int[] nums){
        int p = pivot(nums);
        if(p == -1){
            return nums[0];
        }
        else{
            return nums[p+1];
        }
    }



    
    // Question - 15
  static int PageAllocation(int[] nums,int students){
    int ans = -1;
    int start = 0;
    int end = 0;
    for(int i:nums){
        end += i;
    }

    while (start <= end) {
        int mid = start + (end - start)/2;
        if(isValid(nums, students, mid)){
            ans = mid;        
            end = mid -1;
        }
        else{
            start = mid +1;
        }
    }
    return ans;
  }


  static boolean isValid(int[] nums ,int students,int MaxPages){
    int student = 1;
    int pages = 0;
    for(int i :nums){
        if(i > MaxPages){
            return false;
        }
        else if(pages + i <= MaxPages){
            pages += i;
        }
        else{
            pages = i;
            student++;
        }
    }

    return student <= students;
  }




  // Question - 16
  static int AggressiveCows(int[] nums,int Ncows){
    Arrays.sort(nums);
    int ans = -1;
    int start = 1;
    int end = nums[nums.length -1] - nums[0];

    while (start <= end) {
        int mid = start + (end - start)/2; 
        if(isValid2(nums,mid,Ncows)){
            ans = mid;
            start = mid +1;
        }
        else{
            end = mid -1;
        }
    }

    return ans;
  }


  static boolean isValid2(int[] nums,int MaxDistance,int NCows){
    int cows =1;
    int minDistance = nums[0];
    for(int i = 1;i<nums.length;i++){
        if(nums[i] - minDistance >= MaxDistance){
            cows++;
            minDistance = nums[i];
        }
        if(cows >= NCows){
            return true;
        }
    }
    return false;
  }




  // Question - 17
//   Painter's Problem
  static int painter(int[] board,int painters){
    int start = board[0];
    int end = 0;
    int ans = -1;
    for(int i :board){
        if(i > start){
            start = i;
        }
        end += i;
    }

    while (start <= end) {
        int mid = start + (end - start)/2;
        if(isValid3(board,mid,painters)){
            ans = mid;
            end = mid -1;
        }
        else{
            start = mid +1;
        }
    }

    return ans;
  }


  static boolean isValid3(int[] board,int mid, int painters){
    int painter = 1;
    int MinTime = 0;

    for(int i :board){
        if(i > mid){
            return false;
        }
        else if(MinTime + i <= mid){
            MinTime += i;
        }
        else{
            painter++;
            MinTime = i;
        }
    }

    return painter <= painters;
  }




  //Question - 18
  static int splitArray(int[] nums,int k){
    int start = nums[0];
    int end = 0;
    int ans = -1;
    for(int i :nums){
        if(i > start){
            start = i;
        }
        end += i;
    }

    while (start <= end) {
        int mid = start + (end - start)/2;
        if (isValid4(nums,k,mid)) {
            ans = mid;
            end = mid -1;
        }
        else{
            start = mid +1;
        }
    }

    return ans;
  }


  static boolean isValid4(int[] num,int k, int mid){
    int s = 0;
    int k1 = 1;
    for(int i:num){
        if(s + i <= mid){
            s += i;
        }
        else{
            s = i;
            k1++;
        }
    }

    return k1 <= k;
  }




    // Question - 20
    static int SmallestDivisor(int[] nums, int thresold){
        int ans = -1;
        int start = 1;
        int end = Integer.MIN_VALUE;

        for(int i :nums){
            end = Math.max(i, end);
        }

        while (start <= end) {
            int mid = start + (end - start)/2;
            if(IsValid5(nums,thresold,mid)){
                ans = mid;
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
    }


    static boolean IsValid5(int[] nums, int thresold, int mid){
        int sum = 0;
        for(int i : nums){
            sum += (i + mid -1)/mid;
        }

        if(sum <= thresold){
            return true;
        }
        return false;
    }





    // Question - 21
    static int WeightCapacity(int[] weights, int days){
        int ans = -1;
        int start = Integer.MIN_VALUE;
        int end = 0;
        for(int i :weights){
            if(i > start){
                start = i;
            }
            end += i;
        }
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(IsValid6(weights,mid,days)){
                ans = mid;
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
    }


    static boolean IsValid6(int[] weights,int mid, int days){
        int day  = 1;
        int sum = 0;
        for(int i :weights){
            if(i + sum > mid){
                sum = 0;
                day++;
            }
            if(i > mid){
                return false;
            }
            else{
                sum += i;
            }
            if(day > days){
                return false;
            }
        }

        return true;
    }




    // Question - 22
    static int MinDays(int[] nums,int bucket, int flowers){
        int ans = -1;
        int start = nums[0];
        int end = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > end){
                end = nums[i];
            }
            if(nums[i] < start){
                start = nums[i];
            }
        }

        while (start <= end) {
            int mid = start + (end - start)/2;
            if(isValid7(nums,bucket,flowers,mid)){
                ans = mid;
                end = mid -1;
            }
            else{
                start = mid +1;
            }

        }
        return ans;
    }


    static boolean isValid7(int[] nums,int bucket,int flowers, int mid){
        int flow = 0;
        int buck = 0;
        for(int i: nums){
            if(i <= mid){
                flow++;
            }
            else{
                flow = 0;
            }
            if(flow == flowers){
                buck++;
            }
            if(buck == bucket){
                return true;
            }
        }
        return false;
    }




    // Question - 23
    // Koko Eating bananas
    static int Koko(int[] piles, int hour){
        int start = 1;
        int ans = -1;
        int banana = piles[0];
        for(int i = 1;i<piles.length;i++){
            if(piles[i] > banana){
                banana = piles[i];
            }
        }
        while (start <= banana) {
            int mid = start + (banana - start)/2;
            int n = isValid8(piles, mid);
            if(n <= hour){
                ans = mid;
                banana = mid -1;
            }
            else{
                start = mid +1;
            }
        }

        return ans;
    }


    static int isValid8(int[] piles, int bananas){
        int sum = 0;
        for(int i :piles){
            sum += (i + bananas -1)/bananas;
        }
        return sum;
    }




    // Question - 24
    // Kth missing no.
    static int kthMissing(int[] nums,int k){   // Debug it on pen & paper
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int missing= nums[mid] - (mid +1);
            if(missing < k){
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }
         
        return k + end +1;
    }

}
