
/**
 *
 * @author abadie
 */
public class Main {

    public static void main(String[] args) {

        Almacen almacen = new Almacen("Calle 1", "099999999", "Almacen 1");
        long valorStock = almacen.obtenerValorStock();
        System.out.printf("Valor del stock inicio = $%d \n", valorStock);

        String[] lineasAltas = ManejadorArchivosGenerico.leerArchivo(".\\src\\altas.txt");

        Producto producto;
        String[] lineaActual;

        for (int i = 0; i < lineasAltas.length; i++) {
            lineaActual = lineasAltas[i].split(",");

            try {
                producto = new Producto(Integer.parseInt(lineaActual[0]), Integer.parseInt(lineaActual[2]),
                        Integer.parseInt(lineaActual[3]), lineaActual[1]);

                almacen.insertarProducto(producto);
            } catch (Exception e) {
                System.out.println("Ha sucedido un Error en la lectura del producto, número de la linea = " + (i + 1));
            }

        }

        // Para imprimir el listado de productos descomentar lo siguiente:
        /**
         * System.out.println("Listado de productos:");
         * System.out.println(almacen.imprimirProductos());
         */
        valorStock = almacen.obtenerValorStock();
        System.out.printf("\nValor del stock post compra = $%d \n", valorStock);

        String[] lineasBajas = ManejadorArchivosGenerico.leerArchivo(".\\src\\ventas.txt");

        for (int i = 0; i < lineasBajas.length; i++) {
            lineaActual = lineasBajas[i].split(",");
            almacen.restarStock(Integer.parseInt(lineaActual[0]), Integer.parseInt(lineaActual[1]));
        }
        
        long valorStock2 = almacen.obtenerValorStock();
        System.out.printf("\nValor del stock post venta = $%d \n", valorStock2);
        System.out.printf("\nEl monto total vendido = $%d \n", valorStock - valorStock2);
        
        String[] lineasEliminar = ManejadorArchivosGenerico.leerArchivo(".\\src\\elim.txt");

        // Para poder ver en consola los elementos eliminados, descomentar los println en if y else
        for (int i = 0; i < lineasEliminar.length; i++) {
            if (almacen.eliminarProducto(Integer.parseInt(lineasEliminar[i]))){
                // System.out.println("Se eliminó el producto con el código " + lineasEliminar[i]);
            } else{
                // System.out.println("No se eliminó el producto con el código " + lineasEliminar[i]);
            }
        }
        
        valorStock = almacen.obtenerValorStock();
        System.out.printf("\nValor del stock post eliminación de productos = $%d \n", valorStock);
    }

}
