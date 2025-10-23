class Node {
    int data;
    Node next;

    Node(int data){
        this.data=data;
    }
}

class SLL{
    Node head;
    public void insert(int data){
        Node newNode = new Node(data);
        if (head == null ){
            head = newNode;
        } else {
            Node temp = head;
            while (temp != null){
                temp=temp.next;
            }
            temp.next = newNode;
        }
    }
    public void print(){
        if (head == null){
            System.out.println("List is Empty");
        } else {
            Node temp = head;
            while (temp!=null){
                System.out.println(temp.data+" -> ");
            }
            System.out.println("Null");
        }
    }

    public void printReverse(){
        if ( head == null ){
            System.out.println("List is Empty");
        } else {
            Node end = null;
            while ( end!= head ){
                Node temp = head;
                while (temp.next != end ){
                    temp=temp.next;
                }
                System.out.print(temp.data+" -> ");
                end = temp;
            }
            System.out.println("Null");
        }
    }
}