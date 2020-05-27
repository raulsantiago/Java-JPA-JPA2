package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {
	
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Neg�cios");
		
		Conta conta = new Conta();
		conta.setId((long) 2);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem � SP");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300.0));
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem � RJ");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(350.0));
		movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao2.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager manager = emf.createEntityManager();		
			
		manager.getTransaction().begin();
		manager.persist(categoria);
		manager.persist(categoria2);
		manager.persist(movimentacao);
		manager.persist(movimentacao2);		
		manager.getTransaction().commit();	
		manager.close();
		
	}

}