import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node back ;

    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }

    Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }
}

public class DoubleLL {
    private static Node convertArrToDLL(int[] arr) {
        if (arr.length == 0) return null;  
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], null, prev);
            prev.next = newNode;
            prev = newNode;
        }
        return head;
    }

    private static Node deleteHead(Node head){
        if(head == null || head.next == null) return null;
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    private static Node deleteTail(Node head){
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newTail = temp.back;
        newTail.next = null;
        temp.back = null;
        return head;
    }
    
    private static Node removeKth(Node head, int k){
        if(head == null) return null;
        int cnt = 0;
        Node kNode = head; 
        while(kNode != null){
            cnt++;
            if(cnt == k) break;
            kNode = kNode.next;
        }
        Node prev = kNode.back;
        Node front = kNode.next;
         
        if(prev == null && front == null) return null;
        else if(prev == null) return deleteHead(head);
        else if(front == null) return deleteTail(head);

        prev.next = front;
        front.back = prev;
        kNode.next = null;
        kNode.back = null;
        return head;
    }

    private static void removeNode(Node node){
        Node prev = node.back;
        Node front = node.next;
        if(front == null){
            prev.next = null;
            node.back = null;
            return;
        }
        prev.next = front;
        front.back = prev;
        node.next = node.back = null;
    }

    private static Node insertBeforeHead(Node head, int val){
        Node newHead = new Node(val, head, null);
        head.back = newHead;
        return newHead;
    } 

    private static Node insertBeforTail(Node head, int val){
        if(head.next == null) return insertBeforeHead(head, val);
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node prev = tail.back;
        Node newNode = new Node(val, tail, prev);
        tail.back = newNode;
        prev.next = newNode;
        return head;
    }   

    private static Node insertBeforeKth(Node head, int k, int val){
        if(k == 1) return insertBeforeHead(head, val);
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(val, temp, prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }

    private static void insertBeforeNode(Node node, int val){
        Node prev = node.back;
        Node newNode = new Node(val, node, prev);
        prev.next = newNode;
        node.back = newNode;
    }

    private static void printDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(); 
    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Node head = convertArrToDLL(arr);
        //head = deleteHead(head);
        //head = deleteTail(head);
        // head = removeKth(head, 3);
        //removeNode(head.next);

        //head = insertBeforeHead(head, 8);
        //head = insertBeforTail(head, 8);
        //head = insertBeforeKth(head, 3, 8);
        insertBeforeNode(head.next, 8);
        printDLL(head);
    }
}
