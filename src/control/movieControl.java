package control;

import model.movieModel;
import view.FormMovie;

import java.sql.ResultSet;
import java.util.List;
import model.movieModel;
import view.FormMovie;

public class movieControl {
    private FormMovie view;
    private movieModel model;

    private String judul;
    double alur, penokohan, akting, nilai;

    public movieControl(FormMovie view){
        this.view = view;
        model = new movieModel();
    }

    public  ResultSet tampilMovie(){
        return model.tampilMovie();
    }

   public void inputMovie(String judul, double alur, double penokohan, double akting, double nilai){
       model.setJudul(judul);
       model.setAlur(alur);
       model.setPenokohan(penokohan);
       model.setAkting(akting);
       model.setNilai(nilai);
      
   }
    
    public boolean insertMovie(){
        return model.insertMovie();
    }
    
    public void hapusMovie(String judul){
        model.setJudul(judul);
    }
    public boolean deleteMovie(){
        return model.deleteMovie();
    }
    
    public void ubahMovie(String judul, double alur, double penokohan, double akting, double nilai){
       model.setJudul(judul);
       model.setAlur(alur);
       model.setPenokohan(penokohan);
       model.setAkting(akting);
       model.setNilai(nilai);
    }
    public boolean updateMovie(){
        return model.updateMovie();
    }


}