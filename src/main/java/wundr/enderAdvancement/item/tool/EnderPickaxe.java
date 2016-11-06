package wundr.enderAdvancement.item.tool;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class EnderPickaxe extends ItemPickaxe {
	public EnderPickaxe(ToolMaterial material) {
		super(material);
		setRegistryName(new ResourceLocation(Main.MOD_ID + ":pick"));
		setUnlocalizedName(Main.MOD_ID + "_enderPickaxe");
	}
}
