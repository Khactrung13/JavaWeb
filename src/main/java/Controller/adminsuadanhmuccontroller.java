package Controller;

import java.io.IOException;

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
 * Servlet implementation class adminsuadanhmuccontroller
 */
@WebServlet("/adminsuadanhmuccontroller")
public class adminsuadanhmuccontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminsuadanhmuccontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session =request.getSession();
		String ten = request.getParameter("tenloai");
		DanhMuc dm = (DanhMuc)session.getAttribute("dm");
		int id= dm.getId();
		if(ten=="") {
			request.setAttribute("mess", "Tên loại không được để trống  !!!	");
			
		}else {
		danhmucbo bll = new danhmucbo();
		bll.SuaDanhMuc(id,ten);
		session.removeAttribute("dm");
		}
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
