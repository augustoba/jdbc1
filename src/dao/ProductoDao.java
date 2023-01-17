package dao;

import entities.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import services.ProductoService;

public class ProductoDao extends Dao {

    public List<Producto> listAll() {

        String query = "select * from producto";
        consultarDb(query);

        List<Producto> productos = new ArrayList<>();
        Producto producto;

        try {
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getNString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));

                productos.add(producto);

            }

        } catch (SQLException ex) {
            System.out.println("ocurrio un error al buscar en la base: " + ex.getMessage());
        } finally {
            desconectarDb();
        }

        return productos;
    }

    public List<Producto> nombre() {
        String query = "select nombre from producto";

        List<Producto> productos = new ArrayList<>();
        Producto producto;
        consultarDb(query);

        try {
            while (resultado.next()) {
                producto = new Producto();
                //producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getNString("nombre"));
                //producto.setPrecio(resultado.getDouble("precio"));
                //producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));

                productos.add(producto);

            }

        } catch (SQLException ex) {
            System.out.println("ocurrio un error al buscar en la base: " + ex.getMessage());
        } finally {
            desconectarDb();
        }

        return productos;

    }

    public List<Producto> nombrePrec() {
        String query = "select nombre,precio from producto";

        List<Producto> productos = new ArrayList<>();
        Producto producto;
        consultarDb(query);

        try {
            while (resultado.next()) {
                producto = new Producto();
                //producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getNString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                //producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));

                productos.add(producto);

            }

        } catch (SQLException ex) {
            System.out.println("ocurrio un error al buscar en la base: " + ex.getMessage());
        } finally {
            desconectarDb();
        }

        return productos;

    }

    public List<Producto> prod120y202() {
        String query = "select * from producto where precio  between  120 and 202 ";

        List<Producto> productos = new ArrayList<>();
        Producto producto;
        consultarDb(query);

        try {
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getNString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));

                productos.add(producto);

            }

        } catch (SQLException ex) {
            System.out.println("ocurrio un error al buscar en la base: " + ex.getMessage());
        } finally {
            desconectarDb();
        }

        return productos;

    }

    public List<Producto> portatiles() {
        String query = "select * from producto where nombre like '%Portátil%'";

        List<Producto> productos = new ArrayList<>();
        Producto producto;
        consultarDb(query);

        try {
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getNString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));

                productos.add(producto);

            }

        } catch (SQLException ex) {
            System.out.println("ocurrio un error al buscar en la base: " + ex.getMessage());
        } finally {
            desconectarDb();
        }

        return productos;

    }

    public List<Producto> masBarato() {
        String query = "select nombre , precio from producto order by precio  limit 1";

        List<Producto> productos = new ArrayList<>();
        Producto producto;
        consultarDb(query);

        try {
            while (resultado.next()) {
                producto = new Producto();
                // producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getNString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                // producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));

                productos.add(producto);

            }

        } catch (SQLException ex) {
            System.out.println("ocurrio un error al buscar en la base: " + ex.getMessage());
        } finally {
            desconectarDb();
        }

        return productos;

    }

    public void insertarProd(Producto producto) {

        String query = "insert into producto values(default, '" + producto.getNombre() + "', '" + producto.getPrecio() + "', '" + producto.getCodigoFabricante() + "')";
        insertarActualizarEliminar(query);

    }

    public void ModificarProducto(String query) throws Exception {
       
        insertarActualizarEliminar(query);
       
        try {

            insertarActualizarEliminar(query);
        } catch (Exception e) {
            System.out.println("no se pudo modificar el producto" + e.getMessage());
        } finally {
            desconectarDb();

        }

    }

}
