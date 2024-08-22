import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class NewAccount extends HttpServlet
{
int d1,d7;
String d2,d3,d4,d5,d6,d8;
Connection cn;
Statement st;
ResultSet rs;
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
	pw.println("<html><title>New Account Opening</title><body bgcolor=#808080>");
	pw.println("<p align=center><b><font color=#FFFFFF face=Bookman Old Style size=6>");
	pw.println("ONLINE BANKING SYSTEM");
	pw.println("</font></b></p><hr>");
	pw.println("<p align=center><b><font face=Arial size=5 color=#FFFFFF>New Account Opening</font></b></p><form method=POST action=><div align=center><center>");
	pw.println("<table border=3 cellpadding=8 cellspacing=8 style=border-collapse: collapse bordercolor=#111111 width=61%>");
	pw.println("<tr><td width=50%>Account No</td><td width=50% align=center><input type=text name=T1 size=25></td></tr>");
	pw.println("<tr><td width=50%>Account Holder's Name</td><td width=50% align=center><input type=text name=T2 size=25></td></tr>");
	pw.println("<tr><td width=50%>Address Field 1</td><td width=50% align=center><input type=text name=T3 size=25></td></tr>");
	pw.println("<tr><td width=50%>Address Field 2</td><td width=50% align=center><input type=text name=T4 size=25></td></tr>");
	pw.println("<tr><td width=50%>Account Type</td><td width=50% align=center><input type=text name=T5 size=25></td></tr>");
	pw.println("<tr><td width=50%>Opening Date</td><td width=50% align=center><input type=text name=T6 size=25></td></tr>");
	pw.println("<tr><td width=50%>Opening Amount</td><td width=50% align=center><input type=text name=T7 size=25></td></tr>");
	pw.println("<tr><td width=50%>Remarks</td><td width=50% align=center><input type=text name=T8 size=25></td></tr>");
	pw.println("<tr><td width=100% colspan=2><p align=center><input type=submit value=Submit name=B1><input type=reset value=Reset name=B2></td></tr>");
	pw.println("</table></center></div></form><hr></body></html>");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
	PrintWriter pw=res.getWriter();
	d1=Integer.parseInt(req.getParameter("T1"));
	d2=req.getParameter("T2");
	d3=req.getParameter("T3");
	d4=req.getParameter("T4");
	d5=req.getParameter("T5");
	d6=req.getParameter("T6");
	d7=Integer.parseInt(req.getParameter("T7"));
	d8=req.getParameter("T8");
		try
		{
		rs=st.executeQuery("insert into newac values("+d1+",'"+d2+"','"+d3+"','"+d4+"','"+d5+"','"+d6+"',"+d7+",'"+d6+"',"+d7+",'"+d8+"')");
		}catch(Exception e2){}
	res.sendRedirect("http://localhost:8080/examples/servlet/BankHome");
	}
}
