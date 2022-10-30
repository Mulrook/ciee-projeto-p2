package br.com.cieeprojeto.cieeprojeto.controller;

import br.com.cieeprojeto.cieeprojeto.model.Registration;
import br.com.cieeprojeto.cieeprojeto.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/registration")
public class RegistrationController {

    private final RegistrationService registrationService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Registration> save(@RequestBody Registration registration){

        return new ResponseEntity<>(registrationService.save(registration), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Registration>> list(){

        List<Registration> registrationList = registrationService.findAllRegistration ();

        return new ResponseEntity<>(registrationList,HttpStatus.OK);
    }

    @GetMapping(path = "{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Registration> findByCpf(@PathVariable(value = "cpf", required = false) Long cpf){

        return new ResponseEntity<>(registrationService.findByCpf(cpf), HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Registration> replace(@RequestBody Registration registration){

        Registration registration1 = registrationService.findByCpf(registration.getCpf());

        registration1.setName(registration.getName());
        registration1.setCpf(registration.getCpf());

        registrationService.update(registration1);

        return new ResponseEntity<>(registration1,HttpStatus.OK);
    }

    @DeleteMapping(path = "{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable(value = "cpf", required = false) Long cpf){

        registrationService.delete(cpf);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
