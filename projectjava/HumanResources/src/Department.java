public class Department {
    private String maBoPhan;
    private String tenBoPhan;
    private int soLuongNhanVienHienTai;

    //Constructor
    public Department(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
        this.soLuongNhanVienHienTai = 1;
    }

    public Department(String maBoPhan, String tenBoPhan) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soLuongNhanVienHienTai = 0;
    }
    //Hàm getter và hàm setter

    public String getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public int getSoLuongNhanVienHienTai() {
        return soLuongNhanVienHienTai;
    }

    public void setSoLuongNhanVienHienTai(int soLuongNhanVienHienTai) {
        this.soLuongNhanVienHienTai = soLuongNhanVienHienTai;
    }
    // Hàm tostring

    @Override
    public String toString() {
        return "Department{" +
                "maBoPhan='" + maBoPhan + '\'' +
                ", tenBoPhan='" + tenBoPhan + '\'' +
                ", soLuongNhanVienHienTai=" + soLuongNhanVienHienTai +
                '}';
    }
    // Xem có bị trùng tên hay không
    public boolean checkTenMa(Department dpm){
        return  this.getTenBoPhan().equals(dpm.getTenBoPhan())&&this.getMaBoPhan().equals(dpm.getMaBoPhan());
    }
}
