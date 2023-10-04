package persistence;

import com.example.proyectoweb.logic.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO implements InterfaceDAO<Subject>{
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
            String query = "SELECT * FROM asignaturas";
            ResultSet rs = statement.executeQuery( query );
            List<Subject> list = new ArrayList<>();

            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("nombre");

                list.add( new Subject(id,name) );
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Subject findById(Integer idFind) {
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
            String query = "SELECT * FROM asignaturas WHERE id='" + idFind + "'";
            ResultSet rs = statement.executeQuery( query );
            Subject subject = null;

            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("nombre");

                subject = new Subject(id,name);
            }

            return subject;
        } catch (SQLException e) {
            String errorMessage = "Error al realizar la operación en la base de datos.";
            throw new RuntimeException(errorMessage,e);
        }
    }

    @Override
    public boolean add(Subject subject) {

        String id = String.valueOf(subject.getId());

        String name = subject.getName();

        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "INSERT INTO asignaturas VALUES('" + id + "','" + name  + "')";

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
    public Subject update(Subject object) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}