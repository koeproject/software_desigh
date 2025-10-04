package com.weapon;

public class Queen extends Character{
	@Override
	public void fight() {
		System.out.println("The Queen fight!!");
		weapon.useWeapon();
	}
}
