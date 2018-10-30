package labfive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.Test;

import src.main.java.labfive.labfive.JSONProperty;
import src.main.java.labfive.labfive.Serializer;

@SuppressWarnings("static-method")
class SerializerTest {
  // pro requires the test class to finish with 'Tests'	
  
	@Test
	void toJSONTest() {
		Person p = new Person("John", "Doe");
		String expectedPerson = "{\n" +
		        "  \"firstName\": \"" + p.getFirstName() + "\"\n" +
		        "  \"lastName\": \"" + p.getLastName() + "\"\n" +
		        "}\n";
		assertEquals(expectedPerson, Serializer.toJSON(p));
		Alien a = new Alien("Gallifrey", 900);
		String expectedAlien = "{\n" +
		        "  \"planet\": \"" + a.getPlanet() + "\"\n" +
		        "  \"age\": \"" + a.getAge() + "\"\n" +
		        "}\n";
		assertEquals(expectedAlien, Serializer.toJSON(a));
	}
	
	private class Person {
		  private final String firstName;
		  private final String lastName;

		  public Person(String firstName, String lastName) {
		    this.firstName = Objects.requireNonNull(firstName);
		    this.lastName = Objects.requireNonNull(lastName);
		  }

			@JSONProperty
		  public String getFirstName() {
		    return firstName;
		  }
			
			@JSONProperty
		  public String getLastName() {
		    return lastName;
		  }
	}
	
	private class Alien {
		  private final String planet;
		  private final int age;

		  public Alien(String planet, int age) {
		    if (age <= 0) {
		      throw new IllegalArgumentException("Too young...");
		    }
		    this.planet = Objects.requireNonNull(planet);
		    this.age = age;
		  }

			@JSONProperty
		  public String getPlanet() {
		    return planet;
		  }

			@JSONProperty
		  public int getAge() {
		    return age;
		  }
	}
}
