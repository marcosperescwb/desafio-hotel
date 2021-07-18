package br.com.senior.desafiohotel.repository;

import br.com.senior.desafiohotel.model.Hospede;
import org.springframework.data.repository.CrudRepository;

public interface HospedeRepository extends CrudRepository<Hospede, Integer> {
}
