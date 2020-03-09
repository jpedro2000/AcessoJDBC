package Application;

import Db.Db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args){

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
        }

    }
}
