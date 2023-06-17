package br.com.fiap.postech.fastfood.core.services.exception;

public class ClienteNaoEncontradoException extends RuntimeException{

    public ClienteNaoEncontradoException (String message){
        super(message);
    }
}
