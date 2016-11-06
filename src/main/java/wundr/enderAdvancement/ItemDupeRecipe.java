package wundr.enderAdvancement;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import wundr.enderAdvancement.item.*;
import wundr.enderAdvancement.item.tool.EnderItemTeleportWand;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class ItemDupeRecipe implements IRecipe {
	
	@Override
	public boolean matches(InventoryCrafting grid, World world) {
		int otherItemCount = 0;
		int pureCoreCount = 0;
		
		for(int slot = 0; slot < grid.getSizeInventory(); slot++) {
			ItemStack currentStack = grid.getStackInSlot(slot);
			
			if(currentStack != null) {
				if(currentStack.getItem() instanceof EnderItemPureCore) {
					pureCoreCount++;
				} else {
					if((currentStack.getItem() instanceof EnderItemEssence) || (currentStack.getItem() instanceof EnderItemHeatedCore) || (currentStack.getItem() instanceof EnderItemImpureCore) || (currentStack.getItem() instanceof EnderItemStick) || (currentStack.getItem() instanceof EnderItemTeleportWand)) {
						return false;
					}
					
					otherItemCount++;
				}
			}
		}
		
		return (otherItemCount == 1) && (pureCoreCount == 1);
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting grid) {
		for(int slot = 0; slot < grid.getSizeInventory(); slot++) {
			ItemStack currentStack = grid.getStackInSlot(slot);
			
			if((currentStack != null) && !(currentStack.getItem() instanceof EnderItemPureCore)) {
				ItemStack cloneStack = currentStack.copy();
				cloneStack.stackSize = currentStack.stackSize * 2;
				return cloneStack;
			}
		}
		
		return null; //Won't run
	}
	
	//I presume it's two because it's a two-stack recipe, but idk
	@Override
	public int getRecipeSize() {
		return 2;
	}
  
	@Override
	@Nullable
	public ItemStack getRecipeOutput() {
		return null;
	}
	
	@Override
	public ItemStack[] getRemainingItems(InventoryCrafting grid) {
		ItemStack pureCore = null;
		ItemStack otherStack = null;
		
		for(int i = 0; i < grid.getSizeInventory(); i++) {
			try {
				if(grid.getStackInSlot(i).getItem() instanceof EnderItemPureCore) {
					pureCore = grid.getStackInSlot(i).copy();
				} else {
					otherStack = grid.getStackInSlot(i).copy();
				}
			} catch(NullPointerException e) {
				continue;
			}
		}
		
		grid.clear();
		
		if(otherStack.stackSize < 50) {
			pureCore.attemptDamageItem(otherStack.stackSize, Minecraft.getMinecraft().theWorld.rand);
			return new ItemStack[] {pureCore};
		} else if(otherStack.stackSize == 50) {
			return new ItemStack[] {};
		} else {
			otherStack.stackSize -= 50;
			return new ItemStack[] {otherStack};
		}
	}
}
