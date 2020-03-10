package Application;

import Db.*;
import Db.DbIntegrityException;
import ModelEntities.Department;

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

        /*INSERE DADOS NO DB
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = Db.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) values"
                                                            + "(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "João Carvalho");
            preparedStatement.setString(2,"joao@hotmail.com");
            preparedStatement.setDate(3, new java.sql.Date(sd.parse("18/07/2000").getTime()));
            preparedStatement.setDouble(4, 5000.0);
            preparedStatement.setInt(5, 1);


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
        */

        /*ATUALIZA DADOS NO DB
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = Db.getConnection();

            preparedStatement = conn.prepareStatement("UPDATE seller SET BaseSalary = BaseSalary + ? WHERE (DepartmentId = ?)");
            preparedStatement.setDouble(1, 1500.0);
            preparedStatement.setInt(2, 2);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Rows affected: " + rowsAffected);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            Db.closeStatament(preparedStatement);
            Db.closeConnection();
        }*/

        /*DELETA DADOS DE UM DB
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = Db.getConnection();

            preparedStatement = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
            preparedStatement.setInt(1,2);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Rows affected: " + rowsAffected);
        }catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }finally{
            Db.closeStatament(preparedStatement);
            Db.closeConnection();
        }*/

        /*CONCEITO DE TRANSAÇÕES NO DB
        Connection conn = null;
        Statement statement = null;
        try{
            conn = Db.getConnection();

            conn.setAutoCommit(false);

            statement = conn.createStatement();

            int rows1 = statement.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            int rows2 = statement.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("Rows1: " + rows1);
            System.out.println("Rows2: " + rows2);

        }catch (SQLException e){
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            }catch (SQLException e1){
                throw new DbException("Error trying to rollack!! Caused by: " + e1.getMessage());
            }
        }finally{
            Db.closeStatament(statement);
            Db.closeConnection();
        }*/

        Department obj = new Department(1, "Books");
        System.out.println(obj);

    }
}
