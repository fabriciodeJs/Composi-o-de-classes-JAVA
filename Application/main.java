package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoDeHoras;
import entities.Departamento;
import entities.Trabalhador;
import entities.ENUMS.NivelDeTrabalho;

public class main {

	public static void main(String[] args) throws ParseException {
			
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.printf("Entre com o nome do Departamento: ");
		String nomeDepartamneto = sc.nextLine();
		System.out.println("Insira os dados do trabalhador: ");
		System.out.printf("Nome: ");
		String trabalhadornome = sc.nextLine();
		System.out.printf("Nivel: ");
		String trabalhadorNivel = sc.nextLine();
		System.out.printf("Base Salarial: ");
		double salario = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(trabalhadornome, NivelDeTrabalho.valueOf(trabalhadorNivel), salario, new Departamento(nomeDepartamneto));
		
		System.out.println("Qual o numero de Contratados do Trabalhador: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("Entre com o #" + i + " Contrato: ");
			System.out.println("Date (DD/MM/yyyy): ");
			Date dataDeContrato = sdf.parse(sc.next());
			System.out.println("Valor por hora: ");
			double ValorPorHora = sc.nextDouble();
			System.out.println("Duração (HORAS): ");
			int horas = sc.nextInt();
			ContratoDeHoras contrato = new ContratoDeHoras(dataDeContrato,ValorPorHora,horas);
			trabalhador.addContratos(contrato);
		}
			System.out.println();
			System.out.println("Digite o Mês e o Ano: (MM/YYYY)");
			String mesEAno = sc.next();
			int mes = Integer.parseInt(mesEAno.substring(0, 2));
			int ano = Integer.parseInt(mesEAno.substring(3));
			
			System.out.println("Nome: " + trabalhador.getNome());
			System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
			System.out.println("Valor para Mês e Ano" + mesEAno + ": " + trabalhador.renda(ano, mes));
			
		
		sc.close();
	}

}
