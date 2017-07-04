package wundr.endadvance.eventHandlers;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipesBanners;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.endadvance.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon
 * @author wundrweapon
 */
@EventBusSubscriber(modid = EnderAdvancement.MOD_ID)
@SuppressWarnings("unused")
public class Registry {
	
	//
	//IForgeRegistry events
	//
	
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
	
	//
	//ModelRegistryEvent
	//
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent reg) {
		for(Item i : EnderAdvancement.ITEMS) {
			ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName().toString()));
		}
	}
}
