package entities;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private String nome;
    private List <Funcionario> funcionarios = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void addFuncionario(Funcionario func) {
/*  O exercício pede pra limitar o array a 100 elementos mas fica implícito no
*   enunciado que pode ser lista. Como eu prefiro trabalhar com lista pq é muito
*   mais fácil, decidi decidi limitar aqui no método.
*/
        if (funcionarios.size() < 100){
            funcionarios.add(func);
        } else {
            System.out.println("Limite de funcionários atingido neste departamento");
        }
    }

    public void reajuste (Double porcentagem){
        if (funcionarios.isEmpty()){
            System.out.println("Não há funcionários neste departamento");
        } else {
            for (Funcionario f : this.funcionarios) {
                f.reajustarSalario(porcentagem);
            }
        }
    }

    public String listarFuncionarios (){
        StringBuilder sb = new StringBuilder();
        for (Funcionario f : funcionarios) {
            sb.append("\n"+f+"\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "\n" + nome + "\n" +
                "Funcionários: " + listarFuncionarios();
    }
}
