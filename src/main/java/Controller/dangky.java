package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.khachhangbo;


/**
 * Servlet implementation class dangky
 */
@WebServlet("/dangky")
public class dangky extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangky() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		String ten = request.getParameter("ten");
		String diachi = request.getParameter("diachi");
		String sodth = request.getParameter("sdt");
		String email = request.getParameter("email");
		String matkhau = request.getParameter("pass");
		String matkhau1 =  request.getParameter("pass1");
		khachhangbo bl = new khachhangbo();
		HttpSession session =request.getSession();
		session.setAttribute("dn","1");
		if(request.getParameter("pass")==null) {
			request.getRequestDispatcher("dangky.jsp").forward(request, response);
		}
		if(ten!="" &&diachi!=""&&email!=""&&matkhau1!=""&& matkhau!=""){
			if(bl.KiemTraTaiKhoan(email)==null) {
				if(matkhau.equalsIgnoreCase(matkhau1)) {
					matkhau  = khachhangbo.toSha1(matkhau);
					bl.Dangky(ten, email, diachi, matkhau, sodth);
					
					//session.setAttribute("dn",email);
					request.getRequestDispatcher("dangnhap.jsp").forward(request, response);
				}else {
					request.setAttribute("mess1", "Mật khẩu nhập lại không chính xác !!!");
					request.getRequestDispatcher("dangky.jsp").forward(request, response);
				}
			}else {
					request.setAttribute("mess1", "Tên đăng nhập đã tồn tại!!!");
					request.getRequestDispatcher("dangky.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("mess1", "Vui lòng điền đầy đủ thông tin !!!");
			request.getRequestDispatcher("dangky.jsp").forward(request, response);
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
