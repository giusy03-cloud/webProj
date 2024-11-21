package com.dipartimento.ristorantitwo.model;

public class Piatto {

    private String nome;
    private String ingredienti;

    // Costruttore senza argomenti (equivalente a @NoArgsConstructor)
    public Piatto() {
    }

    // Costruttore con tutti i campi (equivalente a @AllArgsConstructor)
    public Piatto(String nome, String ingredienti) {
        this.nome = nome;
        this.ingredienti = ingredienti;
    }

    // Getter per 'nome'
    public String getNome() {
        return nome;
    }

    // Setter per 'nome'
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter per 'ingredienti'
    public String getIngredienti() {
        return ingredienti;
    }

    // Setter per 'ingredienti'
    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    // Metodo toString per la rappresentazione della classe
    @Override
    public String toString() {
        return "Piatto{" +
                "nome='" + nome + '\'' +
                ", ingredienti='" + ingredienti + '\'' +
                '}';
    }

}
