package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager manager = emf.createEntityManager();
		
		
		Conta conta = new Conta();
		conta.setTitular("Julinao");
		conta.setNumero(123456789);
		conta.setAgencia(20);
		conta.setSaldo(500.01);
		
		manager.getTransaction().begin();		
		
		manager.persist(conta);
		
		manager.getTransaction().commit();
	}

}
