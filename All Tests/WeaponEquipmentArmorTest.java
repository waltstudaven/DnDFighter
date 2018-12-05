/**
 * This Component Testing class tests Equipment, Armor, and Weappon as well as Damage Type, Character, and Character Creation Classes
 * @author Jeremiah Hobbs
 * @version 1.0
 *
 */
public class WeaponEquipmentArmorTest {
	
	Character character;
	
	public WeaponEquipmentArmorTest(Character c) {
		character = c;
		this.testing();
	}
	
	public void testing() {
		character.allEquipment.add(Weapon.CLUB);
		System.out.println("Testing weapon, equipment, and armor:");
		System.out.println(character.allEquipment);
	}
	
	public static void main(String[] args) {
	    CharacterCreation tester = new CharacterCreation();
	    Character c = tester.characterCreator();
		WeaponEquipmentArmorTest t = new WeaponEquipmentArmorTest(c);
	}

}
