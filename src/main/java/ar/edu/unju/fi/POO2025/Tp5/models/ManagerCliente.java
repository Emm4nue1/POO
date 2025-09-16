package ar.edu.unju.fi.POO2025.Tp5.models;
import ar.edu.unju.fi.POO2025.Tp5.models.client.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ManagerCliente {
    private List<Cliente> clientes;

    public ManagerCliente() {
        this.clientes = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) throws ClienteException {
        for (Cliente c : clientes) {
            if (c.getDni().equals(cliente.getDni())) {
                throw new ClienteException("El DNI ya está registrado");
            }
        }

        for (Cliente c : clientes) {
            if (c.getEmail().equals(cliente.getEmail())) {
                throw new ClienteException("El email ya está registrado");
            }
        }
        clientes.add(cliente);
    }

    public void registrarCompra(String dni, Compra compra) throws ClienteException {
        Cliente cliente = buscarClientePorDni(dni);
        if (cliente == null) {
            throw new ClienteException("Cliente no encontrado");
        }
        cliente.agregarCompra(compra);
    }

    public int cantidadComprasCliente(String dni) throws ClienteException {
        Cliente cliente = buscarClientePorDni(dni);
        if (cliente == null) {
            throw new ClienteException("Cliente no encontrado");
        }
        return cliente.getCantidadCompras();
    }

    public double totalRecaudadoLocalidad(String idLocalidad) {
        double total = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getLocalidad().getId().equals(idLocalidad)) {
                total += cliente.getTotalGastado();
            }
        }
        return total;
    }

    private Cliente buscarClientePorDni(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }
}