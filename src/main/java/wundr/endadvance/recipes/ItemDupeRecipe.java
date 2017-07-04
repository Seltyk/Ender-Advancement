package wundr.endadvance.recipes;

import com.google.common.reflect.TypeToken;
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
import wundr.endadvance.EnderAdvancement;
import wundr.endadvance.item.EnderItem;
import wundr.endadvance.item.EnderItemPureCore;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file, and to the Forge folks for some {@link net.minecraftforge.registries.IForgeRegistryEntry} code I'm borrowing ;)
 * @author wundrweapon
 */
//Normally, I'd organize the class, but I'm using this order to keep up-to-date with any changes to superclasses
public class ItemDupeRecipe implements IRecipe {
	private ResourceLocation regName;
	private TypeToken<IRecipe> token = new TypeToken<IRecipe>(getClass()) {}; //Don't mind me, just borring Forge code
	
	public ItemDupeRecipe(ResourceLocation resourceLocation) {
		setRegistryName(resourceLocation);
	}
	
	@Override
	public IRecipe setRegistryName(ResourceLocation name) {
		regName = name;
		return this;
	}
	
	@Override
	public ResourceLocation getRegistryName() {
		return regName;
	}
	
	@Override
	public Class<IRecipe> getRegistryType() {
		return (Class<IRecipe>) token.getRawType(); //Still borrowing Forge code
	}
	
	@Override
	public boolean matches(InventoryCrafting grid, World world) {
		int otherItemCount = 0;
		int pureCoreCount = 0;
		
		for(int slot = 0; slot < grid.getSizeInventory(); slot++) {
			ItemStack currentStack = grid.getStackInSlot(slot);
			
			//ItemStack now uses ItemStack.EMPTY rather than null
			if(!currentStack.isEmpty()) {
				if(currentStack.getItem() instanceof EnderItemPureCore) {
					pureCoreCount++;
				} else {
					
					//Is it any item from the mod? If so, then too bad, you're not cloning it
					if(currentStack.getItem().getClass().getPackage().getName().substring(0, 21).equalsIgnoreCase("wundr.endadvance.item")) {
						return false;
					}
					
					otherItemCount++;
				}
			}
		}
		
		return otherItemCount == 1 && pureCoreCount == 1;
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting grid) {
		for(int slot = 0; slot < grid.getSizeInventory(); slot++) {
			ItemStack currentStack = grid.getStackInSlot(slot);
			
			if(!currentStack.isEmpty() && !(currentStack.getItem() instanceof EnderItemPureCore)) {
				ItemStack cloneStack = currentStack.copy();
				cloneStack.setCount(currentStack.getCount() * 2);
				return cloneStack;
			}
		}
		
		return null; //Won't run
	}
	
	@Override
	public boolean canFit(int width, int height) {
		return width >= 1 && height >= 2 || width >= 2 && height >= 1; //Minimum 1x2 either direction
	}
	
	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY; //Recipe is too complex to support this unused system
	}
	
	@Override
	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting grid) {
		ItemStack pureCore = null;
		ItemStack otherStack = null;
		
		for(int i = 0; i < grid.getSizeInventory(); i++) {
			try {
				if(grid.getStackInSlot(i).getItem() instanceof EnderItemPureCore) {
					pureCore = grid.getStackInSlot(i).copy();
				} else {
					otherStack = grid.getStackInSlot(i).copy();
				}
			} catch(NullPointerException e) {}
		}
		
		grid.clear();
		
		if(otherStack.getCount() < pureCore.getItemDamage()) {
			try {
				Container c = (Container) ReflectionHelper.findField(InventoryCrafting.class, "eventHandler").get(grid);
				
				if(c instanceof ContainerPlayer) {
					pureCore.damageItem(otherStack.getCount(), (EntityPlayer) ReflectionHelper.findField(ContainerPlayer.class, "player").get(c));
				} else {
					pureCore.damageItem(otherStack.getCount(), (EntityPlayer) ReflectionHelper.findField(SlotCrafting.class, "player").get(c.getSlot(0)));
				}
			} catch(IllegalAccessException e) {} //Never throws anything
			
			NonNullList<ItemStack> out = NonNullList.create();
			out.add(pureCore);
			
			return out;
		} else if(otherStack.getCount() == pureCore.getItemDamage()) {
			return NonNullList.create();
		} else {
			otherStack.setCount(otherStack.getCount() - pureCore.getItemDamage());
			
			NonNullList<ItemStack> out = NonNullList.create();
			out.add(otherStack);
			
			return out;
		}
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> out = NonNullList.create();
		out.add(Ingredient.fromItem(EnderAdvancement.PURE_CORE));
		
		return out;
	}
	
	//No isHidden() - its default implementation is fine
	
	@Override
	public String getGroup() {
		return EnderAdvancement.RECIPE_GROUP.toString();
	}
}
