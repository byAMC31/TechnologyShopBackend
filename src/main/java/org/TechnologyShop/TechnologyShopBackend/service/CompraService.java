package org.TechnologyShop.TechnologyShopBackend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.TechnologyShop.TechnologyShopBackend.Repository.ComprasRepository;
import org.TechnologyShop.TechnologyShopBackend.Repository.UsuariosRepository;
import org.TechnologyShop.TechnologyShopBackend.model.Compra;
import org.TechnologyShop.TechnologyShopBackend.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompraService {
	
	public final ComprasRepository comprasRepository;
    public final UsuariosRepository usuariosRepository; 

    @Autowired
    public CompraService(ComprasRepository comprasRepository, UsuariosRepository usuariosRepository) {
        this.comprasRepository = comprasRepository;
        this.usuariosRepository = usuariosRepository;
    }

	
	public List<Compra> getAllCompras() {
		return comprasRepository.findAll();
	}

	
	public Compra getCompra(Long id) {
	    Optional<Compra> compraOpt = comprasRepository.findById(id);
	    if (compraOpt.isPresent()) {
	        return compraOpt.get();
	    } else {
	        throw new IllegalArgumentException("La compra con el id [" + id + "] no existe.");
	    }
	}

	
	public Compra deleteCompra(Long id) {
		Compra comp = null;
		if(comprasRepository.existsById(id)) {
			comp= comprasRepository.findById(id).get();
			comprasRepository.deleteById(id);
		}
		return comp;
	}//deleteCompra

	
	public Compra addCompra(Compra compra) {
	    // Verifica si ya existe una compra (mismo usuario y fecha)
	    Optional<Compra> compraExistente = comprasRepository.findByFechaAndUsuarioid(compra.getFecha(), compra.getUsuarioid());
	    if (compraExistente.isPresent()) {
	        throw new IllegalArgumentException("La compra ya existe para este usuario en esta fecha.");
	    }
	    return comprasRepository.save(compra);
	}

	
	public Compra updateCompra(Long id, Double total, LocalDateTime fecha, Long usuarioid) {
	    Optional<Compra> optionalCompra = comprasRepository.findById(id);
	    if (!optionalCompra.isPresent()) {
	        throw new IllegalArgumentException("Compra no encontrada con id: " + id);
	    }
	    Compra compra = optionalCompra.get();
	    if (total != null) compra.setTotal(total);
	    if (fecha != null) compra.setFecha(fecha);
	    if (usuarioid != null) {
	        Optional<Usuario> optionalUsuario = usuariosRepository.findById(usuarioid);
	        if (!optionalUsuario.isPresent()) {
	            throw new IllegalArgumentException("Usuario no encontrado con id: " + usuarioid);
	        }
	        compra.setUsuarioid(usuarioid);
	    }

	    return comprasRepository.save(compra);
	}

	

}
