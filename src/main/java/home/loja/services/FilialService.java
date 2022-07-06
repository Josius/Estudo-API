package home.loja.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import home.loja.entities.Filial;
import home.loja.exception.EntityNotFoundException;
import home.loja.repositories.FilialRepository;

@Service
public class FilialService {
    
// Boa prática ao desenvolver uma aplicação Spring
// Usar essa injeção de dependência ao invés do @Autowired
    private final FilialRepository filialRepository;

    public FilialService(FilialRepository filialRepository) {
        this.filialRepository = filialRepository;
    }

    public Filial salvarFilial(Filial filial){

        return filialRepository.save(filial);
    }

    public Page<Filial> listarTodasAsFiliais(Pageable pageable){

        return filialRepository.findAll(pageable);
    }

    public Filial buscarFilial(Long id) {
        
        Optional<Filial> optional = filialRepository.findById(id);

        // return optional.orElseThrow(() -> new RuntimeException("Filial não encontrada!"));
        return optional.orElseThrow(() -> new EntityNotFoundException("Filial não encontrada!"));
    }

    public Filial atualizarFilial(Filial filial, Long id) {

        Filial filialOriginal = this.buscarFilial(id);
        
        filial.setId(filialOriginal.getId());

        return filialRepository.save(filial);
    }

    public void excluirFilial(Long id) {
        
        Filial filialOriginal = this.buscarFilial(id);
        
        filialRepository.delete(filialOriginal);
    }
}
