import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {

    // ---- Lop Sach: luu thong tin 1 cuon sach ----
    static class Sach {
        String maSach;
        String tenSach;
        String tacGia;
        int namXuatBan;
        double donGia;
        int soLuong;

        Sach(String maSach, String tenSach, String tacGia,
             int namXuatBan, double donGia, int soLuong) {
            this.maSach = maSach;
            this.tenSach = tenSach;
            this.tacGia = tacGia;
            this.namXuatBan = namXuatBan;
            this.donGia = donGia;
            this.soLuong = soLuong;
        }

        double thanhTien() {
            return donGia * soLuong;
        }

        double phiVanChuyen() {
            return thanhTien() * 0.05;
        }

        double tongTienNhap() {
            return thanhTien() + phiVanChuyen();
        }

        void hienThi() {
            System.out.println("Ma sach: " + maSach);
            System.out.println("Ten sach: " + tenSach);
            System.out.println("Tac gia: " + tacGia);
            System.out.println("Nam xuat ban: " + namXuatBan);
            System.out.printf("Don gia: %,.0f VND%n", donGia);
            System.out.println("So luong: " + soLuong);
            System.out.printf("Thanh tien: %,.0f VND%n", thanhTien());
            System.out.printf("Phi van chuyen (5%%): %,.0f VND%n", phiVanChuyen());
            System.out.printf("Tong tien nhap: %,.0f VND%n", tongTienNhap());
        }
    }

    static final Scanner scanner = new Scanner(System.in);
    static final ArrayList<Sach> danhSach = new ArrayList<>();

    // ---- Cac ham nhap an toan (nhap sai thi bat nhap lai) ----
    static int docSoNguyen(String thongBao, int min) {
        while (true) {
            System.out.print(thongBao);
            try {
                int giaTri = Integer.parseInt(scanner.nextLine().trim());
                if (giaTri >= min) {
                    return giaTri;
                }
                System.out.println("Gia tri phai >= " + min + ". Vui long nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen hop le!");
            }
        }
    }

    static double docSoThuc(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                double giaTri = Double.parseDouble(scanner.nextLine().trim());
                if (giaTri >= 0) {
                    return giaTri;
                }
                System.out.println("Gia tri khong duoc am. Vui long nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le!");
            }
        }
    }

    static String docChuoi(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Khong duoc de trong. Vui long nhap lai!");
        }
    }

    static Sach timTheoMa(String ma) {
        for (Sach s : danhSach) {
            if (s.maSach.equalsIgnoreCase(ma)) {
                return s;
            }
        }
        return null;
    }

    // ---- BAI 1: Nhap n sach bang vong lap ----
    static void nhapNSach() {
        int n = docSoNguyen("Nhap so luong sach can nhap (n): ", 1);

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Nhap sach thu " + i + "/" + n + " ---");

            String maSach;
            while (true) {
                maSach = docChuoi("Nhap ma sach: ");
                if (timTheoMa(maSach) == null) {
                    break;
                }
                System.out.println("Ma sach da ton tai. Vui long nhap ma khac!");
            }

            String tenSach = docChuoi("Nhap ten sach: ");
            String tacGia = docChuoi("Nhap tac gia: ");
            int namXuatBan = docSoNguyen("Nhap nam xuat ban: ", 1);
            double donGia = docSoThuc("Nhap don gia: ");
            int soLuong = docSoNguyen("Nhap so luong: ", 0);

            danhSach.add(new Sach(maSach, tenSach, tacGia, namXuatBan, donGia, soLuong));
        }
        System.out.println("\nDa nhap xong " + n + " sach.");
    }

    // ---- Hien thi toan bo danh sach ----
    static void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach dang trong. Hay chon 1 de nhap sach.");
            return;
        }
        System.out.println("\n=== DANH SACH SACH (" + danhSach.size() + " dau sach) ===");
        int stt = 1;
        for (Sach s : danhSach) {
            System.out.println("\n[" + stt++ + "]");
            s.hienThi();
        }
        System.out.println("===================================");
    }

    // ---- BAI 2: Tinh tong so luong va tong gia tri ----
    static void thongKe() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach dang trong. Hay chon 1 de nhap sach.");
            return;
        }
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        for (Sach s : danhSach) {
            tongSoLuong += s.soLuong;
            tongGiaTri += s.thanhTien();
        }
        System.out.println("\n=== THONG KE ===");
        System.out.println("So dau sach: " + danhSach.size());
        System.out.println("Tong so luong: " + tongSoLuong);
        System.out.printf("Tong gia tri: %,.0f VND%n", tongGiaTri);
        System.out.println("===================================");
    }

    // ---- BAI 4: Tim sach theo ma ----
    static void timSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach dang trong. Hay chon 1 de nhap sach.");
            return;
        }
        String ma = docChuoi("Nhap ma sach can tim: ");
        Sach s = timTheoMa(ma);
        if (s == null) {
            System.out.println("Khong tim thay sach co ma \"" + ma + "\".");
        } else {
            System.out.println("\n=== KET QUA TIM KIEM ===");
            s.hienThi();
            System.out.println("===================================");
        }
    }

    static void hienThiMenu() {
        System.out.println("\n========== QUAN LY SACH ==========");
        System.out.println("1. Nhap n sach");
        System.out.println("2. Hien thi danh sach sach");
        System.out.println("3. Tinh tong so luong va tong gia tri");
        System.out.println("4. Tim sach theo ma");
        System.out.println("0. Thoat");
        System.out.println("==================================");
    }

    // ---- BAI 3: Menu lap den khi chon Thoat ----
    public static void main(String[] args) {
        int luaChon;
        do {
            hienThiMenu();
            luaChon = docSoNguyen("Moi chon chuc nang: ", 0);

            switch (luaChon) {
                case 1:
                    nhapNSach();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    thongKe();
                    break;
                case 4:
                    timSach();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        } while (luaChon != 0);

        scanner.close();
    }
}