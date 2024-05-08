package Controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import BO.danhmucbo;
import BO.sanphambo;

import Entity.DanhMuc;
import Entity.SanPham;

/**
 * Servlet implementation class Sanpham
 */
@WebServlet("/sanpham")
public class sanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public sanpham() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		sanphambo bll1 = new sanphambo();
		//phan trang
		int begin;
		int page = 1;
		String trang = request.getParameter("trang");
		if(trang==null) {
			begin = 0;
		}
		else {
			page= Integer.parseInt(trang);
			begin =(page*6)-6;
		}
		request.setAttribute("tr",page);
		ArrayList<SanPham> dssp = bll1.getListSanPham1(begin);
		request.setAttribute("ds",dssp);
		danhmucbo dmuc = new danhmucbo();
		ArrayList<DanhMuc> ds = dmuc.getDanhmuc();
		request.setAttribute("dm",ds);
		
		int count = bll1.DemSoLuongSP();
		int endpage= count/6;
		if(count % 6 !=0) {
			endpage ++;
			
		}
		request.setAttribute("endp",endpage);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
