package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaMovimentacao {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia(123);
		conta.setNumero(123456);
		conta.setSaldo(300.0);
		conta.setTitular("Japa");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.persist(movimentacao);
		manager.getTransaction().commit();
		manager.close();
		
		
		
		
	}

}
