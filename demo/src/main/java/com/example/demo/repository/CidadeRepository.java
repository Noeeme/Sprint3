package repository;

import modelo.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Page<Cidade> findByRegiao(String regiao, Pageable paginacao);

    Page<Cidade> findByPopulacao(Long populacao, Pageable paginacao);
}

