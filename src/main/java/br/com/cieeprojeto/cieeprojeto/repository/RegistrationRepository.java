package br.com.cieeprojeto.ciee.repository;

import br.com.cieeprojeto.cieeprojeto.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    boolean existsById(Long id);

    Registration getById(Long id);

    boolean existsByCpf(Long cpf);

    Registration getByCpf(Long cpf);


}
