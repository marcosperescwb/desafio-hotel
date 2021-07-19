package br.com.senior.desafiohotel.repository;

import br.com.senior.desafiohotel.controller.HospedeController;
import br.com.senior.desafiohotel.model.Hospede;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeRepository extends  CrudRepository<Hospede, Integer>,
                                            PagingAndSortingRepository<Hospede, Integer> {

    @Query(value = "Select * from hospede order by nome", nativeQuery = true)
    HospedeController findHospede();

}
