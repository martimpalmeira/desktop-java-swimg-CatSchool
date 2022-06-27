package catSchool.controller;

import catSchool.dao.ExceptionDAO;
import catSchool.model.Aluno;
import catSchool.model.Professor;
import java.util.ArrayList;

public class ProfessorController {
	
	public static boolean cadastrarProfessor(String nome, String cpf , String formacao, String identidadeProfissional) throws ExceptionDAO {
		if(!nome.equals("") && !cpf.equals("") && !identidadeProfissional.equals("") && !formacao.equals("")) {
			Professor professor = new Professor(nome,cpf,formacao, identidadeProfissional);
			professor.cadastrarProfessor(professor);
			return true;
		}else {
			return false;
		}
                
                
	}
        
        
        public static ArrayList<Professor> listarProfessores(String nome) throws ExceptionDAO{
            return new Professor().listarProfessores(nome);
        }
        
        public boolean apagarProfessor(String nome) throws ExceptionDAO{
            if(nome.equals(null)){
                return false;
            }else{
                Professor professor = new Professor();
                professor.setNome(nome);
                professor.apagarProfessor(professor);
                return true;
            }
        }
}
