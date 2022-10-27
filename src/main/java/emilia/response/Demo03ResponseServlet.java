package emilia.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(value = "/response3")
public class Demo03ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //字节输出流
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\emilia\\Dropbox\\emilia\\java\\emiliaProjects\\web-request-response\\src\\main\\webapp\\imgs\\reg_bg_min.jpg"));
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(bis,outputStream);
    }
}
