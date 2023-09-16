package com.poly.CRUD_Fix_Cung.controller;

import com.poly.CRUD_Fix_Cung.entity.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan_vien/load",
        "/nhan_vien/view_add",
        "/nhan_vien/add",
        "/nhan_vien/view-update",
        "/nhan_vien/update",
        "/nhan_vien/delete",
        "/nhan_vien/details"
})
public class NhanVienServlet extends HttpServlet {

    private List<NhanVien> listNhanVien = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String uri = request.getRequestURI();
       if (uri.contains("load")){
           this.hienThiDanhhSachNhanVien(request,response);
       }else if (uri.contains("details")){
           this.detailsNhanVien(request,response);
       }else if (uri.contains("view_add")){
           this.viewAddNhanVien(request,response);
       }else if (uri.contains("view-update")){
           this.viewUpdateNhanVien(request,response);
       }else if (uri.contains("delete")){
           this.deleteNhanVien(request,response);
       }else {
           this.hienThiDanhhSachNhanVien(request,response);
       }
    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String manv = request.getParameter("manv");
        int viTri = -1;
        for(int i=0;i<listNhanVien.size();i++){
            if (listNhanVien.get(i).getMa().equalsIgnoreCase(manv)){
                viTri=i;
            }
        }
        listNhanVien.remove(viTri);
        response.sendRedirect("load");
    }

    private void viewUpdateNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String manv = request.getParameter("manv");
        int viTri = -1;
        for(int i=0;i<listNhanVien.size();i++){
            if (listNhanVien.get(i).getMa().equalsIgnoreCase(manv)){
                viTri=i;
            }
        }
        NhanVien nv = listNhanVien.get(viTri);
        request.setAttribute("nv",nv);
        request.getRequestDispatcher("/views/update_nhan_vien.jsp").forward(request,response);
    }

    private void viewAddNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/add_nhan_vien.jsp").forward(request,response);
    }

    private void detailsNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String manv = request.getParameter("manv");
        int viTri = -1;
        for(int i=0;i< listNhanVien.size();i++){
            if (listNhanVien.get(i).getMa().equalsIgnoreCase(manv)){
                viTri=i;
            }
        }

        NhanVien nhanVien = listNhanVien.get(viTri);

        request.setAttribute("nv",nhanVien);

        request.getRequestDispatcher("/views/details_nhan_vien.jsp").forward(request,response);
    }

    private void hienThiDanhhSachNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (listNhanVien.isEmpty()){
            listNhanVien.add(new NhanVien("NV1","Trần Tuấn Phong",true,18,"Hà Nội"));
            listNhanVien.add(new NhanVien("NV2","Nguyễn Hoàng Tiến",true,15,"Hà Nội1"));
            listNhanVien.add(new NhanVien("NV3","Vũ Văn Nguyên",false,19,"Hà Nội2"));
            listNhanVien.add(new NhanVien("NV4","Nguyễn Thị Hằng",true,20,"Hà Nội3"));
            listNhanVien.add(new NhanVien("NV5","Lâm Cao Hùng",false,21,"Hà Nội4"));
        }

        request.setAttribute("nhanvien",listNhanVien);

        request.getRequestDispatcher("/views/nhan_vien.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")){
            this.addNhanVien(request,response);
        }else if (uri.contains("update")){
            this.updateNhanVien(request,response);
        }
    }

    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String manv = request.getParameter("manv");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");

        int viTri = -1;
        for(int i=0;i<listNhanVien.size();i++){
            if (listNhanVien.get(i).getMa().equalsIgnoreCase(manv)){
                viTri=i;
            }
        }
        NhanVien nhanVien = listNhanVien.get(viTri);
        nhanVien.setMa(manv);
        nhanVien.setTen(ten);
        nhanVien.setGioiTinh(Boolean.valueOf(gioiTinh));
        nhanVien.setTuoi(Integer.valueOf(tuoi));
        nhanVien.setDiaChi(diaChi);

        listNhanVien.set(viTri,nhanVien);

        response.sendRedirect("load");
    }

    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String manv = request.getParameter("manv");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");

        NhanVien nhanVien = new NhanVien(manv,ten,Boolean.valueOf(gioiTinh),Integer.valueOf(tuoi),diaChi);
        listNhanVien.add(nhanVien);
        response.sendRedirect("load");
    }
}
