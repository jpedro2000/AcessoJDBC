package Application;

import Db.Db;

import java.sql.Connection;

public class Program {
    public static void main(String[] args){
        Connection conn = Db.getConnection();
        Db.closeConnection();
    }
}
