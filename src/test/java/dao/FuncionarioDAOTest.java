package dao;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import domain.Funcionario;
import domain.Pessoa;

public class FuncionarioDAOTest {
	
	private FuncionarioDAO funcionarioDAO;
	private PessoaDAO pessoaDAO;
	
	@Before
	public void setUp() throws Exception {
		funcionarioDAO = new FuncionarioDAO();
		pessoaDAO = new PessoaDAO();
	}

	@Test
	public void salvar() throws ParseException {
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCarteiraDeTrabalho("0000000");
		funcionario.setDataDeAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("09/08/1998"));
		funcionario.setPessoa(pessoa);
		
		funcionarioDAO.salvar(funcionario);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		List<Funcionario> funcionarios = funcionarioDAO.listar();
		
		for(Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.toString());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Funcionario funcionario = funcionarioDAO.buscar(2L);
		if(funcionario == null) {
			fail("Funcionario não encontrada. Código inválido.");
		}
		System.out.println(funcionario.toString());
	}
	
	@Test
	@Ignore
	public void excluir() {
		Funcionario funcionario = funcionarioDAO.buscar(1L);
		if(funcionario == null) {
			fail("Funcionario não encontrada. Código inválido.");
		}

		funcionarioDAO.excluir(funcionario.getCodigo());
	}
	
	@Test
	@Ignore
	public void editar() {
		Funcionario funcionario = funcionarioDAO.buscar(1L);
		if(funcionario == null) {
			fail("Funcionario não encontrada. Código inválido.");
		}
		funcionario.setCarteiraDeTrabalho("22222");
		funcionarioDAO.editar(funcionario);
	}
}
