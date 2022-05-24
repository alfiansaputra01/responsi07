
package model;

import koneksi.koneksiDB;
import java.sql.ResultSet;


public class movieModel {

    private final koneksiDB koneksi;
    private ResultSet rsMovie;
    private String query;
    private boolean status;
    
    public movieModel(){
        koneksi = new koneksiDB();
        koneksi.getConn();
    }
    
    private String judul;
    double alur, penokohan, akting, nilai;
    
     public double getAlur() {
        return alur;
    }

    public void setAlur(double alur) {
        this.alur = alur;
    }

    public double getPenokohan() {
        return penokohan;
    }

    public void setPenokohan(double penokohan) {
        this.penokohan = penokohan;
    }

    public double getAkting() {
        return akting;
    }

    public void setAkting(double akting) {
        this.akting = akting;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

     
    
    public ResultSet tampilMovie(){
        query = "SELECT * FROM movie_db ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsMovie = koneksi.getRs();
        }
        return rsMovie;
    }
    public boolean insertMovie(){
        query = "insert into movie_db (judul, alur, penokohan, akting, nilai) values ('"+judul+"','"+alur+"','"+penokohan+"','"+akting+"','"+nilai+"')";
        status= koneksi.eksekusiQuery(query, false);
        return status;
    }
   
    public boolean deleteMovie(){
        query = "delete from movie_db where judul='"+judul+"'";
        status= koneksi.eksekusiQuery(query, false);
        return status;
    }
    
    public boolean updateMovie(){
        query = "update movie_db set alur='"+alur+"',penokohan='"+penokohan+"',akting='"+akting+"',nilai='"+nilai+"' where judul='"+judul+"'";
        status= koneksi.eksekusiQuery(query, false);
        return status;
    }

   
   
}

