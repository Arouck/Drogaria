package dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import domain.Estado;

public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		 Estado estado = new Estado();
		 
		 estado.setNome("Pará");
		 estado.setSigla("PA");
		 
		 EstadoDAO dao = new EstadoDAO();
		 dao.salvar(estado);
		 
	}
	
	@Test
	@Ignore
	public void listar() {
		EstadoDAO dao = new EstadoDAO();
		List<Estado> estados = dao.listar();
		System.out.println("Tota de registros encontrados: " + estados.size());

		for(Estado estado : estados) {
			System.out.println(estado.toString());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		EstadoDAO dao = new EstadoDAO();
		Estado estado = dao.buscar(4L);
		if(estado == null) {
			fail("Estado não encontrado. Valor do código inválido");
		} else {
			System.out.println(estado.toString());			
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		EstadoDAO dao = new EstadoDAO();
		Estado estado = dao.buscar(7L);
		if(estado == null) {
			fail("Estado não encontrado. Valor do código inválido");
		} else {
			dao.excluir(estado.getCodigo());
		}
	}
	
	@Test
	public void editar() {
		EstadoDAO dao = new EstadoDAO();
		Estado estado = dao.buscar(4L);
		if(estado == null) {
			fail("Estado não encontrado. Valor do código inválido");
		} else {
			estado.setNome("Acre");
			estado.setSigla("AC");
			dao.editar(estado);
		}
	}

}
