package dao;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import domain.Cliente;
import domain.Pessoa;

public class ClienteDAOTest {
	
	private ClienteDAO clienteDAO;
	private PessoaDAO pessoaDAO;

	@Before
	public void setUp() throws Exception {
		clienteDAO = new ClienteDAO();
		pessoaDAO = new PessoaDAO();
	}

	@Test
	@Ignore
	public void salvar() {
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		Cliente cliente = new Cliente();
		cliente.setData(new Date());
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);
		
		clienteDAO.salvar(cliente);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		List<Cliente> clientes = clienteDAO.listar();
		
		for(Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Cliente cliente = clienteDAO.buscar(1L);
		if(cliente == null) {
			fail("Cliente não encontrada. Código inválido.");
		}
		System.out.println(cliente.toString());
	}
	
	@Test
	public void excluir() {
		Cliente cliente = clienteDAO.buscar(3L);
		if(cliente == null) {
			fail("Cliente não encontrada. Código inválido.");
		}

		clienteDAO.excluir(cliente.getCodigo());
	}
	
	@Test
	@Ignore
	public void editar() {
		Cliente cliente = clienteDAO.buscar(3L);
		if(cliente == null) {
			fail("Cliente não encontrada. Código inválido.");
		}
		cliente.setLiberado(false);

		clienteDAO.editar(cliente);
	}
}
