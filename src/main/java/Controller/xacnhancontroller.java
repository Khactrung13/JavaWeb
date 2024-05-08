package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.giohangbo;
import BO.hoadonbo;
import Entity.GioHang;
import Entity.KhachHang;

/**
 * Servlet implementation class xacnhancontroller
 */
@WebServlet("/xacnhancontroller")
public class xacnhancontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhancontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			hoadonbo bll = new hoadonbo();
			HttpSession session = request.getSession();
			KhachHang kh =(KhachHang)session.getAttribute("dn");
			if(kh==null) {
				RequestDispatcher rd = request.getRequestDispatcher("dangnhap");
				rd.forward(request, response);
			}else {
				//CGioHang gh = (CGioHang)session.getAttribute("gh");
				//giohangbean gh =(giohangbean)session.getAttribute("gh");
				if(session.getAttribute("gh")!=null) {
					giohangbo gh= new giohangbo();
					gh = (giohangbo)session.getAttribute("gh");
				
					bll.Hoadon(kh.getId());
					int mahd = bll.MaxHd();
					for(GioHang g : gh.ds) {
						bll.ChiTietHoadon(g.getMasanpham(),g.getSoluongmua(),mahd);
						session.removeAttribute("gh");
					
						
					}
					response.sendRedirect("camon");
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("htgiocontroller");
					rd.forward(request, response);

				}
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
