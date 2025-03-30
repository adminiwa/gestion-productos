package com.ejemplo.productos.service;
import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return repository.findById(id);
    }

    public Producto crearProducto(Producto producto) {
        return repository.save(producto);
    }

    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }
}
