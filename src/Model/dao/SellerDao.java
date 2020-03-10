package Model.dao;

import ModelEntities.Seller;

import java.util.List;

public interface SellerDao {

    /*
   Função que ira inserir algum seller no DB
    */
    void insert(Seller obj);

    /*
    Função que ira atualizar algum seller no DB
     */
    void update(Seller obj);

    /*
    Função que ira deletar um seller no DB por id
     */
    void deleteById(Integer id);

    /*
    Função que ira listar um seller por id
     */
    Seller findById(Integer id);

    /*
    Função que ira listar todos os seller
     */
    List<Seller> findAll();
}
