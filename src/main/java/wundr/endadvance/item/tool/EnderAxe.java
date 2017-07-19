package wundr.endadvance.item.tool;

import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;

/**
 * The Ender Axe<br>
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderAxe extends ItemAxe {
	private static final String NAME = "axe";
	
	/**
	 * Ender Axe constructor
	 */
	public EnderAxe() {
		super(EnderAdvancement.ENDERIUM, 12, -2.8f);
		setRegistryName(new ResourceLocation(EnderAdvancement.MOD_ID + ":" + NAME));
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + NAME);
	}
}
