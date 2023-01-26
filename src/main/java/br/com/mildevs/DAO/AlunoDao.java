package br.com.mildevs.DAO;

import java.util.List;

import br.com.mildevs.entity.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AlunoDao {
	private EntityManager manager;

	public AlunoDao() {
		this.manager = Persistence.createEntityManagerFactory("escola").createEntityManager();
	}
	
	public boolean cadastrarAluno (Aluno aluno) {

		this.manager.getTransaction().begin();
		this.manager.persist(aluno);
		this.manager.getTransaction().commit();
		return true;
		
		
	}
	
	
	public Aluno consultaAluno (int matricula) {
		
		return manager.find(Aluno.class, matricula);
	}
	
	
	public List<Aluno> listarAlunos () {
		Query query = manager.createQuery("SELECT a FROM Aluno as a ORDER BY matricula ASC  ");
		

		return query.getResultList();
	}
	
	public boolean removeAluno (int matricula) {
		
		Aluno aluno = manager.find(Aluno.class, matricula);
		
		if (aluno == null) {
			System.err.println("Esse aluno não existe!");
			return false;
		}
		
		this.manager.getTransaction().begin();
		this.manager.remove(aluno);
		this.manager.getTransaction().commit();
		
		return true;
		
		
	}
	
}
