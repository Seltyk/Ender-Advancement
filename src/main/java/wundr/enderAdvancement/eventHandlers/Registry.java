package wundr.enderAdvancement.eventHandlers;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.enderAdvancement.Main;

/**
 * Copyright 2016 wundrweapon
 * @author wundrweapon
 */
@EventBusSubscriber
public class Registry {
	private static Enchantment duper = Main.duper;
	private static Item[] items = {Main.bebpd, Main.enderAxe, Main.enderEssence, Main.enderInfusedTwig, Main.enderPickaxe, Main.enderShovel, Main.enderSword, Main.heatedEnderCore, Main.impureEnderCore, Main.pureEnderCore};
	
	@SubscribeEvent
	public static void registerItems(Register<Item> registry) {
		registry.getRegistry().registerAll(items);
	}
	
	@SubscribeEvent
	public static void registerEnchantments(Register<Enchantment> registry) {
		registry.getRegistry().register(duper);
	}
}
