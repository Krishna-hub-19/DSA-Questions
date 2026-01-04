package Stack;
import java.util.EmptyStackException;
import java.util.Stack;


public class StackQuetions {
    public static void main(String[] args) {
    }



    // Quetion - 1 ==> find top element of stack
    public static int topEle(Stack<Integer> stack){
        int ans = 0;
        for(int ele: stack){
            ans = ele;
        }

        return ans;
    }



    // Question - 2 ==> reverse the entire stack
    static void reverse(Stack<Integer> stack){

        if(stack.isEmpty()) return; // base condition

        int top = stack.pop();
        reverse(stack);
        
        bucket2(stack, top);
    }

    private static void bucket2(Stack<Integer> stack, int element){
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        bucket2(stack, element);
        stack.push(top);
    }


    

    // Question - 3 ==> find min Element in Stack
    static int findMin(Stack<Integer> stack){
        int min = Integer.MAX_VALUE;
        for(int i: stack){
            if(i < min){
                min = i;
            }
        }

        return min;
    }



    // Question - 4 ==> remove the middle element from stack
    static int removeMid(Stack<Integer> stack){
        Stack<Integer> stack2 = new Stack<>();

        int n = stack.size();
        if(n < 1) throw new EmptyStackException();

        int ans = -1;
        for(int i = 0; i < n; i++){
            if(i == n/2){
               ans = stack.pop(); // removing mid element
               break;
            }
            stack2.push(stack.pop());
        }

        n = stack2.size();
        for(int i = 0; i < n; i++){
            stack.push(stack2.pop());
        }

        return ans;
    }



    // Question - 5 ==> Sort a stack 
    static void sortStack(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            int top = stack.pop();

            while (!temp.isEmpty() && temp.peek() > top) {
                stack.push(temp.pop());
            }

            temp.push(top);
        }

        // for change in original stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }



    // Question - 6 ==> display stack without modifying it
    static void display(Stack<Integer> stack){ 
        Stack<Integer> stack2 = new Stack<>();

        for(int i : stack){
            stack2.push(i);
        }

        for(int i: stack2){
            System.out.print(i + " ");
        }
        
        System.out.println();
    }




    // Question - 7 ==> check for valid paranthese
    static boolean checkValid(String parenthese){
        Stack<Character> stack = new Stack<>();

        for(char c: parenthese.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()) {
                    return false;
                }

                char popped = stack.pop();
                if(c == '}' && popped != '{'){
                    return false;
                }
                else if(c == ']' && popped != '['){
                    return false;
                }
                else if(c == ')' && popped != '('){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    

    // Question - 8 ==> Postfix evauluation (only works for a single digits)
    static int ansPostFix(String expression){
        Stack<Integer> stack = new Stack<>();
        for(char c : expression.toCharArray()){
            if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%'){
                int total = 0;
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (c) {
                    case '+':
                        total = (num1 + num2);
                        break;
                    
                    case '-':
                        total = (num2 - num1);
                        break;

                    case '*':
                        total = (num1 * num2);
                        break;

                    case '/':
                        total = num1 == 0 ? 0 : num2 / num1;
                        break;

                    case '^':
                        total = (int)Math.pow(num2, num1);
                        break;

                    case '%':
                        total = (num2 % num1);
                        break;
                                     
                }
                stack.push(total);
            }
            else{
                stack.push(Integer.parseInt(c + ""));
            }

        }

        return stack.pop();
    }




    // Question - 9 ==> transform postfix to infix
    static String PostfixToInfix(String s){
        int n = s.length();

        if(n == 0 || n == 1){
            return s;
        }

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            char currChar = s.charAt(i);
            if ((currChar >= 65 && currChar <= 90) || (currChar >= 97 && currChar <= 122)) {
                stack.push(currChar + "");
            }
            else{
                // for operator - +, -, *, /, %
                String first = stack.pop();
                String second = stack.pop();
                String finalExp = "(" + second + currChar + first + ")";
                stack.push(finalExp);
            }
        }
        return stack.peek();
    }




    // Question - 10 ==> find the greater element
    static int[] nextGreater(int[] nums){
        int n = nums.length;

        if(n == 1 || n == 0){
            return nums;
        }

        int[] ans = new int[n];
        int[] stack = new int[n];
        int index = 0;
        for(int i = n - 1; i >= 0; i--){
            int curr = nums[i];
            while (index >= 0 && stack[index] <= curr) {
                index--;
            }
            ans[i] = index < 0 ? -1 : stack[index];

            stack[++index] = curr; 
        }
        
        return ans;
    }

    

