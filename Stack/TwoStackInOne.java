package Stack;

import java.util.EmptyStackException;

public class TwoStackInOne {
    
    private int[] stack;
    private int size1 = 0;
    private int size2 = 0;
    private int bound;
    
    TwoStackInOne(){
        stack = new int[20];
        bound = stack.length/2;
    }

    TwoStackInOne(int n){
        // asume n for both array
        stack = new int[(n * 2)];
        bound = stack.length/2;
    }

    // for dynamic array
    private void doubleArr(){
        int[] temp = new int[(size1 * 2) + (size2 * 2)]; // we can also use nums.length

        int newBound = temp.length/2;
        // stack - 1
        for(int i = 0; i < size1; i++){
            temp[i] = stack[i];
        }

        // stack - 2
        for(int i = 0; i < size2; i++){
            temp[i + newBound] = stack[i + bound];
        }

        stack = temp;
        bound = newBound;
    }



    // stack 1
    public void push1(int val){
        if (size1 == bound) {
            this.doubleArr();
        }
        this.stack[this.size1] = val;
        size1++;
    }

    public int pop1() throws EmptyStackException{
        if (isEmpty1()) {
            throw new EmptyStackException();
        }
        size1--;
        return this.stack[size1];
    }

    public boolean isEmpty1(){
        return size1 == 0;
    }

    public int peek1() throws EmptyStackException{
        if (this.isEmpty1()) {
            throw new EmptyStackException();
        }
        return this.stack[size1 - 1];
    }

    public int Search1(int val){
        for(int i = 0; i < size1; i++){
            if(stack[i] == val){
                return i;
            }
        }

        return -1;
    }



    // stack - 2
     public void push2(int val){
        if ((size2 + bound) >= stack.length) { // you can also use nums.length, since both are equal
            this.doubleArr();
        }
        this.stack[(bound + size2)] = val;
        size2++;
        
     }
    public int pop2() throws EmptyStackException{
        if (this.isEmpty2()) {
            throw new EmptyStackException();
        }
        size2--;
        return this.stack[bound + size2];
    }

    public boolean isEmpty2(){
        return size2 == 0;
    }

    public int peek2() throws EmptyStackException{
        if (this.isEmpty2()) {
            throw new EmptyStackException();
        }
        return this.stack[bound + (size2 - 1)];
    }

    public int Search2(int val){
        for(int i = 0; i < size2; i++){
            if(stack[bound + i] == val){
                return i; // it's a indexing of stack 2
            }
        }

        return -1;
    }
}
