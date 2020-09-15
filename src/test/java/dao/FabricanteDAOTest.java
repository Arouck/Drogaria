package dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();

		fabricante.setNome("Bayern");
		Fabricante fabricante2 = new Fabricante();
		fabricante2.setNome("Bayern");
		Fabricante fabricante3 = new Fabricante();
		fabricante3.setNome("Bayern");

		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fabricante);
		dao.salvar(fabricante2);
		dao.salvar(fabricante3);

	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		System.out.println("Tota de registros encontrados: " + fabricantes.size());

		for (Fabricante fabricante : fabricantes) {
			System.out.println(fabricante.toString());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscar(11L);
		if (fabricante == null) {
			fail("Fabricante não encontrado. Valor do código inválido");
		} else {
			System.out.println(fabricante.toString());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscar(7L);
		if (fabricante == null) {
			fail("Fabricante não encontrado. Valor do código inválido");
		} else {
			dao.excluir(fabricante.getCodigo());
		}
	}

	@Test
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscar(5L);
		if (fabricante == null) {
			fail("Fabricante não encontrado. Valor do código inválido");
		} else {
			fabricante.setNome("EMS Corp");
			dao.editar(fabricante);
		}
	}

}
