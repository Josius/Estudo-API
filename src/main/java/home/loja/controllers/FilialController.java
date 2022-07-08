package home.loja.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.loja.dto.filial.ConsultaFilialDTO;
import home.loja.dto.filial.FilialMapper;
import home.loja.dto.filial.RegistroFilialDTO;
import home.loja.entities.Filial;
import home.loja.services.FilialService;

@RestController
@RequestMapping("v1/filiais")
public class FilialController {

    private final FilialService filialService;

    public FilialController(FilialService filialService) {
        this.filialService = filialService;
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaFilialDTO>> buscarTodasAsFiliais(@PageableDefault() Pageable pageable) {

        
        // O método '.stream()...' pega o retorno de uma lista de objetos Filial e converte para uma lista de objetos ConsultaFilialDTO
        // return ResponseEntity.ok(filialService.listarTodasAsFiliais()
        //         .stream().map(FilialMapper::fromEntity).collect(Collectors.toList()));
        return ResponseEntity.ok(filialService.listarTodasAsFiliais(pageable).map(FilialMapper::fromEntity));
    }

    @PostMapping
    public ResponseEntity<ConsultaFilialDTO> salvarFilial(@RequestBody RegistroFilialDTO dto) {

        Filial filial = filialService.salvarFilial(FilialMapper.fromDTO(dto));

        return ResponseEntity.ok(FilialMapper.fromEntity(filial));
    }

    @GetMapping("{id}") // localhost:8080/v1/filiais/2
    public ResponseEntity<ConsultaFilialDTO> buscarFilial(@PathVariable Long id) {

        // Usando com 'return optional.orElseThrow(() -> new RuntimeException("Filial não encontrada!"));'' do FilialService->buscarFilial
        // try {
        //     Filial filial = filialService.buscarFilial(id);
        
        //     return ResponseEntity.ok(FilialMapper.fromEntity(filial));
        // } catch (RuntimeException ex) {

        //     return ResponseEntity.notFound().build();
        // }
        
        Filial filial = filialService.buscarFilial(id);

        return ResponseEntity.ok(FilialMapper.fromEntity(filial));
    }
    
    @PutMapping("{id}")
    public ResponseEntity<ConsultaFilialDTO> alterarFilial(@RequestBody RegistroFilialDTO dto, @PathVariable Long id) {

        // try {
        //     Filial filial = filialService.atualizarFilial(FilialMapper.fromDTO(dto), id);
            
        //     return ResponseEntity.ok(FilialMapper.fromEntity(filial));
        // } catch (RuntimeException ex) {
            
        //     return ResponseEntity.notFound().build();
        // }
        Filial filial = filialService.atualizarFilial(FilialMapper.fromDTO(dto), id);
        
        return ResponseEntity.ok(FilialMapper.fromEntity(filial));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaFilialDTO> excluirFilial(@PathVariable Long id) {
    
        // try {
        //     filialService.excluirFilial(id);
            
        //     return ResponseEntity.ok().build();
        // } catch (RuntimeException ex) {
            
        //     return ResponseEntity.notFound().build();
        // }
        filialService.excluirFilial(id);
        
        return ResponseEntity.ok().build();
    }

}
