package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductoServiceTest {
    private ProductoRepository repository;
    private ProductoService service;

    @BeforeEach
    public void setUp() {
        repository = mock(ProductoRepository.class);
        service = new ProductoService(repository);
    }

    @Test
    public void testListarProductos() {
        List<Producto> productos = Arrays.asList(new Producto(1L, "Producto 1", 10.0, 5));
        when(repository.findAll()).thenReturn(productos);

        List<Producto> resultado = service.listarProductos();

        assertEquals(1, resultado.size());
        assertEquals("Producto 1", resultado.get(0).getNombre());
    }

    @Test
    public void testObtenerProductoPorId() {
        Producto producto = new Producto(1L, "Producto 1", 10.0, 5);
        when(repository.findById(1L)).thenReturn(Optional.of(producto));

        Optional<Producto> resultado = service.obtenerProductoPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Producto 1", resultado.get().getNombre());
    }
}
