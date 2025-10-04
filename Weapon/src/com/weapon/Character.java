package com.weapon;

public abstract class Character {

	protected WeaponBehavior weapon;
		
	public void setWeapon(WeaponBehavior w) {
			this.weapon = w;
	}
		
	public abstract void fight();

}
