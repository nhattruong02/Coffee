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
public class DSHDNHAP extends HDNHAP {

    ArrayList<HDNHAP> dshdn = new ArrayList<HDNHAP>();
    private int i = 0;
    private String mahdn, ncc, tennl, kt;
    private int soluong;
    private double gia;
    private Date ngaynhap;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            i++;
            System.out.println("Nhập thông tin cho hóa đơn nhập thứ " + i);
            do {
                System.out.print("Mã hóa đơn nhập:");
                mahdn = sc.nextLine();
                if (mahdn.equals("")) {
                    System.out.println("Mã hóa đơn khác rỗng!");
                }
            } while (mahdn.equals(""));
            do {
                System.out.print("Nhà cung cấp:");
                ncc = sc.nextLine();
                if (ncc.equals("")) {
                    System.out.println("Nhà cung cấp khác rỗng!");
                }
            } while (ncc.equals(""));
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                do {
                    System.out.println("Nhập ngày nhập:");
                    ngaynhap = sdf.parse(sc.nextLine());
                    if (sdf.parse("30-12-1960").after(ngaynhap)) {
                        System.out.println("Năm sinh phải lớn hơn 1960!");
                    }
                } while (sdf.parse("30-12-1960").after(ngaynhap));
            } catch (ParseException ex) {
                Logger.getLogger(DSHDNHAP.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Tên nguyên liệu:");
                tennl = sc.nextLine();
                if (tennl.equals("")) {
                    System.out.println("Tên nguyên liệu khác rỗng!");
                }
            } while (tennl.equals(""));
            while (true) {
                try {
                    System.out.print("Số lượng:");
                    soluong = Integer.parseInt(sc.nextLine());
                    if (soluong > 0) {
                        break;
                    } else {
                        System.out.println("Số lượng > 0!");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            while (true) {
                try {
                    System.out.print("Giá :");
                    gia = Integer.parseInt(sc.nextLine());
                    if (gia > 0) {
                        break;
                    } else {
                        System.out.println("Giá > 0!");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            HDNHAP hdn = new HDNHAP(mahdn, ncc, ngaynhap, tennl, soluong, gia, Tong());
            dshdn.add(hdn);
            System.out.print("Bạn có muốn nhập thêm nhân viên không?Nhập bất kì để tiếp tục!Nếu không nhập 'k' để dừng lại:");
            kt = sc.nextLine();
            kt = kt.toLowerCase();
            if (kt.equals("k")) {
                break;
            }
        }
    }

    public void Hienthi() {
        System.out.println("Mã hóa đơn nhập\tNhà cung cấp\tNgày nhập\tTên nguyên liệu\tSố lượng\tGiá\tTổng");
        for (HDNHAP hdn : dshdn) {
            System.out.println(hdn.toString());
        }
    }

    public void Sua(String mahdn1) {
        int i = TimKiem(mahdn1);
        if (i == -1) {
            System.out.println("Không có hóa đơn mã " + mahdn1);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Sửa thông tin hóa đơn mã" + mahdn1);
            do {
                System.out.print("Mã hóa đơn nhập:");
                mahdn = sc.nextLine();
                if (mahdn.equals("")) {
                    System.out.println("Mã hóa đơn khác rỗng!");
                }
            } while (mahdn.equals(""));
            do {
                System.out.print("Nhà cung cấp:");
                ncc = sc.nextLine();
                if (ncc.equals("")) {
                    System.out.println("Nhà cung cấp khác rỗng!");
                }
            } while (ncc.equals(""));
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                do {
                    System.out.println("Nhập ngày nhập:");
                    ngaynhap = sdf.parse(sc.nextLine());
                    if (sdf.parse("30-12-1960").after(ngaynhap)) {
                        System.out.println("Năm sinh phải lớn hơn 1960!");
                    }
                } while (sdf.parse("30-12-1960").after(ngaynhap));
            } catch (ParseException ex) {
                Logger.getLogger(DSHDNHAP.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Tên nguyên liệu:");
                tennl = sc.nextLine();
                if (tennl.equals("")) {
                    System.out.println("Tên nguyên liệu khác rỗng!");
                }
            } while (tennl.equals(""));
            while (true) {
                try {
                    System.out.print("Số lượng:");
                    soluong = Integer.parseInt(sc.nextLine());
                    if (soluong > 0) {
                        break;
                    } else {
                        System.out.println("Số lượng > 0!");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            while (true) {
                try {
                    System.out.print("Giá :");
                    gia = Integer.parseInt(sc.nextLine());
                    if (gia > 0) {
                        break;
                    } else {
                        System.out.println("Giá > 0!");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            dshdn.get(i).setMahdn(mahdn);
            dshdn.get(i).setNcc(ncc);
            dshdn.get(i).setNgaynhap(ngaynhap);
            dshdn.get(i).setTennl(tennl);
            dshdn.get(i).setSoluong(soluong);
            dshdn.get(i).setGia(gia);
            dshdn.get(i).Tong();
        }
    }

    public void Them(String mahdn1) {
        int k2 = TimKiem(mahdn1);
        if (k2 == -1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Thêm thông tin hóa đơn mã" + mahdn1);
            do {
                System.out.print("Mã hóa đơn nhập:");
                mahdn = sc.nextLine();
                if (mahdn.equals("")) {
                    System.out.println("Mã hóa đơn khác rỗng!");
                }
            } while (mahdn.equals(""));
            do {
                System.out.print("Nhà cung cấp:");
                ncc = sc.nextLine();
                if (ncc.equals("")) {
                    System.out.println("Nhà cung cấp khác rỗng!");
                }
            } while (ncc.equals(""));
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                do {
                    System.out.println("Nhập ngày nhập:");
                    ngaynhap = sdf.parse(sc.nextLine());
                    if (sdf.parse("30-12-1960").after(ngaynhap)) {
                        System.out.println("Năm sinh phải lớn hơn 1960!");
                    }
                } while (sdf.parse("30-12-1960").after(ngaynhap));
            } catch (ParseException ex) {
                Logger.getLogger(DSHDNHAP.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Tên nguyên liệu:");
                tennl = sc.nextLine();
                if (tennl.equals("")) {
                    System.out.println("Tên nguyên liệu khác rỗng!");
                }
            } while (tennl.equals(""));
            while (true) {
                try {
                    System.out.print("Số lượng:");
                    soluong = Integer.parseInt(sc.nextLine());
                    if (soluong > 0) {
                        break;
                    } else {
                        System.out.println("Số lượng > 0!");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            while (true) {
                try {
                    System.out.print("Giá :");
                    gia = Integer.parseInt(sc.nextLine());
                    if (gia > 0) {
                        break;
                    } else {
                        System.out.println("Giá > 0!");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            HDNHAP hdn = new HDNHAP(mahdn, ncc, ngaynhap, tennl, soluong, gia, Tong());
            dshdn.add(hdn);
            System.out.println("Đã thêm hóa đơn " + mahdn1);
        } else {
            System.out.println("Đã có hóa đơn " + mahdn1);
        }
    }

    public void Xoa(String mahdn1) {
        int k2 = TimKiem(mahdn1);
        if (k2 == -1) {
            System.out.println("Không có hóa đơn nào có mã" + mahdn1);
        } else {
            dshdn.remove(k2);
            System.out.println("Đã xóa hóa đơn" + mahdn1);
        }

    }

    public void TimKiem1(String mahdn1) {
        System.out.println("Mã hóa đơn nhập\tNhà cung cấp\tNgày nhập\tTên nguyên liệu\tSố lượng\tGiá\tTổng");
        int d=0;
        for (int i = 0; i < dshdn.size(); i++) {
            if (dshdn.get(i).getMahdn().equals(mahdn1)) {
                System.out.println(dshdn.get(i));
            }
        }
        if (d==0){
            System.out.println("Không có hóa đơn nào có mã " + mahdn1);
        }
    }

    public int TimKiem(String mahdn1) {
        int index = -1;
        for (int i = 0; i < dshdn.size(); i++) {
            if (dshdn.get(i).getMahdn().equals(mahdn1)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void ThongKe() {
        System.out.println("Mã hóa đơn nhập\tNhà cung cấp\tNgày nhập\tTên nguyên liệu\tSố lượng\tGiá\tTổng");
        for (int i = 0; i < dshdn.size(); i++) {
            if (dshdn.get(i).Tong() > 500000) {
                System.out.println(dshdn.get(i));
            }
        }
    }

    public void Ghitep() {
        try {
            PrintWriter pw = new PrintWriter("D:\\Java\\QLQUANCAPHE\\hoadonnhap.txt", "UTF-8");
            for (HDNHAP hdn : dshdn) {
                pw.println(hdn.toStringfile());
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DSHDNHAP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DSHDNHAP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Doctep() {
        File f = new File("D:\\Java\\QLQUANCAPHE\\hoadonnhap.txt");
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line;
            while ((line = br.readLine()) != null) {
                HDNHAP hdn = new HDNHAP(line);
                dshdn.add(hdn);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DSHDNHAP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t***Chương trình quản lý quán cà phê***");
        System.out.println("\t\t\tQuản lý hóa đơn nhập");
        System.out.println("\t\t\t1.Nhập thông tin hóa đơn");
        System.out.println("\t\t\t2.Thêm thông tin hóa đơn");
        System.out.println("\t\t\t3.Sửa thông tin hóa đơn");
        System.out.println("\t\t\t4.Xóa thông tin hóa đơn");
        System.out.println("\t\t\t5.Hiển thị thông tin hóa đơn");
        System.out.println("\t\t\t6.Tìm kiếm");
        System.out.println("\t\t\t7.Thống kê hóa > 500000");
        System.out.println("\t\t\t0.Thoát khỏi chương trình");
        System.out.print("\t\t\tMời nhập chức năng 0-7:");
        int chon = sc.nextInt();
        return chon;
    }

}
