package com.dipartimento.ristorantitwo.persistence.dao.impljdbc;

import com.dipartimento.ristorantitwo.model.Piatto;
import com.dipartimento.ristorantitwo.model.Ristorante;
import com.dipartimento.ristorantitwo.persistence.DBManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//implementa il pattern Proxy per gestire l'accesso alla lista dei
//piatti associati a un ristorante

public class RistoranteProxy extends Ristorante {

    //il pattern proxy è utilizzato per controllare l'accesso a un oggetto
    //solitamente per gestire la sua creazione o per ritardare il caricamento dei dati pesanti
    //come in questo caso i piatti di un ristorante

    //estende Ristorante quindi eredita tutti i metodi e le proprietà


    //questo metodo restituisce la lista dei piatti associati a un ristorante
    public List<Piatto> getPiatti() {
        if(this.piatti==null){
            this.piatti= DBManager.getInstance().getPiattoDao().findAllByRistoranteName(this.nome);
        }
        return piatti;
    }

}