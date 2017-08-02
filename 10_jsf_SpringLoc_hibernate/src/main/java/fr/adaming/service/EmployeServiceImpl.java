package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEmployeDao;
import fr.adaming.model.Employe;

//pour permettre l'association entre dao et service il faut une relation unidirectionnel qui sera sous java 
//pour le declarer en bean

//vient du managed bean  !!!!!!
@Service ("employeServiceBean")//l'annotation (=StateFull pour EJB) pour la def d'un bean de service


@Transactional//toutes les methodes de la classe sont transactionnel pour eviter de le mettre sur chaque methode
public class EmployeServiceImpl implements IEmployeService {

	//transformation de l'association UML en java
	@Autowired//l'annotation de l'injection de dependance
	private IEmployeDao empDao;
	
	//setter pour l'injection par modificateur
	public void setEmpDao(IEmployeDao empDao) {
		this.empDao = empDao;
	}

	
	@Transactional//annotation pour specifier que la methode est transactionnell
	@Override
	public void addEmploye(Employe emp) {
	//appel de la methode du dao
		empDao.addEmploye(emp);
		
		

	}

	@Override
	public List<Employe> getAllEmployes() {
		
		
		return empDao.getAllEmployes();
		
		
	}

	@Override
	public Employe getEmployeById(int id_emp) {
		return empDao.getEmployeById(id_emp);
	}

	@Override
	public void updateEmploye(Employe emp) {
		
		 empDao.updateEmploye(emp);

	}

	@Override
	public void deleteEmploye(int id_emp) {
		empDao.deleteEmploye(id_emp);

	}

}
