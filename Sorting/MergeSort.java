// First Download this pdf and try by yourself then you can take help from solutions
// --> https://drive.google.com/file/d/1zlPx1gRXvIWKOnOnGjedp9Tz7V1xUJJB/view?usp=sharing


// Desclaimer - I am still a learner, so there may be bugs in my solutions or opportunities for optimization.

//If you come across any improvements, I would greatly appreciate it if you could submit a pull request with the updated code, as it will be helpful for both me and others.


package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort{
    public static void main(String[] args){

    }   


    // Question - 1
    static int[] mergeSort(int[] nums){
        if(nums.length <= 1){
            return nums;
        }
        
        int mid = nums.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(nums,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums,mid,nums.length));

        return merging(left, right);
    }

    static int[] merging(int[] left, int[] right){

        int i = 0;
        int j = 0;
        int k  = 0;

        int leftLength = left.length;
        int rightLength = right.length;

        int[] arr = new int[leftLength + rightLength];

        while (i < leftLength && j < rightLength) {

            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return arr;
    }



    // Question - 2 (Merge sort for decending elements)
    static int[] mergeSort2(int[] nums){
        if(nums.length <= 1){
            return nums;
        }

        int mid = nums.length/2;
        
        int[] left = mergeSort2(Arrays.copyOfRange(nums,0,mid));
        int[] right = mergeSort2(Arrays.copyOfRange(nums,mid,nums.length));

        return merge2(left,right);
    }

    static int[] merge2(int[] left, int[] right){
        
        int leftLength = left.length;
        int rightLength = right.length;

        int[] arr = new int[leftLength + rightLength];

        int i = 0;
        int j = 0;
        int k = 0;
    
        while (i < leftLength && j < rightLength) {
            if(left[i] > right[j]){
                arr[k] = left[i++];
            }
            else{
                arr[k] = right[j++];
            }
            k++;
        }

        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        while (j < rightLength) {
            arr[k++] = right[j++];
        }

        return arr;
    }




    // Question - 3
    static int count = 0; // only used for count comparison during merge sort
    static int countComparison(int[] nums){
        count = 0;
        mergeSort3(nums);

        return count;
    }

    static int[] mergeSort3(int[] nums){
        if(nums.length <= 1){
            return nums;
        }

        int mid = nums.length/2;

        int[] left = mergeSort3(Arrays.copyOfRange(nums,0,mid));
        int[] right = mergeSort3(Arrays.copyOfRange(nums,mid,nums.length));

        return merge(left,right);
    }

    static int[] merge(int[] left, int[] right){

        int leftLength = left.length;
        int rightLength = right.length;

        int[] arr = new int[leftLength + rightLength];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftLength && j < rightLength) {
            if(left[i] < right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }

            count++; // for Count comparisons during Merge Sort
        }

        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        while (j < rightLength) {
            arr[k++] = right[j++];
        }

        return arr;
    }




    // Question - 4
    static int[] sortOddOnly(int[] nums){
        if(nums.length == 1){
            return nums;
        }

        int mid = nums.length/2;

        int[] left = sortOddOnly(Arrays.copyOfRange(nums,0,mid));
        int[] right = sortOddOnly(Arrays.copyOfRange(nums,mid,nums.length));

        return mergeOddOnly(left,right);
    }

    static int[] mergeOddOnly(int[] first,int[] second){

        int firstLen = first.length;
        int secondLen = second.length;

        int[] arr = new int[firstLen + secondLen];
        
        ArrayList<Integer> evenNo = new ArrayList<>();
        ArrayList<Integer> evenNoIndex = new ArrayList<>();
        ArrayList<Integer> OddNo = new ArrayList<>();

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < firstLen) {
            if(first[i] %2 == 0){
                evenNo.add(first[i]);
                evenNoIndex.add(i);
            }
            else{
                OddNo.add(first[i]);
            }
            i++;
            k++;
        }

        while (j < secondLen) {
            if(second[j] %2 == 0){
                evenNo.add(second[j]);
                evenNoIndex.add(k);
            }
            else{
                OddNo.add(second[j]);
            }
            j++;
            k++;
        }

        i = 0;
        int n = OddNo.size();

        int[] odd = new int[n];

        while (i < n) {
            odd[i] = OddNo.get(i);
            i++;
        }

        Arrays.sort(odd);

        i = 0;

        for (int index = 0; index < arr.length; index++) {
            if (!evenNoIndex.contains(index)) {
                arr[index] = odd[i++];
            }
        }

        i = 0;
        while (i < evenNo.size()) {
            arr[evenNoIndex.get(i)] = evenNo.get(i);
            i++;
        }

        return arr;
    }



    // Question - 5
    static int[] sortEvenOnly(int[] nums){
        if(nums.length == 1){
            return nums;
        }

        int mid = nums.length/2;

        int[] left = sortEvenOnly(Arrays.copyOfRange(nums,0,mid));
        int[] right = sortEvenOnly(Arrays.copyOfRange(nums,mid,nums.length));

        return mergeEvenOnly(left,right);
    }

    static int[] mergeEvenOnly(int[] left,int[] right){
        int leftLenght = left.length;
        int rightLength = right.length;

        int[] arr = new int[leftLenght + rightLength];

        ArrayList<Integer> OddNo = new ArrayList<>();
        ArrayList<Integer> OddIndex = new ArrayList<>();
        ArrayList<Integer> EvenNo = new ArrayList<>();

        int i = 0;
        for(i = 0; i< leftLenght;i++){
            if(left[i]%2 == 0){
                EvenNo.add(left[i]);
            }
            else{
                OddNo.add(left[i]);
                OddIndex.add(i);
            }
        }

        int j = 0;
        while (j  < rightLength) {
            if(right[j] %2 == 0){
                EvenNo.add(right[j]);
            }
            else{
                OddIndex.add(j+i);
                OddNo.add(right[j]);
            }
            j++;
        }

        int[] Evens = new int[EvenNo.size()];

        i = 0;
        for(;i<Evens.length;i++){
            Evens[i] = EvenNo.get(i);
        }

        Arrays.sort(Evens);

        int n = arr.length;
        j = 0;
        i  = 0;

        for(;i<n;i++){
            if(!OddIndex.contains(i)){
                arr[i] = Evens[j];
                j++;
            }
        }

        i = 0;
        for(;i<OddIndex.size();i++){
            arr[OddIndex.get(i)] = OddNo.get(i);
        }

        return arr;
    }



    // Question -  6
    static char[] sortChar(char[] nums){
        if(nums.length <= 1){
            return nums;
        }

        int mid = nums.length/2;
        char[] left = sortChar(Arrays.copyOfRange(nums,0,mid));
        char[] right = sortChar(Arrays.copyOfRange(nums, mid,nums.length));

        return mergedChar(left,right);
    }

    static char[] mergedChar(char[] left, char[] right){
        int l = left.length;
        int r = right.length;

        char[] arr = new char[l+r];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l && j < r) {
            if(left[i] < right[j]){
                arr[k] = left[i++];
            }
            else{
                arr[k] = right[j++];
            }

            k++;
        }

        while (i < l) {
            arr[k++] = left[i++];
        }

        while (j < r) {
            arr[k++] = right[j++];
        }

        return arr;
    }



    // Question - 7
    static int Inversion = 1; // Used only for count Inversion
    static int countInversion(int[] nums){
        Inversion = 0;
        mergeSortCountInversion(nums);
        return Inversion;
    }

    static int[] mergeSortCountInversion(int[] nums){

        if (nums.length == 1) {
            return nums;
        }

        int mid = nums.length/2;
        int[] left = mergeSortCountInversion(Arrays.copyOfRange(nums,0, mid));
        int[] right = mergeSortCountInversion(Arrays.copyOfRange(nums,mid,nums.length));

        return mergeInversion(left,right);
    }


    static int[] mergeInversion(int[] left,int[] right){

        int l = left.length;
        int r = right.length;

        int[] arr = new int[l + r];

        int j = 0;
        int k = 0;
        int n = 0;

        while (j  <  l && k < r) {
            if(left[j] < right[k]){
                arr[n] = left[j++];
            }
            else{
                arr[n] = right[k++];
                Inversion += (l - j);
            }
            n++;
        }

        while (j < l) {
            arr[n++] = left[j++];
        }

        while (k < r) {
            arr[n++] = right[k++];
        }

        return arr;
    }



    // Question - 8
    static String[] stringLength(String[] s){
        if(s.length == 1){
            return s;
        }

        int mid = s.length/2;

        String[] left = stringLength(Arrays.copyOfRange(s,0,mid));
        String[] right = stringLength(Arrays.copyOfRange(s, mid,s.length));

        return mergedLength(left, right);
    }

    static String[] mergedLength(String[] left, String[] right){

        int l = left.length;
        int r = right.length;

        String[] arr = new String[l + r];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l && j < r) {
            if(left[i].length() < right[j].length()){
                arr[k] = left[i++];
            }
            else{
                arr[k] = right[j++];
            }
            k++;
        }

        while (i < l) {
            arr[k++] = left[i++];
        }

        while (j < r) {
            arr[k++] = right[j++];
        }

        return arr;
    }



    // Question - 9
    static int digitsSum(int n){
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }

        return sum;
    }

    static int[] digitMergeSort(int[] array){
        if (array.length == 1) {
            return array;
        }

        int mid = array.length / 2;

        int[] left = digitMergeSort(Arrays.copyOfRange(array,0,mid));
        int[] right = digitMergeSort(Arrays.copyOfRange(array,mid,array.length));

        return digitMerge(left, right);
    }

    static int[] digitMerge(int[] left, int[] right){
        int l = left.length;
        int r = right.length;

        int[] arr = new int[l + r];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l && j < r) {
            
            int leftDigits = digitsSum(left[i]);
            int rightDigits = digitsSum(right[j]);

            if(leftDigits == rightDigits){
                if(left[i] < right[j]){
                    arr[k] = left[i++];
                }
                else{
                    arr[k] = right[j++];
                }
            }
            else if(leftDigits < rightDigits){
                arr[k] = left[i++];
            }
            else{
                arr[k] = right[j++];
            }

            k++;
        }

        while (i < l) {
            arr[k++] = left[i++];
        }

        while (j < r) {
            arr[k++] = right[j++];
        }

        return arr;
    }

    

    // Question - 10
    static int[] rotateArray(int[] nums){
        int[] arr = mergeSort(nums);

        int n = arr.length -1;

        int temp = arr[0];

        for(int i = 0;i<n;i++){
            arr[i] = arr[i+1];
        }

        arr[n] = temp;

        return arr;
    }




    // Question - 11
    static int[] mergedSortOnLastDigit(int[] nums){

        if(nums.length == 1){
            return nums;
        }

        int mid = nums.length/2;

        int[] left = mergedSortOnLastDigit(Arrays.copyOfRange(nums,0,mid));
        int[] right = mergedSortOnLastDigit(Arrays.copyOfRange(nums, mid,nums.length));

        return mergedOnLastdigit(left,right);
    }

    static int[] mergedOnLastdigit(int[] left,int[] right){

        int l = left.length;
        int r = right.length;

        int[] arr = new int[l+r];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l && j < r) {
            if(left[i]%10 < right[j]%10){
                arr[k] = left[i++];
            }
            else{
                arr[k] = right[j++];
            }
            k++;
        }

        while (i < l) {
            arr[k++] = left[i++];
        }

        while (j < r) {
            arr[k++] = right[j++];
        }

        return arr;
    }



    // Question - 12
    static int[] sortSubarray(int[] nums, int l, int r){

        int n = nums.length;

        int[] array = new int[nums.length];

        for(int i = 0;i<l;i++){
            array[i] = nums[i];
        }

        for(int i = r+1;i<n;i++){
            array[i] = nums[i];
        }

        int[] arr = mergeSort(Arrays.copyOfRange(nums,l,r+1));
        
        for(int i:arr){
            array[l++] = i;
            if (l > r) {
                break;
            }
        }

        return array;
    }



    // Question - 13
    static int[] mergeMatrix(int[][] matrix){
        int n = matrix.length;
        if (n < 1) {
            return new int[]{};
        }
        int index = 0;
        for(int[] row : matrix){
            matrix[index++] = mergeSort(row);
        }

        int[] arr = matrix[0];
        if (n == 1) {
            return arr;
        }

        index = 1;
        while(index < n){
            arr = merge(arr, matrix[index++]);
        }

        return arr;
    }
}