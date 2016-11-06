package wundr.enderAdvancement.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import wundr.modutils.Getters;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class DuperEnchantment extends Enchantment {
	public DuperEnchantment(Rarity rarity, EnumEnchantmentType enchType, EntityEquipmentSlot[] slots) {
		super(rarity, enchType, slots);
		setName("duper");
		setRegistryName("enderadvancement:duper");
	}
	
	@Override
	public int getMinEnchantability(int enchLvl) {
		return Getters.getMinEnchantability(enchLvl);
	}
	
	@Override
	public int getMaxEnchantability(int enchLvl) {
		return Getters.getMaxEnchantability(enchLvl);
	}
}