    // Question - 11 ==> find the next smallest element from right (for each element)
    static int[] nextSmallest(int[] nums){
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        if (n == 1) {
            return new int[] {-1};
        }
        int[] stack = new int[n];
        int[] ans = new int[n];
        int index = 0;
        for(int i = n - 1; i >= 0; i++){
            int curr = nums[i];
            while (index >= 0 && stack[index] >= curr) {
                index--;
            }

            ans[i] = index < 0? -1 : stack[index];
            stack[++index] = curr;
        }

        return ans;
    }



    // Question - 12 ==> calculate span for stock prices (for each day)
    static int[] stockSpan(int[] nums){
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] ans = new int[n];
        int[] stack = new int[n];
        if (n == 1) {
            return ans;
        }

        int index = -1;
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            while (index >= 0 && nums[stack[index]] <= curr) {
                index--;
            }

            ans[i] = (index == -1) ? 1 : i - stack[index];
            stack[++index] = i;
        }
        return ans;
    }




    // Question - 13 ==> find previous greater element (for each element)
    static int[] prevGreater(int[] nums){
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int index = 0;
        for(int ele: nums){
            while (!stack.isEmpty() && stack.peek() <= ele) {
                stack.pop();
            }

            ans[index++] = stack.isEmpty()? -1 : stack.peek();
            stack.push(ele);
        }

        return ans;
    }



    // Question - 14 ==> find previous smaller element (for each element)
    static int[] prevSmaller(int[] nums){
        int n = nums.length;
        if (n == 0) {
            return nums;
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int index = 0;
        for(int ele : nums){
            while (!stack.isEmpty() && stack.peek() >= ele) {
                stack.pop();
            }

            ans[index++] = stack.isEmpty()? -1 : stack.peek();
            stack.push(ele);
        }


        return ans;
    }



    // Question - 15 ==> find largest rectangle in the histrogram
    static int histroGram(int[] nums){
        
        int n = nums.length;
        int[] stack = new int[n];

        // for left side boundary
        int[] leftSmaller = new int[n];
        int index = -1;
        int ind = 0;
        for(int ele : nums){
            while (index >= 0 && nums[stack[index]] >= ele) {
                index--;
            }
            leftSmaller[ind++] = index == -1 ? -1 : stack[index];
            stack[++index] = ind - 1;
        }


        // for right side boundaries
        index = -1;
        ind = n-1;
        int[] rightSamller = new int[n];
        for(int i = 0; i < n; i++){
            int curr = nums[ind];
            while (index >= 0 && nums[stack[index]] >= curr) {
                index--;
            }

            rightSamller[ind--] = index == -1 ? n : stack[index];
            stack[++index] = ind + 1;
        }

        // main program
        int ans = 0;
        for(int i = 0; i < n; i++){
            int width = rightSamller[i] - leftSmaller[i] - 1;
            int currArea = nums[i] * width;
            ans = Math.max(ans, currArea);
        }

        return ans;   
    }



    
    // Question - 16 ==> simplify the unix path
    static String simplyPath(String s){
        String[] path = s.split("/");
        Stack<String> stack = new Stack<>();
        for(String c : path){
            if(c.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
            else if(!c.equals("." ) && !c.equals("")){
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();
        for(String ele :stack){
            ans.append("/" + ele);
        }
        return ans.toString();
    }


    // Question - 17 ==> trapping rain water
    public static int trap(int[] height) {
        int len = height.length;
        
        int gt =  0;
        // calculate left most heigths bars
        int[] left = new int[len];
        for(int i = 0; i < len; i++){
            int curr = height[i];
            if(curr >= height[gt]){
                gt = i;
            }
            left[i] = height[gt];
        }

        // calculate right most heights bars
        gt = 0;
        int[] right = new int[len];
        for(int i = len - 1; i >= 0; i--){
            int curr = height[i];
            if(curr >= height[gt]){
                gt = i;
            }
            right[i] = height[gt];
        }


        // main calculation(for trapped water)
        int ans = 0;
        for(int i = 0; i < len; i++){
            int min = Math.min(left[i], right[i]);
            int curr = height[i];
            ans += (min - curr);
        }

        return ans;
    }
}
