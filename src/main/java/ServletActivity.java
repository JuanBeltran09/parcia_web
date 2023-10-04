import com.example.proyectoweb.logic.Activity;
import com.example.proyectoweb.logic.Subject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.ActivityDAO;
import persistence.SubjectDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ServletActivity", value = "/servlet-activity")
public class ServletActivity extends HttpServlet {

    private ActivityDAO stDAO;

    @Override
    public void init() throws ServletException {
        stDAO = new ActivityDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        List<Activity> activities = stDAO.findAll();


        PrintWriter out = response.getWriter();
        out.println( gson.toJson( activities ));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}