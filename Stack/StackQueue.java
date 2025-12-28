package Stack;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueue {
    
    private Queue<Integer> stack;
    
    StackQueue(){
        stack = new LinkedList<>();
    }


    public void push(int val){
        stack.offer(val);
    }

    public int pop(){
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        Queue<Integer> bucket = new LinkedList<>();
        while (stack.size() > 1) {
            bucket.offer(stack.remove());
        }
        int peeked = stack.remove();
        stack = bucket;
        return peeked;
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int peek(){
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        Queue<Integer> bucket = new LinkedList<>();
        while (stack.size() > 1) {
            bucket.offer(stack.remove());
        }
        int peeked = stack.remove();
        bucket.offer(peeked);
        stack = bucket;

        return peeked;
    }

    public int size(){
        return stack.size();
    }
}
