
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Cadastro;

/**
 *
 * @author Kaua Semenov
 */
public class CadastroDAO {
    
    public void create(Cadastro c){
        
      Connection con = ConnectionFactory.getConnection();  
      PreparedStatement stmt = null;
       
        try {
            stmt = con.prepareStatement("INSERT INTO tb_customer_account (cpf_cnpj, nm_customer, is_active, vl_total) VALUES (?, ? , ?, ?)");
            stmt.setLong(1, c.getCpf_cnpj());
            stmt.setString(2, c.getNm_customer());
            stmt.setString(3, c.getIs_active());
            stmt.setLong(4, c.getVl_total());

            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sucesso ao salvar");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
    }
    
    public List<Cadastro> read(){
        
       Connection con = ConnectionFactory.getConnection();  
       PreparedStatement stmt = null;
       ResultSet rs = null; 
       
       
       
       List<Cadastro> cadastros = new ArrayList<>();
       
        try {
            stmt = con.prepareCall("SELECT * FROM  tb_customer_account");
            rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                
                Cadastro cadastro = new Cadastro();
                
                cadastro.setNm_customer(rs.getString("nm_customer")); 
                cadastros.add(cadastro);
            }
            
        
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
          ConnectionFactory.closeConnection(con, stmt, rs);  
        }
        
        return cadastros;
    }
    public List<Cadastro> readclientesmedia(){
        
       Connection con = ConnectionFactory.getConnection();  
       PreparedStatement stmt = null;
       ResultSet rs = null; 
       
       
       
       List<Cadastro> cadastros = new ArrayList<>();
       
        try {
            stmt = con.prepareCall("SELECT * FROM (SELECT * FROM tb_customer_account WHERE vl_total > 560) AS tb_customer_account WHERE id_customer BETWEEN 1500 AND 2700 ORDER BY vl_total DESC;" );
            rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                
                Cadastro cadastro = new Cadastro();
                
                cadastro.setNm_customer(rs.getString("nm_customer")); 
                cadastros.add(cadastro);
            }
            
        
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
          ConnectionFactory.closeConnection(con, stmt, rs);  
        }
        
        return cadastros;
    }
    
 public List<Cadastro> readavg(){
        
       Connection con = ConnectionFactory.getConnection();  
       PreparedStatement stmt = null;
       ResultSet rs = null; 
       
       
       
       List<Cadastro> cadastros = new ArrayList<>();
       
        try {
            stmt = con.prepareCall("SELECT AVG (vl_total) FROM (SELECT * FROM tb_customer_account WHERE vl_total > 560) AS tb_customer_account WHERE id_customer BETWEEN 1500 AND 2700" );
            
            rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                
                Cadastro cadastro = new Cadastro();
                
                cadastro.setVl_total(rs.getInt("AVG (vl_total)")); 
                cadastros.add(cadastro);
            }
            
        
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
          ConnectionFactory.closeConnection(con, stmt, rs);  
        }
        
        return cadastros;
    }
    
}
