package form;

import com.sun.istack.NotNull;
import modelo.Cidade;
import repository.CidadeRepository;

public class CidadeForm {
    @NotNull
    private String nome;
    @NotNull
    private String regiao;
    @NotNull
    private Long populacao;
    @NotNull
    private String capital;
    @NotNull
    private Long area;

    public CidadeForm setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public CidadeForm setRegiao(String regiao) {
        this.regiao = regiao;
        return this;
    }

    public CidadeForm setPopulacao(Long populacao) {
        this.populacao = populacao;
        return this;
    }

    public CidadeForm setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public CidadeForm setArea(Long area) {
        this.area = area;
        return this;
    }

    public Cidade converter(CidadeRepository cidadeRepository) {
        return new Cidade(nome, regiao, populacao, capital, area);
    }
}
