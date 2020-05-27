package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {
		
		// Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(123);
		conta.setNumero(123456789);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		
		// Transient -> Managed
		manager.persist(conta);
		
		// Managed -> Remove
		manager.remove(conta);
		
		manager.getTransaction().commit();
		
		
		
		
		
		
	}
}
