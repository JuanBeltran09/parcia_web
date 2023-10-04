import com.example.proyectoweb.logic.Activity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.ActivityDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


@WebServlet(name = "ServletSendActivity", value = "/add-activity")
public class ServletSendActivity extends HttpServlet {
    private ActivityDAO stDAO;

    @Override
    public void init() throws ServletException {
        stDAO = new ActivityDAO();
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

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nombre");
        String type = request.getParameter("tipo");
        String date = request.getParameter("fechaInicio");
        String[] aux = date.split("-");
        int year = Integer.parseInt( aux[0]);
        int month = Integer.parseInt( aux[1]);
        int day = Integer.parseInt( aux[2]);
        LocalDate btd = LocalDate.of( year,month,day);
        Double ponderado = Double.parseDouble(request.getParameter("ponderado"));

        Activity activity = new Activity( id, name, type, btd, ponderado);

        try(
                PrintWriter out = response.getWriter();
        ){
            if( stDAO.add(activity) ){
                out.println(gson.toJson(activity));
            }else{
                out.println(gson.toJson( null ));
            }
        }
    }
}