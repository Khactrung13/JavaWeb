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

import BO.hoadonbo;
import Entity.Admin;
import Entity.KhachHang;
import Entity.hoadon;

/**
 * Servlet implementation class adminhoadon
 */
@WebServlet("/adminhoadon")
public class adminhoadon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminhoadon() {
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
			HttpSession session = request.getSession();
			Admin a =(Admin)session.getAttribute("dnadmin");
			if(a==null) {
				RequestDispatcher rd = request.getRequestDispatcher("dangnhapadmin.jsp");
				rd.forward(request, response);
			}
			hoadonbo bll = new hoadonbo();
			bll.XoaHoaDonTren15NgayChuaThanhToan();
			ArrayList<hoadon> ds = bll.getHoadon();
			request.setAttribute("hoadon",ds);
			String tukhoa = request.getParameter("tukhoa");
			if(tukhoa!=null) {
				ArrayList<hoadon> dss = bll.Timkiem(tukhoa);
				request.setAttribute("hoadon",dss);
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
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
