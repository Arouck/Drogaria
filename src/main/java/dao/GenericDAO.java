package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import util.EntityManagerUtil;

public class GenericDAO<Entidade> {

	private EntityManager em;
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		instanciarEm();
	}
	
	public void salvar(Entidade entidade) {
		try {
			if(!em.isOpen()) {
				instanciarEm();
			}
			abrirSessao();
			em.persist(entidade);
			fazerCommmit();
		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				fazerRollback();
			}
			throw ex;
		} finally {
			fecharSessao();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){
		try {
			if(!em.isOpen()) {
				instanciarEm();
			}
			abrirSessao();
			List<Entidade> lista = em.createQuery("FROM " + classe.getName()).getResultList();
			return lista;
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			fecharSessao();
		}
	}
	
	public Entidade buscar(Long codigo){
		try {
			if(!em.isOpen()) {
				instanciarEm();
			}
			abrirSessao();
			Entidade entidade = em.find(classe, codigo);
			return entidade;
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			fecharSessao();
		}
	}
	
	public void excluir(Long codigo) {
		try {
			if(!em.isOpen()) {
				instanciarEm();
			}
			abrirSessao();
			em.remove(em.getReference(classe, codigo));
			fazerCommmit();
		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				fazerRollback();
			}
			throw ex;
		} finally {
			fecharSessao();
		}
	}
	
	public void editar(Entidade entidade) {
		try {
			if(!em.isOpen()) {
				instanciarEm();
			}
			abrirSessao();
			em.merge(entidade);
			fazerCommmit();
		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				fazerRollback();
			}
			throw ex;
		} finally {
			fecharSessao();
		}
	}
	
	public void merge(Entidade entidade) {
		try {
			if(!em.isOpen()) {
				instanciarEm();
			}
			abrirSessao();
			em.merge(entidade);
			fazerCommmit();
		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				fazerRollback();
			}
			throw ex;
		} finally {
			fecharSessao();
		}
	}
	
	public void abrirSessao() {
		em.getTransaction().begin();
	}
	
	public void fazerCommmit() {
		em.getTransaction().commit();
	}
	
	public void fecharSessao() {
		em.close();
	}
	
	public void fazerRollback() {
		em.getTransaction().rollback();
	}
	
	public void instanciarEm() {
		setEm(EntityManagerUtil.getEntityManager());
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
