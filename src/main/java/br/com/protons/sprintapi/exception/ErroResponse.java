package br.com.protons.sprintapi.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ErroResponse(LocalDateTime timestamp, int status, String mensagem, Map<String, String> campos) {

    public ErroResponse(int status, String mensagem) {
        this(LocalDateTime.now(), status, mensagem, null);
    }

    public ErroResponse(int status, String mensagem, Map<String, String> campos) {
        this(LocalDateTime.now(), status, mensagem, campos);
    }
}
