package wundr.endadvance.item.tool;

import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;

/**
 * Dangerously overpowered Ender Sword<br>
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderSword extends ItemSword {
	private static final String NAME = "sword";
	
	public EnderSword()  {
		super(EnderAdvancement.ENDERIUM);
		setRegistryName(new ResourceLocation(EnderAdvancement.MOD_ID + ":" + NAME));
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + NAME);
	}
}
