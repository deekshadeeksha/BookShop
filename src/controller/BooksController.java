package controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import manager.Manager;

/**
 * Servlet implementation class GenresController
 */
@WebServlet("/BooksController")
public class BooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	/*
	*/
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String genId="",pub_id="",auth_id="",title="",publication_date="",language="",price="";
		
		/*
		
		
		*/
		  int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
		    final int MAX_REQUEST_SIZE = 1024 * 1024;
		    String filePath="";
		    
		    DiskFileItemFactory factory = new DiskFileItemFactory();

		    // Sets the size threshold beyond which files are written directly to disk.
		    factory.setSizeThreshold(MAX_MEMORY_SIZE);

		    // Sets the directory used to temporarily store files that are larger
		    // than the configured size threshold. We use temporary directory for java
		    factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		    // constructs the folder where uploaded file will be stored
		    String uploadFolder = "C:/Users/ddeeksha/eclipse-workspace/BookShop/WebContent/images";
		    // Create a new file upload handler
		    ServletFileUpload upload = new ServletFileUpload(factory);

		    // Set overall request size constraint
		    upload.setSizeMax(MAX_REQUEST_SIZE);

		    try {
		        // Parse the request
		    	List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
		        for (Object item1 : items) {
		            FileItem item = (FileItem) item1;

		            if (!item.isFormField()) {
		                String fileName = new File(item.getName()).getName();
		                
		        		
		                
		              filePath = uploadFolder + "/"+ fileName;
		                File uploadedFile = new File(filePath);

		                // saves the file to upload directory
		                item.write(uploadedFile);
		            }
		            else
		            {
		            	String fieldname = item.getFieldName();
		                String fieldvalue = item.getString();
		                if (fieldname.equals("genId")) 
		                    //logic goes here...
		                	genId=fieldvalue;
		                
		                else if(fieldname.equals("pub_id"))
		                	pub_id=fieldvalue;
	                
		            else if(fieldname.equals("auth_id"))
		                	auth_id=fieldvalue;
		            else if(fieldname.equals("title"))
	                	title=fieldvalue;
		            else if(fieldname.equals("publication_date"))
	                	publication_date=fieldvalue;
		            else if(fieldname.equals("language"))
	                	language=fieldvalue;
		            else if(fieldname.equals("price"))
	                	price=fieldvalue;  
		            }
		            
		        }
		       // response.sendRedirect("success.jsp");
		    } catch (Exception e) {
		    	System.out.println(e);
		       // response.sendRedirect("errorPage.jsp");
		    }
		   
			float pr=Float.parseFloat(price);
			int gen=Integer.parseInt(genId);
			int pub=Integer.parseInt(pub_id);
			int auth=Integer.parseInt(auth_id);
			String str="insert into books_details (genre_id,publication_id,author_id,title,date_of_publication,language,price,photo) values"
					+ "("+gen+","+pub+","+auth+",'"+title+"','"+publication_date+"','"+language+"',"+pr+",'"+filePath+"')";
			int i=Manager.setDetails(str);
				
		if(i>0)
		{
			request.setAttribute("msg","Books Details are Successfully Saved!!");
			request.getRequestDispatcher("addBooks.jsp").forward(request, response);
		}
		   // System.out.println(genId);
		   // System.out.print("File Path:"+filePath);
			//System.out.println("gen id:"+genId+"Pubb id:"+pub_id+"auth_id:"+auth_id+"title:"+title+"publ dte:"+publication_date+"lang"+language);
	//request.setAttribute("st",st);
	//request.getRequestDispatcher("NewFile.jsp").forward(request,response);
	}

}
