import com.example.proyectoweb.logic.Subject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.SubjectDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


@WebServlet(name = "ServletSendActivity", value = "/add-activity")
public class ServletSendActivity extends HttpServlet {
    private SubjectDAO stDAO;

    @Override
    public void init() throws ServletException {
        stDAO = new SubjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        Integer id = Integer.parseInt(request.getParameter("idSubject"));
        String name = request.getParameter("name");
        Subject subject = new Subject( id, name);

        try(
                PrintWriter out = response.getWriter();
        ){
            if( stDAO.add( subject) ){
                out.println(gson.toJson(subject));
            }else{
                out.println(gson.toJson( null ));
            }
        }
    }
}