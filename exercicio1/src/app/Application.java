package app;

import entities.Departamento;
import entities.Empresa;
import entities.Funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        char chec;

        System.out.println("Digite o nome da empresa: ");
        String nomeEmpresa = input.nextLine();
        System.out.println("Insira o CNPJ da empresa: ");
        String cnpj = input.nextLine();

        Empresa empresa = new Empresa(nomeEmpresa, cnpj);
        System.out.println("Empresa registrada no sistema!\n");
        System.out.println(empresa);

        do {
            System.out.println("Digite o nome do departamento a ser registrado: ");
            String deptNome = input.nextLine();
            Departamento dept = new Departamento(deptNome);
            empresa.addDepartamento(dept);
            System.out.println("Departamento registrado com sucesso!\n");

            do {
                System.out.println("Deseja registrar outro departamento? (s/n) ");
                chec = Character.toUpperCase(input.next().charAt(0));
                input.nextLine();
                if (chec != 'S' && chec != 'N'){
                    System.out.println("Entrada inválida!\n");
                }
            } while (chec != 'S' && chec != 'N');
        } while (chec != 'N');

        System.out.println("Registro de departamentos finalizado");
        System.out.println(empresa);

        for (Departamento dept : empresa.getDepartamentos()) {
            System.out.println("Deseja registrar um funcionário no " + dept.getNome() +"? (s/n) ");
            do {
                chec = Character.toUpperCase(input.next().charAt(0));
                input.nextLine();
                if (chec != 'S' && chec != 'N'){
                    System.out.println("Entrada inválida!\n");
                }
            } while (chec != 'S' && chec != 'N');
            while (chec == 'S'){
                System.out.println("Nome do funcionário: ");
                String nomeFunc = input.nextLine();
                System.out.println("Salário inicial: ");
                Double salario = input.nextDouble();
                System.out.println("Data de admissão (dd/mm/aaaa): ");
                Date admissao = dateFormat.parse(input.next());
                input.nextLine();
                Funcionario f = new Funcionario(nomeFunc, salario, admissao);
                dept.addFuncionario(f);
                System.out.println("\nFuncionário registrado com sucesso!\n");

                do {
                    System.out.println("Deseja registrar outro funcionario? (s/n) ");
                    chec = Character.toUpperCase(input.next().charAt(0));
                    input.nextLine();
                    if (chec != 'S' && chec != 'N'){
                        System.out.println("Entrada inválida!\n");
                    }
                } while (chec != 'S' && chec != 'N');
            };
        }

        System.out.println("Registro de funcionários finalizado!");
        System.out.println(empresa.listarDptos());

        Boolean deuCerto;
        do {
            System.out.println("Efetuar reajuste de salário");
            System.out.println("Insira o nome do departamento onde haverá reajuste: ");
            String nomeDept = input.nextLine();
            System.out.println("Insira o percentual de reajuste: ");
            Double percentual = input.nextDouble();

            deuCerto = empresa.reajusteDept(nomeDept, percentual);
            if (!deuCerto){
                do {
                    System.out.println("Deseja tentar novamente? (s/n) ");
                    chec = Character.toUpperCase(input.next().charAt(0));
                    input.nextLine();
                    if (chec != 'S' && chec != 'N'){
                        System.out.println("Entrada inválida!\n");
                    }
                } while (chec != 'S' && chec != 'N');
            }
        } while (!deuCerto && chec == 'S');

        System.out.println("Dados atualizados:\n");
        System.out.println(empresa);

    }
}
