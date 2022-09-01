/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author belu_
 */
public class Almacen implements IAlmacen {

    private Lista<Producto> listaProductos;

    private String direccion;

    private String telefono;

    private String nombre;

    public Almacen(String direccion, String telefono, String nombre) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        listaProductos = new Lista<>();
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean agregarStock(Comparable codProducto, Integer cantidad) {
        Nodo<Producto> nodo = listaProductos.buscar(codProducto);

        if (nodo == null) {
            return false;
        }

        nodo.getDato().agregarCantidadStock(cantidad);
        return true;
    }

    public Integer restarStock(Comparable codProducto, Integer cantidad) {
        Nodo<Producto> nodoProducto = listaProductos.buscar(codProducto);

        if (nodoProducto != null) {
            Producto productoActual = nodoProducto.getDato();
            productoActual.restarCantidadStock(cantidad);
            return productoActual.getStock();
        } else {
            System.out.println("No existe ningún producto con el código: " + codProducto);
            return null;
        }
    }

    @Override
    public Lista<Producto> getListaProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long obtenerValorStock() {
        long valorStock = 0;
        Nodo<Producto> nodo = listaProductos.getPrimero();

        while (nodo != null) {
            valorStock += nodo.getDato().obtenerValorStock();
            nodo = nodo.getSiguiente();
        }

        return valorStock;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        Nodo<Producto> nodo = new Nodo(unProducto.getCodProducto(), unProducto);
        listaProductos.insertar(nodo);
    }

    @Override
    public boolean eliminarProducto(Comparable codProducto) {
        return listaProductos.eliminar(codProducto);
    }

    @Override
    public String imprimirProductos() {
        String listado = "";
        Nodo<Producto> nodo = listaProductos.getPrimero();

        while (nodo != null) {
            listado += nodo.getDato().productoToString() + "\n";
            nodo = nodo.getSiguiente();
        }

        return listado;
    }

    @Override
    public String imprimirSeparador(String separador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto buscarPorCodigo(Comparable codProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void listarOrdenadoPorNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cantidadProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
