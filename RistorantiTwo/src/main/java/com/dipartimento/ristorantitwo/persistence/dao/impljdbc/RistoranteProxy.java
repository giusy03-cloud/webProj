package com.dipartimento.ristorantitwo.persistence.dao.impljdbc;

import com.dipartimento.ristorantitwo.model.Piatto;
import com.dipartimento.ristorantitwo.model.Ristorante;
import com.dipartimento.ristorantitwo.persistence.DBManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


public class RistoranteProxy extends Ristorante {


    public List<Piatto> getPiatti() {
        if(this.piatti==null){
            this.piatti= DBManager.getInstance().getPiattoDao().findAllByRistoranteName(this.nome);
        }
        return piatti;
    }

}