package Stack;


import java.util.EmptyStackException;
import java.util.LinkedList;

public class StackLinkedList {
    
    private LinkedList<Integer> stack;

    StackLinkedList(){
        stack = new LinkedList<>();
    }

    public void push(int element){
        stack.add(element);
    }

    
    public int pop(){
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeLast();
    }


    public boolean isEmpty(){
        return stack.isEmpty();
    }


    public int peek(){
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getLast();
    }


    public int search(int target){
        int index = stack.size();
        for(int element : this.stack){
            if(element == target){
                return index;
            }
            index--;
        }

        return -1;
    }
}
