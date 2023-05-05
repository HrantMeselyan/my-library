package com.example.authorBookServlet.servlet.book;

import com.example.authorBookServlet.constant.SharedConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/getImage")
public class GetImgServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String picName = req.getParameter("picName");

        File imageFile = new File(SharedConstants.UPLOAD_FOLDER + picName);
        if (imageFile.exists()) {
            try (FileInputStream inputStream = new FileInputStream(imageFile)) {
                OutputStream outputStream = resp.getOutputStream();
                resp.setContentType("image/jpeg");
                resp.setContentLength((int) imageFile.length());

                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
