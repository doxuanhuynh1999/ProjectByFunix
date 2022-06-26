import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Timestamp;

public class Function {
    static int n;
    static ArrayList<Double> a = new ArrayList<>();
    static ArrayList<Double> b = new ArrayList<>();

    /**
     * Nhập giá trị của n
     * Thêm giá trị vào mảng có độ dài là n
     * Lưu vào tệp INPUT.TXT
     */
    public static void InputTxt() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập giá trị của n: ");
        n = sc.nextInt();
        Double[] array = new Double[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập giá trị của mảng tại vị trí " + i);
            array[i] = sc.nextDouble();
        }
        File file = new File("C:\\Users\\Admin\\Project1\\INPUT.TXT");
        try {
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < array.length; i++) {
                fw.write(String.valueOf(array[i] + " "));
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Đọc dữ liệu từ  Input và lưu vào mảng a
     */
    public static void OutputTxt() {
        File file = new File("C:\\Users\\Admin\\Project1\\INPUT.TXT");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Read from file");
        System.out.print("Array a: ");
        // đọc file theo số
        while (scanner.hasNextDouble()) {
            Double number = scanner.nextDouble();
            a.add(number);
            System.out.print(number + " ");
        }
        System.out.println();
    }

    /**
     * Coppy mảng a sang mảng b
     */
    public static void coppyArray(ArrayList<Double> a) {
        b = (ArrayList<Double>) a.clone();
    }

    // Hàm display() in ra các phần tử của mảng
    public static void display(ArrayList<Double> b) {
        for (Double number : b) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    /**
     * Bubble sort
     * In ra kết quả từng bước ra màn hình
     * Lưu kết quả cuối cùng vào file OUTPUT1.TXT
     */
    public static void BubbleSort() {
        // Coppy mảng a ra mảng b
        coppyArray(a);
        // Bubble Sort
        System.out.println("Bubble Sort");
        // sap xep tu cuoi len dau
        for (int i = b.size() - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (b.get(j - 1) > b.get(j)) {
                    double tmp = b.get(j);
                    b.set(j, b.get(j - 1));
                    b.set(j - 1, tmp);
                }
            }
            display(b);
        }

        // Lưu kết quả cuối cùng vào file OUTPUT1.TXT
        File file = new File("C:\\Users\\Admin\\Project1\\OUTPUT1.TXT");
        try {
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < b.size(); i++) {
                fw.write(String.valueOf(b.get(i) + " "));
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Selection sort
     * In ra kết quả từng bước ra màn hình
     * Lưu kết quả cuối cùng vào file OUTPUT2.TXT
     */
    public static void SelectionSort() {
        // Coppy mảng a ra mảng b
        coppyArray(a);
        // Selection Sort
        System.out.println("Selection Sort");
        for (int i = 0; i < b.size() - 1; i++) {
            // tim index có giá trị nhỏ nhất
            int minIndex = i;
            for (int j = i + 1; j < b.size(); j++) {
                if (b.get(minIndex) > b.get(j)) {
                    minIndex = j;
                }
            }
            // thực  hiện swap
            double tmp = b.get(minIndex);
            b.set(minIndex, b.get(i));
            b.set(i, tmp);
            display(b);
        }
        // Lưu kết quả cuối cùng vào file OUTPUT2.TXT
        File file = new File("C:\\Users\\Admin\\Project1\\OUTPUT2.TXT");
        try {
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < b.size(); i++) {
                fw.write(String.valueOf(b.get(i) + " "));
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Insertion sort
     * In ra kết quả từng bước ra màn hình
     * Lưu kết quả cuối cùng vào file OUTPUT3.TXT
     */
    public static void InsertionSort(){
        // Coppy mảng a ra mảng b
        coppyArray(a);
        // Selection Sort
        System.out.println("Insertion Sort");
        for (int i = 1; i < b.size(); i++){
            // Nhấc 1 số lên
            double tmp = b.get(i);
            int j = i -1;
            // Tìm ra vị trí chính xác để chèn
            while (j>=0 && tmp < b.get(j)){
                b.set(j+1,b.get(j));
                j--;
            }
            // chèn vào vị trí tìm thấy
            b.set(j+1,tmp);
            display(b);
        }
        // Lưu kết quả cuối cùng vào file OUTPUT3.TXT
        File file = new File("C:\\Users\\Admin\\Project1\\OUTPUT3.TXT");
        try {
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < b.size(); i++) {
                fw.write(String.valueOf(b.get(i) + " "));
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * LinearSearch
     * Đầu vào array b, value, size là độ lớn của mảng
     * return ArrayList[Interger] chứ  các chỉ số có giá trị lớn hơn value
     */
    public static ArrayList<Integer> LinearSearch(ArrayList<Double>b,int size,double value){
        int i;
        ArrayList<Integer> arr = new ArrayList<>();
        for(i =0; i < size; i++){
            if (b.get(i) > value){
                arr.add(i);
            }
        }
        return arr;
    }
    /**
     * LinearSearch
     * Nhập một value từ bán phím
     * Chọn ra vị trí có giá trị lớn hơn value
     * Lưu kết quả cuối cùng vào file OUTPUT4.TXT
     */

    public static void LinearSearchTxt(){
        // Coppy mảng a ra mảng b
        coppyArray(a);
        int size = b.size();
        // Tạo ra 1 arraylist để lưu vị trí
        ArrayList<Integer> arrayListSearch = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        // Nhập giá trị bạn muốn tìm
        System.out.println("Linear Search");
        System.out.print("Input value: ");
        double value = sc.nextDouble();
        System.out.print("Chỉ số là: ");
        // sử dụng hàm LinearSearch()
        arrayListSearch = LinearSearch(b,size,value);
        for (int i = 0; i < arrayListSearch.size(); i++){
            System.out.print(arrayListSearch.get(i) + " ");
        }
        System.out.println();
        // Lưu kết quả cuối cùng vào file OUTPUT4.TXT
        File file = new File("C:\\Users\\Admin\\Project1\\OUTPUT4.TXT");
        try {
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < arrayListSearch.size(); i++) {
                fw.write(String.valueOf(arrayListSearch.get(i) + " "));
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Binary Search
     * Đầu vào array b, value, size là độ lớn của mảng
     * return mid vị trí cần tìm
     */
    public static int BinarySearch(ArrayList<Double>b, int value, int size ){
        int left = 0;
        int right = size -1;
        int mid;
        int tmp = -1;
        while (left <= right){
            mid = (left + right)/2;
            if (b.get(mid) > value){
                right = mid -1;
            }else if (b.get(mid) < value){
                left = mid + 1;
            }else {
                    right = mid -1;
                tmp = mid;
            }
        }
        return tmp;
    }
    /**
     * Binary Search
     * Sắp xếp mảng b theo selection sort
     * Nhập một value từ bán phím
     * Chọn ra vị trí có giá trị lớn hơn value
     * Lưu kết quả cuối cùng vào file OUTPUT5.TXT
     */
    public static void BinarySearchTxt(){
        // Coppy mảng a ra mảng b
        coppyArray(a);
        int size = b.size();
        // Sắp xếp b theo kiểu selection sort
        for (int i = 0; i < b.size() - 1; i++) {
            // tim index có giá trị nhỏ nhất
            int minIndex = i;
            for (int j = i + 1; j < b.size(); j++) {
                if (b.get(minIndex) > b.get(j)) {
                    minIndex = j;
                }
            }
            // thực  hiện swap
            double tmp = b.get(minIndex);
            b.set(minIndex, b.get(i));
            b.set(i, tmp);
        }
        // Nhập giá trị muốn tìm kiếm
        Scanner sc = new Scanner(System.in);
        System.out.println("Binary Search");
        System.out.print("Input value: ");
        int value = sc.nextInt();
        int index = BinarySearch(b,value,size);
        System.out.println("Index of first element: " + index);
        // Lưu kết quả cuối cùng vào file OUTPUT5.TXT
        File file = new File("C:\\Users\\Admin\\Project1\\OUTPUT5.TXT");
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(String.valueOf(index));
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

