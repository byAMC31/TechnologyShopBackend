package org.TechnologyShop.TechnologyShopBackend.Repository;


import java.util.Optional;

import org.TechnologyShop.TechnologyShopBackend.model.DetalleDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DetallesDeCompraRepository extends JpaRepository<DetalleDeCompra, Long>{
	Optional<DetalleDeCompra> findByCompraId(Long compraId);
}