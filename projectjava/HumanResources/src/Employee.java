public class Employee extends Staff implements ICalculator {
    private double soGioLamThem;

    // Constructor
    public Employee(String maNhanVien, String tenNhanVien, String tuoiNhanVien, double heSoLuong, String ngayVaoLam, Department boPhanlamViec, double soNgayNghiPhep, double soGioLamThem) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanlamViec, soNgayNghiPhep);
        this.soGioLamThem = soGioLamThem;
    }

    public Employee() {
    }

    // Hàm getter và setter
    public double getSoGioLamThem() {
        return soGioLamThem;
    }

    public void setSoGioLamThem(double soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

    @Override // Thông tin của nhân viên
    public void displayInformation() {
        System.out.print("Mã: " + getMaNhanVien() + " - ");
        System.out.print("Tên: " + getTenNhanVien() + " - ");
        System.out.print("Tuổi: " + getTuoiNhanVien() + " - ");
        System.out.print("Hệ số lương: " + getHeSoLuong() + " - ");
        System.out.print("Ngày vào làm: " + getNgayVaoLam() + " - ");
        System.out.print("Bộ phận: " + getBoPhanlamViec() + " - ");
        System.out.print("Số ngày nghỉ: " + getSoNgayNghiPhep() + " - ");
        System.out.print("Giờ làm thêm: " + getSoGioLamThem());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Mã: " + getMaNhanVien() + " - " + "Tên: " + getTenNhanVien() + " - " + "Tuổi: " + getTuoiNhanVien() + " - " + "Hệ số lương: " + getHeSoLuong() + " - " +
                "Ngày vào làm: " + getNgayVaoLam() + " - " + "Bộ phận: " + getBoPhanlamViec() + " - " + "Số ngày nghỉ: " + getSoNgayNghiPhep() + " - " + "Giờ làm thêm: " + getSoGioLamThem();
    }
    //  Lương của nhân viên
    @Override
    public double calculateSalary() {
        return getHeSoLuong() * 3000000 + getSoGioLamThem() * 200000;
    }
}


