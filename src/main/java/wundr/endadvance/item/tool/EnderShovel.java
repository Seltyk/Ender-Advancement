package wundr.endadvance.item.tool;

import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;

/**
 * Ender Shovel<br>
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderShovel extends ItemSpade {
	private static final String NAME = "shovel";
	
	public EnderShovel() {
		super(EnderAdvancement.ENDERIUM);
		setRegistryName(new ResourceLocation(EnderAdvancement.MOD_ID + ":" + NAME));
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + NAME);
	}
}
