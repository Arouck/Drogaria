package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import dao.EstadoDAO;
import domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private EstadoDAO estadoDAO;
	private List<Estado> estados;

	public void salvar() {
		try {
			estadoDAO.salvar(estado);
			
			instanciarEstado();
			carregarLista();
			
			Messages.addGlobalInfo("Salvo com sucesso");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o elemento.");
			ex.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		estadoDAO.excluir(estado.getCodigo());
		
		carregarLista();
		
		Messages.addGlobalInfo("Excluído com sucesso.");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o elemento.");
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void carregarLista() {
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
	
	public void instanciarEstado() {
		estado = new Estado();
	}
	
	public void instanciarEstadoDAO() {
		estadoDAO = new EstadoDAO();
	}
	
	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}
}
