import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int selection;
        do {
            Function function = new Function();
            FunctionCompareTime functionCompareTime = new FunctionCompareTime();
            System.out.println("---Menu---");
            System.out.println("1: Input");
            System.out.println("2: Out ");
            System.out.println("3: Bubble Sort");
            System.out.println("4: Selection Sort");
            System.out.println("5: Insertion Sort");
            System.out.println("6: Search > value");
            System.out.println("7: Search =  value");
            System.out.println("8: Compare time");
            System.out.println("0: The end!");
            System.out.print("Your selection: ");
            selection = sc.nextInt();
            switch (selection){
                case 1:
                    function.InputTxt();
                    break;
                case 2:
                    function.OutputTxt();
                    break;
                case 3:
                    function.BubbleSort();
                    break;
                case 4:
                    function.SelectionSort();
                    break;
                case 5:
                    function.InsertionSort();
                    break;
                case 6:
                    function.LinearSearchTxt();
                    break;
                case 7:
                    function.BinarySearchTxt();
                    break;
                case 8:
                    functionCompareTime.Time();
                    break;
            }
        }while (selection !=0 );
    }
}
