package com.samuek.apibanco.controller;

import com.samuek.apibanco.domain.Cliente;
import com.samuek.apibanco.domain.Conta;
import com.samuek.apibanco.service.ContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public List<Conta> listarTodas() {
        return contaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable Long id) {
        return contaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Conta salvar(@RequestBody Map<String, Object> dados) {
        Long clienteId = Long.valueOf(dados.get("clienteId").toString());
        String numero = dados.get("numero").toString();
        Double saldo = Double.valueOf(dados.get("saldo").toString());

        Cliente cliente = contaService.buscarCliente(clienteId);

        Conta conta = new Conta();
        conta.setNumero(numero);
        conta.setSaldo(saldo);
        conta.setCliente(cliente);

        return contaService.salvar(conta);
    }

    @PostMapping("/{id}/deposito")
    public Conta depositar(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        return contaService.depositar(id, body.get("valor"));
    }

    @PostMapping("/{id}/saque")
    public Conta sacar(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        return contaService.sacar(id, body.get("valor"));
    }
}
