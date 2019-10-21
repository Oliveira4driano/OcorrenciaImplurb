/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JFormattedTextField;





/**
 *
 * @author Adriano
 */
public class Servidor {
    
    
    private static final long serialVersionUID = 1L;
    private String nome;
    private String matricula;
    private String vinculo;
    private String justificativa;
    private String dataOcorrencia;
   


    public Servidor() {
    }

    public Servidor(String nome, String matricula, String vinculo, String justificativa, String dataOcorrencia) {
        this.nome = nome;
        this.matricula = matricula;
        this.vinculo = vinculo;
        this.justificativa = justificativa;
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(String dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }
    
    
    

    
    
    

    

    

    
    
    
    
}
