/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlquancaphe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BKV
 */
public class DSHANGHOA {

    ArrayList<HANGHOA> dshh = new ArrayList<HANGHOA>();
    private int i, soluong, chon;
    private double gia;
    private String mahh, tenhh, loaihh;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            i++;
            System.out.println("Nhập thông tin cho hàng hóa thứ " + i);
            do {
                System.out.print("Mã hàng hóa:");
                mahh = sc.nextLine();
                if (mahh.equals("")) {
                    System.out.println("Mã hàng hóa khác rỗng!");
                }
            } while (mahh.equals(""));
            do {
                System.out.print("Tên hàng hóa:");
                tenhh = sc.nextLine();
                if (tenhh.equals("")) {
                    System.out.println("Tên hàng hóa khác rỗng!");
                }
            } while (tenhh.equals(""));
            do {
                System.out.print("Loại hàng hóa:");
                loaihh = sc.nextLine();
                if (loaihh.equals("")) {
                    System.out.println("Loại hàng hóa khác rỗng!");
                }
            } while (loaihh.equals(""));
            while (true) {
                try {
                    System.out.print("Số lượng hàng hóa:");
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
                    System.out.print("Giá hàng hóa:");
                    soluong = Integer.parseInt(sc.nextLine());
                    if (soluong > 0) {
                        break;
                    } else {
                        System.out.println("Giá > 0!");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            HANGHOA hh = new HANGHOA(mahh, tenhh, loaihh, soluong, gia);
            dshh.add(hh);
            System.out.print("Bạn có muốn nhập thêm hàng hóa không?Nhập bất kì để tiếp tục!Nếu không nhập 'k' để dừng lại:");
            String kt = sc.nextLine();
            kt = kt.toLowerCase();
            if (kt.equals("k")) {
                break;
            }
        }
    }

    public void Hienthi() {
        System.out.println("Mã hàng hóa\tTên hàng hóa\tLoại hàng hóa\tSố lượng\tGiá");
        for (HANGHOA hh : dshh) {
            System.out.println(hh.toStringfile());
        }
    }

    public void Sua(String mahh1) {
        int i = TimKiem(mahh1);
        if (i == -1) {
            System.out.println("Không có hàng hóa mã " + mahh1);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Cập nhật thông tin hàng hóa mã" + mahh1);
            do {
                System.out.print("Mã hàng hóa:");
                mahh = sc.nextLine();
                if (mahh.equals("")) {
                    System.out.println("Mã hóa đơn khác rỗng!");
                }
            } while (mahh.equals(""));
            do {
                System.out.print("Tên hàng hóa:");
                tenhh = sc.nextLine();
                if (tenhh.equals("")) {
                    System.out.println("Tên hàng hóa khác rỗng!");
                }
            } while (tenhh.equals(""));
            do {
                System.out.print("Loại hàng hóa:");
                loaihh = sc.nextLine();
                if (loaihh.equals("")) {
                    System.out.println("Loại hàng hóa khác rỗng!");
                }
            } while (loaihh.equals(""));
            while (true) {
                try {
                    System.out.print("Số lượng hàng hóa:");
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
                    System.out.print("Giá hàng hóa:");
                    soluong = Integer.parseInt(sc.nextLine());
                    if (soluong > 0) {
                        break;
                    } else {
                        System.out.println("Giá > 0!");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            dshh.get(i).setMahh(mahh);
            dshh.get(i).setTenhh(tenhh);
            dshh.get(i).setLoaihh(loaihh);
            dshh.get(i).setSoluong(soluong);
            dshh.get(i).setGia(gia);
        }
    }

    public void Them(String mahh1) {
        int k2 = TimKiem(mahh1);
        if (k2 == -1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Thêm thông tin nhân viên mã " + mahh1);
            do {
                System.out.print("Mã hàng hóa:");
                mahh = sc.nextLine();
                if (mahh.equals("")) {
                    System.out.println("Mã hóa đơn khác rỗng!");
                }
            } while (mahh.equals(""));
            do {
                System.out.print("Tên hàng hóa:");
                tenhh = sc.nextLine();
                if (tenhh.equals("")) {
                    System.out.println("Tên hàng hóa khác rỗng!");
                }
            } while (tenhh.equals(""));
            do {
                System.out.print("Loại hàng hóa:");
                loaihh = sc.nextLine();
                if (loaihh.equals("")) {
                    System.out.println("Loại hàng hóa khác rỗng!");
                }
            } while (loaihh.equals(""));
            while (true) {
                try {
                    System.out.print("Số lượng hàng hóa:");
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
                    System.out.print("Giá hàng hóa:");
                    soluong = Integer.parseInt(sc.nextLine());
                    if (soluong > 0) {
                        break;
                    } else {
                        System.out.println("Giá > 0!");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            HANGHOA hh = new HANGHOA(mahh, tenhh, loaihh, soluong, gia);
            dshh.add(hh);
            System.out.println("Đã thêm hàng hóa " + mahh1);
        } else {
            System.out.println("Đã có hàng hóa " + mahh1);
        }
    }

    public void Xoa(String mahh1) {
        int k2 = TimKiem(mahh1);
        if (k2 == -1) {
            System.out.println("Không có hàng hóa nào có mã" + mahh1);
        } else {
            dshh.remove(k2);
            System.out.println("Đã xóa hàng hóa mã" + mahh1);
        }

    }

    public void TimKiem1(String mahh1) {
        System.out.println("Mã hàng hóa\tTên hàng hóa\tLoại hàng hóa\tSố lượng\tGiá");
        int d=0;
        for (int i = 0; i < dshh.size(); i++) {
            if (dshh.get(i).getMahh().equals(mahh1)) {
                System.out.println(dshh.get(i));
            }
        }
        if (d == 0) {
            System.out.println("Không có hàng hóa nào có mã " + mahh1);
        }
    }

    public int TimKiem(String mahh1) {
        int index = -1;
        for (int i = 0; i < dshh.size(); i++) {
            if (dshh.get(i).getMahh().equals(mahh1)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void Ghitep() {
        try {
            PrintWriter pw = new PrintWriter("D:\\Java\\QLQUANCAPHE\\hanghoa.txt", "UTF-8");
            for (HANGHOA hh : dshh) {
                pw.println(hh.toStringfile());
                pw.append(hh.toStringfile());
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DSHANGHOA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DSHANGHOA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Doctep() {
        File f = new File("D:\\Java\\QLQUANCAPHE\\hanghoa.txt");
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line;
            while ((line = br.readLine()) != null) {
                HANGHOA hh = new HANGHOA(line);
                dshh.add(hh);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DSHANGHOA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t***Chương trình quản lý quán cà phê***");
        System.out.println("\t\t\tQuản lý hàng hóa");
        System.out.println("\t\t\t1.Nhập thông tin hàng hóa");
        System.out.println("\t\t\t2.Thêm thông tin hàng hóa");
        System.out.println("\t\t\t3.Sửa thông tin hàng hóa");
        System.out.println("\t\t\t4.Xóa thông tin hàng hóa");
        System.out.println("\t\t\t5.Hiển thị thông tin hàng hóa");
        System.out.println("\t\t\t6.Tìm kiếm");
        System.out.println("\t\t\t0.Thoát khỏi chương trình");
        System.out.print("\t\t\tMời nhập chức năng 0-6:");
        chon = sc.nextInt();
        return chon;
    }
}
