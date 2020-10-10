package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class TestDepartamento {

    private void rodarTestarRetorno(String expected, Departamento departamento) {
        // action
        String retorno = departamento.dadosDepartamento();
        // assertion
        assertEquals(expected, retorno);
        }
    
        private void verificarCampoObrigatorio(String mensagemEsperada, Departamento departamento) {
            try {
                departamento.dadosDepartamento();
            } catch (RuntimeException e) {
                assertEquals(mensagemEsperada, e.getMessage());
            }
        }

    private String BREAK = System.lineSeparator();

    private String NOME_DEPARTAMENTO = "Depto. test.";
    private String SIGLA = "D1";
    private String LOCALIZACAO = "Local 1";
    private String NOME_COORDENADOR = "Coord. 1";
    private int IDADE = 40;
    private String CPF = "111.222.333-44";

    private String TEXTO_ESPERADO_DEPARTAMENTO_COMPLETO = "Depto. test." + BREAK + "D1" + BREAK
            + "Local 1" + BREAK + "Coord. 1" + BREAK + "40 anos" + BREAK + "CPF: 111.222.333-44" + BREAK;

    public void departamentoCompleto() {
        Departamento departamentoCompleto = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO,
                                            new Coordenador(NOME_COORDENADOR, IDADE, CPF));                
        rodarTestarRetorno(TEXTO_ESPERADO_DEPARTAMENTO_COMPLETO, departamentoCompleto);
    }

    public void NomeDepartamentoVazio() {
        Departamento nomeDepartamentoVazio = new Departamento("", SIGLA, LOCALIZACAO,
                                            new Coordenador(NOME_COORDENADOR, IDADE, CPF));
		verificarCampoObrigatorio("O nome do departamento é obrigatório", nomeDepartamentoVazio);

		Departamento nomeDepartamentoNulo = new Departamento(null, SIGLA, LOCALIZACAO,
                                            new Coordenador(NOME_COORDENADOR, IDADE, CPF));
		verificarCampoObrigatorio("O nome do departamento é obrigatório", nomeDepartamentoNulo);
    }
    
    private String TEXTO_ESPERADO_SEM_SIGLA = "Depto. test." + BREAK + "" + BREAK
            + "Local 1" + BREAK + "Coord. 1" + BREAK + "40 anos" + BREAK + "CPF: 111.222.333-44" + BREAK;
            
    public void semSigla() {
        Departamento siglaVazia = new Departamento(NOME_DEPARTAMENTO, "", LOCALIZACAO,
                                            new Coordenador(NOME_COORDENADOR, IDADE, CPF));                
        rodarTestarRetorno(TEXTO_ESPERADO_SEM_SIGLA, siglaVazia);

        Departamento siglaNula = new Departamento(NOME_DEPARTAMENTO, null, LOCALIZACAO,
                                            new Coordenador(NOME_COORDENADOR, IDADE, CPF));                
        rodarTestarRetorno(TEXTO_ESPERADO_SEM_SIGLA, siglaNula);
    }

    public void localDepartamentoVazio() {
        Departamento localDepartamentoVazio = new Departamento(NOME_DEPARTAMENTO, SIGLA, "",
                                            new Coordenador(NOME_COORDENADOR, IDADE, CPF));
		verificarCampoObrigatorio("A localização do departamento é obrigatória", localDepartamentoVazio);

		Departamento localDepartamentoNulo = new Departamento(NOME_DEPARTAMENTO, SIGLA, null,
                                            new Coordenador(NOME_COORDENADOR, IDADE, CPF));
		verificarCampoObrigatorio("A localização do departamento é obrigatória", localDepartamentoNulo);
    }

    public void nomeCoordenadorVazio() {
        Departamento nomeCoordenadorVazio = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO,
                                            new Coordenador("", IDADE, CPF));
		verificarCampoObrigatorio("O nome do coordenador é obrigatório", nomeCoordenadorVazio);

		Departamento nomeCoordenadorNulo = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO,
                                            new Coordenador(null, IDADE, CPF));
		verificarCampoObrigatorio("O nome do coordenador é obrigatório", nomeCoordenadorNulo);
    }

    private String TEXTO_ESPERADO_SEM_IDADE = "Depto. test." + BREAK + SIGLA + BREAK
            + "Local 1" + BREAK + "Coord. 1" + BREAK + "CPF: 111.222.333-44" + BREAK;
            
    public void semIdade() {
        Departamento idadeVazia = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO, 
                                    new Coordenador(NOME_COORDENADOR, 0, CPF));                
        rodarTestarRetorno(TEXTO_ESPERADO_SEM_IDADE, idadeVazia);
    }

    public void cpfCoordenadorVazio() {
        Departamento cpfCoordenadorVazio = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO,
                                            new Coordenador(NOME_COORDENADOR, IDADE, ""));
		verificarCampoObrigatorio("O cpf do coordenador é obrigatório", cpfCoordenadorVazio);

		Departamento cpfCoordenadorNulo = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO,
                                            new Coordenador(NOME_COORDENADOR, IDADE, null));
		verificarCampoObrigatorio("O cpf do coordenador é obrigatório", cpfCoordenadorNulo);
    }

    private String TEXTO_ESPERADO_SEM_SIGLA_SEM_IDADE = "Depto. test." + BREAK + "" + BREAK
            + "Local 1" + BREAK + "Coord. 1" + BREAK + "CPF: 111.222.333-44" + BREAK;
            
    public void semSiglaSemIdade() {
        Departamento siglaIdadeVazia = new Departamento(NOME_DEPARTAMENTO, "", LOCALIZACAO,
                                            new Coordenador(NOME_COORDENADOR, 0, CPF));                
        rodarTestarRetorno(TEXTO_ESPERADO_SEM_SIGLA_SEM_IDADE, siglaIdadeVazia);
    }    
}