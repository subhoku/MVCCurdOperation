package com.codeo.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet{
  public static final int buffer_size=1024*1000; 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName=req.getParameter("fileName");
		String path=getServletContext().getRealPath("")+"imgs"+File.separator+fileName;
		System.out.println(path);
		File file=new File(path);
		OutputStream os=null;
		FileInputStream fis=null;
		resp.setHeader("Content-Disposition",String.format("attachment;filename=\"%s\"" , file.getName()));
		resp.setContentType("application/octet-stream");
		if(file.exists()) {
			os=resp.getOutputStream();
			fis=new FileInputStream(file);
			byte[] bytes=new byte[buffer_size];
			int byteRead=-1;
			while((byteRead=fis.read())!=-1) {
				os.write(bytes,0,byteRead);
			}
		}
		else {
			resp.setContentType("text/html");
			System.out.println("File Not found");
		}
		
	}

	
}
