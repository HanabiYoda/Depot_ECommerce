package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import fr.adaming.model.Employe;
import fr.adaming.service.IEmployeService;


@ManagedBean(name="empMB")
@RequestScoped
public class EmployeManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	//les attributs utilisés par la vue
	private List<Employe> liste;
public List<Employe> getListe() {
		return liste;
	}

	public void setListe(List<Employe> liste) {
		this.liste = liste;
	}



private Employe employe;

//les getters et setters utilisés par la vue
public Employe getEmploye() {
return employe;
}

public void setEmploye(Employe employe) {
this.employe = employe;
}
	
	

	//transformation de cette association avec un attribut employeService
	


	@ManagedProperty(value="#{employeServiceBean}")//identite du bean qu'il va managé
	private IEmployeService empService;
	//le conteneur web utilise JSF alors que Spring utilise hibernate et spring dans service et dao
//besoin d'un setter de l'autre côté

	//appelle le setter pour l'injection de dependance
	//car il est obligatoire avec l'annotation managed  property exige 
	public void setEmpService(IEmployeService empService) {
		this.empService = empService;
	}

	//constructeur vide
	public EmployeManagedBean() {
		
		super();
		
		//instencie l'employe pour eviter l'exception target  Unreachibale
		this.employe=new Employe();
		
		
		
		// TODO Auto-generated constructor stub
	}
	@PostConstruct//cette anotation veut dire que la methode sera executé après l'instanciation du managed bean
	public void init(){
	//permet de passer outre le probleme de vieux scoppe (le coneneur web va instancier un nouveau manage bean à cahque fois que je quitte la page)	
		this.liste=empService.getAllEmployes();
		
		
	}
	//methode metiers
	
	public String ajouterEmploye(){
		
		//appel de la methode service
		empService.addEmploye(this.employe);//appel de la methode service
		
		this.liste=empService.getAllEmployes();
		
		
		
		return "index";
	}
	
	public String rechercherEmploye(){
		
		this.employe = empService.getEmployeById(this.employe.getId());
		
		return "recherche";
		
	}
	public String suppEmploye(){
	empService.deleteEmploye(this.employe.getId());
	this.liste=empService.getAllEmployes();
	
		return "index";
	}
	
	public String modifEmploye(){
		empService.updateEmploye(this.employe);
		
		this.liste=empService.getAllEmployes();
		
		
		return "index";
	}
	
	

}
