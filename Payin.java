import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Payin extends HttpServlet
{
Connection cn;
Statement st;
ResultSet rs;
int d1,d3;
String d2;
	public void init(ServletConfig config)throws ServletException
	{
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		cn=DriverManager.getConnection("jdbc:odbc:accdsn");
		st=cn.createStatement();
		}catch(Exception e1){}
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
	PrintWriter pw=res.getWriter();
	pw.println("<html><title>Payin </title><body bgcolor=#808080>");
	pw.println("<p align=center><b><font face=Bookman Old Style size=6 color=#FFFFFF>PAYIN</font></b></p>");
	pw.println("<hr><p align=center>&nbsp;</p><p align=center>&nbsp;</p>");
	pw.println("<form method=POST action=http://localhost:8080/examples/servlet/Payin><p align=center>");
	pw.println("<b><font face=Arial color=#FFFFFF>Account No</font></b></p>");
	pw.println("<p align=center><font face=Arial color=#FFFFFF><b>");
	pw.println("<input type=text name=T1 size=20></b></font></p><p align=center><b><font face=Arial color=#FFFFFF>Payin Date</font></b></p>");
	pw.println("<p align=center><font face=Arial color=#FFFFFF><b><input type=text name=T2 size=20></b></font></p>");
	pw.println("<p align=center><b><font face=Arial color=#FFFFFF>Payin Amount</font></b></p>");
	pw.println("<p align=center><input type=text name=T3 size=20></p><p align=center><input type=submit value=Submit name=B1><input type=reset value=Reset name=B2></p>");
	pw.println("</form><p align=center>&nbsp;</p><p align=center>&nbsp;</p><hr>");
	pw.println("<p align=center>&nbsp;</p><p align=center>&nbsp;</p></body></html>");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
	PrintWriter pw=res.getWriter();
	d1=Integer.parseInt(req.getParameter("T1"));
	d2=req.getParameter("T2");
	d3=Integer.parseInt(req.getParameter("T3"));
		try
		{
		rs=st.executeQuery("insert into payin values("+d1+",'"+d2+"',"+d3+")");
		}catch(Exception e2){}
		try
		{
		rs=st.executeQuery("update newac set trd="+d2+", cbl=cbl+"+d3+" where acn="+d1);
		}catch(Exception e3){}
	}
}