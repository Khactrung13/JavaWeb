package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.danhmucbo;
import BO.sanphambo;
import Entity.DanhMuc;

/**
 * Servlet implementation class adminxoadanhmuc
 */
@WebServlet("/adminxoadanhmuc")
public class adminxoadanhmuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminxoadanhmuc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		danhmucbo bll = new danhmucbo();
		ArrayList<DanhMuc> dsloai =bll.getDanhmuc();
		request.setAttribute("dsloai", dsloai);
		
		String id = request.getParameter("id");
		bll.XoaLoai(Integer.parseInt(id));
		sanphambo bo = new sanphambo();
		bo.XoaSanPhamByDanhMuc(Integer.parseInt(id));
		RequestDispatcher rd = request.getRequestDispatcher("adminloaicontroller");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
