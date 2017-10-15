/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author luizo
 */
public class Salario {
    public int cod_func;
    public int cod_sal;
    public String valor;
    public String nome;
    public String data_ini;
    public String data_fim;

    /**
     * @return the cod_func
     */
    public int getCod_func() {
        return cod_func;
    }

    /**
     * @param cod_func the cod_func to set
     */
    public void setCod_func(int cod_func) {
        this.cod_func = cod_func;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the data_ini
     */
    public String getData_ini() {
        return data_ini;
    }

    /**
     * @param data_ini the data_ini to set
     */
    public void setData_ini(String data_ini) {
        this.data_ini = data_ini;
    }

    /**
     * @return the data_fim
     */
    public String getData_fim() {
        return data_fim;
    }

    /**
     * @param data_fim the data_fim to set
     */
    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    /**
     * @return the cod_sal
     */
    public int getCod_sal() {
        return cod_sal;
    }

    /**
     * @param cod_sal the cod_sal to set
     */
    public void setCod_sal(int cod_sal) {
        this.cod_sal = cod_sal;
    }
}

    