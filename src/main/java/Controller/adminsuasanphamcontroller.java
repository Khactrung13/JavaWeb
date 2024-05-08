package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BO.sanphambo;
import Entity.SanPham;

/**
 * Servlet implementation class adminsuasanphamcontroller
 */
@WebServlet("/adminsuasanphamcontroller")
public class adminsuasanphamcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminsuasanphamcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session =request.getSession();
response.setCharacterEncoding("utf-8");
request.setCharacterEncoding("utf-8");
		
		SanPham spp = (SanPham)session.getAttribute("sp");
		String anh = spp.getHinhanh();
		
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 SanPham sp = new SanPham();
		 
		try {

			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
			//duyệt qua các đối tượng gửi lên từ client gồm file và các control
	for (FileItem fileItem : fileItems) {
			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
				 if(fileItem.getSize()>0) {
				// xử lý file
				String nameimg = fileItem.getName();
				sp.setHinhanh(nameimg);
				if (!nameimg.equals("")) {
			           //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
					String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "files";
					File dir = new File(dirUrl);
					if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
						dir.mkdir();
					}
				           String fileImg = dirUrl + File.separator + nameimg;
				           File file = new File(fileImg);//tạo file
				            try {
				               fileItem.write(file);//lưu file
				              
				 } catch (Exception e) {
				    e.printStackTrace();
				}
			}
				 }else {
					 sp.setHinhanh(anh);
				 }
		 }
			else//Neu la control
			{
				//SanPham sp = new SanPham();
				if(fileItem.getFieldName().equals("tensp")) {
					sp.setTensp(fileItem.getString());
				}
				if(fileItem.getFieldName().equals("masp")) {
					sp.setMa(fileItem.getString());
					//sp.setMa(fileItem.getString());
				}
				if(fileItem.getFieldName().equals("gia")) {
					sp.setGia(Double.parseDouble(fileItem.getString()));
				}
				if(fileItem.getFieldName().equals("soluong")) {
					sp.setSoluong(Integer.parseInt(fileItem.getString()));
				}
				//if(fileItem.getFieldName().equals("hinhanh")) {
					//sp.setHinhanh(fileItem.getString());
				//}
				if(fileItem.getFieldName().equals("tomtat")) {
					sp.setTomtat(fileItem.getString());
				}
				if(fileItem.getFieldName().equals("noidung")) {
					sp.setNoidung(fileItem.getString());
				}
				if(fileItem.getFieldName().equals("iddanhmuc")) {
					sp.setIddanhmuc(Integer.parseInt(fileItem.getString()));
				}
				
			}
			}
			try {
				sanphambo bll = new sanphambo();
				bll.SuaSanPham(sp.getTensp(),sp.getMa(),sp.getGia(),sp.getSoluong(),sp.getHinhanh(),sp.getTomtat(),sp.getNoidung(),sp.getIddanhmuc(),spp.getId());
				//bll.SuaSanPham("1","2",123,3,"asdasd","sadas","sad",1,123);
				//session.removeAttribute("sp");
				RequestDispatcher rd = request.getRequestDispatcher("adminsanphamcontroller");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
						
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		//request.getRequestDispatcher("adminsanphamcontroller").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
