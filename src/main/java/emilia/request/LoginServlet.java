package emilia.request;

import emilia.mapper.UserMapper;
import emilia.pojo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * 登录ing
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int i = checkUser(username, password);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset:uft-8");
        if(i==1){
            writer.write("登录成功,"+username+"欢迎来到海岛");
        }if(i==0){
            writer.write("拒绝您的访问");
        }

    }

    public int checkUser(String username, String password) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(inputStream);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUser(username, password);
        sqlSession.close();

        if (user != null) {
            return 1;//用户存在

        } else {
            return 0;//失败
        }

    }
}
