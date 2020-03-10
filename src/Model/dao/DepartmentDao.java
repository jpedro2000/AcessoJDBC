package Model.dao;

import ModelEntities.Department;

import java.util.List;

public interface DepartmentDao {

    /*
    Função que ira inserir algum departamento no DB
     */
    void insert(Department obj);

    /*
    Função que ira atualizar algum departamento no DB
     */
    void update(Department obj);

    /*
    Função que ira deletar um departamento no DB por id
     */
    void deleteById(Integer id);

    /*
    Função que ira listar um departamento por id
     */
    Department findById(Integer id);

    /*
    Função que ira listar todos os departamentos
     */
    List<Department> findAll();


}
