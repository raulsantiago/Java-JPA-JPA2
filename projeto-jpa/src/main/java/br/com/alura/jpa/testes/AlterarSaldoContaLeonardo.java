package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlterarSaldoContaLeonardo {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager manager = emf.createEntityManager();
		
		// 1L é o Id 1 da tabela.
		Conta contaLeonardo = manager.find(Conta.class, 1L);
		
		manager.getTransaction().begin();
		
		contaLeonardo.setSaldo(20.05);
		
		manager.getTransaction().commit();
		
		System.out.println("Conta do Leo => " + contaLeonardo.getTitular());
		
		
	}

}
