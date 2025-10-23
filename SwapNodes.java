class Node {
    int data;
    Node next;

    Node(int data) {
        this.data=data;
    }    
}

class SLL {
    Node head;

    public void insert(int data){
        Node newNode = new Node(data);
        if ( head == null ){
            newNode = head;
        } else {
            Node temp = head;
            while ( temp != null ){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void print(){
        if ( head == null ){
            System.out.println("List is Empty");
        } else {
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data+" -> ");
                temp = temp.next;
            }
            System.out.println("Null");
        }
    }

    public void swapNodes(int val1,int val2){
        if (head==null){
            System.out.println("List is empty");
        } else {
            Node valOneNode = null;
            Node valTwoNode = null;

            Node temp = head;
            while(temp != null){
                if (temp.data==val1){
                    valOneNode=temp;
                }
                if (temp.data==val2){
                    valTwoNode=temp;
                }
                temp=temp.next;
            }
            if (valOneNode == null || valTwoNode == null){
                System.out.println("None or any one value not Found");
                return;
            }

            int tempData = valOneNode.data;
            valOneNode.data = valTwoNode.data;
            valTwoNode.data = tempData;

            System.out.println("Values Swapped ");
        }
    }
}
