package com.nadhem.test;
import com.nadhem.dao.MototDao;
import com.nadhem.entities.Moto;
public class MotoTest {
public static void main(String[] args) {
	Moto c = new Moto();
c.setNomMoto("BMW");
c.setPrix(15480);
//ajouter l'objet client à la BD
MototDao cltDao = new MototDao();
cltDao.ajouter(c);
System.out.println("Appel de la méthode listerTous");
for (Moto cl : cltDao.listerTous())
System.out.println(cl.getIdMoto()+" "+cl.getNomMoto());
System.out.println("Appel de la méthode listerParNom");
for (Moto cl : cltDao.listerParNom("bmw"))

System.out.println(cl.toString());

//tester les autres méthodes de la classe ClientDao
}
}