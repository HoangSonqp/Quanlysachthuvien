import java.util.Scanner;

public class QuanLySach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ================= NHAP THONG TIN (TUAN 3 + TUAN 4) =================
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

        // ================= XU LY DIEU KIEN (TUAN 4) =================
        // Bai 1: Kiem tra tinh hop le
        boolean hopLe = true;
        String lyDoKhongHopLe = "";
        if (donGia <= 0) {
            hopLe = false;
            lyDoKhongHopLe += "Don gia phai > 0. ";
        }
        if (soLuong < 0) {
            hopLe = false;
            lyDoKhongHopLe += "So luong phai >= 0. ";
        }
        if (namXuatBan < 0 || namXuatBan > 2026) {
            hopLe = false;
            lyDoKhongHopLe += "Nam xuat ban khong hop le. ";
        }

        // Bai 2: Phan loai gia
        String phanLoaiGia = "";
        if (donGia < 50000) {
            phanLoaiGia = "Sach gia thap";
        } else if (donGia >= 50000 && donGia <= 100000) {
            phanLoaiGia = "Sach gia trung binh";
        } else if (donGia > 100000 && donGia <= 200000) {
            phanLoaiGia = "Sach gia cao";
        } else {
            phanLoaiGia = "Sach gia dac biet";
        }

        // Bai 3: Phan loai ton kho
        String phanLoaiTonKho = "";
        if (soLuong == 0) {
            phanLoaiTonKho = "Het sach";
        } else if (soLuong >= 1 && soLuong <= 5) {
            phanLoaiTonKho = "Sap het";
        } else if (soLuong >= 6 && soLuong <= 20) {
            phanLoaiTonKho = "Con it";
        } else {
            phanLoaiTonKho = "Con nhieu";
        }

        // Bai 4: Chon loai sach (Switch-case)
        System.out.println("\n--- CHON LOAI SACH ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Nhap lua chon cua ban (1-4): ");
        int luaChon = scanner.nextInt();

        String loaiSach = "";
        switch (luaChon) {
            case 1: loaiSach = "Sach giao khoa"; break;
            case 2: loaiSach = "Sach tham khao"; break;
            case 3: loaiSach = "Sach chuyen nganh"; break;
            case 4: loaiSach = "Sach khac"; break;
            default: loaiSach = "Khong xac dinh"; break;
        }

        // ================= TINH TOAN CHI PHI (TUAN 3) =================
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05;
        double tongTienNhap = thanhTien + phiVanChuyen;

        // ================= HIEN THI BAO CAO TONG HOP =================
        System.out.println("\n=============================================");
        System.out.println("=== THONG TIN TONG HOP QUAN LY SACH ===");
        System.out.println("=============================================");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Loai sach (T4-B4): " + loaiSach);
        
        System.out.println("---------------------------------------------");
        if (hopLe) {
            System.out.println("Trang thai du lieu (T4-B1): HOP LE");
        } else {
            System.out.println("Trang thai du lieu (T4-B1): KHONG HOP LE (" + lyDoKhongHopLe + ")");
        }
        System.out.println("Phan loai gia (T4-B2): " + phanLoaiGia);
        System.out.println("Phan loai ton kho (T4-B3): " + phanLoaiTonKho);
        
        System.out.println("---------------------------------------------");
        System.out.printf("Don gia: %,.0f VND\n", donGia);
        System.out.println("So luong: " + soLuong);
        System.out.printf("Thanh tien (T3-B2): %,.0f VND\n", thanhTien);
        System.out.printf("Phi van chuyen (T3-B3): %,.0f VND\n", phiVanChuyen);
        System.out.printf("Tong tien nhap (T3-B4): %,.0f VND\n", tongTienNhap);
        System.out.println("=============================================");

        scanner.close();
    }
}
