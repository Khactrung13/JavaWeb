package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.giohangbo;


/**
 * Servlet implementation class tru
 */
@WebServlet("/tru")
public class tru extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tru() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		giohangbo g = new giohangbo();
		
		HttpSession session = request.getSession();
		g=(giohangbo)session.getAttribute("gh");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String ms = request.getParameter("ms");
		int sh = g.ds.size();
		for(int i=0;i<sh;i++) {
			if(g.ds.get(i).getMasanpham().equalsIgnoreCase(ms)) {
				if(g.ds.get(i).getSoluongmua()>0) {
				g.ds.get(i).setSoluongmua(g.ds.get(i).getSoluongmua()-1);
				}
			}
		}
		response.sendRedirect("htgiocontroller");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
