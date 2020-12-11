package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//定义当前类为Servlet（服务端java代码提供的http服务）
//服务路径必须以/开头，否则tomcat启动就会报错
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //响应头Content-Type，告诉对端响应体的解析方式
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.printf("username=%s,password=%s%n", username, password);

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
