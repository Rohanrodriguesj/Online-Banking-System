import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class PayinReport extends HttpServlet
{
Connection cn;
Statement st;
ResultSet rs;
int acn;
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
	pw.println("<html><title>Payin Reports</title><body>");
	pw.println("<p align=center><b><font size=5 face=Arial>PAYIN - REPORTS</font></b></p><hr>");
	pw.println("<p align=center>&nbsp;</p><p align=center>&nbsp;</p>");
	pw.println("<form method=POST action=http://localhost:8080/examples/servlet/PayinReport>");
	pw.println("<p align=center><b><font face=Bookman Old Style>Enter the Account Number</font></b></p>");
	pw.println("<p align=center><input type=text name=T1 size=20></p>");
	pw.println("<p align=center><input type=submit value=Submit name=B1><input type=reset value=Reset name=B2></p>");
	pw.println("</form><p align=center>&nbsp;</p><p align=center>&nbsp;</p></body></html>");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
	PrintWriter pw=res.getWriter();
	acn=Integer.parseInt(req.getParameter("T1"));
	pw.println("<html>");
	pw.println("<body>");
	pw.println("<center>");
	pw.println("<table border=3 cellpadding=7 cellspacing=7>");
	pw.println("<tr><th>Account No</th><th>Payin Date</th><th>Payin Amount</th></tr>");
		try
		{
		rs=st.executeQuery("select *from payin where acn="+acn);
			while(rs.next())
			{
			pw.println("<tr><td>");
			pw.println(rs.getString(1));
			pw.println("</td><td>");
			pw.println(rs.getString(2));
			pw.println("</td><td>");
			pw.println(rs.getString(3));
			pw.println("</td></tr>");
			}
		}catch(Exception e2){}
	pw.println("</table><a href=http://localhost:8080/examples/servlet/DashBoard>");
	pw.println("Back");
	pw.println("</body></html>");

	}
}