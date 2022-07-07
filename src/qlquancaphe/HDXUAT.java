/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlquancaphe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BKV
 */
public class HDXUAT {

    /**
     * @return the soluong
     */
    public int getSoluong() {
        return soluong;
    }

    /**
     * @param soluong the soluong to set
     */
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    /**
     * @return the gia
     */
    public double getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(double gia) {
        this.gia = gia;
    }

    /**
     * @return the tong
     */
    public double getTong() {
        return tong;
    }

    /**
     * @param tong the tong to set
     */
    public void setTong(double tong) {
        this.tong = tong;
    }

    /**
     * @return the mahdx
     */
    public String getMahdx() {
        return mahdx;
    }

    /**
     * @param mahdx the mahdx to set
     */
    public void setMahdx(String mahdx) {
        this.mahdx = mahdx;
    }

    /**
     * @return the ngayxuat
     */
    public Date getNgayxuat() {
        return ngayxuat;
    }

    /**
     * @param ngayxuat the ngayxuat to set
     */
    public void setNgayxuat(Date ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    /**
     * @return the makh
     */
    public String getMakh() {
        return makh;
    }

    /**
     * @param makh the makh to set
     */
    public void setMakh(String makh) {
        this.makh = makh;
    }

    /**
     * @return the mahh
     */
    public String getMahh() {
        return mahh;
    }

    /**
     * @param mahh the mahh to set
     */
    public void setMahh(String mahh) {
        this.mahh = mahh;
    }

    /**
     * @return the tenhh
     */
    public String getTenhh() {
        return tenhh;
    }

    /**
     * @param tenhh the tenhh to set
     */
    public void setTenhh(String tenhh) {
        this.tenhh = tenhh;
    }
    private String mahdx, makh, mahh, tenhh;
    private Date ngayxuat;
    private int soluong;
    private double gia, tong;

    public HDXUAT() {

    }

    public HDXUAT(String mahdx, Date ngayxuat, String makh, String mahh, int soluong, double gia, double tong) {
        this.mahdx = mahdx;
        this.ngayxuat = ngayxuat;
        this.makh = makh;
        this.mahh = mahh;
        this.soluong = soluong;
        this.gia = gia;
        this.tong = tong;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public HDXUAT(String line) {
        String[] sc = line.split("#");
        this.mahdx = sc[0];
        try {
            this.ngayxuat = sdf.parse(sc[1]);
        } catch (ParseException ex) {
            Logger.getLogger(HDXUAT.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.makh = sc[2];
        this.mahh = sc[3];
        this.soluong = Integer.parseInt(sc[4]);
        this.gia = Double.parseDouble(sc[5]);
        this.tong = Double.parseDouble(sc[6]);
    }

    public String toString() {
        return mahdx + "\t" + sdf.format(ngayxuat) + "\t" + makh + "\t" + mahh + "\t" + soluong + "\t" + gia + "\t" + Tong();
    }

    public String toStringfile() {
        return mahdx + "#" + sdf.format(ngayxuat) + "#" + makh + "#" + mahh + "#" + soluong + "#" + gia + "#" + Tong();
    }

    public double Tong() {
        return soluong * gia;
    }

}
