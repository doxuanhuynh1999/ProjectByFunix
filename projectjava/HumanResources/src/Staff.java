public abstract class Staff {
    private String maNhanVien;
    private String tenNhanVien;
    private String tuoiNhanVien;
    private double heSoLuong;
    private String ngayVaoLam;
    private Department boPhanlamViec;
    private double soNgayNghiPhep;


    public Staff(String maNhanVien, String tenNhanVien, String tuoiNhanVien, double heSoLuong, String ngayVaoLam, Department boPhanlamViec, double soNgayNghiPhep) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tuoiNhanVien = tuoiNhanVien;
        this.heSoLuong = heSoLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhanlamViec = boPhanlamViec;
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

    public Staff() {
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maNhanVien = maSinhVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTuoiNhanVien() {
        return tuoiNhanVien;
    }

    public void setTuoiNhanVien(String tuoiNhanVien) {
        this.tuoiNhanVien = tuoiNhanVien;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public Department getBoPhanlamViec() {
        return boPhanlamViec;
    }

    public void setBoPhanlamViec(Department boPhanlamViec) {
        this.boPhanlamViec = boPhanlamViec;
    }

    public double getSoNgayNghiPhep() {
        return soNgayNghiPhep;
    }

    public void setSoNgayNghiPhep(double soNgayNghiPhep) {
        this.soNgayNghiPhep = soNgayNghiPhep;
    }
    public abstract void displayInformation();



}
