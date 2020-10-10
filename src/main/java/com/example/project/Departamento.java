package com.example.project;

public class Departamento {

    private String nomeDepartamento;
    private String sigla;
    private String localizacao;
    private Coordenador coordenador;

    public Departamento(String nomeDepartamento, String sigla,
                        String localizacao, Coordenador coordenador){
        this.nomeDepartamento = nomeDepartamento;
        this.sigla = sigla;
        this.localizacao = localizacao;
        this.coordenador = coordenador;
    }

    public String getNomeDepartamento() {
        return this.nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Coordenador getCoordenador() {
        return this.coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
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

        if (checker(this.getNomeDepartamento()) == false){
			throw new RuntimeException ("O nome do departamento é obrigatório");
        }

        if (checker(this.getLocalizacao()) == false){
			throw new RuntimeException ("A localização do departamento é obrigatória");
        }
    }

    public String dadosDepartamento() {

        validar_dados_obrigatorios();

        String siglaDepto = checker(this.sigla) == false? "" : this.sigla;

        String localDepto = checker(this.localizacao) == false? "" : this.localizacao;

        return (this.getNomeDepartamento() + Spacer +
        siglaDepto + Spacer +
        localDepto + Spacer + 
        this.coordenador.dadosCoordenador()) + Spacer;


    }


    
}
