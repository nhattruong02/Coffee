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
public class HDNHAP {

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
     * @return the mahdn
     */
    public String getMahdn() {
        return mahdn;
    }

    /**
     * @param mahdn the mahdn to set
     */
    public void setMahdn(String mahdn) {
        this.mahdn = mahdn;
    }

    /**
     * @return the ncc
     */
    public String getNcc() {
        return ncc;
    }

    /**
     * @param ncc the ncc to set
     */
    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    /**
     * @return the ngaynhap
     */
    public Date getNgaynhap() {
        return ngaynhap;
    }

    /**
     * @param ngaynhap the ngaynhap to set
     */
    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    /**
     * @return the tennl
     */
    public String getTennl() {
        return tennl;
    }

    /**
     * @param tennl the tennl to set
     */
    public void setTennl(String tennl) {
        this.tennl = tennl;
    }

    private String mahdn, ncc, tennl;
    private Date ngaynhap;
    private int soluong;
    private double gia,tong;
    public HDNHAP(){
    }
    public HDNHAP(String mahdn, String ncc, Date ngaynhap, String tennl, int soluong, double gia,double tong){
        this.mahdn = mahdn;
        this.ncc = ncc;
        this.ngaynhap = ngaynhap;
        this.tennl = tennl;
        this.soluong=soluong;
        this.gia=gia;
        this.tong=tong;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public HDNHAP (String line){
        String[] sc = line.split("#");
        this.mahdn=sc[0];
        this.ncc=sc[1];
        try {
            this.ngaynhap=sdf.parse(sc[2]);
        } catch (ParseException ex) {
            Logger.getLogger(HDNHAP.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tennl=sc[3];
        this.soluong=Integer.parseInt(sc[4]);
        this.gia=Double.parseDouble(sc[5]);
        this.tong=Double.parseDouble(sc[6]);
    }

    public String toString() {
        return mahdn + "\t" + ncc + "\t" + sdf.format(ngaynhap) + "\t" + tennl + "\t" +getSoluong()+"\t"+getGia()+"\t"+Tong();
    }

    public String toStringfile() {
        return mahdn + "#" + ncc + "#" + sdf.format(ngaynhap) + "#" + tennl + "#" +getSoluong()+"#"+getGia()+"#"+Tong();
    }
    public double Tong(){
        return getSoluong()*getGia();
    }
}
