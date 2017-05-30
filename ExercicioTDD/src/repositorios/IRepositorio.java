package repositorios;

import java.util.List;

public interface IRepositorio<T> {
	
	public List<T> listar();
	
	public void cadastrar(T objeto);

}
