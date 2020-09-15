package dao;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import domain.Fabricante;
import domain.Produto;

public class ProdutoDAOTest {
	
	private ProdutoDAO produtoDAO;
	private FabricanteDAO fabricanteDAO;

	@Before
	public void setUp() throws Exception {
		produtoDAO = new ProdutoDAO();
		fabricanteDAO = new FabricanteDAO();
	}

	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = fabricanteDAO.buscar(new Long("2"));
		
		Produto produto = new Produto();
		produto.setNome("Cataflan 50mg com 20 comprimidos");
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));
		produto.setFabricante(fabricante);
		
		produtoDAO.salvar(produto);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		
		List<Produto> produtos = produtoDAO.listar();
		System.out.println("Tota de registros encontrados: " + produtos.size());

		for (Produto produto : produtos) {
			System.out.println(produto.toString());
		}
		
	}
	
	@Test
	@Ignore
	public void buscar() {
		Produto produto = produtoDAO.buscar(5L);
		if (produto == null) {
			fail("Produto não encontrado. Valor do código inválido");
		} else {
			System.out.println(produto.toString());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Produto produto = produtoDAO.buscar(3L);
		if (produto == null) {
			fail("Produto não encontrado. Valor do código inválido");
		} else {
			produtoDAO.excluir(produto.getCodigo());
		}
	}

	@Test
	public void editar() {
		Produto produto = produtoDAO.buscar(5L);
		Fabricante fabricante = fabricanteDAO.buscar(1L);
		if (produto == null) {
			fail("Produto não encontrado. Valor do código inválido");
		} else {
			produto.setNome("Dorflex 50mg com 20 comprimidos");
			produto.setPreco(new BigDecimal("15.70"));
			produto.setQuantidade(new Short("20"));
			produto.setFabricante(fabricante);
			
			produtoDAO.editar(produto);
		}
	}

}
