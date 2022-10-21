package bd_zoologico;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
//Animal a = new Animal ("Ardilla", "Bosque",0.10);
//Animal b = new Animal ("KAKApoo", "Bosque",7.5);		
//AnimalDAO.insertAnimal(a);
//AnimalDAO.insertAnimal(b);
//AnimalDAO.deleteAllAnimal();
//AnimalDAO.deleteAnimalByNombre("Ardilla");
//Animal a = AnimalDAO.findById(3);
//System.out.println(a);	
		
//ArrayList<Animal> animales = AnimalDAO.findAllAnimales();
//		
//		for (int i = 0; i < animales.size(); i++) {
//			System.out.println(animales.get(i));
		
		


	//System.out.println(AnimalDAO.findAllAnimals());

Animal a = AnimalDAO.findById(3);
a.setNombre("PEPITO");
a.setHabitad("Agua");
a.setPeso_aproximado(10);
AnimalDAO.updateAnimal(a);


}
}