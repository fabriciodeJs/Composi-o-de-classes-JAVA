package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.ENUMS.NivelDeTrabalho;

public class Trabalhador {
	
		private String nome;
		private NivelDeTrabalho nivel;
		private Double salarioBase;
		
		private Departamento departamento;
		private List<ContratoDeHoras> contratos = new ArrayList<>();
		
		public Trabalhador() {
			
		}

		public Trabalhador(String nome, NivelDeTrabalho nivel, Double salarioBase, Departamento departamento) {
			this.nome = nome;
			this.nivel = nivel;
			this.salarioBase = salarioBase;
			this.departamento = departamento;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public NivelDeTrabalho getNivel() {
			return nivel;
		}

		public void setNivel(NivelDeTrabalho nivel) {
			this.nivel = nivel;
		}

		public Double getBasesalarial() {
			return salarioBase;
		}

		public void setBasesalarial(Double salarioBase) {
			this.salarioBase = salarioBase;
		}

		public Departamento getDepartamento() {
			return departamento;
		}

		public void setDepartamento(Departamento departamento) {
			this.departamento = departamento;
		}

		public List<ContratoDeHoras> getContratos() {
			return contratos;
		}

		public void addContratos(ContratoDeHoras contrato) {
			contratos.add(contrato);
		}
		public void removeContratos(ContratoDeHoras contrato) {
			contratos.remove(contrato);
		}
		public double renda(int ano, int mes) {
			double soma = salarioBase;
			Calendar cal = Calendar.getInstance();
			for (ContratoDeHoras c : contratos) {
				cal.setTime(c.getData());
				int c_ano = cal.get(Calendar.YEAR);
				int c_mes = 1 + cal.get(Calendar.MONTH);
				if( ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
				}
			}
			return soma;
		}
}
