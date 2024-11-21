package com.dipartimento.ristorantitwo.persistence.dao;

import com.dipartimento.ristorantitwo.model.Piatto;
import com.dipartimento.ristorantitwo.model.Ristorante;

import java.util.List;

//interfaccia che definisce le operazioni CRUD per la gestione dei piatti
//nel database
public interface PiattoDao {

    //recupera tutti i piatti
    public List<Piatto> findAll();

    //trova un piatto tramite il suo nome
    public Piatto findByPrimaryKey(String nome);

    //salva un nuovo piatto nel DB
    public void save(Piatto piatto);

    //elimina piatto da DB
    public void delete(Piatto piatto);

    //trova tutti i piatti associati a un determinato ristorante
    //identificato dal suo nome
    List<Piatto> findAllByRistoranteName(String name);




}