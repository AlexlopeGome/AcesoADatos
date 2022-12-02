package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

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
//		
//		Zoologico z2 = new Zoologico(
//		"Selvo Marina",
//		"Sevilla",
//		2016);
//
//		session.save(z2);
//		
//		
//		Zoologico z3 = new Zoologico(
//		"Zoo Madrid",
//		"Madrid",
//		2012);
//
//		session.save(z3);	
		
//		List Animales = session.createQuery("FROM Animal").getResultList();		
//		
//		for (Iterator i1 = Animales.iterator(); i1.hasNext();) {
//			Animal a1 = (Animal) i1.next();
//			System.out.println(a1.getNombre());
//		}
//		
//		System.out.println("-------------------");
//		
//		List zologicos = session.createQuery("FROM Zoologico").getResultList();		
//		
//		for (Iterator i1 = zologicos.iterator(); i1.hasNext();) {
//			Zoologico a1 = (Zoologico) i1.next();
//			System.out.println(a1.getNombre());
//		}		
//		
//		System.out.println("-------------------");
		
		String hql = "FROM Animal where habitat = :habitat"; //Esto es para buscar al animal por habitat
        Query query = session.createQuery(hql);
        query.setParameter("habitat", "Selva");
        List animales = query.getResultList();
        //Recorre e imprime solo los animales que tengan Bosque en su habitat
        for(Iterator i = animales.iterator(); i.hasNext();) {
            Animal a = (Animal) i.next();
            System.out.println(a.getNombre());
        }
        
        System.out.println("-------------------");
        
    	String hql2 = "FROM Zoologico where anyo_fundacion = :anyo_fundacion";
        Query query2 = session.createQuery(hql2);
        query2.setParameter("anyo_fundacion", 2012);
        List zologicos = query2.getResultList();
        //Recorre e imprime solo los animales que tengan Bosque en su habitat
        for(Iterator i2 = zologicos.iterator(); i2.hasNext();) {
            Zoologico a = (Zoologico) i2.next();
            System.out.println(a.getNombre());
        }
        
        
        
		session.close();
	}

	
	
}
