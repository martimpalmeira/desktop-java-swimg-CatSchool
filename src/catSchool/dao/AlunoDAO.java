package catSchool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import catSchool.model.Aluno;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class AlunoDAO {

	public static void cadastrarAluno(Aluno aluno) throws ExceptionDAO {
		String sql = "INSERT INTO aluno (nome,cpf,numeroDeMatricula) VALUE (?,?,?)";
		PreparedStatement pStatement = null;
		Connection connection = null;

		try {
			connection = new ConnectionCatSchool().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, aluno.getNome());
			pStatement.setString(2, aluno.getCpf());
			pStatement.setString(3, aluno.getNumeroDeMatricula());
			pStatement.execute();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar aluno: " + e);
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
        
        public static ArrayList<Aluno> listarAlunos(String nome) throws ExceptionDAO{
            String sql = "SELECT * FROM aluno WHERE nome LIKE '%" + nome + "%' ORDER BY nome";
            Connection connection = null;
            PreparedStatement pStatement = null;
            ArrayList<Aluno> alunos = null;
            
           
            try{
                connection = new ConnectionCatSchool().getConnection();
                pStatement = connection.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery(sql);
                
                if(rs!= null){
                    alunos = new ArrayList<Aluno>();
                    while(rs.next()){
                        Aluno aluno = new Aluno();
                        aluno.setNome(rs.getString("nome"));
                        aluno.setCpf(rs.getString("cpf"));
                        aluno.setNumeroDeMatricula(rs.getString("numeroDeMatricula"));
                        alunos.add(aluno);
                    }
                }                              
            }
            catch(Exception e){
                throw new ExceptionDAO("Houve um erro ao consultar alunos: " + e);
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
            
          return alunos;
                    
        }
        
        
        public static void apagarAluno(Aluno aluno) throws ExceptionDAO {
		String sql = "DELETE FROM aluno WHERE nome = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;

		try {
			connection = new ConnectionCatSchool().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, aluno.getNome());
			pStatement.execute();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao apagar aluno: " + e);
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
