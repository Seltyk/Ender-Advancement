package wundr.endadvance.recipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;
import wundr.endadvance.EnderAdvancement;
import wundr.endadvance.item.EnderItemPureCore;

/**
 * The way-more-complex-than-I-had-initially-anticipated code for an item duplication recipe! Supports varying stack sizes and any item you
 * throw at it <s>except for those I specifically reject</s><br>
 * Normally, I'd organize the class by name and whatnot, but I'm using this order to keep up-to-date with any changes to superclasses<br>
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class ItemDupeRecipe extends Impl<IRecipe> implements IRecipe {
	public ItemDupeRecipe(ResourceLocation registryLocation) {
		setRegistryName(registryLocation);
	}
	
	/**
	 * Given a grid and the world in which the player uses the grid, see if a given setup is considered to be a duplication setup
	 * @param grid the crafting inventory being used
	 * @param world where the crafting grid opened up
	 * @return {@code true} if the grid contains a duplication setup, {@code false} otherwise
	 */
	@Override
	public boolean matches(InventoryCrafting grid, World world) {
		int otherItemCount = 0;
		int pureCoreCount = 0;
		
		//Iterate through the grid count the stacks.
		for(int slot = 0; slot < grid.getSizeInventory(); slot++) {
			ItemStack currentStack = grid.getStackInSlot(slot);
			
			//ItemStack now uses ItemStack.EMPTY rather than null
			if(!currentStack.isEmpty()) {
				if(currentStack.getItem() instanceof EnderItemPureCore) {
					pureCoreCount++;
				} else {
					
					//Is it any item from the mod? If so, then too bad, you're not cloning it
					try {
						if(currentStack.getItem().getClass().getPackage().getName().substring(0, 21).equalsIgnoreCase("wundr.endadvance.item")) {
							return false;
						}
					} catch(NullPointerException e) {} //Not sure if this is necessary as empty grid slots don't return null any more...
					
					otherItemCount++;
				}
			}
		}
		
		return otherItemCount == 1 && pureCoreCount == 1; //Too much stuff? Too bad
	}
	
	/**
	 * Get the duplicated stack output
	 * @param grid crafting grid containing the already-known-to-be-corrrect items
	 * @return a stack that is equal to double to duplicating stack
	 */
	@Override
	public ItemStack getCraftingResult(InventoryCrafting grid) {
		ItemStack pureCore = ItemStack.EMPTY;
		ItemStack outStack = ItemStack.EMPTY;
		
		for(int i = 0; i < grid.getSizeInventory(); i++) {
			if(grid.getStackInSlot(i).getItem() instanceof EnderItemPureCore) {
				pureCore = grid.getStackInSlot(i).copy();
			} else if(!grid.getStackInSlot(i).isEmpty()) {
				outStack = grid.getStackInSlot(i).copy();
			}
		}
		
		outStack.setCount(outStack.getCount() * 2 <= (pureCore.getMaxDamage() - pureCore.getItemDamage()) ? outStack.getCount() * 2 : (pureCore.getMaxDamage() - pureCore.getItemDamage()) * 2); //MaxDamage - ItemDamage = remaining uses
		return outStack;
	}
	
	/**
	 * @param width grid's x size
	 * @param height grid's y size
	 * @return {@code true} if the grid is at least 1x2 either way
	 */
	@Override
	public boolean canFit(int width, int height) {
		return width >= 1 && height >= 2 || width >= 2 && height >= 1; //Minimum 1x2 either direction
	}
	
	/**
	 * Archaic system to determine what the recipe output will be. Can safely be empty
	 * @return {@link ItemStack#EMPTY} cuz I ain't usin' this garbage
	 */
	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY; //Recipe is too complex to support this archaic system
	}
	
	/**
	 * Keeps the core or items in the grid if any goes unused
	 * @param grid the crafting grid just used
	 * @return
	 */
	@Override
	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting grid) {
		ItemStack pureCore = ItemStack.EMPTY;
		ItemStack cloneStack = ItemStack.EMPTY;
		
		//Grab the pure core and clone item
		for(int i = 0; i < grid.getSizeInventory(); i++) {
			if(grid.getStackInSlot(i).getItem() instanceof EnderItemPureCore) {
				pureCore = grid.getStackInSlot(i).copy();
			} else if(!grid.getStackInSlot(i).isEmpty()) {
				cloneStack = grid.getStackInSlot(i).copy();
			}
		}
		
		grid.clear(); //Clear off the grid
		
		//Damage the pure core and leave it
		if(cloneStack.getCount() < pureCore.getMaxDamage() - pureCore.getItemDamage()) {
			try {
				Container c = (Container) ReflectionHelper.findField(InventoryCrafting.class, "eventHandler").get(grid);
				
				if(c instanceof ContainerPlayer) {
					pureCore.damageItem(cloneStack.getCount(), (EntityPlayer) ReflectionHelper.findField(ContainerPlayer.class, "player").get(c));
				} else {
					pureCore.damageItem(cloneStack.getCount(), (EntityPlayer) ReflectionHelper.findField(SlotCrafting.class, "player").get(c.getSlot(0)));
				}
			} catch(IllegalAccessException e) {} //Never throws anything
			
			NonNullList<ItemStack> out = NonNullList.create();
			out.add(pureCore);
			
			return out;
		} else if(cloneStack.getCount() == pureCore.getMaxDamage() - pureCore.getItemDamage()) { //Leave neither if pure core drains out evenly with duplication
			return NonNullList.create();
		} else { //Leave cloned stack's remains if pure core drains before completed duplication
			cloneStack.setCount(cloneStack.getCount() - (pureCore.getMaxDamage() - pureCore.getItemDamage()));
			
			NonNullList<ItemStack> out = NonNullList.create();
			out.add(cloneStack);
			
			return out;
		}
	}
	
	/**
	 * Get the list of ingredients required to duplicate
	 * @return a {@link NonNullList} containing only a pure core (as a wildcard stack can't be named)
	 */
	@Override
	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> out = NonNullList.create();
		out.add(Ingredient.fromItem(EnderAdvancement.PURE_CORE));
		
		return out;
	}
	
	//No isHidden() - its default implementation is fine
	
	/**
	 * @return the Ender Advancement recipe group (of which this is an element)
	 */
	@Override
	public String getGroup() {
		return EnderAdvancement.RECIPE_GROUP.toString();
	}
}
