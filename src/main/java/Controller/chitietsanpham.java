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
 * Servlet implementation class chitietsanpham
 */
@WebServlet("/chitietsanpham")
public class chitietsanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitietsanpham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		sanphambo bll = new sanphambo();
		SanPham ds = bll.getChitietsanpham1(id);
		request.setAttribute("ds",ds);
		danhmucbo dmuc = new danhmucbo();
		ArrayList<DanhMuc> dss = dmuc.getDanhmuc();
		request.setAttribute("dm",dss);
		request.getRequestDispatcher("chitietsanpham.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
