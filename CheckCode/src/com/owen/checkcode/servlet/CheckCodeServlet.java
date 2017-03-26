package com.owen.checkcode.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * 
 * @author fiver_
 *
 */

@SuppressWarnings("serial")
public class CheckCodeServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();

		String userName = request.getParameter("userName"); // 账号
		String userCode = request.getParameter("userCode"); // 输入的验证码

		
		/*	获取系统生成的验证码，同时移除掉	*/
		String verificationCode = (String) session.getAttribute("checkcode_inSession");
		session.removeAttribute("checkcode_inSession");


		/*	验证码正确才进行账户信息检查	*/
		
		// 验证码错误
		if (!userCode.equals(verificationCode))
		{
			session.setAttribute("loginError", "验证码错误");
			response.sendRedirect("login.jsp");
		} 
		else
		{			
			// 账号存在,此处也可以通过js进行合法性检查
			if (userName!=null && userName!="")
			{
				// 登录成功
				if (userName.equals("admin"))
				{
					//把登录成功的用户信息存放在session中
					session.setAttribute("UserInfoSession", userName);
					response.sendRedirect("main.jsp");
				}
				// 登录失败，账号信息有误
				else
				{
					session.setAttribute("loginError", "账号信息有误");
					response.sendRedirect("login.jsp");
				}			
			}
		}
	}
}
