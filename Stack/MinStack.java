package Stack;

import java.util.EmptyStackException;

public class MinStack {
    
    Node head;
    MinStack(){
        head = null;
    }

    public void push(int val){
        if (head == null) {
            head = new Node(val, val);
            return;
        }

        Node node = new Node(val);
        if(val < head.min){
            node.min = val;
        }
        else{
            node.min = head.min;
        }

        node.next = head;
        head = node;
    }

    public int pop(){
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        int popped = head.value;
        head = head.next;
        return popped;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getMin(){
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return head.min;
    }



    // we just made a node for each value that holds it's own value, next pointer and minimum till that value
    private class Node{
        Node(int val){
            this.value = val;
        }
        Node(int val, int min){
            this.value = val;
            this.min = min;
        }
        Node(int val, int min, Node pointer){
            this(val,min);
            this.next = pointer;
        }
        int value;
        int min;
        Node next;
    }
}
