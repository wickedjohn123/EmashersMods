package emasher.core.hemp;

import emasher.core.EmasherCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemHempTunic extends ItemArmor {
	public ItemHempTunic( ArmorMaterial par2EnumArmorMaterial,
						  int par3, int par4 ) {
		super( par2EnumArmorMaterial, par3, par4 );
		
		this.setCreativeTab( EmasherCore.tabEmasher );
		//setIconIndex(32);
		setUnlocalizedName( "hempTunic" );
	}

	@Override
	public String getArmorTexture( ItemStack stack, Entity entity, int slot, String type ) {
		return "emasher:textures/models/armour/hemp_1.png";
	}
	
	@Override
	public void registerIcons( IIconRegister iconRegister ) {
		itemIcon = iconRegister.registerIcon( "emashercore:hempTunic" );
	}
}
