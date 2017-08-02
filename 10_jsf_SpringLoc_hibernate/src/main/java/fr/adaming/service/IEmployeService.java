package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Employe;

public interface IEmployeService {

	public void addEmploye(Employe emp);
	
	public List<Employe>getAllEmployes();
	
	public Employe getEmployeById(int id_emp);
	
	public void updateEmploye(Employe emp);
	
	public void deleteEmploye(int id_emp);
	
}
