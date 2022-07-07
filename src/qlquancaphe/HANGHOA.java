/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlquancaphe;

import java.util.Scanner;

/**
 *
 * @author BKV
 */
public class HANGHOA {

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

    /**
     * @return the loaihh
     */
    public String getLoaihh() {
        return loaihh;
    }

    /**
     * @param loaihh the loaihh to set
     */
    public void setLoaihh(String loaihh) {
        this.loaihh = loaihh;
    }

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
    private String mahh, tenhh, loaihh;
    private int soluong;
    private double gia,tong;

    public HANGHOA() {
    }
    public HANGHOA(String mahh, String tenhh, String loaihh, int soluong, double gia) {
        this.mahh = mahh;
        this.tenhh = tenhh;
        this.loaihh = loaihh;
        this.soluong = soluong;
        this.gia = gia;
    }

    public HANGHOA(String line) {
        String[] sc = line.split("#");
        this.mahh = sc[0];
        this.tenhh = sc[1];
        this.loaihh = sc[2];
        this.soluong = Integer.parseInt(sc[3]);
        this.gia = Double.parseDouble(sc[4]);
    }
    public String toString() {
        return mahh + "\t" + tenhh + "\t" + loaihh + "\t" + soluong + "\t" + gia;
    }
    public String toStringfile(){
        return mahh + "#" + tenhh + "#" + loaihh + "#" + soluong + "#" + gia ;
    }
}
