package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel{
	
	private static final String[] colunas = {
			"Banca", "\u00D3rg\u00E3o", "Estado", "Ano", "Nivel", "Cargo", "ID"
		};
	
	private ArrayList<Prova> provas;
	
	
	
	public ModeloTabela(ArrayList<Prova> provas) {
		super();
		this.provas = provas;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return provas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Prova prova = provas.get(rowIndex);
		if(columnIndex == 0) {
			return prova.Cargo;
		}else if(columnIndex == 1) {
			return prova.Orgao;
		}else if(columnIndex == 2) {
			return prova.Ano;
		}else if(columnIndex == 3) {
			return prova.Estado;
		}else if(columnIndex == 4) {
			return prova.Nivel;
		}else if(columnIndex == 5) {
				return prova.Banca;
		}else if(columnIndex == 6) {
				return prova.ID;
		}else {
			return null;
		}
	}

	public String getColumnName(int column) {
		
		return colunas[column];
	}
	
}
	
	


