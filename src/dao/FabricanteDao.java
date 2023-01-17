
package dao;

import entities.Fabricante;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FabricanteDao  extends Dao{
    
    
    
    public List<Fabricante> listAll (){
        
        String query = "select * from fabricante";
        consultarDb(query);
        
        List<Fabricante> fabricantes = new ArrayList<>();
        Fabricante fabricante;
        
        
        try {
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo"));
                fabricante.setNombre(resultado.getNString("nombre"));
                
                
                
                fabricantes.add(fabricante);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("ocurrio un error al buscar en la base: "+ ex.getMessage());
        }finally {
            desconectarDb();
        }
        
        
        return fabricantes;
    }
    
    
    
    public void insertarFab(Fabricante fabricante){
               
        String query = "insert into fabricante values(default, '"+ fabricante.getNombre()+"')";
        insertarActualizarEliminar(query);
        
    }

}
