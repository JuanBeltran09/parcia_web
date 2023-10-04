package persistence;

import com.example.proyectoweb.logic.Activity;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO implements InterfaceDAO<Activity>{
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/uptc?allowPublicKeyRetrieval=true&useSSL=false";
    private final String USER = "userUptc";
    private final String PASSWORD = "1234";

    @Override
    public List findAll() {
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){


            e.printStackTrace();
        }

        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "SELECT * FROM actividades";
            ResultSet rs = statement.executeQuery( query );
            List<Activity> list = new ArrayList<>();

            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("nombre");
                String type = rs.getString("tipo");
                Date aux = rs.getDate("fecha");
                LocalDate date = aux.toLocalDate();
                Double percentage = rs.getDouble("ponderado");

                list.add( new Activity(id,name,type,date,percentage) );
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Activity findById(Integer idFind) {
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            String errorMessage = "Error al realizar la operación en la base de datos.";
            throw new RuntimeException(errorMessage,e);
        }

        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "SELECT * FROM actividades WHERE id='" + idFind + "'";
            ResultSet rs = statement.executeQuery( query );
            Activity activity = null;

            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("nombre");
                String type = rs.getString("tipo");
                Date aux = rs.getDate("fecha");
                LocalDate date = aux.toLocalDate();
                Double percentage = rs.getDouble("ponderado");

                activity = new Activity(id,name,type,date,percentage);
            }

            return activity;
        } catch (SQLException e) {
            String errorMessage = "Error al realizar la operación en la base de datos.";
            throw new RuntimeException(errorMessage,e);
        }
    }

    @Override
    public boolean add(Activity activity) {

        String id = String.valueOf(activity.getId());
        String name = activity.getName();
        String type = activity.getType();
        String date = activity.getDate().toString();
        String percentage = String.valueOf(activity.getPercentage());

        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "INSERT INTO asignaturas  VALUES('" + id + "','" + name  + "')";

            int rows = statement.executeUpdate( query );

            return rows > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Activity update(Activity object) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}