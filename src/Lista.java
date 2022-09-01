
public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public boolean esVacia() {
        if (primero == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(Nodo<T> nodo) {
        if (esVacia()) {
            primero = nodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nodo);
        }
    }

    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> actual = primero;

        while (actual != null) {
            if (actual.getEtiqueta().equals(clave)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            if (primero.getEtiqueta() == clave) {
                primero = null;
                return true;
            } else {
                return false;
            }
        }
        
        Nodo anterior = primero;
        Nodo temporal = primero.getSiguiente();

        while (temporal != null) {
            if (temporal.getEtiqueta().equals(clave)) {
                anterior.setSiguiente(temporal.getSiguiente());
                return true;
            }

            anterior = temporal;
            temporal = temporal.getSiguiente();
        }

        // Si el método llegó a este punto, significa que no encontro un nodo con la clave indicada.
        return false;
    }
}
