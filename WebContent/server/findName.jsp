<%@page import="net.sf.json.JSONObject"%>
<%@page import="review.emp.EmpDTO"%>
<%@page import="review.emp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//EmpDAO dao = EmpDAO.getInstance();
	int id = Integer.parseInt(request.getParameter("id"));
	EmpDTO dto = EmpDAO.getInstance().getEmp(id);
	out.print(JSONObject.fromObject(dto).toString());
	//List ==> "[      ]"
	//DTO, Map ==> "{       }"
%>

