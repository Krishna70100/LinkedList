import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }
}

public class LinkedList {
    private static Node convertArrToLL(int[] arr) {
        if (arr.length == 0) return null;  
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            mover.next = newNode;
            mover = newNode;
        }
        return head;
    }

    private static int lengthLL(Node head){
        if(head == null) return 0;
        Node temp = head;
        int count  = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    private static Node deleteHead(Node head){
        if(head == null) return head;
        head = head.next;
        return head;
    }

    private static Node deleteTail(Node head){
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node removeKth(Node head, int k){
        if(head == null) return head;
        if(k == 1){
            head = head.next;
            return head;
        }
        int count = 0; Node temp = head; //Node prev = null;
        while(temp != null){
            count++;
            if(count == k-1){
                //prev.next = prev.next.next;
                temp.next = temp.next.next;
                break;
            }
            //prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node removeElem(Node head, int val){
        if(head == null) return head;
        if(head.data == val){
            head = head.next;
            return head;
        }
        Node temp = head; Node prev = null;
        while(temp != null){
            if(temp.data == val){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node insertHead(Node head, int k){
        return new Node(k, head);
    }

    private static Node insertTail(Node head, int k){
        if(head == null) return new Node(k);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(k);
        temp.next = newNode;
        return head;
    }

    private static Node insertKth(Node head, int k, int val){
        if(head == null){
            if(k == 1) return new Node(val);
            else return head;
        }
        if(k == 1) return new Node(val, head);
        int count = 0; Node temp = head;
        while(temp != null){
            count++;
            if(count == k-1){
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertBeforeVal(Node head, int elem, int val){
        if(head == null) return head;

        if(head.data == elem) return new Node(val, head);
        Node temp = head;
        while(temp.next != null){
            if(temp.next.data == elem){
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static void printLL(Node head) {
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
        
        Node head = convertArrToLL(arr);
        //System.out.print(lengthLL(head));
        //head = deleteHead(head);
        //head = deleteTail(head);
        head = removeKth(head, 3);
        //head = removeElem(head, 7);

        //head = insertHead(head,5);
        //head = insertTail(head, 3);
        //head = insertKth(head, 3, 6);
        //head = insertBeforeVal(head, 4, 5);
        printLL(head);
    }
}
