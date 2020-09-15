package dao;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import domain.ItemVenda;
import domain.Produto;
import domain.Venda;

public class ItemVendaDAOTest {

	private ItemVendaDAO itemVendaDAO;
	private ProdutoDAO produtoDAO;
	private VendaDAO vendaDAO;

	@Before
	public void setUp() throws Exception {
		itemVendaDAO = new ItemVendaDAO();
		produtoDAO = new ProdutoDAO();
		vendaDAO = new VendaDAO();
	}

	@Test
	@Ignore
	public void salvar() {
		Produto produto = produtoDAO.buscar(1L);
		Venda venda = vendaDAO.buscar(1L);

		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(new Short("8"));
		itemVenda.setValorParcial(new BigDecimal((Double.parseDouble(produto.getPreco().toString()))
				* Integer.parseInt(itemVenda.getQuantidade().toString())));
		itemVenda.setVenda(venda);

		itemVendaDAO.salvar(itemVenda);

	}

	@Test
	@Ignore
	public void listar() {

		List<ItemVenda> itemVendas = itemVendaDAO.listar();
		System.out.println("Tota de registros encontrados: " + itemVendas.size());

		for (ItemVenda itemVenda : itemVendas) {
			System.out.println(itemVenda.toString());
		}

	}

	@Test
	@Ignore
	public void buscar() {
		ItemVenda itemVenda = itemVendaDAO.buscar(2L);
		if (itemVenda == null) {
			fail("Item não encontrada. Valor do código inválido");
		} else {
			System.out.println(itemVenda.toString());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		ItemVenda itemVenda = itemVendaDAO.buscar(1L);
		if (itemVenda == null) {
			fail("Item não encontrado. Valor do código inválido");
		} else {
			itemVendaDAO.excluir(itemVenda.getCodigo());
		}
	}

	@Test
	public void editar() {
		ItemVenda itemVenda = itemVendaDAO.buscar(2L);
		Venda venda = vendaDAO.buscar(3L);
		if (itemVenda == null) {
			fail("Item não encontrado. Valor do código inválido");
		}
		itemVenda.setVenda(venda);
		itemVendaDAO.editar(itemVenda);
	}
}
