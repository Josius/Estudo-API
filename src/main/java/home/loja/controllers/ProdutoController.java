package home.loja.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.loja.dto.produto.ConsultaProdutoDTO;
import home.loja.dto.produto.ProdutoMapper;
import home.loja.dto.produto.RegistroProdutoDTO;
import home.loja.entities.Produto;
import home.loja.entities.Usuario;
import home.loja.services.ProdutoService;

@RestController
@RequestMapping("v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("usuario")
    public ResponseEntity<String> metodoGetUsuario() {

        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(usuario);

        if (usuario.getPerfil().getNome().equals("Admin")) {

            return ResponseEntity.ok("Admin chegou aqui!");
        }
        return ResponseEntity.ok("Usuário chegou aqui!");
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<Page<ConsultaProdutoDTO>> buscarTodosOsProdutos(
            @PageableDefault(size = 3) Pageable pageable) {

        return ResponseEntity.ok(produtoService.listarTodosOsProdutos(pageable).map(ProdutoMapper::fromEntity));
    }

    @PostMapping
    public ResponseEntity<ConsultaProdutoDTO> salvarProduto(@RequestBody RegistroProdutoDTO dto) {

        Produto produto = produtoService.salvarProduto(ProdutoMapper.fromDTO(dto));

        return ResponseEntity.ok(ProdutoMapper.fromEntity(produto));
    }

    @GetMapping("{id}") // -> localhost:8080v1/produtos/{"id"} -> exemplo: localhost:8080v1/produtos/2
    public ResponseEntity<ConsultaProdutoDTO> buscarProduto(@PathVariable Long id) {

        // try {
        // Produto produto = produtoService.buscarProduto(id);

        // return ResponseEntity.ok(ProdutoMapper.fromEntity(produto));
        // } catch (RuntimeException ex) {

        // return ResponseEntity.notFound().build();
        // }
        Produto produto = produtoService.buscarProduto(id);

        return ResponseEntity.ok(ProdutoMapper.fromEntity(produto));
    }

    @PutMapping("{id}")
    public ResponseEntity<ConsultaProdutoDTO> alterarProduto(@RequestBody RegistroProdutoDTO dto,
            @PathVariable Long id) {

        // try {
        // Produto produto = produtoService.atualizarProduto(ProdutoMapper.fromDTO(dto),
        // id);

        // return ResponseEntity.ok(ProdutoMapper.fromEntity(produto));
        // } catch (RuntimeException ex) {

        // return ResponseEntity.notFound().build();
        // }
        Produto produto = produtoService.atualizarProduto(ProdutoMapper.fromDTO(dto), id);

        return ResponseEntity.ok(ProdutoMapper.fromEntity(produto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaProdutoDTO> excluirProduto(@PathVariable Long id) {

        // try {
        // produtoService.excluirProduto(id);

        // return ResponseEntity.ok().build();
        // } catch (RuntimeException ex) {

        // return ResponseEntity.notFound().build();
        // }
        produtoService.excluirProduto(id);

        return ResponseEntity.ok().build();
    }

}
