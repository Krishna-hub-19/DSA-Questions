package Stack;

import java.util.EmptyStackException;

public class CustomStack{
    private int[] stackArr;
    private int stackSize;

    CustomStack(){
        stackArr = new int[10];
        stackSize = 0;
    }

    CustomStack(int size){
        stackArr = new int[size];
        stackSize = 0;
    }


    private void doubleSize(){
        int[] temp = new int[this.stackArr.length * 2];

        for(int i = 0; i < stackSize; i++){
            temp[i] = this.stackArr[i];
        }

        stackArr = temp;
    }


    public void push(int a){
        if(this.stackSize == this.stackArr.length){
            this.doubleSize();
        }

        this.stackArr[this.stackSize] = a;
        this.stackSize++;
    }


    public int pop(){
        if (this.isEmpty()) {
            throw new EmptyStackException();

        }
        stackSize--;
        return stackArr[stackSize];
    }


    public int peek(){
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        return stackArr[(stackSize) - 1];
    }


    public boolean isEmpty(){
        return stackSize == 0;
    }

    
    public int Search(int target){
        for (int i = stackSize - 1; i >= 0; i++) {
            if(this.stackArr[i] == target){
                return i;
            }
        }

        return -1; // Ans not found
    }
}
