package emilia.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/req02")
public class Demo1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
          }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.请求行
        // 获取请求方式
        String method = req.getMethod();
        System.out.println("method = " + method);

        // 获取虚拟目录
        System.out.println("ContextPath() = " + req.getContextPath());

        // URL
        System.out.println("URL() = " + req.getRequestURL());

        // URI
        System.out.println("URI() = " + req.getRequestURI());

        // 获取请求方式
        System.out.println("QueryString() = " + req.getQueryString());

        //2.请求头
        // key:value的形式,



        //3.请求体


        //1.响应行


    }


    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
    }
}
