package br.com.mildevs.Principal;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.mildevs.DAO.AlunoDao;
import br.com.mildevs.DAO.ProfessorDao;
import br.com.mildevs.entity.Aluno;
import br.com.mildevs.entity.Professor;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		AlunoDao alunoDao = new AlunoDao();
		ProfessorDao professorDao = new ProfessorDao();
		
		Aluno aluno1 = new Aluno();
		
		
		aluno1.setNome("Laura Pereira");
		aluno1.setSerie("série b");
		aluno1.setDataNasc(LocalDate.of(2002, 05, 10));
		
		Aluno aluno2 = new Aluno();
		
		
		aluno2.setNome("Marcos Silva");
		aluno2.setSerie("série A");
		aluno2.setDataNasc(LocalDate.of(2005, 10, 11));
		
		alunoDao.cadastrarAluno(aluno1);
		alunoDao.cadastrarAluno(aluno2);

		System.out.println( alunoDao.consultaAluno(1));
		
		alunoDao.removeAluno(1);
		
		System.out.println(alunoDao.listarAlunos());
		
		System.out.println(alunoDao.consultaAluno(1));
		
		
		Professor prof1 = new Professor();
		
		prof1.setNome("Bianca Bezerra");
		prof1.setTelefone("7599490979");
		prof1.setDiciplina("História");
		prof1.setNivelGraduacao("Doutorado");	
		prof1.setSalario(2545.22);
		
		professorDao.cadastrarProfessor(prof1);
		
		Professor prof2 = new Professor();
		
		prof2.setNome("Lucas Santana");
		prof2.setTelefone("7598885878");
		prof2.setDiciplina("Sociologia");
		prof2.setNivelGraduacao("Doutorado");	
		prof2.setSalario(2000.00);
		
		professorDao.cadastrarProfessor(prof2);
		
		System.out.println(professorDao.listarProfessores());
		
		professorDao.removeProfessor(2);
		
		System.out.println(professorDao.listarProfessores());
		System.out.println(professorDao.consultaProfessor(1));
		
	}
	
	
	
}
