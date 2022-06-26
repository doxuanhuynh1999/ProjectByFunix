import javax.security.sasl.SaslClient;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Function {
    // tạo ra các biến static
    static ArrayList<SanPham> sanPhams = new ArrayList<>();
    static ArrayList<SanPham> a = new ArrayList<>();
    static LinkedList  list = new LinkedList();
    static StackLinkedList stackLinkedList = new StackLinkedList();
    static QueueLinkedList queueLinkedList = new QueueLinkedList();
    // case 1 Đọc dữ liệu có sẵn từ file và lưu vào danh sách móc nối và hiển thị danh sách ra màn hình
    /**
     * Tạo ra file data.txt
     * Dữ liệu ở trong là một mảng chứa các sản phẩm
     */
    public static void InputTxt(){
        // san pham
        SanPham sp1 = new SanPham("P03","SP1",12,5);
        SanPham sp2 = new SanPham("P01","SP2",10,5);
        SanPham sp3 = new SanPham("P02","SP3",5,5);
        SanPham sp4 = new SanPham("P05","SP1",7,5);
        SanPham sp5 = new SanPham("P07","SP2",11,5);
        SanPham sp6 = new SanPham("P04","SP3",9,5);
        SanPham sp7 = new SanPham("3","SP1",3,5);
        SanPham sp8 = new SanPham("4","SP2",4,5);

        // them san pham vao arraylist
        sanPhams.add(sp1);
        sanPhams.add(sp2);
        sanPhams.add(sp3);
        sanPhams.add(sp4);
        sanPhams.add(sp5);
        sanPhams.add(sp6);
        sanPhams.add(sp7);
        sanPhams.add(sp8);

        File file = new File("C:\\Users\\Admin\\Project2\\data.txt");
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileWriter fw = new FileWriter(file);
            //Bước 2: Ghi mảng đối tượng vào file
            for (SanPham sanPham : sanPhams){
                fw.write(sanPham + "\n");
            }
            //Bước 3: Đóng luồng
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: "+ex);
        }
    }

    /**
     * Đọc dữ liệu từ file data.txt đã tạo
     * Đọc theo từng hàng và cho ngăn cách từng phần tử bằng dấu ","
     * lưu vào danh sách móc nối và hiển thị danh sách ra màn hình
     */
    public static void OutputTxt() {
        File file = new File("C:\\Users\\Admin\\Project2\\data.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Đọc file theo hàng
        while (scanner.hasNextLine()) {
            String number = scanner.nextLine();
            // cac phan tu cách nhau bằng dấu ","
            String [] number1 = number.split(",");
            SanPham sp = new SanPham(number1[0],number1[1],Integer.valueOf(number1[2]),Double.valueOf(number1[3]));
            // them vao Linkedlist
            list.insertAtTail(sp);
        }
        list.print();
        System.out.println("Successfully!");
    }
    // Case 2 Nhập và thêm một sản phẩm vào cuối của danh sách móc nối

    /**
     * thêm sản phẩm vào cuối danh sách móc nối
     * Sản phẩm mới bao gồm: Mã, Tên, Số lượng, Giá.
     */
    public static void addProduct(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Product new: ");
        System.out.print("Input new ID: ");
        String Id = sc.next();
        System.out.print("Input product's name: ");
        String name = sc.next();
        System.out.print("Input product's quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Input product's price: ");
        double price = sc.nextDouble();
        SanPham newSanPham = new SanPham(Id,name,quantity,price);
        // lưu và danh sách sản phẩm
        sanPhams.add(newSanPham);
        // Thêm vào Linked List
        list.insertAtTail(newSanPham);
    }
    // Case 3 Hiển thị thông tin của các sản phẩm trong danh sách móc nối
    /**
     * Hiển thị danh sách sản phẩm trong danh sách móc nối
     * dùng print() để in ra
     */
    public void display(){
        list.print();
    }
    // case 4 Lưu danh sách móc nối các sản phẩm vào file
    public static void SaveFileTxt(){
        list.SaveFile();
    }
    // case 5 Tìm kiếm thông tin của sản phẩm theo ID

    /**
     * Tìm kiếm sản phẩm theo Id
     * Hiện thị sản phẩm đó
     */
    public static void Search(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Do you want to find ID : ");
        String Id = sc.next();
        if (list.find(Id) == null){
            System.out.println("Result: -1");
            return;
        }
        System.out.println("Result: "+ list.find(Id));
    }
    // case 6 Xóa sản phẩm trong danh sách theo ID

    /**
     * Xóa sản phẩm theo ID
     * Xóa sản phẩm theo ID trong mảng và cập nhật và file
     * Xóa sản phẩm theo ID trong Linkedlist
     */
    public static void DeleteProduct(){
        Scanner sc = new Scanner(System.in);
        System.out.print("The ID you want to delete: ");
        String Id = sc.next();
        // xoa Id trong mang
        list.DeletaAt(Id);
        System.out.println("Deleted!");
    }
    // case 7.1 Sắp xếp các sản phẩm  trong danh sách móc nối theo ID
    public static void SortId(){
        list.sortList();
        System.out.println("successfully!");
    }
    // 7.2 Sap xem theo de quy
    public static void SortRecursionId(){
        list.sortListRecursion(list.getHead());
        System.out.println("successfully!");
    }
    // case 8 Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10) của phần tử đầu tiên trong Linked List ra hệ đếm nhị phân bằng phương pháp đệ quy.
    public static void Binary(){
        list.BinaryHead();
    }
    // case 9 Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Hiển thị ra màn hình các sản phẩm có trong stack.
    public static void SaveStack(){
        File file = new File("C:\\Users\\Admin\\Project2\\data.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Đọc file theo hàng
        while (scanner.hasNextLine()) {
            String number = scanner.nextLine();
            // cac phan tu cách nhau bằng dấu ","
            String [] number1 = number.split(",");
            SanPham sp = new SanPham(number1[0],number1[1],Integer.valueOf(number1[2]),Double.valueOf(number1[3]));
            // them vao Linkedlist
            stackLinkedList.push(sp);
        }
        stackLinkedList.DisplayStack();
    }
    // case 10 Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. Hiển thị ra màn hình các sản phẩm có trong queue.
    public static void SaveQueue(){
        File file = new File("C:\\Users\\Admin\\Project2\\data.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Đọc file theo hàng
        while (scanner.hasNextLine()) {
            String number = scanner.nextLine();
            // cac phan tu cách nhau bằng dấu ","
            String [] number1 = number.split(",");
            SanPham sp = new SanPham(number1[0],number1[1],Integer.valueOf(number1[2]),Double.valueOf(number1[3]));
            // them vao Linkedlist
            queueLinkedList.enqueue(sp);
        }
        queueLinkedList.DisplayQueue();
    }
}
