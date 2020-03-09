package Db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Db {

    private static Connection conn = null;

    /*
    Carrega as informações necessárias para se conectar ao DB
    @return uma variavel com as informações do arquivo
     */
    private static Properties loadProperties(){
        try(FileInputStream fileInputStream = new FileInputStream("Db.properties")){
            Properties props = new Properties();
            props.load(fileInputStream);
            return props;
        }catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }

    /*
    Pega uma conexão com o DB. Caso não existir uma, a conexão é criada
    @return a conexao com o banco
     */
    public static Connection getConnection(){
        if(conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    /*
    Fecha a conexão com o DB
     */
    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatament(Statement statement){
        if(statement != null){
            try{
                statement.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

}
