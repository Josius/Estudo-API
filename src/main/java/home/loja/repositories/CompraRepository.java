package home.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.loja.entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
    
}
