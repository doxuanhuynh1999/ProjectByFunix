import java.text.DecimalFormat;
import java.util.Scanner;

public class GradeStudent {
    //    Khai báo biến static
    static int midTermWeight;
    static int finalTermWeight;
    static int homeWorkWeight;
    //    static double weightedScoreMidTerm;
    static double weightedScoreFinal;
    static double weightedScoreHome;

    //    Hàm Begin
    public static void begin() {
        System.out.println("This program reads exam/homework scores\nand reports yuor overrall courese grade .");
    }

    //    Hàm midTerm
    public static double midTerm() {
        System.out.println("Midterm:");
        Scanner sc = new Scanner(System.in);
        System.out.print("Weight (0-100)? ");
        midTermWeight = sc.nextInt(); // midTermWeight trong khoảng từ 0-100
        while (midTermWeight >= 100 || midTermWeight < 0) {
            System.out.print("Nhập lại Weight (0-100) ");
            midTermWeight = sc.nextInt();
        }
        System.out.print("Score earned? ");
        int scoreEarned = sc.nextInt(); // Số điểm người dùng đạt được
        int shiftAmount; // điểm động
        System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
        int select = sc.nextInt(); // Lựa chọn có cộng điểm hay không 1 có , 2 không
        if (select == 1) {
            System.out.print("Shift amount? ");
            shiftAmount = sc.nextInt();
        } else {
            shiftAmount = 0;
        }
        int totalPoints = scoreEarned + shiftAmount;
        System.out.println("Total  points = " + totalPoints + " / 100");
        double weightedScoreMidTerm;
        weightedScoreMidTerm = (double) (totalPoints * 0.01 * midTermWeight); // Điểm số đã tính trên trọng số
        double weightedScoreLast = (double) Math.round(weightedScoreMidTerm * 10.0) / 10.0;
        System.out.println("Weighted score = " + weightedScoreLast + " / " + midTermWeight);
        return weightedScoreMidTerm;
    }

    //    Hàm FinalTerm
    public static void finalTerm() {
        System.out.println("Final : ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Weight (0-100)? ");
        finalTermWeight = sc.nextInt(); // finalTermWeight trong khoảng từ 0-100
        while (finalTermWeight + midTermWeight >= 100 || finalTermWeight < 0) {
            System.out.print("Nhập lại Weight (0-100) ");
            finalTermWeight = sc.nextInt();
        }
        System.out.print("Score earned? ");
        int scoreEarned = sc.nextInt(); // Số điểm người dùng đạt được
        int shiftAmount; // điểm động
        System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
        int select = sc.nextInt(); // Lựa chọn có cộng điểm hay không 1 có , 2 không
        if (select == 1) {
            System.out.print("Shift amount? ");
            shiftAmount = sc.nextInt();
        } else {
            shiftAmount = 0;
        }
        int totalPoints = scoreEarned + shiftAmount;
        if (totalPoints > 100) {
            totalPoints = 100;
        }
        System.out.println("Total  points = " + totalPoints + " / 100");
        weightedScoreFinal = (double) (totalPoints * 0.01 * finalTermWeight); // Điểm số đã tính trên trọng số
        double weightedScoreLast = (double) Math.round(weightedScoreFinal * 10.0) / 10.0;
        System.out.println("Weighted score = " + weightedScoreLast + " / " + finalTermWeight);
    }

    //    Hàm Homework
    public static void homeWork() {
        System.out.println("Homework: ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Weight (0-100)? ");
        homeWorkWeight = sc.nextInt();
        while (homeWorkWeight + finalTermWeight + midTermWeight != 100 || homeWorkWeight < 0) { // do tổng của 3 cái bằng 100
            System.out.print("Nhập lại Weight (0-100)? ");
            homeWorkWeight = sc.nextInt();
        }
        System.out.print("Number of assignments? ");
        int n = sc.nextInt(); // Số bài assignments
        int sum = 0;
        int sumMax = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Assignment " + (i + 1) + " score and max? ");
            int score = sc.nextInt();
            int max = sc.nextInt();
            while (score > max) {
                System.out.print("nhập lại Assignment " + (i + 1) + " score và max? ");
                score = sc.nextInt();
                max = sc.nextInt();
            }
            sum += score;
            if (sum > 150) {
                sum = 150;
            }
            sumMax += max;
        }

        System.out.print("How many sections did  you attend? ");
        int m = sc.nextInt(); // Số buổi tham gia
        int sectionPoints = m * 5;
        if (sectionPoints > 30) {
            sectionPoints = 30;
        }
        System.out.println("Section points = " + sectionPoints + "/" + 30); // điểm phần attend tối đa là 30
        int totalPoints = sum + sectionPoints;
        System.out.println("Total points = " + totalPoints + "/" + (int) (sumMax + 30));
        weightedScoreHome = (double) (totalPoints * homeWorkWeight) / (sumMax + 30);
        double weightedScoreLast = (double) Math.round(weightedScoreHome * 10.0) / 10.0;
        System.out.println("Weighted score = " + weightedScoreLast + " / " + homeWorkWeight);

    }

    //        Hàm report
    public static void report(double a) {
        System.out.println();
        double grade = Math.round((a + weightedScoreFinal + weightedScoreHome) * 10.0) / (10.0);
        System.out.println("Overall percentage = " + grade);
        double minGrade = grade * 0.01; // Tính ra phần trăm
        double GPA;
        if (minGrade >= 0.85) {
            GPA = 3.0; //Với min grade >=85%: GPA=3.0;
        } else if (minGrade >= 0.75 && minGrade < 0.85) {
            GPA = 2.0;  // min grade >=75% và min grade <85%: thì GPA = 2.0;
        } else if (minGrade >= 0.6 && minGrade < 0.75) {
            GPA = 1.0; // min grade >=60% và min grade <75%: thì GPA= 1.0;
        } else {
            GPA = 0.0; // min grade < 60%: thì GPA= 0.0.
        }
        System.out.println("Your grade will be at least: " + GPA);
        if (GPA == 3.0) {
            System.out.println("Bạn là học sinh giỏi.");
        } else if (GPA == 2.0) {
            System.out.println("Bạn là học sinh khá.");
        } else if (GPA == 1.0) {
            System.out.println("Bạn là học sinh trung bình.");
        } else {
            System.out.println("XIn mời bạn ở lại lớp.");
        }
    }

    //    Hàm main
    public static void main(String[] args) {

        begin();
        System.out.println();
        double weightedScoreMidTerm = midTerm();
        System.out.println();
        finalTerm();
        homeWork();
        report(weightedScoreMidTerm);
    }
}
