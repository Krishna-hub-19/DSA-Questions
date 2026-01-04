package LinkedList;

// First Download this pdf and try by yourself then you can take help from solutions
// --> https://drive.google.com/file/d/158pIi3J8OnwVybSPfvOjI4J14d39Ietq/view?usp=drive_link


// Desclaimer - I am still a learner, so there may be bugs in my solutions or opportunities for optimization.

//If you come across any improvements, I would greatly appreciate it if you could submit a pull request with the updated code, as it will be helpful for both me and others.

public class LinkedLL {

    private class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }

        Node(int value, Node next){
            this.value = value;
            this.next  = next;
        }
    }

    Node head;




    // Question  - 1 ==> Insert at a first position
    public void insertFirst(int val){

        Node node = new Node(val);

        node.next = head;
        head = node;
    }



    // Quetion - 2 ==> Display the whole Linked list
    public void Display(){
        
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }




    // Question - 3 ==>  Find length of Linked List
    public int size(){
        if (head == null) {
            return 0;
        }

        Node temp = head;
        int len = 0;

        for (; temp != null; len++) {
            temp = temp.next;
        }
        
        return len;
    }


    

    // Question - 4 ==> Insert at end
    public void insertEnd(int val){

        if (head == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
    }




    // Question - 5 ==> check node is exist is or not
    public Boolean isExist(int val){
        Node temp = head;

        while (temp != null) {
            if (temp.value == val) {
                return true;
            }

            temp = temp.next;
        }

        
        return false;
    }



    // Question - 6 ==> Delete First node
    public void delFirst(){
        if (head == null) {
            throw new NullPointerException();
        }
        head = head.next;
    }



    // Question - 7 ==> Delete last node
    public void delLast(){

        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }
       

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        // System.out.println(temp.value);
        temp.next = null;
    }




    // Question - 8  ==> Reverse a Linked List
    // Iterative approach
    public void reverseList(){

        if (head == null || head.next == null) {
            return;
        }
        Node temp = head;
        Node temp2 = temp.next;
        temp.next = null;
        while (temp2 != null) {
            Node temp3 = temp2.next;

            temp2.next = temp;

            temp = temp2;
            temp2 = temp3;
        }  
        
        head = temp;
    }




    // Question - 9 ==> find middle noden (if the size is even than  return lower one)
    public int midNode(){
        Node slow = head;
        Node fast = head;

        // int size = size();

        // Boolean flag = size%2 == 0 ? true : false;

        while (fast != null && fast.next != null && fast.next.next != null) {

            // if (flag) { // Check for size is even or not
            //     if (fast.next.next == null) { // for stop earlier so that we can return lower one node
            //         break;
            //     }
            // }


            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.value;
    }



    // Question - 10 ==> Count occurence of key(given)
    public int occurenceKey(int key){
        int occur = 0;

        Node temp = head;

        while (temp != null) {
            if (temp.value == key) {
                occur++;
            }

            temp = temp.next;
        }

        return occur;
    }




    // Question - 11 ==> reverse a list 
    public void reverseList2(){
        if (head == null) {
            throw new NullPointerException();
        }

        head = reverseList2(head);
    }

    private Node reverseList2(Node node){
        if(node == null || node.next == null) return node;

        Node newHead = reverseList2(node.next);

        node.next.next = node;
        node.next = null;

        return newHead;
    }





    // Question - 12 ==> Find cycle or loop if exist
    public void makeCycle(){
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;
    }

    public boolean isCycleExist(){

        if (head == null) {
            throw new NullPointerException();
        }
        Node slow = head;
        Node fast = head;


        do {

            slow = slow.next;

            if (fast.next == null || fast.next.next == null) {
                return false;
            }

            fast = fast.next.next;
        } while (slow != fast);
        return true;
    }



    

    // Question - 13 ==> Remove duplicates(only works for sorted linked List)
    public void remDup(){
        if (head == null) {
            throw new NullPointerException();
        }
        Node temp = head;

        while (temp.next != null) {

            if (temp.value == temp.next.value) {
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
    }




    // Question - 14 ==> Remove duplicates (can works for unsorted linked List but time complexity - O(n^2) )
    public void remDup2(){

        Node curr = head;
        while (curr != null) {
            Node temp = curr;
            while (temp.next != null) {
                if (temp.next.value == curr.value)
                    temp.next = temp.next.next;
                else
                    temp = temp.next;
            }
            curr = curr.next;
        }
    }





    // Question - 15 ==> Find nth Node from last
    public int nthNode(int index){

        if (index <= 0) {
            throw new IndexOutOfBoundsException("Invalid input"); // or return -1
        }

        Node fast = head, slow = head;
        for (int i = 0; i < index; i++){
            if (fast == null) throw new IndexOutOfBoundsException();
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.value;
    }




    // Question - 16 ==> Check if linked List is palindrome
    public boolean isPalindrome(){
        Node temp = head;
        Node check = midNode2();

        Node restore = null;
        Node restore2 = check;
        check = reverseListPali(check);


        while (temp != null && check!= null) {
            
            if (temp.value != check.value) {
                return false;
            }

            restore = temp;
            temp = temp.next;
            check = check.next;
        }


        if (restore != null) {
            restore.next = reverseListPali(restore2);
        }
    
        return true;
    }


    // Find mid node for Check Palindrome no
    public Node midNode2(){
        Node slow = head;
        Node fast = head;
        Node prev = null;


        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // skip the middle node if it's odd
        if(fast != null){
            Node ans = slow.next;
            slow.next = null;
            return ans;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    public Node reverseListPali(Node hNode){

        if (hNode == null || hNode.next == null) {
            return hNode;
        }

        Node temp = hNode;
        Node temp2 = temp.next;
        temp.next = null;
        while (temp2 != null) {
            Node temp3 = temp2.next;

            temp2.next = temp;

            temp = temp2;
            temp2 = temp3;
        }  
        
        return temp;
    }




    // Question - 17 ==> merge two sorted Linked List
    private Node getHead(){
        return head;
    }

    public static LinkedLL merge(LinkedLL first, LinkedLL second){

        LinkedLL l = new LinkedLL();

        Node firstTemp = first.getHead();
        Node secondTemp = second.getHead();

        while (firstTemp != null && secondTemp != null) {
            if (firstTemp.value < secondTemp.value) {
                l.insertEnd(firstTemp.value);
                firstTemp = firstTemp.next;
            }
            else{
                l.insertEnd(secondTemp.value);
                secondTemp = secondTemp.next;
            }
        }


        while (firstTemp != null) {
            l.insertEnd(firstTemp.value);
            firstTemp = firstTemp.next;
        }


        while (secondTemp != null) {
            l.insertEnd(secondTemp.value);
            secondTemp = secondTemp.next;
        }

        return l;
    }




    // Question - 18 ==> first Intersection point b/w two linkedList
    public static int intersectionPoint(LinkedLL first, LinkedLL second){
        Node firstTemp = first.getHead();
        Node secondTempNode = second.getHead();

        while (firstTemp != null) {
            Node secondTemp = secondTempNode;
            while (secondTemp != null) {
                if (firstTemp == secondTemp) {
                    return firstTemp.value;
                }
                secondTemp = secondTemp.next;
            }
            firstTemp = firstTemp.next;
        }


        return Integer.MIN_VALUE;
    }





    // Question - 19 ==>  Detect cycle then remove it
    public void makeCycle2(){ // just for make a cycle because cycle will never be made itself
        Node temp = head;
        int index = 0;

        while (index < 4) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            index++;
        }

        Node last = temp;
        while (last.next != null) {
            last = last.next;
        }

        last.next = temp;
    }


    public void removeCycle(){
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        do {
            slow = slow.next;
            if (fast!= null && fast.next == null) {
                return; // already cycle doesn't exist.
            }

            fast = fast.next.next;
        } while (slow != fast);


        // find the cycle point
        Node check = head;

        while (check != slow){
            check = check.next;
            slow = slow.next;
        }

        // removing the cycle
        Node last = slow;
        while (last.next != slow) {
            last = last.next;
        }
        
        last.next = null;
    }





    // Question - 20 ==> ReArange odd and even position
    public void ReArange(){
        if (head == null || head.next == null) return;

        Node odd = head;
        Node even = odd.next;
        Node rejoint = even;

        while (odd != null && even != null) {
            odd.next = even.next;

            if (odd.next == null) {
                break;
            }
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = rejoint;
    }





    // Question - 21 ==> Rotate the List by k times
    public void rotateK(int k){
        
        if (k == 0 || head == null || head.next == null) {
            return;
        }

        int len = this.len();
        k = k % len;

        if (k == 0) return;
        
        int n = len - k -1 ;
        Node temp = head;
        while (n > 0) {
            temp = temp.next;
            n--;
        }

        Node temp2 = temp.next;
        temp.next = null;
        
        Node newHead = temp2;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }

        temp2.next = head;
        head = newHead;
    }

    // for finding the length of the linked list
    private int len(){
        Node temp = head;
        int ans = 0;

        while (temp != null) {
            ans++;
            temp = temp.next;
        }

        return ans;
    }





    // Question - 22 ==> Pair wise swap node
    public void swapPair(){
        if (head == null || head.next == null) {
            return;
        }

        Node last = head;
        Node temp2 = last.next;

        head = temp2; // Since we swapped it the head is become it's second node

        while (temp2 != null) {
            Node temp3 = temp2.next;

            temp2.next = last;
            
            if (temp3 == null || temp3.next == null) {
                last.next = temp3;
                return;
            }

            last.next = temp3.next;
            last = temp3;
            temp2 = last.next;
        }
    }




    // Question - 23 ==> Add two number of two Linked List then make a new one or you can also add it to existing list
    public Node addLinked(LinkedLL second){

        Node dummyHead = new Node(-1);
        Node current = dummyHead;
        Node l1 = head;
        Node l2 = second.getHead();
        int carry = 0;
        while((l1 != null || l2 != null) || carry != 0){
            int a = (l1 != null) ? l1.value : 0;
            int b = (l2 != null) ? l2.value : 0;

            int sum = a + b + carry;
            int c = 0;
            if(sum > 9){
                c = sum %10;
                carry = sum / 10;
            }
            else{
                c = sum;
                carry = 0;
            }

            current.next = new Node(c);
            current = current.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }





    // Question - 24 ==> only reverse k nodes in linked list
    public void reverseKNodes(int k){
        if (head == null || head.next == null) {
            return;
        }
        if (k < 2) {
            return;
        }
        
        Node temp = head;
        Node temp2 = head;
        Boolean isHeadchanged = true;

        Node last2 = null;

        while (temp2 != null) {
            int n = k - 1;
            Node last = temp;
            temp2 = temp2.next;

            Node check = temp;
            int steps = 0;


            // this condition is only when you want to strickly changed only k nodes else in sequential order
            while (steps < k- 1 && check != null) {
                check = check.next;
                steps++;
            }

            if (check == null) {
                break; // not have enough nodes
            }


            // condition for reverse the n nodes
            while (n > 0 && temp2 != null) {
                Node temp3 = temp2.next;
                temp2.next = temp;

                temp = temp2;
                temp2 = temp3;
                n--;
            }

            if (isHeadchanged) {
                head = temp;
                isHeadchanged = false;
            }
            
            last.next = temp2;
            if (last2 != null) {
                last2.next = temp;
            }
            last2 = last;
            temp = temp2;
        }
    }




     // Question - 25 ==> reorder list like first - last - second - second from last --> so on
    public void reOrder(){
        if (head == null || head.next == null) return;

        Node firstList = head;
        Node mid = midNode2();
        Node secondList = reorder(mid);

        Node temp = firstList.next;
        while (secondList != null && temp != null) {

            firstList.next = secondList;
            secondList = secondList.next;
            firstList = firstList.next;

            firstList.next = temp;
            temp = temp.next;
            firstList = firstList.next;
        }

        firstList.next = null;
    }


    // reverse function for reOrder function (works as a helper function)
    private Node reorder(Node mid){
        if (mid == null || mid.next == null) {
            return mid;
        }
        Node temp = mid;
        Node temp2 = temp.next;
        temp.next = null;
        while (temp2 != null) {
            Node temp3 = temp2.next;

            temp2.next = temp;

            temp = temp2;
            temp2 = temp3;
        }  
        
        return temp;
    }





    // Question - 26 ==> sort Linked list using merge sort approach
    public void sortList(){
        head = mergeSort(head);
    }


    private Node mergeSort(Node head){

        if (head == null || head.next == null) {
            return head;
        }

        Node mid = midNodeMerge(head);
        
        Node left = mergeSort(head);
        Node right = mergeSort(mid);

        return merge(left, right);
    }


    private Node midNodeMerge(Node head){
        Node slow = head;
        Node fast = head;
        Node pre = null;

        
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre != null) {
            pre.next = null;
        }

        return slow;
    }


    private Node merge(Node left, Node right){
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (left != null && right != null) {
            
            if (left.value < right.value) {
                tail.next = left;
                left = left.next;
            }
            else{
                tail.next = right;
                right = right.next;
            }

            tail = tail.next;
        }


        if (left != null) {
            tail.next = left;
        }
        else{
            tail.next = right;
        }

        return dummy.next;
    }
}