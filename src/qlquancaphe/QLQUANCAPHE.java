/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlquancaphe;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BKV
 */
public class QLQUANCAPHE {

    /**
     * @param args the command line arguments
     */
    static int MenuHD() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t***Chương trình quản lý quán cà phê***");
        System.out.println("\t\t\tQuản lý hóa đơn");
        System.out.println("\t\t\t1.Quản lý hóa đơn nhập");
        System.out.println("\t\t\t2.Quản lý hóa đơn xuất");
        System.out.println("\t\t\t0.Thoát khỏi chương trình");
        System.out.print("\t\t\tMời nhập chức năng 0-2:");
        int chon;
        chon = sc.nextInt();
        return chon;
    }

    static int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t***Chương trình quản lý quán cà phê***");
        System.out.println("\t\t\tQuản lý khách hàng");
        System.out.println("\t\t\t1.Quản lý nhân viên");
        System.out.println("\t\t\t2.Quản lý khách hàng");
        System.out.println("\t\t\t3.Quản lý hàng hóa");
        System.out.println("\t\t\t4.Quản lý hóa đơn");
        System.out.println("\t\t\t0.Thoát khỏi chương trình");
        System.out.print("\t\t\tMời nhập chức năng 0-4:");
        int chon;
        chon = sc.nextInt();
        return chon;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (true){
//            System.out.println("\t\t\t\tĐăng nhập");
//            System.out.print("\t\t\tTài khoản:");
//            String tk=sc.nextLine();
//            System.out.print("\t\t\tMật khẩu:");
//            String mk=sc.nextLine();
//            if (tk.equals("quanlyquancaphe") && mk.equals("123456789")){
//                System.out.println("\t\t\tĐăng nhập thành công!");
//                break;
//            }
//            else{
//                System.out.println("\t\t\tBạn đã nhập sai tài khoản hoặc mật khẩu!");
//            }
//        }
        do {
            switch (Menu()) {
                case 1:
                    DSNHANVIEN dsnv = new DSNHANVIEN();
                    do {
                        switch (dsnv.Menu()) {
                            case 1:
                                dsnv.Nhap();
                                dsnv.Ghitep();
                                break;
                            case 2:
                                System.out.print("Nhập mã nhân viên cần thêm:");
                                String manv1 = sc.nextLine();
                                dsnv.Them(manv1);
                                dsnv.Hienthi();
                                dsnv.Ghitep();
                                break;
                            case 3:
                                System.out.print("Nhập mã nhân viên cần sửa:");
                                String manv2 = sc.nextLine();
                                dsnv.Sua(manv2);
                                dsnv.Hienthi();
                                dsnv.Ghitep();
                                break;
                            case 4:
                                System.out.print("Nhập mã nhân viên cần xóa:");
                                String manv3 = sc.nextLine();
                                dsnv.Xoa(manv3);
                                dsnv.Ghitep();
                                dsnv.Hienthi();
                                break;
                            case 5:
                                dsnv.Doctep();
                                dsnv.Hienthi();
                                break;
                            case 6:
                                System.out.print("Nhập mã nhân viên cần tìm:");
                                String manv4 = sc.nextLine();
                                dsnv.TimKiem1(manv4);
                                break;
                            case 0:
                                System.exit(0);
                        }
                    } while (true);
                case 2:
                    DSKHACHHANG dskh = new DSKHACHHANG();
                    do {
                        switch (dskh.Menu()) {
                            case 1:
                                dskh.Nhap();
                                dskh.Ghitep();
                                break;
                            case 2:
                                System.out.print("Nhập mã khách hàng cần thêm:");
                                String makh1 = sc.nextLine();
                                dskh.Them(makh1);
                                dskh.Hienthi();
                                dskh.Ghitep();
                                break;
                            case 3:
                                System.out.print("Nhập mã khách hàng cần sửa:");
                                String makh2 = sc.nextLine();
                                dskh.Sua(makh2);
                                dskh.Hienthi();
                                dskh.Ghitep();
                                break;
                            case 4:
                                System.out.print("Nhập mã khách hàng cần xóa:");
                                String makh3 = sc.nextLine();
                                dskh.Xoa(makh3);
                                dskh.Ghitep();
                                dskh.Hienthi();
                                break;

                            case 5:
                                dskh.Doctep();
                                dskh.Hienthi();
                                break;
                            case 6:
                                System.out.print("Nhập mã khách hàng cần tìm:");
                                String makh4 = sc.nextLine();
                                dskh.TimKiem1(makh4);
                                break;
                            case 0:
                                System.exit(0);
                        }
                    } while (true);

                case 3:
                    DSHANGHOA dshh = new DSHANGHOA();
                    do {
                        switch (dshh.Menu()) {
                            case 1:
                                dshh.Nhap();
                                dshh.Ghitep();
                                break;
                            case 2:
                                System.out.print("Nhập mã hàng hóa cần thêm:");
                                String mahh1 = sc.nextLine();
                                dshh.Them(mahh1);
                                dshh.Hienthi();
                                dshh.Ghitep();
                                break;
                            case 3:
                                System.out.print("Nhập mã hàng hóa cần sửa:");
                                String mahh2 = sc.nextLine();
                                dshh.Sua(mahh2);
                                dshh.Hienthi();
                                dshh.Ghitep();
                                break;
                            case 4:
                                System.out.print("Nhập mã hàng hóa cần xóa:");
                                String mahh3 = sc.nextLine();
                                dshh.Xoa(mahh3);
                                dshh.Ghitep();
                                dshh.Hienthi();
                                break;

                            case 5:
                                dshh.Doctep();
                                dshh.Hienthi();
                                break;
                            case 6:
                                System.out.print("Nhập mã hàng hóa cần tìm:");
                                String mahh4 = sc.nextLine();
                                dshh.TimKiem1(mahh4);
                                break;
                            case 0:
                                System.exit(0);
                        }
                    } while (true);

                case 4:
                    do {
                        switch (MenuHD()) {
                            case 1:
                                DSHDNHAP dshdn = new DSHDNHAP();
                                do {
                                    switch (dshdn.Menu()) {
                                        case 1:
                                            dshdn.Nhap();
                                            dshdn.Ghitep();
                                            break;
                                        case 2:
                                            System.out.print("Nhập mã hóa đơn cần thêm:");
                                            String mahdn1 = sc.nextLine();
                                            dshdn.Them(mahdn1);
                                            dshdn.Hienthi();
                                            dshdn.Ghitep();
                                            break;
                                        case 3:
                                            System.out.print("Nhập mã hóa đơn cần sửa:");
                                            String mahdn2 = sc.nextLine();
                                            dshdn.Sua(mahdn2);
                                            dshdn.Hienthi();
                                            dshdn.Ghitep();
                                            break;
                                        case 4:
                                            System.out.print("Nhập mã hóa đơn cần xóa:");
                                            String mahdn3 = sc.nextLine();
                                            dshdn.Xoa(mahdn3);
                                            dshdn.Ghitep();
                                            dshdn.Hienthi();
                                            break;

                                        case 5:
                                            dshdn.Doctep();
                                            dshdn.Hienthi();
                                            break;
                                        case 6:
                                            System.out.print("Nhập mã hóa đơn cần tìm:");
                                            String mahdn4 = sc.nextLine();
                                            dshdn.TimKiem1(mahdn4);
                                            break;
                                        case 7:
                                            dshdn.ThongKe();
                                            break;
                                        case 0:
                                            System.exit(0);
                                    }
                                } while (true);

                            case 2:
                                DSHDXUAT dshdx = new DSHDXUAT();
                                do {
                                    switch (dshdx.Menu()) {
                                        case 1:
                                            dshdx.Nhap();
                                            dshdx.Ghitep();
                                            break;
                                        case 2:
                                            System.out.print("Nhập mã hóa đơn cần thêm:");
                                            String mahdx1 = sc.nextLine();
                                            dshdx.Them(mahdx1);
                                            dshdx.Hienthi();
                                            dshdx.Ghitep();
                                            break;
                                        case 3:
                                            System.out.print("Nhập mã hóa đơn cần sửa:");
                                            String mahdx2 = sc.nextLine();
                                            dshdx.Sua(mahdx2);
                                            dshdx.Hienthi();
                                            dshdx.Ghitep();
                                            break;
                                        case 4:
                                            System.out.print("Nhập mã hóa đơn cần xóa:");
                                            String mahdx3 = sc.nextLine();
                                            dshdx.Xoa(mahdx3);
                                            dshdx.Hienthi();
                                            dshdx.Ghitep();
                                            break;

                                        case 5:
                                            dshdx.Doctep();
                                            dshdx.Hienthi();
                                            break;
                                        case 6:
                                            System.out.print("Nhập mã hóa đơn cần tìm:");
                                            String mahdx4 = sc.nextLine();
                                            dshdx.TimKiem1(mahdx4);
                                            break;
                                        case 7:
                                            dshdx.ThongKe();
                                            break;
                                        case 0:
                                            System.exit(0);
                                    }
                                } while (true);
                            case 0:
                                System.exit(0);
                        }
                    } while (true);
                case 0:
                    System.exit(0);
            }
        } while (true);
    }
}
