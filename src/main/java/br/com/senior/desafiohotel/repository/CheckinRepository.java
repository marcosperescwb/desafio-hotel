package br.com.senior.desafiohotel.repository;

import br.com.senior.desafiohotel.model.Checkin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CheckinRepository extends CrudRepository<Checkin, Integer>,
        PagingAndSortingRepository<Checkin, Integer> {

    @Query(value = "SELECT hospede.id, hospede.nome, hospede.documento, hospede.telefone, \n" +
            "checkin.id_checkin, checkin.data_entrada, checkin.data_saida, checkin.adicional_veiculo  \n" +
            "from hospede,checkin \n" +
            " where (hospede.id = checkin.id)\n" +
            " and hospede.nome = :nome", nativeQuery = true)
    ArrayList<Checkin> getFindByName(@Param("nome") String nome);

    @Query(value = "SELECT hospede.id, hospede.nome, hospede.documento, hospede.telefone, \n" +
            "checkin.id_checkin, checkin.data_entrada, checkin.data_saida, checkin.adicional_veiculo  \n" +
            "from hospede,checkin \n" +
            " where (hospede.id = checkin.id)\n" +
            " and hospede.documento = :documento", nativeQuery = true)
    ArrayList<Checkin> getFindByDoc(@Param("documento") String nome);

    @Query(value = "SELECT hospede.id, hospede.nome, hospede.documento, hospede.telefone, \n" +
            "checkin.id_checkin, checkin.data_entrada, checkin.data_saida, checkin.adicional_veiculo  \n" +
            "from hospede,checkin \n" +
            " where (hospede.id = checkin.id)\n" +
            " and hospede.telefone = :telefone", nativeQuery = true)
    ArrayList<Checkin> getFindByFone(@Param("telefone") String nome);

    @Query(value = "SELECT hospede.id, hospede.nome, hospede.documento, hospede.telefone, \n" +
            "checkin.id_checkin, checkin.data_entrada, checkin.data_saida, checkin.adicional_veiculo  \n" +
            " from checkin, hospede \n" +
            " where (hospede.id = checkin.id)\n" +
            " and checkin.data_saida is null", nativeQuery = true)
    ArrayList<Checkin> findHospedados();

    @Query(value = "SELECT hospede.id, hospede.nome, hospede.documento, hospede.telefone, \n" +
            "checkin.id_checkin, checkin.data_entrada, checkin.data_saida, checkin.adicional_veiculo  \n" +
            " from checkin, hospede \n" +
            " where (hospede.id = checkin.id)\n" +
            " and checkin.data_saida is not null", nativeQuery = true)
    ArrayList<Checkin> findCheckout();



}
