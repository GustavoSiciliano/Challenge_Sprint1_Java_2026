package br.com.protons.sprintapi.model;

/** Faixa etaria da pergunta. A pontuacao por acerto depende da categoria. */
public enum Categoria {
    CRIANCA(10),
    JOVEM(20),
    ADULTO(30);

    private final int pontos;

    Categoria(int pontos) {
        this.pontos = pontos;
    }

    public int getPontos() {
        return pontos;
    }
}
