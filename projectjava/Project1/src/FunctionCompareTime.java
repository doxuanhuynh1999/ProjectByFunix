import java.sql.Timestamp;
import java.util.Scanner;

public class FunctionCompareTime {
    static int[] b;
    static int[] c;
    static int[] a;
    public static void Time(){
        String select;
        do {
            CompareTime compareTime = new CompareTime();
            Scanner sc = new Scanner(System.in);
            System.out.println("số phần tử");
            int n = sc.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = (int) (Math.random() * n);
            }
            b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = i;
            }
            c = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                c[j] = j;
            }

            Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
            compareTime.BubbleSort(a);
            Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
            compareTime.SelectionSort(a);
            Timestamp timestamp3 = new Timestamp(System.currentTimeMillis());
            compareTime.InsertionSort(a);
            Timestamp timestamp4 = new Timestamp(System.currentTimeMillis());
            System.out.println("thoi gian chay average tại bubble sort : " + (timestamp2.getTime() - timestamp1.getTime()));
            System.out.println("thoi gian chay average tại selection sort : " + (timestamp3.getTime() - timestamp2.getTime()));
            System.out.println("thoi gian chay average tại insertion sort : " + (timestamp4.getTime() - timestamp3.getTime()));
            Timestamp timestamp5 = new Timestamp(System.currentTimeMillis());
            compareTime.BubbleSort(c);
            Timestamp timestamp6 = new Timestamp(System.currentTimeMillis());
            compareTime.SelectionSort(c);
            Timestamp timestamp7 = new Timestamp(System.currentTimeMillis());
            compareTime.InsertionSort(c);
            Timestamp timestamp8 = new Timestamp(System.currentTimeMillis());
            System.out.println("thoi gian chay worst tại bubble sort : " + (timestamp6.getTime() - timestamp5.getTime()));
            System.out.println("thoi gian chay worst tại selection sort : " + (timestamp7.getTime() - timestamp6.getTime()));
            System.out.println("thoi gian chay worst tại insertion sort : " + (timestamp8.getTime() - timestamp7.getTime()));
            Timestamp timestamp9 = new Timestamp(System.currentTimeMillis());
            compareTime.InsertionSort(b);
            Timestamp timestamp10 = new Timestamp(System.currentTimeMillis());
            compareTime.InsertionSort(b);
            Timestamp timestamp11 = new Timestamp(System.currentTimeMillis());
            compareTime.InsertionSort(b);
            Timestamp timestamp12 = new Timestamp(System.currentTimeMillis());
            System.out.println("thoi gian chay best tại bubble sort : " + (timestamp10.getTime() - timestamp9.getTime()));
            System.out.println("thoi gian chay best tại selection sort : " + (timestamp11.getTime() - timestamp10.getTime()));
            System.out.println("thoi gian chay best tại insertion sort : " + (timestamp12.getTime() - timestamp11.getTime()));
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Nhận xét");
            System.out.println("Tại Best case: thời gian Insertion Sort --> Selection -->Bubble Sort ");
            System.out.println("Tại worst case: thời gian Insertion Sort -->Bubble Sort --> Selection");
            System.out.println("Tại average case: thời gian Selection Sort --> Insertion Sort --> Bubble Sort ");
            System.out.println("Nếu bạn muôn tiếp tục hãy chọn yes hoặc y và nếu muốn kết thúc chọn no hoặc n");
            select = sc.next();
        }while (!(select.equalsIgnoreCase("no")) || select.equalsIgnoreCase("n"));


    }
}
