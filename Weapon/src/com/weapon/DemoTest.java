package com.weapon;

public class DemoTest {

	public static void main(String[] args) {
		Character king = new King();
		king.setWeapon(new SwordBehavior());
		king.fight();
		
		Character king2 = new King();
		king2.setWeapon(new BowAndArrowBehavior());
		king2.fight();
		
		Character queen = new Queen();
		queen.setWeapon(new KnifeBehavior());
		queen.fight();	
	}

}
