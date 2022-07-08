package home.loja.exception;

public class LojaException extends RuntimeException {
    
    // VSCode não gera essa variável constante, precisa gerar a mão.
    // Verificar se funciona fazendo a mão, do contrário, tentar sem ou com implements serializable
    private static final long serialVersionUID = -7491873932486289748L;
    

    private String message;

    public LojaException(String message){
        super(message); // chamada para o construtor do RuntimeException passando a message
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
