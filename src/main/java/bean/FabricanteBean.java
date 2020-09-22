package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import dao.FabricanteDAO;
import domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	private Fabricante fabricante;
	private FabricanteDAO fabricanteDAO;
	private List<Fabricante> fabricantes;
	
	public void salvar() {
		try {
			fabricanteDAO.merge(fabricante);
						
			instanciarFabricante();
			carregarLista();
			
			Messages.addGlobalInfo("Fabricante salvo com suceso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o fabricante");
			e.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
		fabricanteDAO.excluir(fabricante.getCodigo());
		
		carregarLista();
		
		Messages.addGlobalInfo("Excluído com sucesso.");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o elemento.");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
	}
	
	@PostConstruct
	public void carregarLista() {
		try {
			if(fabricanteDAO == null) {
				instanciarFabricanteDAO();			
			}
			fabricantes = fabricanteDAO.listar();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os fabricantes");
			ex.printStackTrace();
		}
	}

	public void instanciarFabricante() {
		fabricante = new Fabricante();
	}
	
	public void instanciarFabricanteDAO() {
		fabricanteDAO = new FabricanteDAO();	
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public FabricanteDAO getFabricanteDAO() {
		return fabricanteDAO;
	}

	public void setFabricanteDAO(FabricanteDAO fabricanteDAO) {
		this.fabricanteDAO = fabricanteDAO;
	}

}
