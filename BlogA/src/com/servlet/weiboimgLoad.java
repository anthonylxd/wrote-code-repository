package com.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.fabric.xmlrpc.base.Array;
import com.service.usersetingService;
import com.service.weiboImgService;
import com.tool.CommonConst;


/**
 * Servlet implementation class weiboimgLoad
 */
@WebServlet("/weiboimgLoad")
@MultipartConfig
public class weiboimgLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public weiboimgLoad() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		//路径
		String order = request.getParameter("order");
		String path;
		if(order == "weibo") {
		path = CommonConst.weiboImg;
		}else{
		path = CommonConst.headImg;	
		}
		int imglength = Integer.valueOf(request.getParameter("imgsize"));		
		OutputStream out = null;
	    InputStream filecontent = null;
	    PrintWriter writer = response.getWriter();
	    //暂时的
	    int userId = 1;
	    int imgIds[] = new int[imglength];
	    try {
			for(int i = 0; i< imglength; i++){
				Part filePart = request.getPart("file"+i);
				//设置文件名
				String fileName = getFileName(filePart);
				String fileLast = fileName.substring(fileName.lastIndexOf("."));
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式
				String date = df.format(new Date());					
				fileName = userId + date + fileLast;
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();
	        int read = 0;
	        final byte[] bytes = new byte[1024];
	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        if(order == "weibo") {
	        weiboImgService weiboImgService = new weiboImgService();
	        int imgId = weiboImgService.insert(fileName,userId);
	        imgIds[i] = imgId;
			System.out.println("图片上传Id"+Arrays.toString(imgIds).substring(1,imglength*3-1).replace(" ",""));
			writer.print(Arrays.toString(imgIds).substring(1,Arrays.toString(imgIds).length()-1).replace(" ",""));
	        }else{
	        weiboImgService weiboImgService = new weiboImgService();
	        int imgId = weiboImgService.insert(fileName,userId);
	        usersetingService usersetingService = new usersetingService();
	        usersetingService.headImgUpdate(userId, imgId);
	        writer.print(imgId);
	        }
			}
//	        writer.println("New file " + fileName + " created at " + path);

	    } catch (FileNotFoundException fne) {
//	        writer.println("You either did not specify a file to upload or are "
//	                + "trying to upload a file to a protected or nonexistent "
//	                + "location.");
//	        writer.println("<br/> ERROR: " + fne.getMessage());
	    	writer.println("0");//异常
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	        if (writer != null) {
	            writer.close();
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
	
	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	   // LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

}
