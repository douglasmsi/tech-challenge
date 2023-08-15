package br.com.fiap.postech.fastfood.usecases.exception;

public class ClienteNaoEncontradoException extends RuntimeException{

    public ClienteNaoEncontradoException (String message){
        super(message);
    }
}
