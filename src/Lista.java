
public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
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

}
