package home.loja.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.loja.entities.Usuario;
import home.loja.services.UsuarioService;
import home.loja.usuario.ConsultaUsuarioDTO;
import home.loja.usuario.RegistroUsuarioDTO;
import home.loja.usuario.UsuarioMapper;

@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<ConsultaUsuarioDTO> salvarUsuario(@RequestBody RegistroUsuarioDTO dto) {

        Usuario usuario = usuarioService.salvaUsuario(UsuarioMapper.fromDTO(dto));

        return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario));
    }

    // $2a$10$aF0w.BoJID4ZobfvNZ7.5.6NsyrS0lTH8Yj2BaR46vlAg284/R55m
    // public static void main(String[] args) {

    // BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    // System.out.println(bCryptPasswordEncoder.encode("1234"));
    // }
}
