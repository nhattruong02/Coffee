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
public class DSKHACHHANG {

    ArrayList<KHACHHANG> dskh = new ArrayList<KHACHHANG>();
    private String kt, makh, hoten, gt, sdt, loaikh;
    private Date namsinh;
    private int i = 0, chon;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            i++;
            System.out.println("Nhập thông tin cho khách hàng thứ " + i);
            do {
                System.out.print("Mã khách hàng:");
                makh = sc.nextLine();
                if (makh.equals("")) {
                    System.out.println("Mã khách hàng khác rỗng!");
                }
            } while (makh.equals(""));
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
                Logger.getLogger(DSKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Số điện thoại:");
                sdt = sc.nextLine();
                if (sdt.equals("")) {
                    System.out.println("Số điện thoại khác rỗng!");
                }
            } while (sdt.equals(""));
            do {
                System.out.print("Loại khách hàng:");
                loaikh = sc.nextLine();
                if (loaikh.equals("")) {
                    System.out.println("Loại khách hàng khác rỗng!");
                }
            } while (loaikh.equals(""));
            KHACHHANG kh = new KHACHHANG(makh, hoten, gt, namsinh, sdt, loaikh);
            dskh.add(kh);
            System.out.print("Bạn có muốn nhập thêm khách hàng không?Nhập bất kì để tiếp tục!Nếu không nhập 'k' để dừng lại:");
            kt = sc.nextLine();
            kt = kt.toLowerCase();
            if (kt.equals("k")) {
                break;
            }
        }
    }

    public void Hienthi() {
        System.out.println("Mã khách hàng\tHọ tên\tGiới tính\tNăm sinh\tSố điện thoại\tLoại khách hàng");
        for (KHACHHANG kh : dskh) {
            System.out.println(kh.toString());
        }
    }

    public void Sua(String makh1) {
        int i = TimKiem(makh1);
        if (i == -1) {
            System.out.println("Không có khách hàng mã " + makh1);
        } else {
            Scanner sc = new Scanner(System.in);
            do {
                System.out.print("Mã khách hàng:");
                makh = sc.nextLine();
                if (makh.equals("")) {
                    System.out.println("Mã khách hàng khác rỗng!");
                }
            } while (makh.equals(""));
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
                Logger.getLogger(DSKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Số điện thoại:");
                sdt = sc.nextLine();
                if (sdt.equals("")) {
                    System.out.println("Số điện thoại khác rỗng!");
                }
            } while (sdt.equals(""));
            do {
                System.out.print("Loại khách hàng:");
                loaikh = sc.nextLine();
                if (loaikh.equals("")) {
                    System.out.println("Loại khách hàng khác rỗng!");
                }
            } while (loaikh.equals(""));
            dskh.get(i).setMakh(makh);
            dskh.get(i).setHoten(hoten);
            dskh.get(i).setGt(gt);
            dskh.get(i).setNamsinh(namsinh);
            dskh.get(i).setSdt(sdt);
            dskh.get(i).setLoaikh(loaikh);
        }
    }

    public void Them(String makh1) {
        int k2 = TimKiem(makh1);
        if (k2 == -1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Thêm thông tin nhân viên mã " + makh1);
            do {
                System.out.print("Mã khách hàng:");
                makh = sc.nextLine();
                if (makh.equals("")) {
                    System.out.println("Mã khách hàng khác rỗng!");
                }
            } while (makh.equals(""));
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
                Logger.getLogger(DSKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Số điện thoại:");
                sdt = sc.nextLine();
                if (sdt.equals("")) {
                    System.out.println("Số điện thoại khác rỗng!");
                }
            } while (sdt.equals(""));
            do {
                System.out.print("Loại khách hàng:");
                loaikh = sc.nextLine();
                if (loaikh.equals("")) {
                    System.out.println("Loại khách hàng khác rỗng!");
                }
            } while (loaikh.equals(""));
            KHACHHANG kh = new KHACHHANG(makh, hoten, gt, namsinh, sdt, loaikh);
            dskh.add(kh);
            System.out.println("Đã thêm hóa đơn " + makh1);
        } else {
            System.out.println("Đã có hóa đơn " + makh1);
        }
    }

    public void Xoa(String makh1) {
        int k2 = TimKiem(makh1);
        if (k2 == -1) {
            System.out.println("Không có khách hàng nào có mã" + makh1);
        } else {
            dskh.remove(k2);
            System.out.println("Đã xóa khách hàng" + makh1);
        }

    }

    public void TimKiem1(String makh1) {
        System.out.println("Mã khách hàng\tHọ tên\tGiới tính\tNăm sinh\tSố điện thoại\tLoại khách hàng");
        int d = 0;
        for (int i = 0; i < dskh.size(); i++) {
            if (dskh.get(i).getMakh().equals(makh1)) {
                System.out.println(dskh.get(i));
            }
        }
        if (d == 0) {
            System.out.println("Không có khách hàng nào có mã " + makh1);
        }
    }

    public int TimKiem(String makh1) {
        int index = -1;
        for (int i = 0; i < dskh.size(); i++) {
            if (dskh.get(i).getMakh().equals(makh1)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void ThongKe(String loaikh1) {
        System.out.println("Mã khách hàng\tHọ tên\tGiới tính\tNăm sinh\tSố điện thoại\tLoại khách hàng");
        for (int i = 0; i < dskh.size(); i++) {
            if (dskh.get(i).getLoaikh().equals(loaikh1)) {
                System.out.println(dskh.get(i));
            }
        }
    }

    public void Ghitep() {
        try {
            PrintWriter pw = new PrintWriter("D:\\Java\\QLQUANCAPHE\\khachhang.txt", "UTF-8");
            for (KHACHHANG kh : dskh) {
                pw.println(kh.toStringfile());
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DSKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DSKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Doctep() {
        File f = new File("D:\\Java\\QLQUANCAPHE\\khachhang.txt");
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line;
            while ((line = br.readLine()) != null) {
                KHACHHANG kh = new KHACHHANG(line);
                dskh.add(kh);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DSKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t***Chương trình quản lý quán cà phê***");
        System.out.println("\t\t\tQuản lý khách hàng");
        System.out.println("\t\t\t1.Nhập thông tin khách hàng");
        System.out.println("\t\t\t2.Thêm thông tin khách hàng");
        System.out.println("\t\t\t3.Sửa thông tin khách hàng");
        System.out.println("\t\t\t4.Xóa thông tin khách hàng");
        System.out.println("\t\t\t5.Hiển thị thông tin khách hàng");
        System.out.println("\t\t\t6.Tìm kiếm");
        System.out.println("\t\t\t0.Thoát khỏi chương trình");
        System.out.print("\t\t\tMời nhập chức năng 0-6:");
        chon = sc.nextInt();
        return chon;
    }

}
