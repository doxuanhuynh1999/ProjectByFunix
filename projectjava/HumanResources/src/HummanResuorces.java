import java.util.Scanner;

public class HummanResuorces {
    public static void main(String[] args) {
        int luaChon;
        String tiepTuc;
        Function.danhSachThemTruoc();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-----Menu----");
            System.out.println(
                    "1. Hiển thị danh sách nhân viên hiện có trong công ty \n" +
                            "\n" +
                            "2. Hiển thị các bộ phận trong công ty \n" +
                            "\n" +
                            "3. Hiển thị các nhân viên theo từng bộ phận \n" +
                            "\n" +
                            "4. Thêm nhân viên mới vào công ty \n" +
                            "\n" +
                            "5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên\n" +
                            "\n" +
                            "6. Hiển thị bảng lương của nhân viên toàn công ty \n" +
                            "\n" +
                            "7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần " +
                            "\n" +
                            "8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần "
            );
            System.out.print("Nhập giá trị bạn muốn xem: ");
            luaChon = sc.nextInt();
            if (luaChon > 8 || luaChon < 0) {
                System.out.println("Nhập lại giá trị muốn xem: ");
                luaChon = sc.nextInt();
            }
            switch (luaChon){
                case 1:
                    // in ra danh sách nhân viên
                    Function.danhSachNhanVien();
                    break;
                case 2:
                    // in ra tên các bộ phận trong công ty
                    Function.cacBoPhanTrongCongTy();
                    break;

                case 3:
                    // in ra tên nhân viên theo từng bộ phận
                    Function.tenNhanVienTheoTungBoPhan();
                    break;
                case 4:
                    // thêm nhân viên vào danh sách công ty
                    Function.addStaff();
                    break;
                case 5:
                    // Tìm kiếm nhân viên dựa vào tên hoặc mã nhân viên
                    Function.timKiem();
                    break;
                case 6:
                    // in ra lương của nhân viên
                    Function.luongNhanVien();
                    break;
                case 7:
                    // in ra lương của nhân viên tăng dần
                    Function.luongTangDan();
                    break;
                case 8:
                    // in ra lương của nhân viên giảm dần
                    Function.luongGiamDan();
                    break;
            }
            System.out.print("Bạn có muốn tiếp tục không nếu muốn hãy ấn yes,y, nếu không hay ấn no: ");
            tiepTuc = sc.next();

        } while (tiepTuc.equalsIgnoreCase("y")||tiepTuc.equalsIgnoreCase("yes"));
    }


}
