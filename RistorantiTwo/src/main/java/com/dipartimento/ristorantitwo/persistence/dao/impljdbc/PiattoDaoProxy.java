package com.dipartimento.ristorantitwo.persistence.dao.impljdbc;

import com.dipartimento.ristorantitwo.model.Piatto;
import com.dipartimento.ristorantitwo.persistence.dao.PiattoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PiattoDaoProxy implements PiattoDao {

    private static final Logger logger = LoggerFactory.getLogger(PiattoDaoProxy.class);
    private final PiattoDao piattoDao; // Riferimento al vero DAO

    // Il proxy riceve il vero DAO come dipendenza attraverso il costruttore
    public PiattoDaoProxy(PiattoDao piattoDao) {
        this.piattoDao = piattoDao;
    }

    @Override
    public List<Piatto> findAll() {
        logger.info("Esecuzione del metodo findAll()");
        long startTime = System.nanoTime(); // Inizio del conteggio del tempo
        List<Piatto> result = piattoDao.findAll(); // Delegazione al vero DAO
        long endTime = System.nanoTime(); // Fine del conteggio del tempo
        logger.info("findAll() eseguito in " + (endTime - startTime) + " nanosecondi.");
        return result;
    }

    @Override
    public Piatto findByPrimaryKey(String nome) {
        logger.info("Esecuzione del metodo findByPrimaryKey per il piatto con nome: " + nome);
        long startTime = System.nanoTime();
        Piatto result = piattoDao.findByPrimaryKey(nome); // Delegazione al vero DAO
        long endTime = System.nanoTime();
        logger.info("findByPrimaryKey() eseguito in " + (endTime - startTime) + " nanosecondi.");
        return result;
    }

    @Override
    public void save(Piatto piatto) {
        logger.info("Esecuzione del metodo save per il piatto: " + piatto.getNome());
        long startTime = System.nanoTime();
        piattoDao.save(piatto); // Delegazione al vero DAO
        long endTime = System.nanoTime();
        logger.info("save() eseguito in " + (endTime - startTime) + " nanosecondi.");
    }

    @Override
    public void delete(Piatto piatto) {
        logger.info("Esecuzione del metodo delete per il piatto: " + piatto.getNome());
        long startTime = System.nanoTime();
        piattoDao.delete(piatto); // Delegazione al vero DAO
        long endTime = System.nanoTime();
        logger.info("delete() eseguito in " + (endTime - startTime) + " nanosecondi.");
    }

    @Override
    public List<Piatto> findAllByRistoranteName(String name) {
        logger.info("Esecuzione del metodo findAllByRistoranteName per il ristorante: " + name);
        long startTime = System.nanoTime();
        List<Piatto> result = piattoDao.findAllByRistoranteName(name); // Delegazione al vero DAO
        long endTime = System.nanoTime();
        logger.info("findAllByRistoranteName() eseguito in " + (endTime - startTime) + " nanosecondi.");
        return result;
    }
}
