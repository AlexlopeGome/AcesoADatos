package bd_zoologico;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Animal a = new Animal ("Ardilla", "Bosque",0.10);
//Animal b = new Animal ("KAKApoo", "Bosque",7.5);		
//AnimalDAO.insertAnimal(a);
//AnimalDAO.insertAnimal(b);
//AnimalDAO.deleteAllAnimal();
//AnimalDAO.deleteAnimalByNombre("Ardilla");
//Animal a = AnimalDAO.findById(3);
//System.out.println(a);	

try {
	System.out.println(AnimalDAO.findAllAnimals());
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		
	}

}
