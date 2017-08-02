package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Employe;

public interface IEmployeDao {

	public void addEmploye(Employe emp);
	
	public List<Employe>getAllEmployes();
	
	public Employe getEmployeById(int id_emp);
	
	public void updateEmploye(Employe emp);
	
	public void deleteEmploye(int id_emp);
	
	
	
}
