package demo;

import model.BookDAO;
import model.BooksEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by HaouJohan on 12/12/2016.
 */
@WebServlet(name = "BookDetailsServlet", urlPatterns = "/bookdetails")
public class BookDetailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String bookId = request.getParameter("bookId");
            if(bookId != null){
                BookDAO database = new BookDAO();
                BooksEntity bookEntity = database.getBookDetails(bookId);
                request.setAttribute("book", bookEntity);
                getServletContext().getRequestDispatcher("/bookdetails.jsp").forward(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
