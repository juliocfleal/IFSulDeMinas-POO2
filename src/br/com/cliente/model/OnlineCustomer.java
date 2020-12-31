package br.com.cliente.model;

import java.util.Calendar;

public class OnlineCustomer extends Customer {

	public OnlineCustomer(int id, String nome, String sobrenome, String cpf, Calendar dataNascimento, String salario,
			String rg, String telefone) {
		super(id, nome, sobrenome, cpf, dataNascimento, salario, rg, telefone);

	}

	public OnlineCustomer(String nome, String sobrenome, String cpf, Calendar dataNascimento, String salario, String rg,
			String telefone) {
		super(nome, sobrenome, cpf, dataNascimento, salario, rg, telefone);

	}

	public String toString() {
		String r = String.format("Cliente online: %s", super.toString());

		return r;

	}

}
