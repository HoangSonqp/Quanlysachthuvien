import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {

    static final Scanner scanner = new Scanner(System.in);

    // Bai 2: danh sach ma sach
    static final ArrayList<String> dsMaSach = new ArrayList<>();

    // Bai 3 + 4: moi phan tu = 1 cuon sach, dinh dang:
    // maSach|tenSach|tacGia|namXuatBan|donGia|soLuong
    static final ArrayList<String> danhSachSach = new ArrayList<>();

    // =====================================================================
    //                      HAM NHAP AN TOAN (DUNG CHUNG)
    // =====================================================================
    static String docChuoi(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String s = scanner.nextLine().trim().replace("|", " ");
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Khong duoc de trong. Vui long nhap lai!");
        }
    }

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

    // ---- Nhap dung cho chuc nang SUA: nhan Enter de giu gia tri cu ----
    static String docChuoiSua(String nhan, String cu) {
        System.out.print("Nhap " + nhan + " moi [" + cu + "]: ");
        String s = scanner.nextLine().trim().replace("|", " ");
        return s.isEmpty() ? cu : s;
    }

    static int docSoNguyenSua(String nhan, String cu, int min) {
        while (true) {
            System.out.print("Nhap " + nhan + " moi [" + cu + "]: ");
            String s = scanner.nextLine().trim();
            if (s.isEmpty()) {
                return Integer.parseInt(cu);
            }
            try {
                int giaTri = Integer.parseInt(s);
                if (giaTri >= min) {
                    return giaTri;
                }
                System.out.println("Gia tri phai >= " + min + ". Vui long nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen hop le!");
            }
        }
    }

    static double docSoThucSua(String nhan, String cu) {
        while (true) {
            System.out.printf("Nhap %s moi [%,.0f]: ", nhan, Double.parseDouble(cu));
            String s = scanner.nextLine().trim();
            if (s.isEmpty()) {
                return Double.parseDouble(cu);
            }
            try {
                double giaTri = Double.parseDouble(s);
                if (giaTri >= 0) {
                    return giaTri;
                }
                System.out.println("Gia tri khong duoc am. Vui long nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le!");
            }
        }
    }

    // =====================================================================
    //          BAI 1: MANG int[] soLuong CHO 5 CUON SACH
    // =====================================================================
    static void bai1() {
        int[] soLuong = new int[5];

        // Nhap so luong cua 5 cuon sach
        System.out.println("\n=== NHAP SO LUONG 5 CUON SACH ===");
        for (int i = 0; i < soLuong.length; i++) {
            soLuong[i] = docSoNguyen("So luong cuon sach thu " + (i + 1) + ": ", 0);
        }

        // Hien thi so luong
        System.out.println("\n=== SO LUONG CAC CUON SACH ===");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.println("Sach " + (i + 1) + ": " + soLuong[i]);
        }

        // Tinh tong
        int tong = 0;
        for (int sl : soLuong) {
            tong += sl;
        }
        System.out.println("\nTong so luong: " + tong);

        // Tim so luong lon nhat
        int max = soLuong[0];
        int viTriMax = 0;
        for (int i = 1; i < soLuong.length; i++) {
            if (soLuong[i] > max) {
                max = soLuong[i];
                viTriMax = i;
            }
        }
        System.out.println("So luong lon nhat: " + max + " (cuon sach thu " + (viTriMax + 1) + ")");
    }

    // =====================================================================
    //          BAI 2: ArrayList<String> LUU MA SACH
    // =====================================================================
    static int timViTriMa(String ma) {
        for (int i = 0; i < dsMaSach.size(); i++) {
            if (dsMaSach.get(i).equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    static void themMa() {
        String ma = docChuoi("Nhap ma sach can them: ");
        if (timViTriMa(ma) != -1) {
            System.out.println("Ma sach da ton tai!");
        } else {
            dsMaSach.add(ma);
            System.out.println("Da them ma sach \"" + ma + "\".");
        }
    }

    static void hienThiMa() {
        if (dsMaSach.isEmpty()) {
            System.out.println("Danh sach ma sach dang trong.");
            return;
        }
        System.out.println("\n=== DANH SACH MA SACH (" + dsMaSach.size() + ") ===");
        for (int i = 0; i < dsMaSach.size(); i++) {
            System.out.println((i + 1) + ". " + dsMaSach.get(i));
        }
    }

    static void timMa() {
        String ma = docChuoi("Nhap ma sach can tim: ");
        int viTri = timViTriMa(ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay ma sach \"" + ma + "\".");
        } else {
            System.out.println("Tim thay \"" + dsMaSach.get(viTri) + "\" o vi tri " + (viTri + 1) + ".");
        }
    }

    static void xoaMa() {
        String ma = docChuoi("Nhap ma sach can xoa: ");
        int viTri = timViTriMa(ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay ma sach \"" + ma + "\".");
        } else {
            dsMaSach.remove(viTri);
            System.out.println("Da xoa ma sach \"" + ma + "\".");
        }
    }

    static void bai2() {
        int luaChon;
        do {
            System.out.println("\n===== QUAN LY MA SACH =====");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("0. Quay lai");
            System.out.println("===========================");
            luaChon = docSoNguyen("Moi chon chuc nang: ", 0);

            switch (luaChon) {
                case 1:
                    themMa();
                    break;
                case 2:
                    hienThiMa();
                    break;
                case 3:
                    timMa();
                    break;
                case 4:
                    xoaMa();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        } while (luaChon != 0);
    }

    // =====================================================================
    //   BAI 3: ArrayList<String> danhSachSach (MOI PHAN TU = 1 CUON SACH)
    // =====================================================================
    static String taoChuoi(String ma, String ten, String tacGia,
                           int nam, double donGia, int soLuong) {
        return ma + "|" + ten + "|" + tacGia + "|" + nam + "|" + donGia + "|" + soLuong;
    }

    // Tra ve mang: [0]=ma, [1]=ten, [2]=tac gia, [3]=nam, [4]=don gia, [5]=so luong
    static String[] tach(String s) {
        return s.split("\\|");
    }

    static double thanhTien(String[] t) {
        return Double.parseDouble(t[4]) * Integer.parseInt(t[5]);
    }

    // Tra ve vi tri cua sach co ma can tim, khong thay thi tra ve -1
    static int timViTri(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (tach(danhSachSach.get(i))[0].equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    static boolean danhSachRong() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach dang trong. Hay chon 1 de them sach.");
            return true;
        }
        return false;
    }

    static void hienThiChiTiet(String[] t) {
        System.out.println("Ma sach: " + t[0]);
        System.out.println("Ten sach: " + t[1]);
        System.out.println("Tac gia: " + t[2]);
        System.out.println("Nam xuat ban: " + t[3]);
        System.out.printf("Don gia: %,.0f VND%n", Double.parseDouble(t[4]));
        System.out.println("So luong: " + t[5]);
        System.out.printf("Thanh tien: %,.0f VND%n", thanhTien(t));
    }

    // 1. Them sach
    static void themSach() {
        String ma;
        while (true) {
            ma = docChuoi("Nhap ma sach: ");
            if (timViTri(ma) == -1) {
                break;
            }
            System.out.println("Ma sach da ton tai. Vui long nhap ma khac!");
        }
        String ten = docChuoi("Nhap ten sach: ");
        String tacGia = docChuoi("Nhap tac gia: ");
        int nam = docSoNguyen("Nhap nam xuat ban: ", 1);
        double donGia = docSoThuc("Nhap don gia: ");
        int soLuong = docSoNguyen("Nhap so luong: ", 0);

        danhSachSach.add(taoChuoi(ma, ten, tacGia, nam, donGia, soLuong));
        System.out.println("Da them sach thanh cong!");
    }

    // 2. Hien thi sach
    static void hienThiSach() {
        if (danhSachRong()) {
            return;
        }
        System.out.println("\n=== DANH SACH SACH (" + danhSachSach.size() + " dau sach) ===");
        System.out.printf("%-4s %-10s %-25s %-20s %-6s %14s %6s %16s%n",
                "STT", "Ma", "Ten sach", "Tac gia", "Nam", "Don gia", "SL", "Thanh tien");
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] t = tach(danhSachSach.get(i));
            System.out.printf("%-4d %-10s %-25s %-20s %-6s %,14.0f %6s %,16.0f%n",
                    i + 1, t[0], t[1], t[2], t[3],
                    Double.parseDouble(t[4]), t[5], thanhTien(t));
        }
    }

    // 3. Tim sach theo ma
    static void timSach() {
        if (danhSachRong()) {
            return;
        }
        String ma = docChuoi("Nhap ma sach can tim: ");
        int viTri = timViTri(ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma \"" + ma + "\".");
        } else {
            System.out.println("\n=== KET QUA TIM KIEM (vi tri " + (viTri + 1) + ") ===");
            hienThiChiTiet(tach(danhSachSach.get(viTri)));
        }
    }

    // 4. Xoa sach theo ma
    static void xoaSach() {
        if (danhSachRong()) {
            return;
        }
        String ma = docChuoi("Nhap ma sach can xoa: ");
        int viTri = timViTri(ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma \"" + ma + "\".");
        } else {
            danhSachSach.remove(viTri);
            System.out.println("Da xoa sach co ma \"" + ma + "\".");
        }
    }

    // 5. Sua sach theo ma (khong cho sua ma; nhan Enter de giu nguyen)
    static void suaSach() {
        if (danhSachRong()) {
            return;
        }
        String ma = docChuoi("Nhap ma sach can sua: ");
        int viTri = timViTri(ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma \"" + ma + "\".");
            return;
        }

        String[] t = tach(danhSachSach.get(viTri));
        System.out.println("\nThong tin hien tai:");
        hienThiChiTiet(t);
        System.out.println("\n(Nhan Enter de giu nguyen gia tri cu)");

        String ten = docChuoiSua("ten sach", t[1]);
        String tacGia = docChuoiSua("tac gia", t[2]);
        int nam = docSoNguyenSua("nam xuat ban", t[3], 1);
        double donGia = docSoThucSua("don gia", t[4]);
        int soLuong = docSoNguyenSua("so luong", t[5], 0);

        danhSachSach.set(viTri, taoChuoi(t[0], ten, tacGia, nam, donGia, soLuong));
        System.out.println("Da cap nhat sach thanh cong!");
    }

    // 6. Tinh tong so luong
    static void tongSoLuong() {
        if (danhSachRong()) {
            return;
        }
        int tong = 0;
        for (String s : danhSachSach) {
            tong += Integer.parseInt(tach(s)[5]);
        }
        System.out.println("Tong so luong sach: " + tong);
    }

    // 7. Tinh tong gia tri (don gia * so luong cua moi cuon)
    static void tongGiaTri() {
        if (danhSachRong()) {
            return;
        }
        double tong = 0;
        for (String s : danhSachSach) {
            tong += thanhTien(tach(s));
        }
        System.out.printf("Tong gia tri sach: %,.0f VND%n", tong);
    }

    // =====================================================================
    //          BAI 4: MENU HOAN CHINH (LAP DEN KHI CHON THOAT)
    // =====================================================================
    static void hienThiMenuSach() {
        System.out.println("\n========== QUAN LY SACH ==========");
        System.out.println("1. Them sach");
        System.out.println("2. Hien thi sach");
        System.out.println("3. Tim sach");
        System.out.println("4. Xoa sach");
        System.out.println("5. Sua sach");
        System.out.println("6. Tinh tong so luong");
        System.out.println("7. Tinh tong gia tri");
        System.out.println("8. Thoat");
        System.out.println("==================================");
    }

    static void bai3va4() {
        int luaChon;
        do {
            hienThiMenuSach();
            luaChon = docSoNguyen("Moi chon chuc nang: ", 0);

            switch (luaChon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiSach();
                    break;
                case 3:
                    timSach();
                    break;
                case 4:
                    xoaSach();
                    break;
                case 5:
                    suaSach();
                    break;
                case 6:
                    tongSoLuong();
                    break;
                case 7:
                    tongGiaTri();
                    break;
                case 8:
                    System.out.println("Thoat menu quan ly sach.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        } while (luaChon != 8);
    }

    // =====================================================================
    //                    MAIN: CHON BAI DE CHAY
    // =====================================================================
    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n============ CHUONG TRINH ============");
            System.out.println("1. Bai 1: Mang so luong 5 cuon sach");
            System.out.println("2. Bai 2: Quan ly ma sach");
            System.out.println("3. Bai 3 + 4: Quan ly sach (menu hoan chinh)");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("======================================");
            luaChon = docSoNguyen("Moi chon: ", 0);

            switch (luaChon) {
                case 1:
                    bai1();
                    break;
                case 2:
                    bai2();
                    break;
                case 3:
                    bai3va4();
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