public class QueueLinkedList {
    private Node head;
    private Node tail;
    private int size;
    public QueueLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    // them san pham
    public void enqueue(SanPham sanPham){
        this.size++;
        // tao node moi
        Node newNode = new Node(sanPham);
        // truong hop isEmpty
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }
        // truong hop khong isEmpty
        this.tail.setNextNode(newNode);
        this.tail = newNode;
    }
    // xoa san pham
    public Node dequeue(){
        this.size--;
        if (isEmpty()){
            System.out.println("linkedlist is null");
            return null;
        }
        return this.head =  this.head.getNextNode();
    }
    // kiem tra xem linklist co rong hay khong
    public boolean isEmpty(){
        return this.head == null;
    }
    // bieu dien
    public void DisplayQueue(){
        Node current = this.head;
        System.out.println("ID,Title,Quantity,Price");
        System.out.println("______________________________________");
        while (current != null){
            System.out.println(current);
            current = current.getNextNode();
        }
    }
}
