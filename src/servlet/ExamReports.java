package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.dbBean;
import Model.getDate;

/**
 * Servlet implementation class ExamReports
 */
@WebServlet("/ExamReports")
public class ExamReports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamReports() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/page.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String args =request.getParameter("args");
		String id =request.getParameter("id");
		System.out.println(args+"  "+id);
		dbBean record =getDate.getdata(args, id);
		if(record==null) {
		    response.setContentType("text/html; charset=UTF-8");
			String msg="<p>";
			msg+=args+"  "+id;
			msg+="<br>";
			msg+="データが見つかりません";
			msg+="</p>";
			response.getWriter().println(msg);
		}else {
			request.setAttribute("record", record);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/table.jsp");
			dispatcher.forward(request, response);
		}
	}

}
