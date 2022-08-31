/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author belu_
 */
public class Almacen implements IAlmacen {

    private String direccion;

    private String telefono;

    private String nombre;

    public Almacen(String direccion, String telefono, String nombre) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
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

    @Override
    public Lista<Producto> getListaProductos() {
        return null;
    }

    public long obtenerValorStock() {
        return 0;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
    }

    @Override
    public boolean eliminarProducto(Comparable codProducto) {
        return false;
    }

    @Override
    public String imprimirProductos() {
        return null;
    }

    @Override
    public String imprimirSeparador(String separador) {
        return null;
    }

    @Override
    public Boolean agregarStock(Comparable codProducto, Integer cantidad) {
        return null;
    }

    @Override
    public Integer restarStock(Comparable codProducto, Integer cantidad) {
        return null;
    }

    @Override
    public Producto buscarPorCodigo(Comparable codProducto) {
        return null;
    }

    @Override
    public void listarOrdenadoPorNombre() {
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        return null;
    }

    @Override
    public int cantidadProductos() {
        return 0;
    }
}