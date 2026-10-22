package br.com.protons.sprintapi.dto;

import br.com.protons.sprintapi.model.Alternativa;

public record AlternativaResponse(Long id, String texto, boolean correta) {

    public static AlternativaResponse de(Alternativa a) {
        return new AlternativaResponse(a.getId(), a.getTexto(), a.isCorreta());
    }
}
