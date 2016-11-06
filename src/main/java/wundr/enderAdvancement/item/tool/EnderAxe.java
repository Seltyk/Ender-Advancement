package wundr.enderAdvancement.item.tool;

import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class EnderAxe extends ItemAxe {
	public EnderAxe(ToolMaterial material) {
		super(material, 12, -2.8f);
		setRegistryName(new ResourceLocation(Main.MOD_ID + ":axe"));
		setUnlocalizedName(Main.MOD_ID + "_enderAxe");
	}
}
