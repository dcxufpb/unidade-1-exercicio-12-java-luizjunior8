package com.example.project;

public class Coordenador {

    private String nomeCoordenador;
    private int idade;
    private String cpf;

    public Coordenador(String nomeCoordenador, int idade, String cpf) {
        this.nomeCoordenador = nomeCoordenador;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNomeCoordenador() {
        return this.nomeCoordenador;
    }

    public void setNomeCoordenador(String nomeCoordenador) {
        this.nomeCoordenador = nomeCoordenador;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static String Spacer = System.lineSeparator();


    public static boolean checker (String tested){
		String k = "";
		k += tested;
		if (k.equals("null")|| k.isEmpty()){
			return false;
		}	
		return true;	
    }

    public void validar_dados_obrigatorios() {

        if (checker(this.getNomeCoordenador()) == false){
			throw new RuntimeException ("O nome do coordenador é obrigatório");
        }

        if (checker(this.getCpf()) == false){
			throw new RuntimeException ("O cpf do coordenador é obrigatório");
        }
    }

    public String dadosCoordenador() {

        validar_dados_obrigatorios();

        String idadeCoord = this.getIdade() == 0? "" : this.getIdade() + " anos" + Spacer;

        String cpfCoord = "CPF: " + this.getCpf();

        return (this.getNomeCoordenador() + Spacer +
        idadeCoord + 
        cpfCoord);
    }
}