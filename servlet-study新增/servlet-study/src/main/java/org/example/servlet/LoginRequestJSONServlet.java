package org.example.servlet;

import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

//定义当前类为Servlet（服务端java代码提供的http服务）
//服务路径必须以/开头，否则tomcat启动就会报错
@WebServlet("/loginRequestJSON")
public class LoginRequestJSONServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //响应头Content-Type，告诉对端响应体的解析方式
        resp.setContentType("text/html");

        //请求头使用Content-Type：applicaton/json时，请求数据格式为json字符串的格式
        InputStream is = req.getInputStream();//获取请求体数据
        //{"uername":"abc","password":"123"}
        //User类,private String username; private String password
        //User user = JSONUtil.deserialize(is,User.class);
        
        PrintWriter pw = resp.getWriter();
        //伪代码：用户登录的jdbc校验
        //作业：完成用户登录Servlet+JDBC的代码，返回数据是JSON格式的数据
        //if(;ojinDAO.query(username,password)) {
        //  pw.println("登录成功");
        // }else {
        //  pw.println("登录失败");
        // }
        pw.println("登录成功");
        pw.flush();
        pw.close();
    }
}
