package home.loja.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import home.loja.dto.ApiErrorDTO;

// Toda exceção que ocorrer, o spring irá procurar essa classe para resolver
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ LojaException.class }) // Aqui pode receber uma lista de exception, mas está recebendo só uma
    public ResponseEntity<ApiErrorDTO> handleLojaException(LojaException ex, WebRequest request) {

        String error = "Erro no sistema[loja]."; // Em colchetes, usando só para me orientar

        ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ ProdutoException.class }) // Aqui pode receber uma lista de exception, mas está recebendo só uma
    public ResponseEntity<ApiErrorDTO> handleProdutoException(ProdutoException ex, WebRequest request) {

        String error = "Erro no sistema[produto]."; // Em colchetes, usando só para me orientar

        ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ ClienteException.class }) // Aqui pode receber uma lista de exception, mas está recebendo só uma
    public ResponseEntity<ApiErrorDTO> handleClienteException(ClienteException ex, WebRequest request) {

        String error = "Erro no sistema[cliente]."; // Em colchetes, usando só para me orientar

        ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ FornecedorException.class }) // Aqui pode receber uma lista de exception, mas está recebendo só
                                                     // uma
    public ResponseEntity<ApiErrorDTO> handleFornecedorException(FornecedorException ex, WebRequest request) {

        String error = "Erro no sistema[fornecedor]."; // Em colchetes, usando só para me orientar

        ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ EntityNotFoundException.class }) // Aqui pode receber uma lista de exception, mas está recebendo
                                                         // só uma
    public ResponseEntity<ApiErrorDTO> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {

        String error = "Recurso não encontrado.";

        ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.NOT_FOUND);

        return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}
