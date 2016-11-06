package wundr.enderAdvancement.item.tool;

import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class EnderShovel extends ItemSpade {
	public EnderShovel(ToolMaterial material) {
		super(material);
		setRegistryName(new ResourceLocation(Main.MOD_ID + ":shovel"));
		setUnlocalizedName(Main.MOD_ID + "_enderShovel");
	}
}
