/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advogator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TARDIS
 */
public class Conexao {
    
   private static Connection Cnn;
    private static final String URL="jdbc:mysql://localhost:3306/advogator";
    private static final String USER="root";
    private static final String PASS="";
    
    public static Connection getConexao() { // throws SystemError{
        if(Cnn == null){
            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Cnn = DriverManager.getConnection(URL, USER, PASS);
                } catch (SQLException ex) {
 //                   throw new SystemError("Não foi possivel conectar ao Banco de Dados", ex);
                }
            } catch (ClassNotFoundException ex) {
//                    throw new SystemError("Driver do Banco de Dados não encontrado", ex);
            }
        }
        return Cnn;
    }
    
    public static void CloseConexao() {//throws SystemError{
        if(Cnn != null){
            try {
                Cnn.close();
                Cnn = null;
            } catch (SQLException ex) {
//                throw new SystemError("Erro ao fechar Banco de Dados", ex);
            }
        }
    }
}
