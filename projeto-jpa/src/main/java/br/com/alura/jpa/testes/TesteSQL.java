package br.com.alura.jpa.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TesteSQL {
	public static void main(String[] args) throws Exception {		
		Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/alura_jpa", "postgres", "luar");
		String sql = "insert into Conta(id, agencia, numero, titular, saldo) values(?,?,?,?,?)";
		
		PreparedStatement ps = cnn.prepareStatement(sql);
		ps.setLong(1, 3L);
		ps.setInt(2, 1234);
		ps.setInt(3, 4321);
		ps.setString(4, "Jonas");
		ps.setDouble(5, 900.0);
		
		ps.execute();		
		System.out.println("Inserido com sucesso!");
	}
}