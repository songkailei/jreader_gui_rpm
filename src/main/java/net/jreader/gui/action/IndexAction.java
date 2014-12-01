package net.jreader.gui.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jreader.dao.IndexDao;
import net.jreader.dao.bean.TestBean;

public class IndexAction extends HttpServlet {

	/**
	 * @author song
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IndexDao dao = new IndexDao();
		List<TestBean> list = dao.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
