package emasher.blocks;

import emasher.EngineersToolbox;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockSandBag extends BlockFalling {

	public BlockSandBag( Material par2Material ) {
		super( par2Material );
		this.setCreativeTab(EngineersToolbox.tabBlocks() );
	}
	
	@Override
	public void registerBlockIcons( IIconRegister par1IconRegister ) {
		this.blockIcon = par1IconRegister.registerIcon( "eng_toolbox:sandbag" );
	}
	

}
