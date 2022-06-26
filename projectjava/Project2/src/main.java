import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int selection;
        do {
            Function function = new Function();
            System.out.println("Choose one of this options:\n" +
                    "Product list:");
            System.out.println("1. Load data from file and display");
            System.out.println("2. Input & add to the end.");
            System.out.println("3.Display data");
            System.out.println("4.Save product list to file.");
            System.out.println("5. Search by ID");
            System.out.println("6.Delete by ID");
            System.out.println("7.Sort by ID.");
            System.out.println("8. Convert to Binary ");
            System.out.println("9. Load to stack and display");
            System.out.println("10. Load to queue and display.");
            System.out.println("0: The end!");
            System.out.print("Your selection: ");
            selection = sc.nextInt();
            switch (selection){
                case 1:
                    function.InputTxt();
                    function.OutputTxt();
                    break;
                case 2:
                    function.addProduct();
                    break;
                case 3:
                    function.display();
                    break;
                case 4:
                    function.SaveFileTxt();
                    break;
                case 5:
                    function.Search();
                    break;
                case 6:
                    function.DeleteProduct();
                    break;
                case  7:
//                    function.SortId();
                    function.SortRecursionId();
                    break;
                case 8:
                    function.Binary();
                    break;
                case 9:
                    function.SaveStack();
                    break;
                case 10:
                    function.SaveQueue();
                    break;
            }
        }while (selection !=0 );
    }
}

