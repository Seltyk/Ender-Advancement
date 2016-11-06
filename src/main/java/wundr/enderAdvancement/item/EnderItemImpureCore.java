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
public class EnderItemImpureCore extends Item {
	public EnderItemImpureCore() {
		setRegistryName(new ResourceLocation(Main.MOD_ID + ":impure_core"));
		setUnlocalizedName(Main.MOD_ID + "_impureEnderCore");
	}
}
