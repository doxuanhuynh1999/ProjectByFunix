import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Function {
    // Arraylist staff
    public static ArrayList<Staff> staffArrayList = new ArrayList<>();
    // Arraylist Department
    public static ArrayList<Department> departmentArrayList = new ArrayList<>();

    // tạo ra một danh sách có sẵn
    public static void danhSachThemTruoc() {
        // Tạo Department
        Department it1 = new Department("ms1", "Dev1");
        Department it2 = new Department("ms2", "Dev2");
        Department it3 = new Department("ms3", "Dev3");
        // Them vao listarray department
        departmentArrayList.add(it1);
        departmentArrayList.add(it2);
        departmentArrayList.add(it3);
        // Thêm employee vào trong listarray Staff
        Employee nv1 = new Employee("2017", "nv1", "23", 2, "23-02-2021", it1, 2, 12);
        Employee nv2 = new Employee("2018", "nv2", "23", 2, "23-02-2021", it2, 2, 12);
        Employee nv3 = new Employee("2019", "nv3", "23", 2, "23-02-2021", it3, 2, 12);
        staffArrayList.add(nv1);
        staffArrayList.add(nv2);
        staffArrayList.add(nv3);
        // Thêm manager vào trong listarray Staff
        Manager ql1 = new Manager("52", "ql1", "23", 2, "22-3-2022", it1, 2, "Business Leader");
        Manager ql2 = new Manager("53", "ql2", "23", 2, "22-3-2022", it2, 2, "Project Leader");
        Manager ql3 = new Manager("54", "ql3", "23", 2, "22-3-2022", it3, 2, "Business Leader");
        staffArrayList.add(ql1);
        staffArrayList.add(ql2);
        staffArrayList.add(ql3);
        // update so nhan vien
        for (Staff staff : staffArrayList) {
            for (int i = 0; i < departmentArrayList.size(); i++) {
                Department dp = departmentArrayList.get(i);
                if (staff.getBoPhanlamViec().equals(dp)) {
                    dp.setSoLuongNhanVienHienTai(dp.getSoLuongNhanVienHienTai() + 1);
                }
            }
        }
    }

    // 1.Hiện thị nhân viên
    public static void danhSachNhanVien() {
        System.out.println(" Hiển thị danh sách nhân viên hiện có trong công ty ");
        for (Staff staff : staffArrayList) {
            staff.displayInformation();
        }
    }

    // 2.Hiển thị các bộ phận trong công ty
    public static void cacBoPhanTrongCongTy() {
        System.out.println("Các bộ Phận trong công ty: ");
        for (Department department : departmentArrayList) {
            System.out.println("- " + department);
        }
    }

    //3. Hiển thị các nhân viên theo từng bộ phận
    public static void tenNhanVienTheoTungBoPhan() {
        int luaChon;
        Scanner sc = new Scanner(System.in);
        // Hiển thị các bộ phận trong công ty
        System.out.println("Nhân viên các bộ Phận trong công ty: ");
        for (int i = 0; i < departmentArrayList.size(); i++) {
            System.out.println((i + 1) + ": " + departmentArrayList.get(i).getTenBoPhan());
            for (Staff staff : staffArrayList) {
                if (departmentArrayList.get(i).equals(staff.getBoPhanlamViec())) {
                    staff.displayInformation();
                }
            }
        }
    }


    /**
     * method adDepartment() kiểu dữ liệu trả về là Department
     * @return department
     */
    //4.1. Thêm department
    public static Department addDepartment() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        Department department = null;
        // Nhập giá trị của department
        System.out.print("Nhập mã bộ phận: ");
        String maMoi = sc.next();
        System.out.print("Nhập tên bộ phận: ");
        String tenMoi = sc.next();
        // check xem department đã có hay chưa
        // Nếu có, tăng số lượng nhân viên
        for (int i = 0; i < departmentArrayList.size(); i++) {
            if (departmentArrayList.get(i).getMaBoPhan().equals(maMoi) && departmentArrayList.get(i).getTenBoPhan().equals(tenMoi)) {
                department = departmentArrayList.get(i);
                department.setSoLuongNhanVienHienTai(department.getSoLuongNhanVienHienTai() + 1);
                check = true;
                break;
            }
        }
        // Nếu không có thì tạo một department mới và thêm vào listdepartment
        if (!check) {
            department = new Department(maMoi, tenMoi);
            department.setSoLuongNhanVienHienTai(1);
            departmentArrayList.add(department);
            return department;
        } else {
            return department;
        }
    }

    //4.2 thêm employee
    public static void addEmployee() {
        //Nhập dữ liệu đầu vào
        Scanner sc = new Scanner(System.in);
        System.out.print("Mã nhân viên: ");
        String maNhanVien = sc.next();
        System.out.print("Tên nhân viên: ");
        String tenNhanVien = sc.next();
        System.out.print("Tuổi nhân viên: ");
        String tuoiNhanVien = sc.next();
        System.out.print("Hệ số luong nhân viên: ");
        double heSoLuong = sc.nextDouble();
        System.out.print("Ngày vào làm: ");
        String ngayVaoLam = sc.next();
        Department department = addDepartment();
        System.out.print("soNgayNghi: ");
        double soNgayNghi = sc.nextDouble();
        System.out.print("Giờ làm thêm: ");
        Double gioLamThem = sc.nextDouble();
        // thêm nhân viên
        Employee employee = new Employee(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, department, soNgayNghi, gioLamThem);
        staffArrayList.add(employee);
    }
    /**
     * hàm chucDanh() kiểu dữ liệu trả về String
     * @return "Business Leader" || "Project Leader" || "Technical Leader"
     */
    // 4.3 Thêm manage
    // Thêm chức danh cho manage
    public static String chucDanh() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        System.out.println("Chức danh: ");
        System.out.println("1: Business Leader");
        System.out.println("2: Project Leader");
        System.out.println("3: Technical Leader");
        do {
            System.out.print("Bạn chọn là: ");
            luaChon = sc.nextInt();
        } while (luaChon != 1 && luaChon != 2 && luaChon != 3);
        if (luaChon == 1) {
            return "Business Leader";
        } else if (luaChon == 2) {
            return "Project Leader";
        } else {
            return "Technical Leader";
        }
    }

    // thêm manage
    public static void addManage() {
        // Nhập dữ liệu đầu vào
        Scanner sc = new Scanner(System.in);
        System.out.print("Mã nhân viên: ");
        String maNhanVien = sc.next();
        System.out.print("Tên nhân viên: ");
        String tenNhanVien = sc.next();
        System.out.print("Tuổi nhân viên: ");
        String tuoiNhanVien = sc.next();
        System.out.print("Hệ số luong nhân viên: ");
        double heSoLuong = sc.nextDouble();
        System.out.print("Ngày vào làm: ");
        String ngayVaoLam = sc.next();
        Department department = addDepartment();
        System.out.print("soNgayNghi: ");
        double soNgayNghi = sc.nextDouble();
        String chucDanh = chucDanh();
        // thêm nhân viên
        Manager leader = new Manager(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, department, soNgayNghi, chucDanh);
        staffArrayList.add(leader);
    }

    //4.4 thêm vào danh sach
    public static void addStaff() {
        int luaChon;
        Scanner sc = new Scanner(System.in);
        System.out.println("1: Add employee \n 2: Add manage ");
        do {
            System.out.print("Bạn muốn add employee hay manage: ");
            luaChon = sc.nextInt();
        } while (luaChon != 1 && luaChon != 2);
        if (luaChon == 1) {
            addEmployee();
        } else {
            addManage();
        }
    }

    //5. Tìm kiếm nhân viên thêm tên hoặc mã nhân viên
    //5.1 Tìm kiếm theo tên nhân viên
    public static void timTen() {
        String tenTimKiem;
        boolean checked = false;
        // nhập tên người dùng muốn tìm kiếm
        Scanner sc = new Scanner(System.in);
        System.out.print("Hãy nhập tên nhân viên muốn tìm kiếm: ");
        tenTimKiem = sc.next();
        // kiểm tra xem trong staffarray đã có tên nhân viên hay chưa
        for (Staff staff : staffArrayList) {
            if (staff.getTenNhanVien().equalsIgnoreCase(tenTimKiem)) {
                staff.displayInformation();
                checked = true;
            }
        }
        // nếu không có tên
        if (!checked) {
            System.out.println("không tìm thấy");
        }
    }

    //5.2 Tìm kiếm theo mã nhân viên
    public static void timTheoMaNhanVien() {
        String maTimKiem;
        boolean checked = false;
        // nhập tên người dùng muốn tìm kiếm
        Scanner sc = new Scanner(System.in);
        System.out.print("Hãy nhập mã nhân viên muốn tìm kiếm: ");
        maTimKiem = sc.next();
        // kiểm tra xem trong staffarray đã có mã nhân viên hay chưa
        for (Staff staff : staffArrayList) {
            if (staff.getMaNhanVien().equalsIgnoreCase(maTimKiem)) {
                staff.displayInformation();
                checked = true;
            }
        }
        if (!checked) {
            System.out.println("Không tìm thấy");
        }
    }

    //5.3 Tìm kiếm nhân viên
    public static void timKiem() {
        int luaChon;
        Scanner sc = new Scanner(System.in);
        System.out.println("1: Bạn muốn tìm kiếm theo tên: ");
        System.out.println("2: Bạn muốn tìm kiếm theo mã ");
        do {
            System.out.print("Bạn muốn tìm kiếm theo: ");
            luaChon = sc.nextInt();
        } while (luaChon != 1 && luaChon != 2);
        if (luaChon == 1) {
            timTen();
        } else {
            timTheoMaNhanVien();
        }
    }

    //6. Tính lương nhân viên
    public static void luongNhanVien() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Lương của nhân viên: ");
        for (Staff staff : staffArrayList) {
            staff.displayInformation();
            if(staff instanceof ICalculator){
                System.out.print("Lương: " + df.format((((ICalculator) staff).calculateSalary())));
            }
            System.out.println();
        }
    }

    //7. sắp xếp lương tăng dần
    public static void luongTangDan() {
        System.out.println("Sắp  xếp lương tăng dần: ");
        DecimalFormat df = new DecimalFormat("#.##");
        Collections.sort(staffArrayList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if (o1 instanceof ICalculator && o2 instanceof ICalculator) {
                    if (((ICalculator) o1).calculateSalary() < ((ICalculator) o2).calculateSalary()) {
                        return -1;
                    } else if (((ICalculator) o1).calculateSalary() > ((ICalculator) o2).calculateSalary()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }else if (o1 instanceof ICalculator && !(o2 instanceof ICalculator)){
                    return -1;
                }else if (!(o1 instanceof ICalculator) && o2 instanceof ICalculator){
                    return  1;
                }else {
                    return 0;
                }
            }
        });
        // in ra danh sach
        for (Staff staff : staffArrayList) {
            staff.displayInformation();
            if(staff instanceof ICalculator){
                System.out.print("Lương: " + df.format((((ICalculator) staff).calculateSalary())));
            }
            System.out.println();
        }
    }

    //
//    // 8. Sắp xếp lương giảm dần
    public static void luongGiamDan() {
        System.out.println("Sắp  xếp lương tăng dần: ");
        DecimalFormat df = new DecimalFormat("#.##");
        Collections.sort(staffArrayList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if (o1 instanceof ICalculator && o2 instanceof ICalculator) {
                    if (((ICalculator) o1).calculateSalary() < ((ICalculator) o2).calculateSalary()) {
                        return 1;
                    } else if (((ICalculator) o1).calculateSalary() > ((ICalculator) o2).calculateSalary()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }else if (o1 instanceof ICalculator && !(o2 instanceof ICalculator)){
                    return 1;
                }else if (!(o1 instanceof ICalculator) && o2 instanceof ICalculator){
                    return  -1;
                }else {
                    return 0;
                }
            }
        });
        // in ra danh sach
        for (Staff staff : staffArrayList) {
            staff.displayInformation();
            if(staff instanceof ICalculator){
                System.out.print("Lương: " + df.format((((ICalculator) staff).calculateSalary())));
            }
            System.out.println();
        }
    }
}

