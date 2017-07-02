package wundr.endadvance.eventHandlers;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipesBanners;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.endadvance.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon
 * @author wundrweapon
 */
@EventBusSubscriber
@SuppressWarnings("unused")
public class Registry {
	
	@SubscribeEvent
	public static void registerEnchantment(Register<Enchantment> reg) {
		reg.getRegistry().register(EnderAdvancement.DUPER);
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> reg) {
		reg.getRegistry().registerAll(EnderAdvancement.ITEMS);
	}
	
	@SubscribeEvent
	public static void registerRecipe(Register<IRecipe> reg) {
		reg.getRegistry().register(EnderAdvancement.DUPLICATOR);
	}
}
