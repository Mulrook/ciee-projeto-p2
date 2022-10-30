package br.com.cieeprojeto.cieeprojeto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Registration {
    @Id
    @Column(name = "person_id")
    @GeneratedValue
    private Long id;
    @Column(name = "person_name")
    private String name;
    @Column(name = "cpf")
    private Long cpf;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}
