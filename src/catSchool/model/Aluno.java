package catSchool.model;

import java.util.ArrayList;

import catSchool.dao.AlunoDAO;
import catSchool.dao.ExceptionDAO;

public class Aluno extends Pessoa {

	private String numeroDeMatricula;
	

	public Aluno(String nome, String cpf, String numeroDeMatricula) {
		super(nome, cpf);
		this.numeroDeMatricula = numeroDeMatricula;
		
	}
        
        public Aluno() {
            
	}

	public String getNumeroDeMatricula() {
		return numeroDeMatricula;
	}

	public void setNumeroDeMatricula(String numeroDeMatricula) {
		this.numeroDeMatricula = numeroDeMatricula;
	}

	
	@Override
	public String retornarComprovanteCatSchool() {
		return this.numeroDeMatricula;
	}

	
	public void cadastrarAluno(Aluno aluno) throws ExceptionDAO {
		 AlunoDAO.cadastrarAluno(aluno);
	}
        
        public ArrayList<Aluno> listarAlunos(String nome) throws ExceptionDAO{
            return AlunoDAO.listarAlunos(nome);
        }
        
        public void apagarAluno(Aluno aluno ) throws ExceptionDAO{
             AlunoDAO.apagarAluno(aluno);
            
        }
	
	
	
	

}
