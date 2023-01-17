package services;

import dao.ProductoDao;
import entities.Producto;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class ProductoService {

    private ProductoDao product = new ProductoDao();

    private Scanner read = new Scanner(System.in).useDelimiter("\n");

    public void listAll() {

        List<Producto> productos = product.listAll();

        for (Producto producto : productos) {
            System.out.println(producto.toString());

        }

    }

    public void listarNombre() {

        List<Producto> productos = product.nombre();

        for (Producto producto : productos) {
            System.out.println(producto.getNombre());

        }

    }

    public void listarNombrePrec() {

        List<Producto> productos = product.nombre();

        for (Producto producto : productos) {
            System.out.println("nombre: " + producto.getNombre() + ". precio: " + producto.getPrecio());

        }

    }

    public void prod120202() {
        List<Producto> productos = product.prod120y202();

        for (Object producto : productos) {
            System.out.println(producto);
        }

    }

    public void portatiles() {
        List<Producto> productos = product.portatiles();

        for (Producto producto : productos) {
            System.out.println(producto);
        }

    }

    public void masBarato() {
        List<Producto> productos = product.masBarato();

        for (Producto producto : productos) {
            System.out.println("Nombre:" + producto.getNombre() + ". precio: " + producto.getPrecio());
        }

    }

    public void insertarProducto() {

        Producto nuevProd = new Producto();

        System.out.println("ingrese el nombre del producto");
        nuevProd.setNombre(read.nextLine());
        System.out.println("ingrese el precio del producto");
        nuevProd.setPrecio(read.nextDouble());
        System.out.println("ingrese el codigo del fabricante");
        nuevProd.setCodigoFabricante(read.nextInt());
        read.nextLine();
        product.insertarProd(nuevProd);
    }

    public String menuModProducto() {

        String query = null;
        Producto producto = new Producto();
        List<Producto> productos = product.listAll();

        Integer codigo = null;

        boolean encontrado = false;

        for (Producto producto1 : productos) {
            System.out.println(producto1);
        }

        System.out.println("ingrese el codigo del producto que desea modificar");
        codigo = read.nextInt();
        read.nextLine();
        for (Producto aux : productos) {

            if (Objects.equals(codigo, aux.getCodigo())) {
                encontrado = true;

            }

        }
        if (encontrado == false) {
            System.out.println("no se encontro el producto");
        }

        Integer opc = 0;

        if (encontrado) {
            do {
                System.out.println("ingrese la opcion que desea modificar");
                System.out.println("1-***Nombre del producto");
                System.out.println("2-***Precio del producto");
                System.out.println("3-***Codigo de fabricante");
                System.out.println("4-***Todas las anteriores");
                System.out.println("5-***salir");

                opc = read.nextInt();
                read.nextLine();

                switch (opc) {
                    case 1:

                        query = nombreMod(codigo);

                        break;

                    case 2:

                        query = precioMod(codigo);

                        break;

                    case 3:
                        query = codigoFab(codigo);

                        break;
                    case 4:
                        query = modificarTodo(codigo);
                        break;
                    case 5:
                        

                        break;
                    default:
                        System.out.println("--ingrese una opcion correcta");

                }
            } while (opc != 5);

        }

        return query;
    }

    public String nombreMod(int codigo) {

        System.out.println("--ingrese el nombre nuevo del producto");
        String nombreN = read.nextLine();
        String sql = "update producto set nombre = '" + nombreN + "'" + " where codigo= " + codigo + ";";
        return sql;

    }

    public String precioMod(int codigo) {

        System.out.println("--ingrese el precio nuevo del producto");
        Double precio = read.nextDouble();
        read.nextLine();
        String sql = "update producto set precio = " + precio + "" + " where codigo= " + codigo + ";";
        return sql;

    }

    public String codigoFab(int codigo) {

        System.out.println("--ingrese el precio nuevo del producto");
        String codigoF = read.nextLine();
        String sql = "update producto set codigo_fabricante = '" + codigoF + "'" + " where codigo= " + codigo + ";";
        return sql;

    }

    public String modificarTodo(int codigo) {

        System.out.println("--ingrese el nombre nuevo del producto");
        String nombreN = read.nextLine();
        System.out.println("--ingrese el precio nuevo del producto");
        Double precio = read.nextDouble();
        read.nextLine();
        System.out.println("--ingrese el codigo nuevo del producto");
        String codigoF = read.nextLine();

        String sql = "update producto set nombre = '" + nombreN + "'" + ", " + "precio = " + precio + ", codigo_fabricante = " + codigoF + "" + " where codigo = " + codigo + ";";
        return sql;

    }

    public void mod() throws Exception {

        product.ModificarProducto(menuModProducto());

    }

}
