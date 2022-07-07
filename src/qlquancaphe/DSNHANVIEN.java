/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlquancaphe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BKV
 */
public class DSNHANVIEN {

    ArrayList<NHANVIEN> dsnv = new ArrayList<NHANVIEN>();
    private String kt;
    private int i = 0, chon;
    private String manv, hoten, gt, calv, cmnd, sdt;
    private Date namsinh;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            i++;
            System.out.println("Nhập thông tin cho nhân viên thứ " + i);
            do {
                System.out.print("Mã nhân viên:");
                manv = sc.nextLine();
                if (manv.equals("")) {
                    System.out.println("Mã nhân viên khác rỗng!");
                }
            } while (manv.equals(""));
            do {
                System.out.print("Họ tên:");
                hoten = sc.nextLine();
                if (hoten.equals("")) {
                    System.out.println("Họ tên khác rỗng!");
                }
            } while (hoten.equals(""));
            do {
                System.out.print("Giới tính:");
                gt = sc.nextLine();
                if (gt.equals("")) {
                    System.out.println("Giới tính khác rỗng!");
                }
            } while (gt.equals(""));
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                do {
                    System.out.print("Nhập năm sinh:");
                    namsinh = sdf.parse(sc.nextLine());
                    if (sdf.parse("30-12-1960").after(namsinh)) {
                        System.out.println("Năm sinh phải lớn hơn 1960!");
                    }
                } while (sdf.parse("30-12-1960").after(namsinh));
            } catch (ParseException ex) {
                Logger.getLogger(DSNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Ca làm việc:");
                calv = sc.nextLine();
                if (calv.equals("")) {
                    System.out.println("Ca làm việc khác rỗng!");
                }
            } while (calv.equals(""));
            do {
                System.out.print("Chứng minh nhân dân:");
                cmnd = sc.nextLine();
                if (cmnd.equals("")) {
                    System.out.println("Chứng minh nhân dân khác rỗng!");
                }
            } while (cmnd.equals(""));
            do {
                System.out.print("Số điện thoại:");
                sdt = sc.nextLine();
                if (sdt.equals("")) {
                    System.out.println("Số điện thoại khác rỗng!");
                }
            } while (sdt.equals(""));
            NHANVIEN nv = new NHANVIEN(manv, hoten, gt, namsinh, calv, cmnd, sdt);
            dsnv.add(nv);
            System.out.print("Bạn có muốn nhập thêm nhân viên không?Nhập bất kì để tiếp tục!Nếu không nhập 'k' để dừng lại:");
            kt = sc.nextLine();
            kt = kt.toLowerCase();
            if (kt.equals("k")) {
                break;
            }

        }
    }

    public void Hienthi() {
        System.out.println("Mã nhân viên\tHọ tên\tGiới tính\tNăm sinh\tCa làm việc\tChứng minh nhân dân\tSố điện thoại");
        for (NHANVIEN nv : dsnv) {
            System.out.println(nv.toString());
        }
    }

    public void Sua(String manv1) {
        int i = TimKiem(manv1);
        if (i == -1) {
            System.out.println("Không có nhân viên mã " + manv1);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Cập nhật thông tin nhân viên mã" + manv1);
            do {
                System.out.print("Nhập mã nhân viên cần sửa:");
                manv = sc.nextLine();
                if (manv.equals("")) {
                    System.out.println("Mã nhân viên khác rỗng!");
                }
            } while (manv.equals(""));
            do {
                System.out.print("Nhập tên nhân viên cần sửa:");
                hoten = sc.nextLine();
                if (hoten.equals("")) {
                    System.out.println("Họ tên nhân viên khác rỗng!");
                }
            } while (hoten.equals(""));

            do {
                System.out.print("Giới tính:");
                gt = sc.nextLine();
                if (gt.equals("")) {
                    System.out.println("Giới tính khác rỗng!");
                }
            } while (gt.equals(""));
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                do {
                    System.out.print("Nhập năm sinh:");
                    namsinh = sdf.parse(sc.nextLine());
                    if (sdf.parse("30-12-1960").after(namsinh)) {
                        System.out.println("Năm sinh phải lớn hơn 1960!");
                    }
                } while (sdf.parse("30-12-1960").after(namsinh));
            } catch (ParseException ex) {
                Logger.getLogger(DSNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Ca làm việc:");
                calv = sc.nextLine();
                if (calv.equals("")) {
                    System.out.println("Ca làm việc khác rỗng!");
                }
            } while (calv.equals(""));
            do {
                System.out.print("Chứng minh nhân dân:");
                cmnd = sc.nextLine();
                if (cmnd.equals("")) {
                    System.out.println("Chứng minh nhân dân khác rỗng!");
                }
            } while (cmnd.equals(""));
            do {
                System.out.print("Số điện thoại:");
                sdt = sc.nextLine();
                if (sdt.equals("")) {
                    System.out.println("Số điện thoại khác rỗng!");
                }
            } while (sdt.equals(""));
            dsnv.get(i).setManv(manv);
            dsnv.get(i).setHoten(hoten);
            dsnv.get(i).setGt(gt);
            dsnv.get(i).setNamsinh(namsinh);
            dsnv.get(i).setCalv(calv);
            dsnv.get(i).setCmnd(cmnd);
            dsnv.get(i).setSdt(sdt);
        }
    }

    public void Them(String manv1) {
        int k2 = TimKiem(manv1);
        if (k2 == -1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Thêm thông tin nhân viên mã " + manv1);
            do {
                System.out.print("Nhập mã nhân viên cần thêm:");
                manv = sc.nextLine();
                if (manv.equals("")) {
                    System.out.println("Mã nhân viên khác rỗng!");
                }
            } while (manv.equals(""));
            do {
                System.out.print("Nhập tên nhân viên cần thêm:");
                hoten = sc.nextLine();
                if (hoten.equals("")) {
                    System.out.println("Họ tên nhân viên khác rỗng!");
                }
            } while (hoten.equals(""));

            do {
                System.out.print("Giới tính:");
                gt = sc.nextLine();
                if (gt.equals("")) {
                    System.out.println("Giới tính khác rỗng!");
                }
            } while (gt.equals(""));
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                do {
                    System.out.print("Nhập năm sinh:");
                    namsinh = sdf.parse(sc.nextLine());
                    if (sdf.parse("30-12-1960").after(namsinh)) {
                        System.out.println("Năm sinh phải lớn hơn 1960!");
                    }
                } while (sdf.parse("30-12-1960").after(namsinh));
            } catch (ParseException ex) {
                Logger.getLogger(DSNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Ca làm việc:");
                calv = sc.nextLine();
                if (calv.equals("")) {
                    System.out.println("Ca làm việc khác rỗng!");
                }
            } while (calv.equals(""));
            do {
                System.out.print("Chứng minh nhân dân:");
                cmnd = sc.nextLine();
                if (cmnd.equals("")) {
                    System.out.println("Chứng minh nhân dân khác rỗng!");
                }
            } while (cmnd.equals(""));
            do {
                System.out.print("Số điện thoại:");
                sdt = sc.nextLine();
                if (sdt.equals("")) {
                    System.out.println("Số điện thoại khác rỗng!");
                }
            } while (sdt.equals(""));
            NHANVIEN nv = new NHANVIEN(manv, hoten, gt, namsinh, calv, cmnd, sdt);
            dsnv.add(nv);
            System.out.println("Đã thêm hóa đơn " + manv1);
        } else {
            System.out.println("Đã có hóa đơn " + manv1);
        }
    }

    public void Xoa(String manv1) {
        int k2 = TimKiem(manv1);
        if (k2 == -1) {
            System.out.println("Không có nhân viên nào có mã" + manv1);
        } else {
            dsnv.remove(k2);
            System.out.println("Đã xóa nhân viên " + manv1);
        }
    }

    public void TimKiem1(String manv1) {
        System.out.println("Mã nhân viên\tHọ tên\tGiới tính\tNăm sinh\tCa làm việc\tChứng minh nhân dân\tSố điện thoại");
        int d = 0;
        for (int i = 0; i < dsnv.size(); i++) {
            if (dsnv.get(i).getManv().equals(manv1)) {
                System.out.println(dsnv.get(i));
                d++;
            }
        }
        if (d == 0) {
            System.out.println("Không có nhân viên nào có mã " + manv1);
        }

    }

    public int TimKiem(String manv1) {
        int index = -1;
        for (int i = 0; i < dsnv.size(); i++) {
            if (dsnv.get(i).getManv().equals(manv1)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void Ghitep() {
        try {
            PrintWriter pw = new PrintWriter("D:\\Java\\QLQUANCAPHE\\nhanvien.txt", "UTF-8");
            for (NHANVIEN nv : dsnv) {
                pw.println(nv.toStringfile());
            }
            pw.flush();
            pw.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DSNHANVIEN.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DSNHANVIEN.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Doctep() {
        File f = new File("D:\\Java\\QLQUANCAPHE\\nhanvien.txt");
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line;
            while ((line = br.readLine()) != null) {
                NHANVIEN nv = new NHANVIEN(line);
                dsnv.add(nv);
            }
            br.close();

        } catch (IOException ex) {
            Logger.getLogger(DSNHANVIEN.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t***Chương trình quản lý quán cà phê***");
        System.out.println("\t\t\tQuản lý nhân viên");
        System.out.println("\t\t\t1.Nhập thông tin nhân viên");
        System.out.println("\t\t\t2.Thêm thông tin nhân viên");
        System.out.println("\t\t\t3.Sửa thông tin nhân viên");
        System.out.println("\t\t\t4.Xóa thông tin nhân viên");
        System.out.println("\t\t\t5.Hiển thị thông tin nhân viên");
        System.out.println("\t\t\t6.Tìm kiếm");
        System.out.println("\t\t\t0.Thoát khỏi chương trình");
        System.out.print("\t\t\tMời nhập chức năng 0-6:");
        chon = sc.nextInt();
        return chon;
    }

}
