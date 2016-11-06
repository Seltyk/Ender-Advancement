package wundr.enderAdvancement.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class EnderItemStick extends Item {
	public EnderItemStick() {
		setRegistryName(new ResourceLocation(Main.MOD_ID + ":twig"));
		setUnlocalizedName(Main.MOD_ID + "_enderInfusedTwig");
	}
}
