/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlthuvien;

/**
 *
 * @author luong
 */
public class Book {
    private String tensach;
    private String tenTacGia;
    private int namNXB;
    private int trangThai;
    private String nxb;
    private String hinh;
    private String moTaSach;
    private float giaSach;

    public Book(String tensach, String tenTacGia, int namNXB, int trangThai, String nxb, String hinh, String moTaSach, float giaSach) {
        this.tensach = tensach;
        this.tenTacGia = tenTacGia;
        this.namNXB = namNXB;
        this.trangThai = trangThai;
        this.nxb = nxb;
        this.hinh = hinh;
        this.moTaSach = moTaSach;
        this.giaSach = giaSach;
    }
    public Book(){};

    public String getTensach() {
        return tensach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public int getNamNXB() {
        return namNXB;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public String getNxb() {
        return nxb;
    }

    public String getHinh() {
        return hinh;
    }

    public String getMoTaSach() {
        return moTaSach;
    }

    public float getGiaSach() {
        return giaSach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public void setNamNXB(int namNXB) {
        this.namNXB = namNXB;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public void setMoTaSach(String moTaSach) {
        this.moTaSach = moTaSach;
    }

    public void setGiaSach(float giaSach) {
        this.giaSach = giaSach;
    }

}
