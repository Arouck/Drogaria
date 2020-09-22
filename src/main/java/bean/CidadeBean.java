package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import dao.CidadeDAO;
import dao.EstadoDAO;
import domain.Cidade;
import domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	private Cidade cidade;
	private List<Cidade> cidades;
	private CidadeDAO cidadeDAO;
	private List<Estado> estados;
	private EstadoDAO estadoDAO;
	
	public void salvar() {
		try {
			cidadeDAO.merge(cidade);
			
			instanciarCidade();
			carregarListaCidades();
			
			Messages.addGlobalInfo("Salvo com sucesso.");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar salvar.");
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
		cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
		cidadeDAO.excluir(cidade.getCodigo());
		
		carregarListaCidades();
		
		Messages.addGlobalInfo("Excluído com sucesso.");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o elemento.");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
		carregarListaEstados();
	}
	
	@PostConstruct
	public void carregarListaCidades() {
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
	
	public void carregarListaEstados() {
		try {
			if(estadoDAO == null) {
				instanciarEstadoDAO();
			}
			estados = estadoDAO.listar();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados");
			ex.printStackTrace();
		}
	}
	
	public void instanciarCidade() {
		cidade = new Cidade();
		
		carregarListaEstados();
	}
	
	public void instanciarCidadeDAO() {
		cidadeDAO = new CidadeDAO();
	}
	
	public void instanciarEstadoDAO() {
		estadoDAO = new EstadoDAO();
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

}
