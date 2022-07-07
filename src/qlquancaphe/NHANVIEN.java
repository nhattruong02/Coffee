/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlquancaphe;

import java.text.DateFormat;
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
public class NHANVIEN {

    /**
     * @return the manv
     */
    public String getManv() {
        return manv;
    }

    /**
     * @param manv the manv to set
     */
    public void setManv(String manv) {
        this.manv = manv;
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
     * @return the calv
     */
    public String getCalv() {
        return calv;
    }

    /**
     * @param calv the calv to set
     */
    public void setCalv(String calv) {
        this.calv = calv;
    }

    /**
     * @return the cmnd
     */
    public String getCmnd() {
        return cmnd;
    }

    /**
     * @param cmnd the cmnd to set
     */
    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
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

    private String manv,hoten,gt,calv, cmnd,sdt;
    private Date namsinh;

    public NHANVIEN() {
    }

    public NHANVIEN(String manv, String hoten, String gt, Date namsinh, String calv, String cmnd,String sdt) {
        this.manv = manv;
        this.hoten=hoten;
        this.gt=gt;
        this.namsinh=namsinh;
        this.calv = calv;
        this.cmnd = cmnd;
        this.sdt=sdt;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public NHANVIEN(String line) {
        String[] sc = line.split("#");
        this.manv = sc[0];
        this.hoten=sc[1];
        this.gt=sc[2];
        try {
            this.namsinh=sdf.parse(sc[3]);
        } catch (ParseException ex) {
            Logger.getLogger(NHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.calv = sc[4];
        this.cmnd = sc[5];
        this.sdt=sc[6];
    }
    public String toString() {
        return manv + "\t" + hoten + "\t" + gt + "\t" + sdf.format(namsinh) + "\t" + calv + "\t" + cmnd + "\t" + sdt;
    }
    public String toStringfile(){
        return manv + "#" + hoten + "#" + gt + "#" + sdf.format(namsinh) + "#" + calv + "#" + cmnd + "#" + sdt;
    }
            
}
