/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlquancaphe;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
public class KHACHHANG {

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
     * @return the hoten
     */
    public String getHoten() {
        return hoten;
    }

    /**
     * @param hoten the hoten to set
     */
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    /**
     * @return the gt
     */
    public String getGt() {
        return gt;
    }

    /**
     * @param gt the gt to set
     */
    public void setGt(String gt) {
        this.gt = gt;
    }

    /**
     * @return the namsinh
     */
    public Date getNamsinh() {
        return namsinh;
    }

    /**
     * @param namsinh the namsinh to set
     */
    public void setNamsinh(Date namsinh) {
        this.namsinh = namsinh;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    /**
     * @return the loaikh
     */
    public String getLoaikh() {
        return loaikh;
    }

    /**
     * @param loaikh the loaikh to set
     */
    public void setLoaikh(String loaikh) {
        this.loaikh = loaikh;
    }

    private String makh, hoten, gt, sdt, loaikh;
    private Date namsinh;
    public KHACHHANG() {
    }

    public KHACHHANG(String makh, String hoten, String gt, Date namsinh, String sdt, String loaikh) {
        this.makh = makh;
        this.hoten = hoten;
        this.gt = gt;
        this.namsinh = namsinh;
        this.sdt = sdt;
        this.loaikh = loaikh;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public KHACHHANG(String line) {
        String[] sc = line.split("#");
        this.makh = sc[0];
        this.hoten = sc[1];
        this.gt = sc[2];
        try {
            this.namsinh=sdf.parse(sc[3]);
        } catch (ParseException ex) {
            Logger.getLogger(KHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.sdt = sc[4];
        this.loaikh = sc[5];
    }

    public String toString() {
        return makh + "\t" + hoten + "\t" + gt + "\t" + sdf.format(namsinh) + "\t" + sdt + "\t" + loaikh;
    }

    public String toStringfile() {
        return makh + "#" + hoten + "#" + gt + "#" + sdf.format(namsinh) + "#" + sdt + "#" + loaikh;
    }

}
