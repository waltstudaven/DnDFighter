//import java.util.*;
//
//public class MonsterFighter {
//	public HashMap<String, Monster> allMonsters;
//	private static Monster fighter1;
//	private static Monster fighter2;
//	private static MonsterFighter alpha;
//
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//
//		alpha = new MonsterFighter(2);
//		System.out.println("What two monsters would you like to have fight eachother?");
//		String response0 = scan.nextLine().toLowerCase();
//		fighter1 = alpha.getMonster(response0);
//		String response1 = scan.nextLine().toLowerCase();
//		fighter2 = alpha.getMonster(response1);
//
//		Monster attacker = alpha.findInitiative();
//		// while (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
//		System.out.println(attacker);
//		// }
//
//		scan.close();
//	}
//
//	public MonsterFighter(int numOfFighters) {
//		allMonsters = new HashMap<>();
//		allMonsters.put("zombie", new Zombie());
//		allMonsters.put("commoner", new Commoner());
//	}
//
//	public Monster getMonster(String monsterName) {
//		return allMonsters.get(monsterName);
//	}
//
//	private Monster findInitiative() {
//		Integer fighter1Initiative = fighter1.rollInitiative();
//		Integer fighter2Initiative = fighter2.rollInitiative();
//		if (fighter1Initiative > fighter2Initiative)
//			return fighter1;
//		else if (fighter2Initiative > fighter1Initiative)
//			return fighter2;
//		else if (fighter1.getDexMod() > fighter2.getDexMod())
//			return fighter1;
//		else if (fighter2.getDexMod() > fighter1.getDexMod())
//			return fighter2;
//		return startGame();
//	}
//
//	private Monster runGame(Monster attacker, Monster defender) {
//		if (attacker.rollToAttack() >= defender.getAc()) defender.setHp(defender.getHp() - attacker.rollDamage());
//
//
//		runGame(defender, attacker);
//	}
//}
//
//// grave yard
//// System.out.println("How many monsters would you like to have fight
//// eachother?");
//// int numOfFighters = scan.nextInt();
