package com.netcracker.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dto.Employee;
import com.netcracker.service.EmployeeService;
import com.netcracker.service.EmployeeServiceImpl;


public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeService empService;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		empService=new EmployeeServiceImpl();
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String useraction=request.getParameter("action");
		if(useraction!=null) {
			switch(useraction) {
			case "DELETE":{
				int id=Integer.parseInt(request.getParameter("eid"));
				try {
					empService.deleteEmployeeById(id);
					response.sendRedirect("EmployeeHome.html");
					
				} catch (DatabaseException e) {
					request.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
				
			}
			break;
			
			case "ADD":{
				int id=Integer.parseInt(request.getParameter("eid"));
				String name=request.getParameter("name");
				float sal=Float.parseFloat(request.getParameter("salary"));
				Employee employee=new Employee(id, name, sal);
				try {
					empService.addEmployee(employee);
					response.sendRedirect("EmployeeHome.html");
				} catch (DatabaseException e) {
					request.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
			
			}
			break;
			
			case "SHOW":{
				Employee emp=null;
				int id=Integer.parseInt(request.getParameter("eid"));
				System.out.println(id);
				try {
					emp=empService.getEmployeeById(id);
					request.setAttribute("employee", emp);
					RequestDispatcher link=request.getRequestDispatcher("ShowEmployeeData.jsp");
					link.forward(request, response);
				} catch (DatabaseException e) {
					request.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
				
				
			}
			break;
			
			case "GETALL":{
				List<Employee> emp=new LinkedList<Employee>();
				try {
					emp=empService.getAllEmployee();
					request.setAttribute("list", emp);
					RequestDispatcher link=request.getRequestDispatcher("ShowAllEmployeeData.jsp");
					link.forward(request, response);
				} catch (DatabaseException e) {
					request.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
				
			}
			break;
			case "UPDATE":{
				int id=Integer.parseInt(request.getParameter("eid"));
				String name=request.getParameter("name");
				float sal=Float.parseFloat(request.getParameter("salary"));
				Employee employee=new Employee(id, name, sal);
				try {
					empService.updateEmployee(employee);
					response.sendRedirect("EmployeeHome.html");
				} catch (DatabaseException e) {
					request.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
			
				
			}
			break;
			default:{
				response.sendRedirect("EmployeeHome.html");
			}
			break;
			}
			
		}
		else {
			response.sendRedirect("EmployeeHome.html");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
