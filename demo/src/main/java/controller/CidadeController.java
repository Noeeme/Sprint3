package controller;

import form.AtualizacaoCidadeForm;
import form.CidadeForm;
import lombok.AllArgsConstructor;
import modelo.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import repository.CidadeRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/states")
public class CidadeController {


    CidadeRepository cidadeRepository;

    @GetMapping
    public List<Cidade> listar(){
        return cidadeRepository.findAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Cidade> cadastrar(@RequestBody @Valid CidadeForm form, UriComponentsBuilder uriBuilder) {
        Cidade cidade = form.converter(cidadeRepository);
        cidadeRepository.save(cidade);
        URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(cidade.getId()).toUri();
        return ResponseEntity.created(uri).body(cidade);
    }

    @GetMapping("/{id}")
    public Page<Cidade> listarPorRegiao(@PathVariable String regiao,
                                        @PageableDefault(sort = "regiao", page = 0, size = 10) Pageable paginacao){
        if(paginacao.getSort() == null){
            Page<Cidade> cidades = cidadeRepository.findAll(paginacao);
            return cidades;
        }else{
            Page<Cidade> cidades = cidadeRepository.findByRegiao(regiao, paginacao);
            return cidades;
        }
    }

    @GetMapping("/{id}")
    public Page<Cidade> listarPorPopulacao(@PathVariable Long populacao,
                                           @PageableDefault(sort = "populacao", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao){
            Page<Cidade> cidades = cidadeRepository.findByPopulacao(populacao, paginacao);
            return cidades;
    }

    @GetMapping("/{id}")
    public Page<Cidade> listarPorArea(@PathVariable Long area,
                                           @PageableDefault(sort = "populacao", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao){
        Page<Cidade> cidades = cidadeRepository.findByPopulacao(area, paginacao);
        return cidades;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Cidade> optional = cidadeRepository.findById(id);
        if (optional.isPresent()) {
            cidadeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Cidade> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCidadeForm form) {
        Optional<Cidade> optional = cidadeRepository.findById(id);
        if (optional.isPresent()) {
            Cidade topico = form.atualizar(id, cidadeRepository);
            return ResponseEntity.ok(new Cidade());
        }

        return ResponseEntity.notFound().build();
    }
}
