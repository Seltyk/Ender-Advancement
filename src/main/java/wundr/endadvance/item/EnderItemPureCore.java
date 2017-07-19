package wundr.endadvance.item;

/**
 * The mod's most overpowered item - it clones things<br>
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderItemPureCore extends EnderItem {
	public EnderItemPureCore() {
		super("pure_core");
		setMaxStackSize(1); //1 per stack
		setMaxDamage(50); //Can make 100 items from 50
		setNoRepair(); //Cannot be repaired under any circumstances
	}
}
