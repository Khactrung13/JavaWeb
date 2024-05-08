package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.danhmucbo;
import BO.sanphambo;
import Entity.Admin;
import Entity.DanhMuc;
import Entity.SanPham;

/**
 * Servlet implementation class adminsanphamcontroller
 */
@WebServlet("/adminsanphamcontroller")
public class adminsanphamcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminsanphamcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		Admin a =(Admin)session.getAttribute("dnadmin");
		if(a==null) {
			RequestDispatcher rd = request.getRequestDispatcher("dangnhapadmin.jsp");
			rd.forward(request, response);
		}
		danhmucbo dmuc = new danhmucbo();
		ArrayList<DanhMuc> dm = dmuc.getDanhmuc();
		request.setAttribute("dm",dm);
		
		sanphambo bll = new sanphambo();
		ArrayList<SanPham> ds =bll.getListSanPham();
		request.setAttribute("dssp", ds);
		String tukhoa = request.getParameter("tukhoa1");
		if(tukhoa!=null) {
			ArrayList<SanPham> ds1 =bll.SearchByKey(tukhoa);
			request.setAttribute("dssp", ds1);
		}
		RequestDispatcher rd = request.getRequestDispatcher("adminsanpham.jsp");
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
