import static org.junit.Assert.*;
import org.junit.Test;

public class CreatureTest extends  Creature{
	// Test the Constructor with the correct Name, Level, Hp,and Attack Damage.
	@Test
	public void test_Constructor(){
			Creature c = new Creature("Pikachu", 30, 1 , 5);
			assertEquals("Created Creature named Pikachu", "Pikachu", c.getName());
			assertEquals("Created Creature with hp: 30", 30, c.getHP());
			assertEquals("Created Creature with Level 1", 1, c.getLevel());
			assertEquals("Created Creature with ATT: 5", 5, c.getAttack());
	}
	//Test the Constructor with Invalid value for Hp negetive 1.
	//The default hp should be 1.
	@Test
	public void test_Constructor_withInvalidNumber_inHp(){
			Creature c = new Creature("Pikachu", -1, 1 , 5);
			assertEquals("Created Creature with hp:-1", 1, c.getHP());
	}
	//Test the Constructor with Valid value for Hp positive 35.
	@Test
	public void test_Constructor_withValidNumber_inHp(){
			Creature c = new Creature("Pikachu", 35, 1 , 5);
			assertEquals("Created Creature with hp:-1", 35, c.getHP());
	}
	//Test the Constructor with Invalid value for Level negetive 1.
	//The default level should be 1.
	@Test
	public void test_Constructor_withInvalidNumber_inLevel(){
			Creature c = new Creature("Pikachu", 1, -1 , 5);
			assertEquals("Created Creature with hp:-1", 1, c.getLevel());
	}
	//Test the Constructor with Valid value for level positive 5.
	@Test
	public void test_Constructor_withValidNumber_inLevel(){
			Creature c = new Creature("Pikachu", 30, 5 , 5);
			assertEquals("Created Creature with hp:-1", 5 , c.getLevel());
	}
	//Test the Constructor with Valid value for Attack positive 5.
	@Test
	public void test_Constructor_withValidNumber_inAttack(){
			Creature c = new Creature("Pikachu", 1, 1 , 5);
			assertEquals("Created Creature with hp:-1", 5, c.getAttack());
	}
	//Test the Constructor with Invalid value for Attack negative 5.
	//The default Attack should be 1.
	@Test
	public void test_Constructor_withInvalidNumber_inAttack(){
			Creature c = new Creature("Pikachu", 1, 1 , -5);
			assertEquals("Created Creature with hp:-1", 1, c.getAttack());
		}
	//Test the getter and setter with Empty name "".
	@Test
	public void test_setter_and_getter_EmptyName(){
			Creature c = new Creature("Pikachu", 30,1,5);
			c.setName("");
			assertEquals("Set name to empty string", "", c.getName());
		}
	//Test the getter and setter for Hp 100.
	@Test
	public void test_setter_and_getter_SetHp100(){
			Creature c = new Creature("Pikachu", 30,2,5);
			c.setHP(33);
			assertEquals("Set hp to 100", 33, c.getHP());
	}
	//Test the getter and setter for attack 20.
	// Because level this.attackDamage += ad, therefor the attack should be 20+5=25.
	@Test
	public void test_setter_and_getter_SetAttack(){
			Creature c = new Creature("Pikachu", 30,1,5);
			c.setAttack(20);
			assertEquals("Set Attack to 20", 25, c.getAttack());
		}
	//Test the getter and setter for X coord.
	//Do nothing when the value exceeds the limit. 
	//The valid value will do action.
	@Test
	public void test_setter_and_getter_SetX(){
			Creature c = new Creature("Pikachu",30,1,5);
			c.setX(32);
			c.setX(1000);
			assertEquals("Set X to 1000", 32, c.getX());
			}
	//Test the getter and setter for Y coord.
	//Do nothing when the value exceeds the limit. 
	//The valid value will do action.
	@Test
	public void test_setter_and_getter_SetY(){
			Creature c = new Creature("Pikachu",30,1,5);
			c.setY(64);
			c.setY(1000);
			assertEquals("Set Y to 1000", 64, c.getY());
			}
	//Test the getter and setter for X and Y coord.
	//Do nothing when the value exceeds the limit. 
	// The valid value will do action.
	@Test
	public void test_setter_and_getter_SetLocation(){
			Creature c = new Creature("Pikachu",30,1,5);
			c.setLocation(1000, 1000);
			c.setLocation(32, 32);
			assertEquals("Set X to 1000", 32, c.getX());
			assertEquals("Set Y to 1000", 32, c.getY());
			}
	//Test the levelup Method. When Level up the level changed.
	@Test
	public void test_Method_LevelUp_forLevel(){
			Creature c = new Creature("Pikachu",30,1,5);
			c.levelUp();
			assertEquals("Level up to 2", 2, c.getLevel());
			}
	//Test the levelup Method. When Level up the Hp changed.
	@Test
	public void test_Method_LevelUp_forHp(){
			Creature c = new Creature("Pikachu",30,1,5);
			c.levelUp();
			assertEquals("Level up Hp changed", 33, c.getHP());
			}
	//Test the levelup Method. When Level up the Attack changed.
	@Test
	public void test_Method_LevelUp_forAttack(){
			Creature c = new Creature("Pikachu",30,1,5);
			c.levelUp();
			assertEquals("Level up attack changed ", 6, c.getAttack());
			}
}