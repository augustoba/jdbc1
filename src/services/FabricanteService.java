
package services;

import dao.FabricanteDao;
import entities.Fabricante;
import java.util.List;
import java.util.Scanner;


public class FabricanteService {
    
   private Fabricante fabricante = new Fabricante();
   private FabricanteDao fDao = new FabricanteDao();
   private Scanner read = new Scanner(System.in);
   
   private FabricanteDao fab = new FabricanteDao();
   
    public void listAllFab() {

        List<Fabricante> fabricantes = fDao.listAll();

        for (Fabricante fabricante : fabricantes) {
            System.out.println(fabricante.toString());

        }
     }
    
   public void  insertarFabricante(){
       System.out.println("ingrese el nombre del fabricante");
       fabricante.setNombre(read.nextLine());
       fDao.insertarFab(fabricante);
   }

}
