package CadAgenda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
public class Contato {
    private String codigo;
    private String nome;
    private String endereco;
    private String fone;
    private String celular;
    private String sexo;
    private String obs;

    public Contato(String codigo, String nome, String endereco, String fone, String celular, String sexo, String obs) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.fone = fone;
        this.celular = celular;
        this.sexo = sexo;
        this.obs = obs;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getFone() {
        return fone;
    }

    public String getCelular() {
        return celular;
    }

    public String getSexo() {
        return sexo;
    }

    public String getObs() {
        return obs;
    }
}



