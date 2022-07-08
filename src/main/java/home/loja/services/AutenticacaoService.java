package home.loja.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import home.loja.dto.autenticacao.AutenticacaoDTO;
import home.loja.dto.autenticacao.TokenDTO;
import home.loja.entities.Usuario;

@Service
public class AutenticacaoService {

    @Autowired
    private AuthenticationManager authManager;

    // Injeção das configurações do application.properties
    @Value("${loja.jwt.secret}")
    private String secret;

    @Value("${loja.jwt.expiration}")
    private String expiration;

    @Value("${loja.jwt.issuer}")
    private String issuer;

    public TokenDTO autenticar(AutenticacaoDTO dto) throws AuthenticationException {

        Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(),
                dto.getSenha()));

        String token = gerarToken(authenticate);

        return new TokenDTO(token);
    }

    // codificação do token
    private Algorithm criarAlgoritmo() {

        return Algorithm.HMAC256(secret);
    }

    private String gerarToken(Authentication authenticate) {
        Usuario principal = (Usuario) authenticate.getPrincipal();

        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(dataExpiracao)
                .withSubject(principal.getId().toString())
                .sign(this.criarAlgoritmo());
    }
}
