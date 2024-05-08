package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.danhmucbo;
import BO.sanphambo;
import Entity.DanhMuc;
import Entity.SanPham;

/**
 * Servlet implementation class timkiem
 */
@WebServlet("/timkiem")
public class timkiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timkiem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		sanphambo bll = new sanphambo();
		danhmucbo dmuc = new danhmucbo();
		ArrayList<DanhMuc> ds = dmuc.getDanhmuc();
		request.setAttribute("dm",ds);

		if(request.getParameter("id")!=null) {
			String tam = request.getParameter("id");
			String tam2 = request.getParameter("sp");
			int begin;
			int page = 1;
			String trang = request.getParameter("trang");
			if(trang==null) {
				begin = 0;
			}
			else {
				page= Integer.parseInt(trang);
				begin =(page*6)-6;
			}
			request.setAttribute("tr",page);
			int id = Integer.parseInt(tam);
			request.setAttribute("id",id);
			ArrayList<SanPham> dss = bll.SearchByid(id, begin);
			request.setAttribute("timkiem",dss);
			//lay ra ten cua tu khoa can tim
			request.setAttribute("timkiem1",tam2);
			int count = bll.DemSoLuongSPbyid(id);
			int endpage= count/6;
			if(count % 6 !=0) {
				endpage ++;
				
			}
			request.setAttribute("endp",endpage);
			request.getRequestDispatcher("timkiem.jsp").forward(request, response);		
			
		}else if(request.getParameter("tukhoa")!=null) {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String ten = request.getParameter("tukhoa");
			int begin;
			int page = 1;
			String trang = request.getParameter("trang");
			if(trang==null) {
				begin = 0;
			}
			else {
				page= Integer.parseInt(trang);
				begin =(page*6)-6;
			}
			request.setAttribute("tr",page);
			ArrayList<SanPham> dsss = bll.SearchByKey(ten, begin);
			request.setAttribute("timkiem1",ten);
			int count = bll.DemSoLuongSPbykey(ten);
			int endpage= count/6;
			if(count % 6 !=0) {
				endpage ++;
				
			}
			request.setAttribute("endp",endpage);
			if(dsss.size()==0) {
				request.setAttribute("mess", "Không tìm thấy sản phẩm !!!");
				request.getRequestDispatcher("timkiembykey.jsp").forward(request, response);
			}else {
				request.setAttribute("timkiem",dsss);
				request.getRequestDispatcher("timkiembykey.jsp").forward(request, response);
			}
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
