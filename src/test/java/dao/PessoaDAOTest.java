package dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import domain.Cidade;
import domain.Pessoa;

public class PessoaDAOTest {

	private PessoaDAO pessoaDAO;
	private CidadeDAO cidadeDAO;

	@Before
	public void setUp() throws Exception {
		pessoaDAO = new PessoaDAO();
		cidadeDAO = new CidadeDAO();
	}

	@Test
	@Ignore
	public void salvar() {
		Cidade cidade = cidadeDAO.buscar(6L);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Pedro");
		pessoa.setBairro("-");
		pessoa.setCelular("-");
		pessoa.setCep("-");
		pessoa.setComplemento("-");
		pessoa.setCpf("-");
		pessoa.setEmail("-");
		pessoa.setNumero(new Short("-"));
		pessoa.setRg("-");
		pessoa.setRua("-");
		pessoa.setTelefone("-");
		pessoa.setCidade(cidade);
		
		pessoaDAO.salvar(pessoa);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		
		List<Pessoa> pessoas = pessoaDAO.listar();
		System.out.println("Tota de registros encontrados: " + pessoas.size());

		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.toString());
		}
		
	}
	
	@Test
	@Ignore
	public void buscar() {
		Pessoa pessoa = pessoaDAO.buscar(2L);
		if (pessoa == null) {
			fail("Pessoa não encontrada. Valor do código inválido");
		} else {
			System.out.println(pessoa.toString());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Pessoa pessoa = pessoaDAO.buscar(3L);
		if (pessoa == null) {
			fail("Pessoa não encontrado. Valor do código inválido");
		} else {
			pessoaDAO.excluir(pessoa.getCodigo());
		}
	}

	@Test
	public void editar() {
		Pessoa pessoa = pessoaDAO.buscar(2L);
		if (pessoa == null) {
			fail("Pessoa não encontrado. Valor do código inválido");
		} else {
			pessoa.setNome("Matheus");
			pessoaDAO.editar(pessoa);
		}
	}
}
