package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import dao.CidadeDAO;
import domain.Cidade;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	
	private List<Cidade> cidades;
	private CidadeDAO cidadeDAO;
	
	@PostConstruct
	public void carregarLista() {
		try {
			if(cidadeDAO == null) {
				instanciarCidadeDAO();
			}
			cidades = cidadeDAO.listar();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as cidades");
			ex.printStackTrace();
		}
	}
	
	public void instanciarCidadeDAO() {
		cidadeDAO = new CidadeDAO();
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public CidadeDAO getCidadeDAO() {
		return cidadeDAO;
	}

	public void setCidadeDAO(CidadeDAO cidadeDAO) {
		this.cidadeDAO = cidadeDAO;
	}

}
