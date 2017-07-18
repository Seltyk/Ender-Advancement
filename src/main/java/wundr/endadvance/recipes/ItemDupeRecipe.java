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
	private TypeToken<IRecipe> token = new TypeToken<IRecipe>(getClass()) {}; //Don't mind me, just borrowing Forge code
	
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
					try {
						if(currentStack.getItem().getClass().getPackage().getName().substring(0, 21).equalsIgnoreCase("wundr.endadvance.item")) {
							return false;
						}
					} catch(NullPointerException e) {}
					
					otherItemCount++;
				}
			}
		}
		
		return otherItemCount == 1 && pureCoreCount == 1;
	}
	
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
		
		outStack.setCount(outStack.getCount() * 2 <= (pureCore.getMaxDamage() - pureCore.getItemDamage()) ? outStack.getCount() * 2 : (pureCore.getMaxDamage() - pureCore.getItemDamage()) * 2);
		return outStack;
	}
	
	@Override
	public boolean canFit(int width, int height) {
		return width >= 1 && height >= 2 || width >= 2 && height >= 1; //Minimum 1x2 either direction
	}
	
	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY; //Recipe is too complex to support this archaic system
	}
	
	@Override
	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting grid) {
		ItemStack pureCore = ItemStack.EMPTY;
		ItemStack cloneStack = ItemStack.EMPTY;
		
		for(int i = 0; i < grid.getSizeInventory(); i++) {
			if(grid.getStackInSlot(i).getItem() instanceof EnderItemPureCore) {
				pureCore = grid.getStackInSlot(i).copy();
			} else if(!grid.getStackInSlot(i).isEmpty()) {
				cloneStack = grid.getStackInSlot(i).copy();
			}
		}
		
		grid.clear();
		
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
		} else if(cloneStack.getCount() == pureCore.getMaxDamage() - pureCore.getItemDamage()) {
			return NonNullList.create();
		} else {
			cloneStack.setCount(cloneStack.getCount() - (pureCore.getMaxDamage() - pureCore.getItemDamage()));
			
			NonNullList<ItemStack> out = NonNullList.create();
			out.add(cloneStack);
			
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
