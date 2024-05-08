package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.danhmucbo;
import BO.giohangbo;
import Entity.DanhMuc;


/**
 * Servlet implementation class giocontroller
 */
@WebServlet("/giocontroller")
public class giocontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giocontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String masp=request.getParameter("ms");
			String tensp= request.getParameter("ts");
			String anh= request.getParameter("anh");
			String gia= request.getParameter("g");
			
			danhmucbo dmuc = new danhmucbo();
			ArrayList<DanhMuc> ds = dmuc.getDanhmuc();
			request.setAttribute("dm",ds);
			HttpSession session = request.getSession();
		
			giohangbo g= new giohangbo();
			  //Neu mua hang lan dau
			  if(session.getAttribute("gh")==null){
			       session.setAttribute("gh", g);//Tao gio
			       request.setAttribute("mess3", "Gio hang trong!!!	");
				  
			  }
			  //Gian session: gh vao bien: g
			  g=(giohangbo)session.getAttribute("gh");
			  //Them hang vao bien: g
			  g.Them(masp,tensp,anh,Double.parseDouble(gia),1);
			  //Luu bien vao session
			  session.setAttribute("gh", g);
			 
			 response.sendRedirect("htgiocontroller");
			
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
