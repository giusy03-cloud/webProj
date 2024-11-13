package com.dipartimento.ristorantitwo.controller;

import com.dipartimento.ristorantitwo.model.Ristorante;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ristorante")  // Aggiungi un path base per gli endpoint legati ai ristoranti
public class GestioneRistorante {

    // Lista temporanea per memorizzare i ristoranti
    private List<Ristorante> ristoranti = new ArrayList<>();

    // Endpoint per visualizzare tutti i ristoranti
    @GetMapping("/elenco")
    public List<Ristorante> elencoRistoranti() {
        return ristoranti;
    }

    // Endpoint per aggiungere un ristorante
    @PostMapping("/addRistorante")
    public String aggiungiRistorante(@RequestBody Ristorante ristorante) {
        // Aggiungi il ristorante alla lista
        ristoranti.add(ristorante);

        // Stampa il nome del ristorante per il debug
        System.out.println("Ristorante aggiunto: " + ristorante.getNome());

        // Restituisci una risposta
        return "Ristorante aggiunto con successo: " + ristorante.getNome();
    }
}
