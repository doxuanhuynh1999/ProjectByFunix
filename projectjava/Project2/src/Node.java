public class Node {
    private SanPham sanPham;
    private Node nextNode;

    // constructor
    public Node(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    // getter and setter
    public SanPham getSanPham() {
        return sanPham;
    }
    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    public Node getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }


    @Override
    public String toString() {
        return String.valueOf(this.sanPham);
    }
}
