package rocks.boltsandnuts.falsework.items;

/*
 * Base item class for getting standard things done with quickly.
 * Extend this for pretty much every item you make.
 */

import rocks.boltsandnuts.falsework.Falsework;
import rocks.boltsandnuts.falsework.ModInformation;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	// If you aren't setting multiple textures for your item. IE: Non-Metadata items.
	public ItemBase(String unlocName, String textureName) {
		super();

		setUnlocalizedName(ModInformation.ID + "." + unlocName);
		setTextureName(ModInformation.ID + ":" + textureName);
		setCreativeTab(Falsework.tabBaseMod);
	}

	// If you are setting multiple textures for your item. IE: Metadata items.
	public ItemBase(String unlocName) {
		super();

		setUnlocalizedName(ModInformation.ID + "." + unlocName);
		setCreativeTab(Falsework.tabBaseMod);
	}
}
