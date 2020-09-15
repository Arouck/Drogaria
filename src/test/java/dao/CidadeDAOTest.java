package dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import domain.Cidade;
import domain.Estado;

public class CidadeDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(4L);
		if(estado == null) {
			fail("Estado não encontrado. Código inválido.");
		}
		
		Cidade cidade = new Cidade();
		cidade.setNome("Altamira");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> cidades = cidadeDAO.listar();
		
		for(Cidade cidade : cidades) {
			System.out.println(cidade.toString());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		CidadeDAO  cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(4L);
		if(cidade == null) {
			fail("Cidade não encontrada. Código inválido.");
		}
		System.out.println(cidade.toString());
	}
	
	@Test
	@Ignore
	public void excluir() {
		CidadeDAO  cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(5L);
		if(cidade == null) {
			fail("Cidade não encontrada. Código inválido.");
		}

		cidadeDAO.excluir(cidade.getCodigo());
	}
	
	@Test
	public void editar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(3L);
		if(estado == null) {
			fail("Estado não encontrado. Código inválido.");
		}
		
		CidadeDAO  cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(7L);
		if(cidade == null) {
			fail("Cidade não encontrada. Código inválido.");
		}
		
		cidade.setNome("Porto Alegre");
		cidade.setEstado(estado);

		cidadeDAO.editar(cidade);
	}
}
