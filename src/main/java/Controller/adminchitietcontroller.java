package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.hoadonbo;

import Entity.lichsu;

/**
 * Servlet implementation class adminchitietcontroller
 */
@WebServlet("/adminchitietcontroller")
public class adminchitietcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminchitietcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String id = request.getParameter("mahd");
			hoadonbo bll = new hoadonbo();
			if(bll.KiemTra(Integer.parseInt(id))==null) {
				bll.CapNhaHoaDon(Integer.parseInt(id));
			}
			
			ArrayList<lichsu> chitiet = bll.getChitiet(Integer.parseInt(id));
			request.setAttribute("chitiethd",chitiet);
			request.getRequestDispatcher("adminchitiethoadon.jsp").forward(request, response);
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
