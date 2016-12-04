package wundr.enderAdvancement.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class EnderItemImpureCore extends Item {
	private static String name = "impure_core";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(Main.MOD_ID + ":" + name);
	
	public EnderItemImpureCore() {
		setRegistryName(new ResourceLocation(Main.MOD_ID + ":impure_core"));
		setUnlocalizedName(Main.MOD_ID + "_" + name);
	}
}
