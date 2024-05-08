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
import Entity.DanhMuc;

/**
 * Servlet implementation class adminsuadanhmuc
 */
@WebServlet("/adminsuadanhmuc")
public class adminsuadanhmuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminsuadanhmuc() {
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
		DanhMuc dm = bll.LaydanhMuc(Integer.parseInt(id));
		HttpSession session =request.getSession();
		session.setAttribute("dm",dm);
		request.setAttribute("dm",dm);
		RequestDispatcher rd = request.getRequestDispatcher("adminsuadanhmuc.jsp");
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
