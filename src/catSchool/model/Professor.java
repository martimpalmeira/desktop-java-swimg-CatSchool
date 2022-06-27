package catSchool.model;

import catSchool.dao.AlunoDAO;
import java.util.ArrayList;

import catSchool.dao.ExceptionDAO;
import catSchool.dao.ProfessorDAO;

public class Professor extends Pessoa {
	
	private String identidadeProfissional;
	
	private String formacao;
	
	public Professor(String nome , String cpf, String identidadeProfissional, String formacao) {
		super(nome, cpf);
		this.identidadeProfissional = identidadeProfissional;
		this.formacao = formacao;
		
	}
        
        public Professor() {
			
	}
	
	@Override
	public String retornarComprovanteCatSchool() {
		return this.identidadeProfissional;
	}

	
	public String getIdentidadeProfissional() {
		return identidadeProfissional;
	}

	public void setIdentidadeProfissional(String identidadeProfissional) {
		this.identidadeProfissional = identidadeProfissional;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public void cadastrarProfessor(Professor professor) throws ExceptionDAO {
		ProfessorDAO.cadastrarProfessor(professor);
	}
        
        public ArrayList<Professor> listarProfessores(String nome) throws ExceptionDAO{
            return ProfessorDAO.listarProfessores(nome);
        }
	
        public void apagarProfessor(Professor professor ) throws ExceptionDAO{
             ProfessorDAO.apagarProfessor(professor);
            
        }
	
}
