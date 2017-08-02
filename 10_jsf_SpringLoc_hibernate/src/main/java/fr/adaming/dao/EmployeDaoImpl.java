package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Employe;





@Repository//l'annotation pour la def d'un DAO de spring Ioc donne un singleton
public class EmployeDaoImpl implements IEmployeDao{

	//attribut session factory, l'annotation sert à l'injection du bean sessionfactory. Elle est spécifique à spring 
	@Autowired
	private SessionFactory sf;
	//cette injection utilise les modificateurs byType donc un setter sinon il le fait par instrospection
	
	//ce setter est utile pour les lignes avec autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	@Override
	public void addEmploye(Employe emp) {
		
		//on fait le bus dans lequel on va avoir ce qui va etre envoyé à la connexion
		//ouvrir une session(bus qui véhicule les données 
		Session s=sf.getCurrentSession();
		
		//ajouter l'employe dans le context hibernate
		s.save(emp);
		
		
	}



	@Override
	public List<Employe> getAllEmployes() {
	//ouvri session
		Session s=sf.getCurrentSession();
		
		//la requete HQL
		String req="FROM Employe";
		
		//utilisation d'hibernate donc pas de jpa persistance
		Query query=s.createQuery(req);
		
		//Envoie de la requete et reccuperation du resultat
		List<Employe> liste=query.list();
	
		return liste;
	}

	@Override
	public Employe getEmployeById(int id_emp) {
		// ouverture de la session
		Session s = sf.getCurrentSession();
//		// la requete HQL
//		String req = "FROM Employe WHERE id_e=:pId";
//
//		Query query = s.createQuery(req);
//		query.setParameter("pId", id_emp);
//		Employe employe = (Employe) query.uniqueResult();
		
		Employe employe = (Employe) s.get(Employe.class, id_emp);
		
		return employe;
	}

	@Override
	public void updateEmploye(Employe emp) {
		
		
		Session s=sf.getCurrentSession();
	s.saveOrUpdate(emp);
		
		
		
	
	}

	@Override
	public void deleteEmploye(int id_emp) {
	
		
		Session s=sf.getCurrentSession();
		
		Employe emp_rec=(Employe) s.get(Employe.class, id_emp);
		
		s.delete(emp_rec);
	
			
		
		
	}

}
