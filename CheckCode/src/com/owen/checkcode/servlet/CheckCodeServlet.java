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

		String userName = request.getParameter("userName"); // �˺�
		String userCode = request.getParameter("userCode"); // �������֤��

		
		/*	��ȡϵͳ���ɵ���֤�룬ͬʱ�Ƴ���	*/
		String verificationCode = (String) session.getAttribute("checkcode_inSession");
		session.removeAttribute("checkcode_inSession");


		/*	��֤����ȷ�Ž����˻���Ϣ���	*/
		
		// ��֤�����
		if (!userCode.equals(verificationCode))
		{
			session.setAttribute("loginError", "��֤�����");
			response.sendRedirect("login.jsp");
		} 
		else
		{			
			// �˺Ŵ���,�˴�Ҳ����ͨ��js���кϷ��Լ��
			if (userName!=null && userName!="")
			{
				// ��¼�ɹ�
				if (userName.equals("admin"))
				{
					//�ѵ�¼�ɹ����û���Ϣ�����session��
					session.setAttribute("UserInfoSession", userName);
					response.sendRedirect("main.jsp");
				}
				// ��¼ʧ�ܣ��˺���Ϣ����
				else
				{
					session.setAttribute("loginError", "�˺���Ϣ����");
					response.sendRedirect("login.jsp");
				}			
			}
		}
	}
}
