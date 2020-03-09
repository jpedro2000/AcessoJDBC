package Application;

import Db.Db;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args){

        /*RECUPERAR DADOS DO DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{

            conn = Db.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("select * from department");

            while (resultSet.next()){
                System.out.println(resultSet.getInt("Id") + " -> " + resultSet.getString("Name"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Db.closeResultSet(resultSet);
            Db.closeStatament(statement);
            Db.closeConnection();
        }*/

        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = Db.getConnection();
            /*preparedStatement = connection.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) values"
                                                            + "(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "João Carvalho");
            preparedStatement.setString(2,"joao@hotmail.com");
            preparedStatement.setDate(3, new java.sql.Date(sd.parse("18/07/2000").getTime()));
            preparedStatement.setDouble(4, 5000.0);
            preparedStatement.setInt(5, 1);
            */

            preparedStatement = connection.prepareStatement("INSERT INTO department (Name) values ('D1'), ('D2')",
                                                            Statement.RETURN_GENERATED_KEYS);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected = " + rowsAffected);

            if(rowsAffected > 0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    System.out.println("Id = " + id);
                }
            }else{
                System.out.println("No rows affected");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            Db.closeStatament(preparedStatement);
            Db.closeConnection();
        }
    }
}
