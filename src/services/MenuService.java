
package services;


import java.util.Scanner;


public class MenuService {
    
    Scanner read = new Scanner (System.in);
            
    String aux;
   
    
    public void menu() throws Exception{
        
  
    do {
    
    System.out.println(" ---------------ingrese una opcion----------------------------------- ");
        System.out.println(" a) Lista el nombre de todos los productos que hay en la tabla producto.");
        System.out.println(" b) Lista los nombres y los precios de todos los productos de la tabla producto.");
        System.out.println(" c) Listar aquellos productos que su precio esté entre 120 y 202.");
        System.out.println(" d) Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println(" e) Listar el nombre y el precio del producto más barato.");
        System.out.println(" f) Ingresar un producto a la base de datos.");
        System.out.println(" g) Ingresar un fabricante a la base de datos");
        System.out.println(" h) listar fabricante.");
        System.out.println(" i) Editar un producto con datos a elección.");
        System.out.println(" j) Salir");
        aux=read.next();
        
        FabricanteService fab = new FabricanteService();
        ProductoService producto = new ProductoService();
        
        
        
     
    switch (aux.toLowerCase()) {
            case "a":
          producto.listarNombre();
            break;
            case "b":
            producto.listarNombrePrec();
            break;
                         
            case "c":
            producto.prod120202();
            
            break;
             case "d":
           producto.portatiles();
            break;
             case "e":
            producto.masBarato();
            break;
            case "f":
            producto.insertarProducto();
            break;
             case "g":
            fab.insertarFabricante();
             break;
             case "h":
              fab.listAllFab();
            break;
            case "i":
              producto.mod();
            break;
            case "j":
                System.out.println("cerrando menu");
            break;
        }
        
        } while (!aux.equalsIgnoreCase("j"));
  }
}
