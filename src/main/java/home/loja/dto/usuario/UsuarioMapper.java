package home.loja.dto.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import home.loja.dto.filial.FilialMapper;
import home.loja.entities.Filial;
import home.loja.entities.Perfil;
import home.loja.entities.Usuario;

public class UsuarioMapper {

    public static Usuario fromDTO(RegistroUsuarioDTO dto) {

        Perfil perfil = new Perfil();
        perfil.setId(dto.getPerfilId());

        Filial filial = new Filial();
        filial.setId(dto.getFilialId());

        return new Usuario(null, dto.getEmail(), new BCryptPasswordEncoder().encode(dto.getSenha()), perfil, filial);
    }

    public static ConsultaUsuarioDTO fromEntity(Usuario usuario) {

        return new ConsultaUsuarioDTO(usuario.getEmail(), usuario.getPerfil().getNome(),
                FilialMapper.fromEntity(usuario.getFilial()));
    }

}
