

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "/out.jsp";
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		if(fname == "")
		{
			request.setAttribute("fname_err", "Please enter a name");
			next = "/main.jsp";
		}
		
		if(lname == "")
		{
			request.setAttribute("lname_err", "Please enter a name");
			next = "/main.jsp";
		}
	
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
		
		dispatch.forward(request, response);
	}
}
