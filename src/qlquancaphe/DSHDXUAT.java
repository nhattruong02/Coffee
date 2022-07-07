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
public class DSHDXUAT extends HDXUAT{

    ArrayList<HDXUAT> dshdx = new ArrayList<HDXUAT>();
    private int soluong, i = 0;
    private double gia, tong;
    private String mahdx, makh, mahh, tenhh, kt;
    private Date ngayxuat;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            i++;
            System.out.println("Nhập thông tin cho hóa đơn nhập thứ " + i);
            do {
                System.out.print("Mã hóa đơn xuất:");
                mahdx = sc.nextLine();
                if (mahdx.equals("")) {
                    System.out.println("Mã hóa đơn khác rỗng!");
                }
            } while (mahdx.equals(""));
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                do {
                    System.out.print("Nhập ngày xuất:");
                    ngayxuat = sdf.parse(sc.nextLine());
                    if (sdf.parse("30-12-1960").after(ngayxuat)) {
                        System.out.println("Năm sinh phải lớn hơn 1960!");
                    }
                } while (sdf.parse("30-12-1960").after(ngayxuat));
            } catch (ParseException ex) {
                Logger.getLogger(DSHDXUAT.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Mã khách hàng:");
                makh = sc.nextLine();
                if (makh.equals("")) {
                    System.out.println("Mã khách hàng khác rỗng!");
                }
            } while (makh.equals(""));
            do {
                System.out.print("Mã hàng hóa:");
                mahh = sc.nextLine();
                if (mahh.equals("")) {
                    System.out.println("Tên nguyên liệu khác rỗng!");
                }
            } while (mahh.equals(""));
            while(true){
                try{
                System.out.print("Số lượng:");
                soluong = Integer.parseInt(sc.nextLine());
                if (soluong > 0) {
                    break;
                }
                else{
                    System.out.println("Số lượng > 0!");
                }
                }catch(Exception e){
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            while(true){
                try{
                System.out.print("Giá :");
                gia = Integer.parseInt(sc.nextLine());
                if (gia > 0) {
                    break;
                }
                else{
                    System.out.println("Giá > 0!");
                }
                }catch(Exception e){
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            HDXUAT hdx = new HDXUAT(mahdx, ngayxuat, makh, mahh, soluong, gia, Tong());
            dshdx.add(hdx);
            System.out.print("Bạn có muốn nhập thêm thông tin hóa đơn không?Nhập bất kì để tiếp tục!Nếu không nhập 'k' để dừng lại:");
            kt = sc.nextLine();
            kt = kt.toLowerCase();
            if (kt.equals("k")) {
                break;
            }
        }
    }

    public void Hienthi() {
        System.out.println("Mã hóa đơn xuất\tNgày xuất\tMã khách hàng\tMã hàng hóa\tSố lượng\tGiá\tTổng");
        for (HDXUAT hdx : dshdx) {
            System.out.println(hdx.toString());
        }
    }

    public void Sua(String mahdx1) {
        int i = TimKiem(mahdx1);
        if (i == -1) {
            System.out.println("Không có hóa đơn mã " + mahdx1);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Thêm thông tin hóa đơn mã" + mahdx1);
            do {
                System.out.print("Mã hóa đơn xuất:");
                mahdx = sc.nextLine();
                if (mahdx.equals("")) {
                    System.out.println("Mã hóa đơn khác rỗng!");
                }
            } while (mahdx.equals(""));
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                do {
                    System.out.println("Nhập ngày xuất:");
                    ngayxuat = sdf.parse(sc.nextLine());
                    if (sdf.parse("30-12-1960").after(ngayxuat)) {
                        System.out.println("Năm sinh phải lớn hơn 1960!");
                    }
                } while (sdf.parse("30-12-1960").after(ngayxuat));
            } catch (ParseException ex) {
                Logger.getLogger(DSHDXUAT.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Mã khách hàng:");
                makh = sc.nextLine();
                if (makh.equals("")) {
                    System.out.println("Mã khách hàng khác rỗng!");
                }
            } while (makh.equals(""));
            do {
                System.out.print("Mã hàng hóa:");
                mahh = sc.nextLine();
                if (mahh.equals("")) {
                    System.out.println("Tên nguyên liệu khác rỗng!");
                }
            } while (mahh.equals(""));
            while(true){
                try{
                System.out.print("Số lượng:");
                soluong = Integer.parseInt(sc.nextLine());
                if (soluong > 0) {
                    break;
                }
                else{
                    System.out.println("Số lượng > 0!");
                }
                }catch(Exception e){
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            while(true){
                try{
                System.out.print("Giá :");
                gia = Integer.parseInt(sc.nextLine());
                if (gia > 0) {
                    break;
                }
                else{
                    System.out.println("Giá > 0!");
                }
                }catch(Exception e){
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            dshdx.get(i).setMahdx(mahdx);
            dshdx.get(i).setNgayxuat(ngayxuat);
            dshdx.get(i).setMakh(makh);
            dshdx.get(i).setMahh(mahh);
            dshdx.get(i).setSoluong(soluong);
            dshdx.get(i).setGia(gia);
            dshdx.get(i).Tong();
        }
    }

    public void Them(String mahdx1) {
        int k2 = TimKiem(mahdx1);
        if (k2 == -1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Thêm thông tin hóa đơn mã" + mahdx1);
            do {
                System.out.print("Mã hóa đơn xuất:");
                mahdx = sc.nextLine();
                if (mahdx.equals("")) {
                    System.out.println("Mã hóa đơn khác rỗng!");
                }
            } while (mahdx.equals(""));
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                do {
                    System.out.println("Nhập ngày xuất:");
                    ngayxuat = sdf.parse(sc.nextLine());
                    if (sdf.parse("30-12-1960").after(ngayxuat)) {
                        System.out.println("Năm sinh phải lớn hơn 1960!");
                    }
                } while (sdf.parse("30-12-1960").after(ngayxuat));
            } catch (ParseException ex) {
                Logger.getLogger(DSHDXUAT.class.getName()).log(Level.SEVERE, null, ex);
            }
            do {
                System.out.print("Mã khách hàng:");
                makh = sc.nextLine();
                if (makh.equals("")) {
                    System.out.println("Mã khách hàng khác rỗng!");
                }
            } while (makh.equals(""));
            do {
                System.out.print("Mã hàng hóa:");
                mahh = sc.nextLine();
                if (mahh.equals("")) {
                    System.out.println("Tên nguyên liệu khác rỗng!");
                }
            } while (mahh.equals(""));
            while(true){
                try{
                System.out.print("Số lượng:");
                soluong = Integer.parseInt(sc.nextLine());
                if (soluong > 0) {
                    break;
                }
                else{
                    System.out.println("Số lượng > 0!");
                }
                }catch(Exception e){
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            while(true){
                try{
                System.out.print("Giá :");
                gia = Integer.parseInt(sc.nextLine());
                if (gia > 0) {
                    break;
                }
                else{
                    System.out.println("Giá > 0!");
                }
                }catch(Exception e){
                    System.out.println("Vui lòng nhập vào số!");
                }
            }
            HDXUAT hdx = new HDXUAT(mahdx, ngayxuat, makh, mahh, soluong, gia, Tong());
            dshdx.add(hdx);
            System.out.println("Đã thêm hóa đơn " + mahdx1);
        } else {
            System.out.println("Đã có hóa đơn " + mahdx1);
        }
    }

    public void Xoa(String mahdx1) {
        int k2 = TimKiem(mahdx1);
        if (k2 == -1) {
            System.out.println("Không có hóa đơn nào có mã" + mahdx1);
        } else {
            dshdx.remove(k2);
            System.out.println("Đã xóa hóa đơn" + mahdx1);
        }

    }

    public void TimKiem1(String mahdx1) {
        System.out.println("Mã hóa đơn xuất\tNgày xuất\tMã khách hàng\tMã hàng hóa\tSố lượng\tGiá\tTổng");
        int d=0;
        for (int i = 0; i < dshdx.size(); i++) {
            if (dshdx.get(i).getMahdx().equals(mahdx1)) {
                System.out.println(dshdx.get(i));
            } 
        }
        if (d==0){
            System.out.println("Không có nhân viên nào có mã " + mahdx);
        }
    }

    public int TimKiem(String mahdx1) {
        int index = -1;
        for (int i = 0; i < dshdx.size(); i++) {
            if (dshdx.get(i).getMahdx().equals(mahdx1)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void ThongKe() {
        System.out.println("Mã hóa đơn xuất\tNgày xuất\tMã khách hàng\tMã hàng hóa\tSố lượng\tGiá\tTổng");
        for (int i = 0; i < dshdx.size(); i++) {
            if (dshdx.get(i).Tong() > 100000) {
                System.out.println(dshdx.get(i));
            }
        }
    }

    public void Ghitep() {
        try {
            PrintWriter pw = new PrintWriter("D:\\Java\\QLQUANCAPHE\\hoadonxuat.txt", "UTF-8");
            for (HDXUAT hdx : dshdx) {
                pw.println(hdx.toStringfile());
            }
            pw.flush();
            pw.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DSHDXUAT.class.getName()).log(Level.SEVERE, null, ex);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DSHDXUAT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Doctep() {
        File f = new File("D:\\Java\\QLQUANCAPHE\\hoadonxuat.txt");
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line;
            while ((line = br.readLine()) != null) {
                HDXUAT hdx = new HDXUAT(line);
                dshdx.add(hdx);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DSHDXUAT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t***Chương trình quản lý quán cà phê***");
        System.out.println("\t\t\tQuản lý hóa đơn xuất");
        System.out.println("\t\t\t1.Nhập thông tin hóa đơn");
        System.out.println("\t\t\t2.Thêm thông tin hóa đơn");
        System.out.println("\t\t\t3.Sửa thông tin hóa đơn");
        System.out.println("\t\t\t4.Xóa thông tin hóa đơn");
        System.out.println("\t\t\t5.Hiển thị thông tin hóa đơn");
        System.out.println("\t\t\t6.Tìm kiếm");
        System.out.println("\t\t\t7.Thống kê hóa đơn >100000");
        System.out.println("\t\t\t0.Thoát khỏi chương trình");
        System.out.print("\t\t\tMời nhập chức năng 0-7:");
        int chon = sc.nextInt();
        return chon;
    }
}
