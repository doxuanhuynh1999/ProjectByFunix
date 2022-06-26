public class StackLinkedList {
    private Node head;
    private int topIndex;
    public StackLinkedList(){
        this.topIndex = -1;
        this.head = null;
    }
    // them phan tu
    public void push(SanPham sanPham){
        // tao ra node moi
        Node newNode = new Node(sanPham);
        newNode.setNextNode(this.head);
        this.head = newNode;
        this.topIndex++;
    }
    // xoa phan tu
    public Node pop(){
        this.topIndex--;
        if (isEmpty()){
            System.out.println("stack is empty");
            return null;
        }
        return this.head = this.head.getNextNode();

    }
    //kiem xem linkedlist co rong hay khong
    public boolean isEmpty(){
        return this.topIndex == -1;
    }
    // in ra man hinh
    public void DisplayStack(){
        Node current = this.head;
        System.out.println("ID,Title,Quantity,Price");
        System.out.println("______________________________________");
        while (current != null){
            System.out.println(current);
            current = current.getNextNode();
        }
    }

}
