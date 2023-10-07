package com.registroVacinacao.service;

import com.registroVacinacao.entity.RegistroVacinacao;
import com.registroVacinacao.repository.RegistroVacinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class RegistroVacinacaoService {
    @Autowired
    RegistroVacinacaoRepository registroVacinacaoRepository;

    public List<RegistroVacinacao> listarRegistroVacinacao() {
        return registroVacinacaoRepository.findAll();
    }

    public RegistroVacinacao buscarRegistroVacinacao(String id) throws Exception {

        Optional<RegistroVacinacao> registroVacinacaoOptional = registroVacinacaoRepository.findById(id);

        if (!registroVacinacaoOptional.isPresent()) {
            throw new Exception("Registro de Vacinação não encontrado!");
        }

        return registroVacinacaoOptional.get();
    }

    public void criarRegistroVacinacao(RegistroVacinacao registroVacinacao) {
        registroVacinacaoRepository.insert(registroVacinacao);
    }

    public RegistroVacinacao atualizarRegistroVacinacao(String id, RegistroVacinacao registroVacinacao) throws Exception {
        RegistroVacinacao registroVacinacaoAntigo = buscarRegistroVacinacao(id);

        registroVacinacaoAntigo.setNomeProfissional(registroVacinacao.getNomeProfissional());
        registroVacinacaoAntigo.setSobrenomeProfissional(registroVacinacao.getSobrenomeProfissional());
        registroVacinacaoAntigo.setDataVacinacao(registroVacinacao.getDataVacinacao());
        registroVacinacaoAntigo.setCpfProfissional(registroVacinacao.getCpfProfissional());
        registroVacinacaoAntigo.setIdentificacaoPaciente(registroVacinacao.getIdentificacaoPaciente());
        registroVacinacaoAntigo.setIdentificacaoVacina(registroVacinacao.getIdentificacaoVacina());
        registroVacinacaoAntigo.setIdentificacaoDose(registroVacinacao.getIdentificacaoDose());

        registroVacinacaoRepository.save(registroVacinacaoAntigo);

        return registroVacinacaoAntigo;
    }

    public void excluirRegistroVacinacao(String id) throws Exception {
        RegistroVacinacao registroVacinacao = buscarRegistroVacinacao(id);

        registroVacinacaoRepository.delete(registroVacinacao);

    }

}
