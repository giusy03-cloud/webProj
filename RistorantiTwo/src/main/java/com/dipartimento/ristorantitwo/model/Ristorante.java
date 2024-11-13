package com.dipartimento.ristorantitwo.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ristorante {

    protected String nome;
    protected String descrizione;
    protected String ubicazione;
    protected List<Piatto> piatti;

}
