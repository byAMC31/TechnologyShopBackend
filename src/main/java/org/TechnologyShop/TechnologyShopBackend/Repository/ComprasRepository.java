package org.TechnologyShop.TechnologyShopBackend.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.TechnologyShop.TechnologyShopBackend.model.Compra;
import org.TechnologyShop.TechnologyShopBackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends JpaRepository<Compra, Long>{
	

	public Optional<Compra> findByFechaAndUsuarioid(LocalDateTime fecha, Long usuarioid);

}
