package br.com.senior.desafiohotel.repository;

import br.com.senior.desafiohotel.model.Checkin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckinRepository extends CrudRepository<Checkin, Integer> {

}
