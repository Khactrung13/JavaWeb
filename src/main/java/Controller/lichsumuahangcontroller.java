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
import BO.lichsubo;
import Entity.DanhMuc;
import Entity.KhachHang;
import Entity.lichsu;


/**
 * Servlet implementation class lichsumuahangcontroller
 */
@WebServlet("/lichsumuahangcontroller")
public class lichsumuahangcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsumuahangcontroller() {
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
			danhmucbo dmuc = new danhmucbo();
			ArrayList<DanhMuc> ds = dmuc.getDanhmuc();
			request.setAttribute("dm",ds);
			KhachHang kh =(KhachHang)session.getAttribute("dn");
			
			if(kh==null) {
				RequestDispatcher rd = request.getRequestDispatcher("dangnhap");
				rd.forward(request, response);
			}else{
				
				int makhachhang= kh.getId();
				lichsubo ls = new lichsubo();
				ArrayList<lichsu> lsb = ls.getLichSu(makhachhang);

				request.setAttribute("lichsu",lsb);
				RequestDispatcher rd = request.getRequestDispatcher("lichsumuahang.jsp");
				rd.forward(request, response);
			
			}
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
