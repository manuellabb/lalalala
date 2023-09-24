package com.example.api_estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoController(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/selecionar")
    public List<Transacao> listarTransacoes(){
        List<Transacao> resposta = transacaoRepository.findAll();
        System.out.println(resposta);
        return resposta;
    }

    @PostMapping("/inserir")
    public ResponseEntity<String> inserirTransacao(@RequestBody Transacao transacao){
        transacaoRepository.save(transacao);
        return ResponseEntity.ok("transacao realizada com sucesso");
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String>ExcluirTransacao(@PathVariable Long id){
        transacaoRepository.deleteById(id);
        return ResponseEntity.ok("Produto excluido com sucesso");
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<String> atualizarDescricaoTransacao(@PathVariable Long id, @RequestBody Transacao transacaoAtualizada ){
        Optional<Transacao> transacaoExistente = transacaoRepository.findById(id);
        if(transacaoExistente.isPresent()){
            Transacao transacao = transacaoExistente.get();
            transacao.setDescricao(transacaoAtualizada.getDescricao());
            transacao.setData_transacao(transacaoAtualizada.getData_transacao());
            transacao.setValor(transacaoAtualizada.getValor());
            transacao.setTipo_transacao(transacaoAtualizada.getTipo_transacao());
            transacaoRepository.save(transacao);
            return ResponseEntity.ok("Transacao atualizado com sucesso");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/selecionar/tipo/{tipo}")
    public List<Transacao> selecionarPorTipo(@PathVariable String tipo){
        return transacaoRepository.findAllByTipo(tipo);
    }
}
