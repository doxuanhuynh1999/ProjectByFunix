import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LinkedList {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    // Thêm phan tu vào cuoi danh sách
    public void insertAtTail(SanPham sanPham){
        Node newNode = new Node(sanPham);
        // Truong hop danh sach rong
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        // truong hop danh sach khong rong
        if (this.tail != null){
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
    }
    // Xem phan tu  có trong danh sách hay không
    public boolean thu(String Id){
        Node current = this.head;
        while (current != null){
            if (current.getSanPham().getMaSanPham().equals(Id)){
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }
    // Tìm kiem phan tu?
    public Node find(String Id){
        Node current = this.head;
        while (current != null){
            if (current.getSanPham().getMaSanPham().equals(Id)){
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    // ham length
    public int length(){
        int length = 0;
        Node current = this.head;
        while (current != null){
            length ++;
            current = current.getNextNode();
        }
        return length;
    }
    // Kiem tra xem có phan tu có trong linked list không
    public boolean Thu(String Id){
        Node current = this.head;
        while (current != null){
            if (current.getSanPham().getMaSanPham().equals(Id)){
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }
    // Xoa phan tu o dau
    public void deleteFromHead(){
        this.head = this.head.getNextNode();
    }
    //xoa o cuoi danh sach
    public void deleteFromTail(){
        Node current = this.head;
        if (current == null || current.getNextNode() == null){
            deleteFromHead();
        }
        while (current.getNextNode().getNextNode() != null){
            current =current.getNextNode();
        }
        this.tail =current;
        current.setNextNode(null);
    }
    // ham xoa theo ID
    public void DeletaAt(String Id){
        if (Thu(Id)) {
            Node current = this.head;
            if (current.getSanPham().getMaSanPham().equals(Id)) {
                deleteFromHead();
            }
            if (this.tail.getSanPham().getMaSanPham().equals(Id)){
                deleteFromTail();
            }
            while (current.getNextNode() != null && !(current.getNextNode().getSanPham().getMaSanPham().equals(Id))) {
                current = current.getNextNode();
            }
            if (current.getNextNode() == null) {
                return;
            }
            current.setNextNode(current.getNextNode().getNextNode());
        }else {
            System.out.println("Ban da nhap sai gia tri can xoa");
        }
    }
    // Sap xep theo Id
    public void sortList(){
        // Node current  làm node dau
        Node current = this.head;
        // Thêm 1 Node null
        Node index = null;
        SanPham temp;
        if (this.head == null){
            return;
        }else {
            while (current != null){
                // Node index  là node next to current
                index = current.getNextNode();
                while (index != null){
                    if (current.getSanPham().getMaSanPham().compareTo(index.getSanPham().getMaSanPham()) > 0){
                        // thuc hien swap
                        temp = current.getSanPham();
                        current.setSanPham(index.getSanPham());
                        index.setSanPham(temp);
                    }
                    index = index.getNextNode();
                }
                current=current.getNextNode();
            }
        }
    }
    // sap xep theo de quy
    public void sortListRecursion(Node p){
        SanPham temp;
        if (p == null){
            return;
        }
        Node pi,pj ;
        pi = p;
        pj = p.getNextNode();
        while (pj != null){
            if (pi.getSanPham().getMaSanPham().compareToIgnoreCase(pj.getSanPham().getMaSanPham()) > 0){
                temp = pi.getSanPham();
                pi.setSanPham(pj.getSanPham());
                pj.setSanPham(temp);
            }
            pj = pj.getNextNode();
        }
        sortListRecursion(p.getNextNode());

    }
    // Bieu dien so luong san pham cua phan tu dau tiên sang he nhi phân
    public void BinaryHead(){
        //Tao ra array list de luu he nhi phân cua n
        ArrayList<Integer> arrayList = new ArrayList<>();
        // lay ra so luong cua san pham dau tiên
        int n = this.head.getSanPham().getSoLuong();
        System.out.print("Quantity = " + n + "=>(");
        // add i vào arraylist
        while (n > 0){
            int i = n % 2;
            arrayList.add(0,i);
            n = n / 2;
        }
        // in ra màn hình
        for (int j = 0; j < arrayList.size(); j++){
            System.out.print(arrayList.get(j));
        }
        System.out.print(")");
        System.out.println();
    }
    // luu vao file
    public  void SaveFile(){
        File file = new File("C:\\Users\\Admin\\Project2\\data.txt");
        try {
            //Buoc 1: Tao doi tuong luong và lien ket nguon du lieu
            FileWriter fw = new FileWriter(file);
            //Buoc 2: Ghi mang doi tuong vào file
            Node current = this.head;
            while (current != null){
                fw.write(current.getSanPham() + "\n");
                current = current.getNextNode();
            }
            System.out.println("Successfully!");
            //Buoc 3: Dong luong
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }
    // ham bieu dien
    public void print(){
        Node current = this.head;
        Node tailCurrent = this.tail;
        System.out.println("ID,Title,Quantity,Price");
        System.out.println("______________________________________");
        while (current != null){
            System.out.println(current);
            current = current.getNextNode();
        }
    }

}
