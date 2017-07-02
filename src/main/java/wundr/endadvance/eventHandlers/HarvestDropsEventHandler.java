package wundr.endadvance.eventHandlers;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.endadvance.EnderAdvancement;
import wundr.endadvance.item.tool.EnderPickaxe;
import wundr.modutils.Booleans;

import java.util.ArrayList;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the original version of this file
 * @author wundrweapon
 */
@EventBusSubscriber
@SuppressWarnings("unused")
public class HarvestDropsEventHandler {

	@SubscribeEvent
	public static void onHarvestDrops(HarvestDropsEvent event) {
		try {
			if(Booleans.isEnchanted(EnderAdvancement.DUPER, event.getHarvester().getActiveItemStack()) || event.getHarvester().getActiveItemStack().getItem() instanceof EnderPickaxe) {
				ArrayList<ItemStack> dropsCopy = new ArrayList<>(event.getDrops()); //Copies the drops list to a new ArrayList
				
				for(ItemStack drop : dropsCopy) {
					if(!(drop.getItem() instanceof ItemBlock || drop.getItem() instanceof ItemBlockSpecial)) {
						event.getDrops().add(drop.copy());
					}
				}
			}
		} catch(NullPointerException e) {}
	}
}