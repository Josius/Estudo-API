package home.loja.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.loja.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // método abaixo usado para fazer login
    Optional<Usuario> findByEmail(String email);

    Page<Usuario> findAll(Pageable pageable);
}
