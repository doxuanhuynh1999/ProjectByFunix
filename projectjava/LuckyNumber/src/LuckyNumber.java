import java.text.DecimalFormat;
import java.util.Scanner;

public class LuckyNumber {
//    Tạo biến static
    static int sumPlay =0;
    static int sumSelect =0;
    static int minPlay = Integer.MAX_VALUE ;
    public static final int MAXIMUM = 100;
// Hàm  trò chơi
    public static void play(){
        sumPlay++;
        int numberTrue =(int)( Math.random()*(MAXIMUM+1));
        int nextSelect = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Tôi đang nghĩ số trong khoảng từ 0 đến " + MAXIMUM +"...");
//        Vòng lặp của trò  chơi
        while (true){
            System.out.print("Bạn đoán? ");
            int yourSelect = sc.nextInt();
            nextSelect++;
            sumSelect++;
            if (numberTrue==yourSelect){
                System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " +nextSelect+ " lần dự đoán!");
//                Tìm số lần quay bé nhất
                if(minPlay > nextSelect){
                    minPlay = nextSelect;
                }
                break;
            }else {
                if (yourSelect<numberTrue){
                    System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
                }else {
                    System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
                }
            }

        }

    }
//    Hàm in ra kết quả
    public static void report(){
        System.out.println("Tổng số lần chơi   = " + sumPlay);
        System.out.println("Tổng số lần dự đoán = " + sumSelect);
//        Tính trung bình
        double avg = (double) sumSelect/sumPlay;
        //        Đổi thành số có 2 chữ số đằng sau
        DecimalFormat df = new DecimalFormat("#.##");
        String avgLast = df.format(avg);
        System.out.println("Số lần dự đoán trung bình mỗi lượt = " + avgLast);
        System.out.println("Số lần dự đoán ít nhất   = " + minPlay);

    }
//Hàm chạy trò chơi
    public static void main(String[] args) {
        String result = "";
        do {
            play();
            System.out.println("Bạn có muốn tiếp tục chơi không ?");
//            Hỏi xem người chơi có muốn tiếp tục hay không
            Scanner sc = new Scanner(System.in);
             result = sc.nextLine();

        }while (result.equalsIgnoreCase("yes" ) || result.equalsIgnoreCase("y"));
            System.out.println("kết quả của trò  chơi:");
            report();

    }


}
