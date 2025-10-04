package com.weapon;

public class Troll extends Character{
	@Override
	public void fight() {
		System.out.println("The Troll fighting ");
		weapon.useWeapon();
	}
}
