package org.TechnologyShop.TechnologyShopBackend.Repository;

import java.util.Optional;

import org.TechnologyShop.TechnologyShopBackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByEmail(String email);
}
