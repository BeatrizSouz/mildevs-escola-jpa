package br.com.mildevs.DAO;

import java.util.List;

import br.com.mildevs.entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ProfessorDao {
	private EntityManager manager;

	public ProfessorDao() {
		this.manager = Persistence.createEntityManagerFactory("escola").createEntityManager();
	}
	
	public boolean cadastrarProfessor (Professor professor) {

		this.manager.getTransaction().begin();
		this.manager.persist(professor);
		this.manager.getTransaction().commit();
		return true;
		
		
	}

	public Professor consultaProfessor (int codFunc) {
		
		return manager.find(Professor.class, codFunc);
	}
	
	public List<Professor> listarProfessores () {
		Query query = manager.createQuery("SELECT p FROM Professor as p ORDER BY codigo_funcionario ASC  ");
		

		return query.getResultList();
	}
	
	public boolean removeProfessor (int codFunc) {
		
		Professor professor = manager.find(Professor.class, codFunc);
		
		if (professor == null) {
			System.err.println("Esse professor não existe!");
			return false;
		}
		
		this.manager.getTransaction().begin();
		this.manager.remove(professor);
		this.manager.getTransaction().commit();
		
		return true;
		
		
	}
}
