import java.util.Scanner;

public class QuanLySach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ---- BAI 1: NHAP THONG TIN ----
        System.out.println("=== NHAP THONG TIN SACH ===");
        
        System.out.print("Nhap ma sach: ");
        String maSach = scanner.nextLine();
        
        System.out.print("Nhap ten sach: ");
        String tenSach = scanner.nextLine();
        
        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();
        
        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = scanner.nextInt();
        
        System.out.print("Nhap don gia: ");
        double donGia = scanner.nextDouble();
        
        System.out.print("Nhap so luong: ");
        int soLuong = scanner.nextInt();

        // ---- BAI 2: TINH THANH TIEN ----
        double thanhTien = donGia * soLuong;

        // ---- BAI 3: TINH PHI VAN CHUYEN (5%) ----
        double phiVanChuyen = thanhTien * 0.05;

        // ---- BAI 4: TONG TIEN NHAP ----
        double tongTienNhap = thanhTien + phiVanChuyen;

        // ---- HIEN THI LAI THONG TIN ----
        System.out.println("\n=== THONG TIN CHI TIET NHAP KHO ===");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        
        System.out.printf("Don gia: %,.0f VND\n", donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("-----------------------------------");
        System.out.printf("Thanh tien (Bai 2): %,.0f VND\n", thanhTien);
        System.out.printf("Phi van chuyen (Bai 3): %,.0f VND\n", phiVanChuyen);
        System.out.printf("Tong tien nhap (Bai 4): %,.0f VND\n", tongTienNhap);
        System.out.println("===================================");
        
        scanner.close();
    }
}