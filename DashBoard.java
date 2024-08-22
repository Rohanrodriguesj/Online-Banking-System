import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DashBoard extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
	PrintWriter pw=res.getWriter();
	pw.println("<html><title>Dash Board</title></head><body bgcolor=#808080>");
	pw.println("<p align=center><b><font color=#FFFFFF face=Bookman Old Style size=6>");
	pw.println("ONLINE BANKING SYSTEM</font></b></p><hr>");
	pw.println("<p align=center><b><font face=Arial size=5 color=#FFFFFF>DASH BOARD</font></b></p>");
	pw.println("<p align=left><a href=http://localhost:8080/examples/servlet/NewAccount>");
	pw.println("<button>new-account</button></a></p>");
	pw.println("<p align=left><a href=http://localhost:8080/examples/servlet/Payin>");
	pw.println("<button>payin</button></a></p>");
	pw.println("<p align=left><a href=http://localhost:8080/examples/servlet/Withdrawl>");
	pw.println("<button>withdrawl</button>< width=210 height=60></a></p>");
	pw.println("<p align=left><a href=http://localhost:8080/examples/servlet/PayinReport>");
	pw.println("<button>reports</button>< width=210 height=60></a></p>");
	pw.println("<p align=left>&nbsp;</p><hr></body></html>");
	}
}