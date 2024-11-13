package com.dipartimento.ristorantitwo.persistence.dao.impljdbc;

import com.dipartimento.ristorantitwo.model.Piatto;
import com.dipartimento.ristorantitwo.model.Ristorante;
import com.dipartimento.ristorantitwo.persistence.DBManager;
import com.dipartimento.ristorantitwo.persistence.dao.PiattoDao;
import com.dipartimento.ristorantitwo.persistence.dao.RistoranteDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//la classe piattoDaoJDBC implementa l'interfaccia PiattoDao,
//quindi deve implementare tutti i metodi definiti nell'interffacia
//per accedere ai dati dei piatti
public class PiattoDaoJDBC implements PiattoDao {

    Connection connection;


    public PiattoDaoJDBC(Connection conn){
        this.connection = conn; //inizializzo conn al database

        //questo consente al Dao di utilizzare questa connessione
        //per eseguire operazioni sul database
    }

    @Override
    public List<Piatto> findAll() {
        //metodo che recupera tutti i piatti dalla tabella piatto nel DB
        List<Piatto> piatti = new ArrayList<Piatto>(); //lista per memorizzare i piatti recuperati dal DB
        String sql = "SELECT * FROM piatto"; //la query SQL per selezionare tutti i piatti
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) { //result set contiene i risultati della query
            while (rs.next()) {
                String nome = rs.getString("nome"); //recupera il nome del piatto
                String ingredienti = rs.getString("ingredienti"); //recupera gli ingredienti
                Piatto piatto = new Piatto(nome, ingredienti); //crea un oggetto piatto
                piatti.add(piatto); //aggiungo il nuovo oggetto alla losta
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return piatti; //restituisce la lista piatti

    }

    @Override
    public Piatto findByPrimaryKey(String nome) {
        //cerco un piatto specifico nel database utilizzando il suo nome
        //come chiave primaria
        Piatto piatto=null; //inizializza la variabile che conterrà il piatto trovato
        String sql = "SELECT * FROM piatto WHERE nome = ?"; //uso la query SQL per trovare un piatto per nome
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nome);//imposta il parametro 'nome' nella query
            ResultSet rs = ps.executeQuery(); //eseguo la query
            if (rs.next()) { //se c'è almeno un risultato
                String ingredienti = rs.getString("ingredienti"); //cercupero gli ingredienti
                piatto = new Piatto(nome, ingredienti); //creo un oggetto Piatto
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return piatto; //restituisce il piatto trovato o null se non è stato trovato
    }

    @Override
    public void save(Piatto piatto) {
        //inserisce un nuovo piatto nel DB
        String sql = "INSERT INTO piatto (nome, ingredienti) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, piatto.getNome()); //imposto param 'nome'
            ps.setString(2, piatto.getIngredienti()); //imposto param 'ingredienti'
            ps.executeUpdate(); //eseguo operazione di inserimento
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Piatto piatto) {
        //elimino un piatto dal DB in base al suo nome
        String sql = "DELETE FROM piatto WHERE nome = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1,piatto.getNome()); //imposto param 'nome'
            ps.executeUpdate(); //eseguo operazione di eliminazione
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Piatto> findAllByRistoranteName(String name) {
        //recupera tutti i piatti associati ad un ristorante specifico
        List<Piatto> piatti = new ArrayList<>(); //lista per memorizzare i piatti
        String sql = "SELECT p.* FROM piatto p " +
                "JOIN ristorante_piatto rp ON p.nome = rp.piatto_nome " +
                "JOIN ristorante r ON rp.ristorante_nome = r.nome " +
                "WHERE r.nome = ?"; //query SQL per trovare i poatti di uno specifico ristorante
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name); //imposta 'name' alla query
            ResultSet rs = ps.executeQuery(); //eseguo la query
            while (rs.next()) {
                String nome = rs.getString("nome");
                String ingredienti = rs.getString("ingredienti");
                Piatto piatto = new Piatto(nome, ingredienti);
                piatti.add(piatto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return piatti;
    }
}