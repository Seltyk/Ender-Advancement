package wundr.enderAdvancement.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderItemImpureCore extends Item implements IEnderItem {
	private static String name = "impure_core";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name);
	
	public EnderItemImpureCore() {
		setRegistryName(new ResourceLocation(EnderAdvancement.MOD_ID + ":impure_core"));
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
}
