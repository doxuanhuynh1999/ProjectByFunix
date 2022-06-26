public class Manager extends Staff implements ICalculator {
    private String chucDanh;
    //Constructor
    public Manager(String maNhanVien, String tenNhanVien, String tuoiNhanVien, double heSoLuong, String ngayVaoLam, Department boPhanlamViec, double soNgayNghiPhep, String chucDanh) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanlamViec, soNgayNghiPhep);
        this.chucDanh = chucDanh;
    }

    public Manager() {
    }
    // Hàm getter và setter

    public String getChucDanh() {
        return chucDanh;
    }
    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    @Override // Lấy thông tin của quản lý
    public void displayInformation() {
        System.out.print("Mã: " + getMaNhanVien() +" - " );
        System.out.print("Tên: " + getTenNhanVien() +" - " );
        System.out.print("Tuổi: " + getTuoiNhanVien() +" - " );
        System.out.print("Hệ số lương: " + getHeSoLuong() +" - " );
        System.out.print("Ngày vào làm: " + getNgayVaoLam() +" - " );
        System.out.print("Bộ phận: " + getBoPhanlamViec() +" - " );
        System.out.print("Số ngày nghỉ: " + getSoNgayNghiPhep() +" - " );
        System.out.print("Chức danh: " + getChucDanh());
        System.out.println();

    }


    @Override
    public String toString() {
        return "Mã: " + getMaNhanVien() +" - " + "Tên: " + getTenNhanVien() +" - " + "Tuổi: " + getTuoiNhanVien() +" - " + "Hệ số lương: " + getHeSoLuong() +" - " +
                "Ngày vào làm: " + getNgayVaoLam() +" - " + "Bộ phận: " + getBoPhanlamViec() +" - " + "Số ngày nghỉ: " + getSoNgayNghiPhep() +" - " + "Chức danh: " + getChucDanh();
    }

    @Override
    public double calculateSalary() {
        if (this.getChucDanh().equalsIgnoreCase("Business Leader")) return getHeSoLuong() * 5000000 + 8000000;
        else if (this.getChucDanh().equalsIgnoreCase("Project Leader")){
            return getHeSoLuong()*5000000 + 5000000;
        }else if (this.getChucDanh().equalsIgnoreCase("Technical Leader")){
            return getHeSoLuong()*5000000 + 6000000;
        }else return 0.0;
    }
}
