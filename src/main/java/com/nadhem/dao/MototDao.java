package com.nadhem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.nadhem.entities.Moto;
import com.nadhem.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class MototDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

//méthode ajouter d'une entité à la bd
	public void ajouter(Moto c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(c);
		tx.commit();
	}

//méthode modifier d'une entité à partir de la bd
	public void modifier(Moto c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(c);
		tx.commit();
	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Moto c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		c = entityManager.merge(c); // important
		entityManager.remove(c);
		tx.commit();
	}

//méthode Consulter d'une entité à partir de la bd
	public Moto consulter(Moto c, Object id) {
		return entityManager.find(c.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Moto> listerTous() {
		List<Moto> motos = entityManager.createQuery("select m from Moto m", Moto.class).getResultList();
		return motos;
	}

//méthode pour lister tous les client dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Moto> listerParNom(String nom) {
		List<Moto> motos = entityManager.createQuery("select m from Moto m where m.nomMoto like :pnom", Moto.class)
				.setParameter("pnom", "%" + nom + "%").getResultList();

		return motos;
	}
}