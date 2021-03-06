package emasher.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emasher.EngineersToolbox;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemIngot extends Item {
	@SideOnly( Side.CLIENT )
	public IIcon[] textures;

	public ItemIngot() {
		super();
		this.setCreativeTab( EngineersToolbox.tabItems() );
		setHasSubtypes( true );
	}
	
	
	@Override
	@SideOnly( Side.CLIENT )
	public IIcon getIconFromDamage( int damage ) {
		return textures[damage];
	}
	
	@Override
	@SideOnly( Side.CLIENT )
	public void registerIcons( IIconRegister ir ) {
		textures = new IIcon[9];
		
		textures[0] = ir.registerIcon( "eng_toolbox:ingotAluminium" );
		textures[1] = ir.registerIcon( "eng_toolbox:ingotBronze" );
		textures[2] = ir.registerIcon( "eng_toolbox:ingotCopper" );
		textures[3] = ir.registerIcon( "eng_toolbox:ingotLead" );
		textures[4] = ir.registerIcon( "eng_toolbox:ingotNickel" );
		textures[5] = ir.registerIcon( "eng_toolbox:ingotPlatinum" );
		textures[6] = ir.registerIcon( "eng_toolbox:ingotSilver" );
		textures[7] = ir.registerIcon( "eng_toolbox:ingotSteel" );
		textures[8] = ir.registerIcon( "eng_toolbox:ingotTin" );
		
		this.itemIcon = textures[0];
	}
	
	@Override
	public String getUnlocalizedName( ItemStack itemstack ) {
		String name = "";
		switch(itemstack.getItemDamage()) {
			case 0:
				name = "e_ingotAluminium";
				break;
			case 1:
				name = "e_ingotBronze";
				break;
			case 2:
				name = "e_ingotCopper";
				break;
			case 3:
				name = "e_ingotLead";
				break;
			case 4:
				name = "e_ingotNickel";
				break;
			case 5:
				name = "e_ingotPlatinum";
				break;
			case 6:
				name = "e_ingotSilver";
				break;
			case 7:
				name = "e_ingotSteel";
				break;
			case 8:
				name = "e_ingotTin";
				break;
		}
		return getUnlocalizedName() + "." + name;
	}
	
	@Override
	@SideOnly( Side.CLIENT )
	public void getSubItems( Item par1, CreativeTabs par2CreativeTabs, List par3List ) {
		for( int i = 0; i < 9; i++ ) par3List.add( new ItemStack( par1, 1, i ) );
	}

}
