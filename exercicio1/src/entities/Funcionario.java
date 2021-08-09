package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcionario {

    private String nomeFunc;
    private Double salario;
    private Date dtAdmissao;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Funcionario(String nomeFunc, Double salario, Date dtAdmissao) {
        this.nomeFunc = nomeFunc;
        this.salario = salario;
        this.dtAdmissao = dtAdmissao;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void reajustarSalario(Double porcentagem) {
        this.salario += salario * porcentagem / 100.0;
    }

    @Override
    public String toString() {
        return "\nNome: " + nomeFunc +
                "\nSalario: " + salario +
                "\nData de admissão: " + dateFormat.format(dtAdmissao);
    }
}