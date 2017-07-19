package wundr.endadvance.eventHandlers;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.endadvance.EnderAdvancement;
import wundr.modutils.Booleans;

import java.util.ArrayList;

/**
 * This class handles doubling experience and drops from certain mined things<br>
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the original version of this file
 * @author wundrweapon
 */
@EventBusSubscriber(modid = EnderAdvancement.MOD_ID)
@SuppressWarnings("unused")
public class HarvestDropsEventHandler {
	
	/**
	 * Doubles the experience dropped when mining with <i>Duper</i>
	 * @param event the {@link BreakEvent} being handled
	 */
	@SubscribeEvent
	public static void onBreak(BreakEvent event) {
		try {
			if(Booleans.isEnchanted(EnderAdvancement.DUPER, event.getPlayer().getHeldItemMainhand())) {
				event.setExpToDrop(event.getExpToDrop() * 2);
			}
		} catch(NullPointerException e) {}
	}
	
	/**
	 * Doubles the drops when mining with <i>Duper</i>
	 * @param event the {@link HarvestDropsEvent} being handled
	 */
	@SubscribeEvent
	public static void onHarvestDrops(HarvestDropsEvent event) {
		try {
			if(Booleans.isEnchanted(EnderAdvancement.DUPER, event.getHarvester().getHeldItemMainhand())) {
				ArrayList<ItemStack> dropsCopy = new ArrayList<>(event.getDrops()); //Copies the drops list to a new ArrayList
				
				for(ItemStack drop : dropsCopy) {
					
					//This statement returns true if and only if the drop does not represent any sort of block
					if(!(drop.getItem() instanceof ItemBlock || drop.getItem() instanceof ItemBlockSpecial)) {
						event.getDrops().add(drop.copy());
					}
				}
			}
		} catch(NullPointerException e) {}
	}
}
