// First Download this pdf and try by yourself then you can take help from solutions
// --> https://drive.google.com/file/d/1Q2AxNPcgXhzzB8PhalK9FV7rw8g2IJth/view?usp=sharing


// Desclaimer - I am still a learner, so there may be bugs in my solutions or opportunities for optimization.

//If you come across any improvements, I would greatly appreciate it if you could submit a pull request with the updated code, as it will be helpful for both me and others.


package Sorting;

public class InsertionSort {
    
    public static void main(String[] args) {
        
    }



    // Question - 1 
    static void insertionsort(int[] nums){
        for(int i = 1;i<nums.length;i++){
            int min = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > min) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = min;
        }
    }



    // Question - 2
    static void sortDesending(int[] nums){
        for(int i = 1;i<nums.length;i++){
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] < key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }


    // Question - 3
    static void sortK(int[] nums,int k){
        for(int i = 1;i<k;i++){
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }



    // Question - 4
    static int countShift(int[] nums){
        int count = 0;
        for(int i = 1;i<nums.length;i++){
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                count++;
                j--;
            }
            nums[j+1] = key;
        }
        return count;
    }



    // Question - 5
    static void EvenIndices(int[] nums){
        for(int i = 2;i<nums.length;i+=2){
            int key = nums[i];
            int j = i-2;
            while (j >= 0 && nums[j] > key) {
                nums[j+2] = nums[j];
                j -=2;
            }
            nums[j+2] = key;
        }
    }



    // Question - 6
    static void OddIndices(int[] nums){
        for(int i = 3;i<nums.length;i+=2){
            int key = nums[i];
            int j = i-2;
            while (j >= 0 && nums[j] > key) {
                nums[j+2] = nums[j];
                j -= 2;
            }
            nums[j+2] = key;
        }
    }

    

    // Question - 7
    static void lastSort(int[] nums){
        int key = nums[nums.length - 1];
        int j = nums.length - 2;
        while (j >= 0 && nums[j] > key) {
            nums[j+1] = nums[j];
            j--;
        }
        nums[j+1] = key;
    }



    // Question - 8
    static String sortChar(String s){
        StringBuilder k = new StringBuilder();
        k.append(s);
        for(int i = 1;i<k.length();i++){
            char key = k.charAt(i);
            int j = i -1;
            while (j >= 0 && k.charAt(j) > key) {
                char c = k.charAt(j);
                k.replace(j+1,j+2,c+"");
                j--;
            }
            k.replace(j+1,j+2,key + "");
        }

        return k + "";
    }



    // Question - 9
    static void sortLenght(String[] nums){
        for(int i = 1;i<nums.length;i++){
            String key = nums[i];
            int j = i -1;
            while (j >= 0 && nums[j].length() > key.length()) {
                nums[j+1] = nums[j];
                j--;
            } 

            nums[j+1] = key;
        }
    }



    // Question - 10
    static void sortDigits(int[] nums){
        for(int i = 1;i<nums.length;i++){
            int key = nums[i];
            int j = i -1;
            while (j >= 0 && digitsHelper(nums[j]) > digitsHelper(key)) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }

    static int digitsHelper(int n){ // Question - 13 helper function
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }

        return sum;
    }



    // Question - 11
    static void sortLexico(String[] nums){
        for(int i = 1;i<nums.length;i++){
            String key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j].compareTo(key) > 0) {
                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = key;
        }
    }



    // Question - 12
    static void EarlyExit(int[] nums){
        
        boolean isSorted = true;
        for(int i = 0;i<nums.length - 1;i++){
            if(nums[i] > nums[i+1]){
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            return;
        }

        for(int i = 1;i<nums.length;i++){
            int key = nums[i];
            int j = i -1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }


    // Question - 13
    static void sortZeros(int[] nums){

        // int n = nums.length;
        
        // int[] temp = new int[n];

        // int pos = 0;
        // for(int i:nums){
        //     if(i != 0){
        //         temp[pos] = i;
        //         pos++;
        //     }
        // }

        // for(int i = 1;i<nums.length;i++){
        //     int key  = temp[i];
        //     if(key == 0){
        //         break;
        //     }
        //     int j = i-1;
        //     while (j >= 0 && temp[j] > key) {
        //         temp[j+1] = temp[j];
        //         j--;
        //     }
        //     temp[j+1] = key;
        // }


        // pos = 0;
        // for(int i = 0;i<nums.length;i++){
        //     if(nums[i] != 0){
        //         nums[i] = temp[pos];
        //         pos++;
        //     }
        // }


        // Second Method
        for(int i = 1;i<nums.length;i++){
            int key = nums[i];
            if(key == 0) continue;

            int j = i-1;
            while (j >= 0 && (nums[j] == 0 || nums[j] > key)) {
                if(nums[j] != 0){
                    int k = j;
                    while(k +1 < i && nums[k+1] == 0){
                        k++;
                    }
                    nums[k+1] = nums[j];
                }
                j--;
            }
            int pos = j+1;
            while (nums[pos] == 0) {
                pos++;
            }
            nums[pos] = key;
        }

        }



    // Question - 14
    // 1st - sort only Even nums and odd as it is
    static void sortEven(int[] nums){
        int n = nums.length;
        // for(int i = 1;i<n;i++){
        //     int key = nums[i];
        //     if(key %2 == 1) continue;

        //     int j = i-1;
        //     while (j >= 0 && (nums[j] %2 == 1 || nums[j] > key)) {
        //         if(nums[j] %2 != 1){
        //             int k = j;
        //             while (k+1 <i && nums[k+1] %2 == 1) {
        //                 k++;
        //             }
        //             nums[k+1] = nums[j];
        //         }
        //         j--;
        //     }

        //     int pos = j+1;
        //     while (nums[pos]%2 == 1) {
        //         pos++;
        //     }
        //     nums[pos] = key;
        // }


        // second method
        int[] k = new int[n];
        
        int ind = 0;
        for(int i :nums){
            if(i %2 == 0){
                k[ind++] = i;
            }
        }

        for(int i = 1;i<ind;i++){
            int key = k[i];
            int j = i-1;
            while (j >= 0 && k[j] > key) {
                k[j+1] = k[j];
                j--;
            }
            k[j+1] = key;
        }

        ind = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] %2 == 0){
                nums[i] = k[ind];
                ind++;
            }
        }
    }

    // 2nd - sort only odd nums and even as it is
    static void sortOdd(int[] nums){
        int n = nums.length;
        // for(int i = 1;i<nums.length;i++){
        //     int key = nums[i];
        //     if(key %2 == 0) continue;

        //     int j = i-1;
        //     while (j >= 0 && (nums[j] %2 == 0 || nums[j] > key)) {
        //         if(nums[j] %2 != 0){
        //             int k = j;
        //             while (k+1 <i && nums[k+1] %2 == 0) {
        //                 k++;
        //             }
        //             nums[k+1] = nums[j];
        //         }
        //         j--;
        //     }

        //     int pos = j+1;
        //     while (nums[pos] %2 == 0) {
        //         pos++;
        //     }
        //     nums[pos] = key;
        // }


        // Second Method
        int[] arr = new int[n];

        int ind = 0;
        for(int i:nums){
            if(i %2 == 1){
                arr[ind++] = i;
            }
        }

        for(int i = 1;i<ind;i++){
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }

        ind = 0;
        for(int i = 0;i<n;i++){
            if(nums[i]%2 == 1){
                nums[i] = arr[ind++];
            }
        }
    }



    // Question - 15
    static void sortCustom(int[] nums){
        for(int i = 1;i<nums.length;i++){
            int key = nums[i];
            int j = i -1;
            while (j >= 0 && nums[j]%3 > key%3) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }



    // Question - 16
    static void sortSwaps(int[] nums){
        for(int i = 1;i<nums.length;i++){
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                swaps(nums,j+1,nums[j]);
                j--;
            }
            swaps(nums,j+1,key);
        }
    }

    static void swaps(int[] nums,int pos1,int element){
        nums[pos1] = element;
    }

    

    // Question - 17
    static void countDup(int[] nums){ // takes only sorted array
        int count = 1;

        for(int i = 1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                count++;
            }
            else{
                System.out.println(nums[i-1] + " -> " + count);
                count = 1;
            }
        }
        System.out.println(nums[nums.length - 1] + " -> " + count);
    }



    // Question - 18
    static int[] tracking(int[] nums){
        int[] index = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            index[i] = i;
        }

        for(int i = 1;i<nums.length;i++){
            int key = nums[i];
            int index1 = index[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                index[j+1] = index[j];
                j--;
            }
            index[j+1] = index1;
            nums[j+1] = key;
        }

        int[] result = new int[nums.length];

        for(int i = 0;i<nums.length;i++){
            result[index[i]] = i;
        }
        return result;
    }



    // Question - 19
    static boolean oneInsertion(int[] nums){
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            int key  = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                count++;
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
        return count <= 1;
    }



    // Question - 20
    static void sortFloat(float[] nums){
        for(int i = 1;i<nums.length;i++){
            float key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }



    // Question - 21
    static void Pair(int[] a, int[] b){
        for(int i = 1;i<a.length;i++){
            int key = a[i];
            int key2 = b[i];
            int j = i-1;
            while (j >= 0 && a[j] > key) {
                a[j+1] = a[j];
                b[j+1] = b[j];
                j--;
            }
            a[j+1] = key;
            b[j+1] = key2;
        }
    }



    // Question - 22
    static void sortCus(int[] age, String[] name){
        for(int i = 1;i<age.length;i++){
            int key = age[i];
            String key2 = name[i];
            int j = i-1;
            while (j >= 0 && age[j] > key) {
                age[j+1] = age[j];
                name[j+1] = name[j];
                j--;
            }
            age[j+1] = key;
            name[j+1] = key2;
        }
    }



    // Question - 23
    static int countInsertion(int[] nums){
        int count = 0;
        for(int i = 1;i<nums.length;i++){
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                count++;
                j--;
            }
            nums[j+1] = key;
        }

        return count;
    }
    

    
    // Question - 24
    static void insertionSortKDistance(int[] arr, int k) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Limit j to (i - k) as minimum
            int m = Math.max(0,i-k);
            while (j >= m && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
