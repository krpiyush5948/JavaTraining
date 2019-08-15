package com.imageRetrival;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

import org.omg.CORBA.portable.InputStream;

public class MainClass {
	
	
	public static BufferedImage rotate(BufferedImage img, int angle) {  
        int w = img.getWidth();  
        int h = img.getHeight();
        System.out.println(img.getType());
        BufferedImage dimg = new BufferedImage(w, h, img.getType());  
        Graphics2D g = dimg.createGraphics();  
        g.rotate(Math.toRadians(angle), w/2, h/2);  
        g.drawImage(img, null, 0, 0);  
        return dimg;  
    } 
	
	public static BufferedImage loadImage(String ref) {  
        BufferedImage bimg = null;  
        try {  
  
            bimg = ImageIO.read(new File(ref));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return bimg;  
    } 
	
	public static void saveImage(BufferedImage img, String ref) {  
	    try {  
	        String format = (ref.endsWith(".png")) ? "png" : "jpg";  
	        ImageIO.write(img, format, new File(ref));  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	} 

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String user = "postgres";
		String password = "Welcome@123";
		String url = "jdbc:postgresql://127.0.0.1/postgres";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
//		String sql = "create table images2(name varchar,img blob)";
//		Statement st = conn.createStatement();
//		st.execute(sql);
//		
//		String sql1 = "insert into images values(?,?)";
//		PreparedStatement stmt = conn.prepareStatement(sql1);
//		stmt.setString(1, "galaxy");
//		FileInputStream fin=new FileInputStream("D:\\galaxy.jpg");  
//		stmt.setBinaryStream(2,fin,fin.available());  
//		int i=stmt.executeUpdate();
//     	System.out.println("Rows affected "+i);
		
		PreparedStatement ps=conn.prepareStatement("select image from images where name ='eyes'");  
		
		FileOutputStream fos = new FileOutputStream("d:\\retrieve.jpg");
		ResultSet rs = ps.executeQuery( );
		        if (rs != null) {
		            while (rs.next()) {

		                byte[] fileBytes = new byte[1024];
		                java.io.InputStream is = rs.getBinaryStream("image");
		                while (is.read(fileBytes) > 0) {
		                    fos.write(fileBytes);
		                }

		            }
		            rs.close();
		        }
		saveImage(rotate(loadImage("d:\\retrieve.jpg"), 90), "d:\\retrieve.jpg");
	}

}
