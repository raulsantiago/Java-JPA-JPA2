package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager manager = emf.createEntityManager();
		
		// Estado de Manager
		Conta conta = new Conta();
		conta.setTitular("Pedro");
		conta.setNumero(123456);
		conta.setAgencia(321);
		conta.setSaldo(100.50);
		
		manager.getTransaction().begin();		
		
		manager.persist(conta);
		
		manager.getTransaction().commit();
		
		// Estado de Deteched
		manager.close();
		
		
		// Estado de Manager reinciar
		EntityManager manager2 = emf.createEntityManager();
		conta.setSaldo(500.0);		
		manager2.getTransaction().begin();
		manager2.merge(conta);
		manager2.getTransaction().commit();
		
	}
}
