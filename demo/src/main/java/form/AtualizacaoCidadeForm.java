package form;

import com.sun.istack.NotNull;
import modelo.Cidade;
import repository.CidadeRepository;

public class AtualizacaoCidadeForm {
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

    public Cidade atualizar(Long id, CidadeRepository cidadeRepository) {
        Cidade cidade = cidadeRepository.getReferenceById(id);

        cidade.setNome(this.nome);
        cidade.setRegiao(this.regiao);
        cidade.setPopulacao(this.populacao);
        cidade.setCapital(this.capital);
        cidade.setArea(this.area);

        return cidade;
    }
    public AtualizacaoCidadeForm setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public AtualizacaoCidadeForm setRegiao(String regiao) {
        this.regiao = regiao;
        return this;
    }

    public AtualizacaoCidadeForm setPopulacao(Long populacao) {
        this.populacao = populacao;
        return this;
    }

    public AtualizacaoCidadeForm setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public AtualizacaoCidadeForm setArea(Long area) {
        this.area = area;
        return this;
    }
}
