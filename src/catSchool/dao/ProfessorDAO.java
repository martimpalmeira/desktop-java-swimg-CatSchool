package catSchool.dao;

import catSchool.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import catSchool.model.Professor;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfessorDAO {
	
	public static void cadastrarProfessor(Professor professor) throws ExceptionDAO {
		String sql = "INSERT INTO professor (nome,cpf, formacao, identidadeProfissional) VALUE (?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection connection = null;

		try {
			connection = new ConnectionCatSchool().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, professor.getNome());
			pStatement.setString(2, professor.getCpf());
			pStatement.setString(3, professor.getFormacao());
			pStatement.setString(4, professor.getIdentidadeProfissional());
			pStatement.execute();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar professor: " + e);
		} finally {

			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar a conexão " + e);
			}
		}
	}
        
         public static ArrayList<Professor> listarProfessores(String nome) throws ExceptionDAO{
            String sql = "SELECT * FROM professor WHERE nome LIKE '%" + nome + "%' ORDER BY nome";
            Connection connection = null;
            PreparedStatement pStatement = null;
            ArrayList<Professor> professores = null;
            
           
            try{
                connection = new ConnectionCatSchool().getConnection();
                pStatement = connection.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery(sql);
                
                if(rs!= null){
                    professores = new ArrayList<Professor>();
                    while(rs.next()){
                        Professor professor = new Professor();
                        professor.setNome(rs.getString("nome"));
                        professor.setCpf(rs.getString("cpf"));
                        professor.setFormacao(rs.getString("formacao"));
                        professor.setIdentidadeProfissional(rs.getString("identidadeProfissional"));
                        professores.add(professor);
                    }
                }                              
            }
            catch(Exception e){
                throw new ExceptionDAO("Houve um erro ao consultar professores: " + e);
            }finally{
                try{
                    if(pStatement != null){
                        pStatement.close();
                    }
                }catch(SQLException e){
                    throw new ExceptionDAO("Houve um erro ao fechar o statement "+ e);
                }
                 try{
                    if(connection != null){
                        connection.close();
                    }
                }catch(SQLException e){
                    throw new ExceptionDAO("Houve um erro ao fechar a conexão "+ e);
                }
            }
            
          return professores;
                    
        }
         
         public static void apagarProfessor(Professor professor) throws ExceptionDAO {
		String sql = "DELETE FROM professor WHERE nome = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;

		try {
			connection = new ConnectionCatSchool().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, professor.getNome());
			pStatement.execute();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao apagar professor: " + e);
		} finally {

			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar a conexão " + e);
			}
		}
	}
}
