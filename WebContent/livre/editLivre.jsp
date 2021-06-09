<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ma.ensak.beans.Livre"%>
<%@ page import="ma.ensak.dao.LivreDao"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier Livre</title>
</head>
<body>
<%
	Livre livre = new Livre();
	LivreDao dao = new LivreDao();
%>
<form method="POST" action='LivreHandler' name="formEditLivre">
<input type="hidden" name="action" value="edit" />
<%
 	String numero = request.getParameter("numero");
 	if (!((numero) == null)) {
 		int id = Integer.parseInt(numero);
 		livre = dao.getLivreById(id);
 %>
<table>
	<tr>
		<td>numero</td>
		<td><input type="text" name="numero" readonly="readonly"
			value="<%=livre.getNumero()%>"/></td>
	</tr>
	<tr>
		<td>titre</td>
		<td><input type="text" name="titre" value="<%=livre.getTitre()%>" /></td>
	</tr>
	<tr>
		<td>numero_edition</td>
		<td><input type="text" name="numero_edition" value="<%=livre.getNumero_edition()%>" /></td>
	</tr>
	<tr>
		<td>date_apparition</td>
		<td><input type="text" name="date_apparition" value="<%=new SimpleDateFormat("dd/MM/yyyy").format(livre.getDate_apparition())%>" /></td>
	</tr>
	<tr>
		<td>stock</td>
		<td><input type="text" name="stock" value="<%=livre.getStock()%>" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update" /></td>
	</tr>
</table>
<%
	} else
		out.println("Numero Not Found");
%>
</form>
</body>
</html>