package com.samuek.apibanco.service;

import com.samuek.apibanco.domain.Cliente;
import com.samuek.apibanco.domain.Conta;
import com.samuek.apibanco.repository.ClienteRepository;
import com.samuek.apibanco.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    public ContaService(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Conta> listarTodas() {
        return contaRepository.findAll();
    }

    public Optional<Conta> buscarPorId(Long id) {
        return contaRepository.findById(id);
    }

    public Conta salvar(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta depositar(Long id, Double valor) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        conta.setSaldo(conta.getSaldo() + valor);
        return contaRepository.save(conta);
    }

    public Conta sacar(Long id, Double valor) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        if (conta.getSaldo() < valor) {
            throw new RuntimeException("Saldo insuficiente");
        }

        conta.setSaldo(conta.getSaldo() - valor);
        return contaRepository.save(conta);
    }

    public Cliente buscarCliente(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
