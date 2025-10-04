package com.weapon;

public class King extends Character{
	@Override
	public void fight() {
		System.out.println("King fighting :");
		weapon.useWeapon();
	}
}
