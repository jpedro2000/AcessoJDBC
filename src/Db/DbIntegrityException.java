package Db;

public class DbIntegrityException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public DbIntegrityException(String msg){
        super(msg);
    }
}
