package br.com.cliente.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Customer {
	private int id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private Calendar dataNascimento;
	private String salario;
	private String rg;
	private String telefone;



	public Customer(String nome, String sobrenome, String cpf, Calendar dataNascimento2, String salario, String rg,
			String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento2;
		this.salario = salario;
		this.rg = rg;
		this.telefone = telefone;
	}

	public Customer(int id, String nome, String sobrenome, String cpf, Calendar dataNascimento, String salario, String rg,
			String telefone) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.rg = rg;
		this.telefone = telefone;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		
		
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String formataData(Calendar data) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = df.format(dataNascimento.getTime());
		return dataFormatada;
		
	}
	
	


	public String toString() {
		String r = String.format(
				
				
				"%s %s, detentor do CPF %s e RG %s, nascido em %s cujo o salario é de %s e o telefone é %s", nome,
				sobrenome, cpf, rg, formataData(dataNascimento) , salario, telefone);

		return r;
	}

}
