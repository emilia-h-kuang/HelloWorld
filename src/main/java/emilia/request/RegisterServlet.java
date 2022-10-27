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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Integer i = checkUsername(username);

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset:uft-8");

        if(i==0){
            SqlSession sqlSession = sqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.add(username,password);
            sqlSession.commit();
            sqlSession.close();
            writer.write("注册成功");

        }else {
            writer.write("用户名已经存在");

        }
    }

    public static SqlSession sqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(inputStream);
        return build.openSession();
    }

    public Integer checkUsername(String username) throws IOException {

        SqlSession sqlSession = sqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUsername(username);
        sqlSession.close();

        if(user!=null){
            return 1;//用户名存在
        }else {
            return 0;//用户名不存在
        }

    }
}
