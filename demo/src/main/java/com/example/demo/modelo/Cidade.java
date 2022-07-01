package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String regiao;
    private Long populacao;
    private String capital;
    private Long area;

    public Cidade(String nome, String regiao, Long populacao, String capital, Long area) {
    }

    public Long getId() {
        return id;
    }

    public Cidade setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cidade setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getRegiao() {
        return regiao;
    }

    public Cidade setRegiao(String regiao) {
        this.regiao = regiao;
        return this;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public Cidade setPopulacao(Long populacao) {
        this.populacao = populacao;
        return this;
    }

    public String getCapital() {
        return capital;
    }

    public Cidade setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public Long getArea() {
        return area;
    }

    public Cidade setArea(Long area) {
        this.area = area;
        return this;
    }
}
