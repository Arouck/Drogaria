package dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import domain.Usuario;
import domain.Pessoa;

public class UsuarioDAOTest {
	
	private UsuarioDAO usuarioDAO;
	private PessoaDAO pessoaDAO;
	
	@Before
	public void setUp() throws Exception {
		usuarioDAO = new UsuarioDAO();
		pessoaDAO = new PessoaDAO();
	}

	@Test
	@Ignore
	public void salvar() {
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		if(pessoa == null) {
			fail("Pessoa não encontrada. Código inválido.");
		}
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setTipo('A');
		usuario.setSenha("123");
		
		usuarioDAO.salvar(usuario);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDAO.listar();
		
		for(Usuario usuario : usuarios) {
			System.out.println(usuario.toString());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Usuario usuario = usuarioDAO.buscar(2L);
		if(usuario == null) {
			fail("Usuario não encontrada. Código inválido.");
		}
		System.out.println(usuario.toString());
	}
	
	@Test
	@Ignore
	public void excluir() {
		Usuario usuario = usuarioDAO.buscar(2L);
		if(usuario == null) {
			fail("Usuario não encontrada. Código inválido.");
		}

		usuarioDAO.excluir(usuario.getCodigo());
	}
	
	@Test
	public void editar() {
		Usuario usuario = usuarioDAO.buscar(3L);
		if(usuario == null) {
			fail("Usuario não encontrada. Código inválido.");
		}
		usuario.setAtivo(false);

		usuarioDAO.editar(usuario);
	}
}
