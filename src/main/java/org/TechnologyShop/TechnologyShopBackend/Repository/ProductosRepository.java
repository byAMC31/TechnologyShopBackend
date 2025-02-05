package org.TechnologyShop.TechnologyShopBackend.Repository;

import java.util.Optional;

import org.TechnologyShop.TechnologyShopBackend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, Long>{
	
	Optional<Producto> findByNombre(String nombre);
	Optional<Producto> findByImagen(String imagen);

}





