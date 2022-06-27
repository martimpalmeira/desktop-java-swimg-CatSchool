package catSchool.controller;

import catSchool.dao.ExceptionDAO;
import catSchool.model.Aluno;
import java.util.ArrayList;

public class AlunoController {
	
	public static boolean cadastrarAluno(String nome, String cpf, String numeroDeMatricula) throws ExceptionDAO{
		if(!nome.equals("") && !cpf.equals("") && !numeroDeMatricula.equals("")) {
			Aluno aluno = new Aluno(nome,cpf, numeroDeMatricula);
			aluno.cadastrarAluno(aluno);
			return true;
		}else {
			return false;
		}	
	}
        
        
        public static ArrayList<Aluno> listarAlunos(String nome) throws ExceptionDAO{
            return new Aluno().listarAlunos(nome);
        }
         
        public boolean apagarAluno(String nome) throws ExceptionDAO{
            if(nome.equals(null)){
                return false;
            }else{
                Aluno aluno = new Aluno();
                aluno.setNome(nome);
                aluno.apagarAluno(aluno);
                return true;
            }
        }
        
        
}
