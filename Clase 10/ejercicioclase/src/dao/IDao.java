package dao;

import java.util.List;

public interface IDao<T> {
    T guardar(T t);
    T buscarPorCampo(String campo);
    List<T> buscarTodos();
}
