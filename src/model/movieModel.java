package model;

import Util.Connector;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class movieModel {
    
    protected String moviename;
    protected double alur,penokohan,akting,nilai;
    
    Connector con;
    Statement stmt;
    
    public movieModel(){
    
        con = new Connector();

    }
    
    public void createMovie(String nama, double alur, double penokohan,double akting){
       
       try{
           nilai = (int) ((alur + penokohan + akting)/3);
           stmt = (Statement) con.getConn().createStatement();
           String sql = "INSERT INTO movie VALUES('" +nama+ "',"+alur+","+penokohan+","+akting+","+ nilai +")";     
           stmt.executeUpdate(sql);
           JOptionPane.showMessageDialog(null, "input berhasil");
           
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
    public String[][] readMovie(){   
        try{
            
            int jmlData = 0;
           
           stmt = (Statement) con.getConn().createStatement();
            
            String data[][] = new String[getBanyakData()][5]; //baris, kolom nya ada 4
            
            String query = "select * from movie"; 
            ResultSet resultSet = stmt.executeQuery(query);
            
           
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("judul"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = String.valueOf(resultSet.getDouble("alur"));                
                data[jmlData][2] = String.valueOf(resultSet.getDouble("penokohan"));
                data[jmlData][3] = String.valueOf(resultSet.getDouble("akting"));
                data[jmlData][4] = String.valueOf(resultSet.getDouble("nilai"));
                jmlData++;
            }
            
//             System.out.println(data[jmlData][1]);
            
            JOptionPane.showMessageDialog(null, "baca berhasil");
            return data;
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, "baca gagal");
           return null;
       }
    }
    
    public void updateMovie(String nama, double alur, double penokohan,double akting){
        
        try{
            int jmlData = 0;
            
            nilai = (int) ((alur + penokohan + akting)/3);
           
            stmt = (Statement) con.getConn().createStatement();
            
            String query1 = "select * from movie where judul = '" + nama + "'";
            
            ResultSet res = stmt.executeQuery(query1);
            
            while(res.next()){
                jmlData++;
            }
          
            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
            
            else{
                
                String query = "UPDATE movie SET alur='" + alur + "', penokohan='" + penokohan + "',akting = '" + akting + "',nilai='"+ nilai+"' WHERE judul= '" + nama + "'" ;  
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "update berhasil");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    }
    
    
    
   
    public int getBanyakData(){
        int jmlData = 0;
        try{
            stmt = con.getConn().createStatement();
            String query = "Select * from movie";
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteMovie (String nama) {
        try{
            String query = "DELETE FROM movie WHERE judul = '"+nama+"'";
            stmt = con.getConn().createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}