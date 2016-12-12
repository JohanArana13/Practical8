package demo;

import model.BookDAO;
import model.BooksEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.*;

/**
 * Created by HaouJohan on 12/12/2016.
 */
@WebServlet(name = "BookCatalogServlet", urlPatterns = "/bookcatalog")
public class BookCatalogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            BookDAO database = new BookDAO();
            List<BooksEntity> list = database.getAllBook();
            request.setAttribute("books", list);
            getServletContext().getRequestDispatcher("/bookcatalog.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
