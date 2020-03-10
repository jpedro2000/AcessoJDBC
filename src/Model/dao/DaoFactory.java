package Model.dao;

import Model.dao.Impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }

}
