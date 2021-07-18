package br.com.senior.desafiohotel.repository;

import br.com.senior.desafiohotel.model.CheckinModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public interface CheckinRepository extends CrudRepository<CheckinModel, Integer> {

}
