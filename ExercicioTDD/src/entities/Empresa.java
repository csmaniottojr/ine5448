package entities;
import java.util.ArrayList;


public class Empresa {
	
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Projeto> projetos;
	
	public Empresa() {
		funcionarios = new ArrayList<>();
		projetos = new ArrayList<>();
	}

	public Funcionario cadastrarFuncionario(String nome) {
		Funcionario func = new Funcionario(nome);
		funcionarios.add(func);
		return func;
	}

	public Projeto cadastrarProjeto(String nome) {
		Projeto projeto = new Projeto(nome);
		projetos.add(projeto);
		return projeto;
	}
	

}
