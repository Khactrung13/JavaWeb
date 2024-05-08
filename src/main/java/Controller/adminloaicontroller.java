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
import Entity.Admin;
import Entity.DanhMuc;


/**
 * Servlet implementation class adminloaicontroller
 */
@WebServlet("/adminloaicontroller")
public class adminloaicontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminloaicontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Admin a =(Admin)session.getAttribute("dnadmin");
		if(a==null) {
			RequestDispatcher rd = request.getRequestDispatcher("dangnhapadmin.jsp");
			rd.forward(request, response);
		}
		danhmucbo bll = new danhmucbo();
		ArrayList<DanhMuc> dsloai =bll.getDanhmuc();
		request.setAttribute("dsloai", dsloai);
		String tukhoa = request.getParameter("tukhoa1");
		if(tukhoa!=null) {
			ArrayList<DanhMuc> dsloai1 =bll.Timkiem(tukhoa);
			request.setAttribute("dsloai", dsloai1);
		}
		RequestDispatcher rd = request.getRequestDispatcher("adminloai.jsp");
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
