public class CompareTime {
    static int[] b;
    static int n;
    // hàm biểu diễn các phần tử trong mảng
    public static void display(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    // Coppy sang mảng mới
    public static void CoppyArray(int [] a){
        n = a.length;
        b = new int[n];
        for (int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
    }
    // thuật toán Bubble Sort
    public static void BubbleSort(int[] a){
        CoppyArray(a);
        for (int i = b.length -1; i >=0; i--){
            for(int j = 1; j <= i; j++){
                if(b[j-1]>b[j]){
                    int tmp = b[j-1];
                    b[j-1]=b[j];
                    b[j] = tmp;
                }
            }
        }
        display(b);
    }
    // thuật toán Selection sort
    public static void SelectionSort(int []a){
        CoppyArray(a);
        for(int i = 0; i < b.length-1; i++){
            int minIndex =  i;
            for (int j = i+1; j < b.length;j++){
                if (b[minIndex]>b[j]){
                    minIndex=j;
                }
            }
            int tmp = b[minIndex];
            b[minIndex] = b[i];
            b[i] = tmp;
        }
        display(b);
    }
    // thuật toán Insertion Sort
    public static void InsertionSort(int[] a){
        CoppyArray(a);
        for (int i = 1; i < b.length; i++){
            int tmp = b[i];
            int j = i-1;
            while (j>=0 && b[j]>tmp){
                b[j+1]=b[j];
                j--;
            }
            b[j+1] = tmp;
        }
        display(b);
    }
}
