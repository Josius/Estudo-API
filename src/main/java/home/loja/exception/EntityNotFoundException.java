package home.loja.exception;

public class EntityNotFoundException extends LojaException {

    // VSCode não gera essa variável constante, precisa gerar a mão.
    // Verificar se funciona fazendo a mão, do contrário, tentar sem ou com implements serializable
    private static final long serialVersionUID = 8766566498150867601L;

    public EntityNotFoundException(String message) {
        super(message);
    }
    
}
