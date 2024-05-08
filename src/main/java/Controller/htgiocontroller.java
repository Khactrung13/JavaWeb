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
 * Servlet implementation class htgiocontroller
 */
@WebServlet("/htgiocontroller")
public class htgiocontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htgiocontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//loaibo lbo = new loaibo();
			//request.setAttribute("dsloai", lbo.getLoai());
			danhmucbo dmuc = new danhmucbo();
			ArrayList<DanhMuc> dss = dmuc.getDanhmuc();
			request.setAttribute("dm",dss);
			HttpSession session = request.getSession();
			if(session.getAttribute("gh")==null){
			     
			       request.setAttribute("mess3", "Giỏ hàng hiện tại đang trống !!!	");
				  
			  }
		
			RequestDispatcher rd = request.getRequestDispatcher("htgio.jsp");
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
