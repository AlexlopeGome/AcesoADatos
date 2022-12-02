package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import pojo.Animal;
import pojo.Zoologico;
import utils.HibernateUtil;

public class main {

	public static void main(String[] args) {
	
		Session session= HibernateUtil
				.getSessionFactory()
				.openSession();
		
//		Animal a1 = new Animal(
//				"BullDog",
//				"Casa",
//				new BigDecimal (25));
//
//				session.save(a1);
		
//				Animal a1 = new Animal(
//						"Quoka",
//						"Selva",
//						new BigDecimal (25));
//
//						session.save(a1);			

//				int id = 1;
//				Animal a = (Animal) session.get(Animal.class, id);
//				System.out.println(a.getNombre());

		
//		List animales = session.createQuery("FROM Animal").getResultList();		
//		
//		for (Iterator i = animales.iterator(); i.hasNext();) {
//			Animal a = (Animal) i.next();
//			System.out.println(a.getNombre());
//		}
		
		
//		Zoologico z1 = new Zoologico(
//		"Fuengirola Park",
//		"Malaga",
//		2012);
//
//		session.save(z1);
//		
		
//		Zoologico z1 = new Zoologico(
//		"Selvo Marina",
//		"Sevilla",
//		2016);
//
//		session.save(z1);
				
		List zologicos = session.createQuery("FROM Zoologico").getResultList();		
		
		for (Iterator i = zologicos.iterator(); i.hasNext();) {
			Zoologico a = (Zoologico) i.next();
			System.out.println(a.getNombre());
		}		
		
		session.close();
	}

}
