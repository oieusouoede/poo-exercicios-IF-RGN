package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresa {
    private String nome;
/*
*   Ao que parece existe um debate sobre usar variável numérica ou string
*   pra guardar cpf e cnpj. Como a ideia aqui não é validar nem trabalhar
*   o cnpj eu vou deixar como String. Mas fica o registro de que isso é algo
*   pra procurar saber mais.
*/
    private String cnpj;
    private List <Departamento> departamentos = new ArrayList<>();

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void addDepartamento (Departamento dept){
        if (departamentos.size() < 10){
            departamentos.add(dept);
        } else {
            System.out.println("Numero máximo de departamentos atingido");
        }
    }

    public Boolean reajusteDept (String nomeDept, Double percentual){
        Departamento dept = getDepartamentos().stream().filter(x -> Objects.equals(x.getNome(), nomeDept)).findFirst().orElse(null);
        if (dept == null){
            System.out.println("Departamento não encontrado!");
            return false;
        } else {
            dept.reajuste(percentual);
            System.out.printf("\nReajuste de %.2f %% efetuado!\n", percentual);
            return true;
        }
    }

    public String listarDptos (){
        StringBuilder sb = new StringBuilder();
        for (Departamento d : departamentos) {
            sb.append(d);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return nome + "\n" +
                "\nCNPJ: " + cnpj +
                "\nDepartamentos: " + listarDptos() + "\n";
    }
}
