package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.danhmucbo;

/**
 * Servlet implementation class adminthemdanhmuc
 */
@WebServlet("/adminthemdanhmuc")
public class adminthemdanhmuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminthemdanhmuc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			String maloai = request.getParameter("maloai");
			String tenloai = request.getParameter("tenloai");
			if(tenloai==""|| maloai=="") {
				request.setAttribute("mess", "Mã loại và tên loại không được để trống  !!!	");
				
			}else {
				danhmucbo bll = new danhmucbo();
				bll.ThemDanhMuc(Integer.parseInt(maloai), tenloai);
			}
			RequestDispatcher rd = request.getRequestDispatcher("adminloaicontroller");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
