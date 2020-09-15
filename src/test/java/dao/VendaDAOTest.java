package dao;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import domain.Venda;
import domain.Cliente;
import domain.Funcionario;

public class VendaDAOTest {
	
	private ClienteDAO clienteDAO;
	private FuncionarioDAO funcionarioDAO;
	private VendaDAO vendaDAO;

	@Before
	public void setUp() throws Exception {
		clienteDAO = new ClienteDAO();
		funcionarioDAO = new FuncionarioDAO();
		vendaDAO = new VendaDAO();
	}

	@Test
	@Ignore
	public void salvar() {
		Cliente cliente = clienteDAO.buscar(1L);
		Funcionario funcionario = funcionarioDAO.buscar(2L);
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setPrecoTotal(new BigDecimal("100.73"));
		
		vendaDAO.salvar(venda);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		List<Venda> vendas = vendaDAO.listar();
		
		for(Venda venda : vendas) {
			System.out.println(venda.toString());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Venda venda = vendaDAO.buscar(2L);
		if(venda == null) {
			fail("Venda não encontrada. Código inválido.");
		}
		System.out.println(venda.toString());
	}
	
	@Test
	@Ignore
	public void excluir() {
		Venda venda = vendaDAO.buscar(2L);
		if(venda == null) {
			fail("Venda não encontrada. Código inválido.");
		}

		vendaDAO.excluir(venda.getCodigo());
	}
	
	@Test
	public void editar() {
		Venda venda = vendaDAO.buscar(3L);
		if(venda == null) {
			fail("Venda não encontrada. Código inválido.");
		}
		
		venda.setHorario(new Date());
		vendaDAO.editar(venda);
	}
}
