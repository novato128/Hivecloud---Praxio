package dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Transportadora;
import util.JpaUtil;
import util.ListaTransportadora;

public class TransportadoraDAOImpl implements TransportadoraDAO {

	private EntityManager em;
	private EntityTransaction et;
	
	List<Transportadora> transportadoras = ListaTransportadora.getInstance();
	
	
	@Override
	public boolean salvar(Transportadora transportadora) {
		transportadora.setId(getRandomNumberInRange(9, 100));
		this.transportadoras.add(transportadora);
		return true;
	}

	@Override
	public boolean alterar(Transportadora transportadora) {
		remover(pesquisar(transportadora.getId()));		
		this.transportadoras.add(transportadora);
		return true;
	}

	@Override
	public boolean remover(Transportadora transportadora) {
		this.transportadoras.remove(transportadora);
		return true;
	}

	@Override
	public Transportadora pesquisar(Integer idTransportadora) {
		Transportadora retorno = null;
		for (Transportadora transportadora : transportadoras) {
			if(transportadora.getId() == idTransportadora) {
				retorno = transportadora;
			}
		}
		return retorno;
	}

	@Override
	public List<Transportadora> listarTodos() {
		return this.transportadoras;
	}

	//=======================  Parte do JPA==========================
	
	public boolean salvarHibernate(Transportadora transportadora) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(transportadora);
			et.commit();
			return true;
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transação");
			return false;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	public boolean alterarHibernate(Transportadora transportadora) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(transportadora);
			et.commit();
			return true;
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transação");
			return false;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	public boolean removerHibernate(Transportadora transportadora) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Transportadora.class, transportadora.getId()));
			et.commit();
			return true;
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transação");
			return false;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	public Transportadora pesquisarHibernate(Integer idTransportadora) {
		Transportadora transportadora = new Transportadora();
		try {
			this.em = JpaUtil.getEntityManager();
			transportadora = em.find(Transportadora.class, idTransportadora);
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return transportadora;
	}

	public List<Transportadora> listarTodosHibernate() {
		try {
			this.em = JpaUtil.getEntityManager();
			Query query = em.createQuery("from Transportadora t");
			List<Transportadora> transportadoras = query.getResultList();
			em.close();
			return transportadoras;
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transação");
			return null;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		
		
		
//		this.em = JpaUtil.getEntityManager();
//		Query query = em.createQuery("from Transportadora t");
//		List<Transportadora> transportadoras = query.getResultList();
//		em.close();
//		return transportadoras;
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
