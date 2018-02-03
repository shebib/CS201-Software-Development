package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	String month = request.getParameter("favmonth");
    	String url = request.getParameter("favweb");
    	String search = request.getParameter("favsearch");
    	
    	String next = "/order.jsp";
    	if (name == "") {
    		request.setAttribute("name_err", "please enter your name");
    		next = "/form.jsp";
    	}
    	if (email == ""){
    		request.setAttribute("email_err", "please enter your email");
    		next = "/form.jsp";
    	}
    	if (month == "") {
    		request.setAttribute("month_err", "please fill in the month");
    		next = "/form.jsp";
    	}
    	if (url == ""){
    		request.setAttribute("url_err", "please fill in the url");
    		next = "/form.jsp";
    	}
    	if (search == ""){
    		request.setAttribute("search_err", "please fill the search section");
    		next = "/form.jsp";
    	}
    	
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
		
    	try {
    		dispatch.forward(request,response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
