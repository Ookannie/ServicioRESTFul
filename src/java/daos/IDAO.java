/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import java.util.List;

/**
 *
 * @author
 */
public interface IDAO<T> {

    public T getById(int id);

    public List<T> getAll();

    public boolean create(T elemento);

    public boolean update(T elemento);

    public boolean delete(int id);
}
