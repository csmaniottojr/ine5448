package repositorios.memoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import repositorios.IRepositorio;
import entidades.Funcionario;
import excecoes.FuncionarioJaCadastrado;

public class RepositorioFuncionarios implements IRepositorio<Funcionario>{
	
	List<Funcionario> funcionarios;
	
	public RepositorioFuncionarios() {
		funcionarios = new ArrayList<Funcionario>();
	}

	public List<Funcionario> listar() {
		return funcionarios;
	}

	public void cadastrar(Funcionario func) {
		if(funcionarios.contains(func)){
			throw new FuncionarioJaCadastrado("Funcionário " + func + " já cadastrado anteriormente");
		}
		funcionarios.add(func);		
	}

}
