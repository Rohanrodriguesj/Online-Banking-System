import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BankHome extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
	PrintWriter pw=res.getWriter();
	pw.println("<html><title>Home Page</title><body bgcolor=#808080>");
	pw.println("<p align=center><b><font color=#FFFFFF face=Bookman Old Style size=6>");
	pw.println("ONLINE BANKING SYSTEM</font></b></p><hr><p align=center>&nbsp;</p>");
	pw.println("<p align=center><font color=#FFFFFF size=5 face=Arial><b>ONLINE BANKING ");
	pw.println("MANAGEMENT SYSTEMS</b></font></p>");
	pw.println("<p align=left><font face=Arial size=4 color=#FFFFFF><b>- New Account</b></font></p>");
	pw.println("<p align=left><font face=Arial size=4 color=#FFFFFF><b>- Payin</b></font></p>");
	pw.println("<p align=left><font face=Arial size=4 color=#FFFFFF><b>- Withdrawl</b></font></p>");
	pw.println("<p align=left><font face=Arial size=4 color=#FFFFFF><b>- Reports</b></font></p>");
	pw.println("<p align=left>&nbsp;</p><hr><p align=center>&nbsp;</p><p align=center>");
	pw.println("<a href=http://localhost:8080/examples/servlet/DashBoard>");
	pw.println("<button>Dashboard</button></a></p>");
	pw.println("</body></html>");
	}
}
