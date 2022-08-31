
/**
 *
 * @author abadie
 */
public class Main {

    public static void main(String[] args) {

        Almacen almacen = new Almacen("Calle 1", "099999999", "Almacen 1");

        String[] lineasAltas = ManejadorArchivosGenerico.leerArchivo(".\\src\\altas.txt");

        for (int i = 0; i < lineasAltas.length; i++) {
            String[] lineaActual = lineasAltas[i].split(",");
            almacen.agregarStock(lineaActual[0], 30)

        }

        String[] lineasBajas = ManejadorArchivosGenerico.leerArchivo(".\\src\\ventas.txt");

        for (int i = 0; i < lineasBajas.length; i++) {
            String[] lineaActual = lineasBajas[i].split(",");
            almacen.restarStock(lineaActual[0], 30);

        }

    }

}
