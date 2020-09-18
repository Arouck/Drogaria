package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import dao.FabricanteDAO;
import domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	
	public void salvar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricante);
			
			Messages.addGlobalInfo("Fabricante salvo com suceso");
			
			instanciar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o fabricante");
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void carregarLista() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os fabricantes");
			ex.printStackTrace();
		}
	}

	public void instanciar() {
		fabricante = new Fabricante();
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

}
