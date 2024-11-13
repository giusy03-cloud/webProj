package com.dipartimento.ristorantitwo.persistence.dao;

import com.dipartimento.ristorantitwo.model.Ristorante;

import java.util.List;

public interface RistoranteDao {
    public List<Ristorante> findAll();
    public Ristorante findByPrimaryKey(String nome);
    public void save(Ristorante ristorante);
    public void delete(Ristorante ristorante);
}