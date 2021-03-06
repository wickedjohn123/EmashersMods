package emasher.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class MultiSmelterRecipeRegistry {
	public static ArrayList<MultiSmelterRecipe> list = new ArrayList<MultiSmelterRecipe>();
	
	public static void registerRecipe( String input1, String input2, ItemStack output ) {
		list.add( new MultiSmelterRecipe( input1, input2, output ) );
		list.add( new MultiSmelterRecipe( input2, input1, output ) );
	}
	
	public static void registerRecipe( ItemStack input1, String input2, ItemStack output ) {
		list.add( new MultiSmelterRecipe( input1, input2, output ) );
		list.add( new MultiSmelterRecipe( input2, input1, output ) );
	}
	
	public static void registerRecipe( String input1, ItemStack input2, ItemStack output ) {
		list.add( new MultiSmelterRecipe( input1, input2, output ) );
		list.add( new MultiSmelterRecipe( input2, input1, output ) );
	}
	
	public static void registerRecipe( ItemStack input1, ItemStack input2, ItemStack output ) {
		list.add( new MultiSmelterRecipe( input1, input2, output ) );
		list.add( new MultiSmelterRecipe( input2, input1, output ) );
	}
	
	public static void registerRecipe( String input1, String input2, String output ) {
		list.add( new MultiSmelterRecipe( input1, input2, output ) );
		list.add( new MultiSmelterRecipe( input2, input1, output ) );
	}

	public static MultiSmelterRecipe getRecipeFor( Object input1, Object input2 ) {
		int[] rID1, rID2, id1, id2;
		boolean firstMatch, secondMatch;

		for( MultiSmelterRecipe r : list ) {
			firstMatch = false;
			secondMatch = false;

			if( input1 instanceof ItemStack ) {
				if( input2 instanceof ItemStack ) {

					id1 = OreDictionary.getOreIDs( ( ItemStack ) input1 );
					id2 = OreDictionary.getOreIDs( ( ItemStack ) input2 );

					if( r.input1 instanceof ItemStack ) rID1 = OreDictionary.getOreIDs((ItemStack) r.input1);
					else rID1 = new int[] { OreDictionary.getOreID( ( String ) r.input1 ) };
					if( r.input2 instanceof ItemStack ) rID2 = OreDictionary.getOreIDs( ( ItemStack ) r.input2 );
					else rID2 = new int[] { OreDictionary.getOreID( ( String ) r.input2 ) };

					if( Util.checkArrays( id1, rID1 ) ) firstMatch = true;
					else if( r.input1 instanceof ItemStack && ( ( ItemStack ) r.input1 ).isItemEqual( ( ItemStack ) input1 ) )
						firstMatch = true;
					if( Util.checkArrays( id2, rID2 ) ) secondMatch = true;
					else if( r.input2 instanceof ItemStack && ( ( ItemStack ) r.input2 ).isItemEqual( ( ItemStack ) input2 ) )
						secondMatch = true;

					if( firstMatch && secondMatch ) {
						if( r.getOutput() != null )
							return r;
					}
				} else if( input2 instanceof String ) {
					id1 = OreDictionary.getOreIDs( ( ItemStack ) input1 );
					id2 = new int[] { OreDictionary.getOreID( ( String ) input2 ) };

					if( r.input1 instanceof ItemStack ) rID1 = OreDictionary.getOreIDs( ( ItemStack ) r.input1 );
					else rID1 = new int[] { OreDictionary.getOreID( ( String ) r.input1 ) };
					if( r.input2 instanceof ItemStack ) rID2 = OreDictionary.getOreIDs( ( ItemStack ) r.input2 );
					else rID2 = new int[] { OreDictionary.getOreID( ( String ) r.input2 ) };

					if( Util.checkArrays( id1, rID1 ) ) firstMatch = true;
					else if( r.input1 instanceof ItemStack && ( ( ItemStack ) r.input1 ).isItemEqual( ( ItemStack ) input1 ) )
						firstMatch = true;
					if( Util.checkArrays( id2, rID2 ) ) secondMatch = true;

					if( firstMatch && secondMatch ) {
						if( r.getOutput() != null )
							return r;
					}
				}
			} else if( input1 instanceof String ) {
				if( input2 instanceof ItemStack ) {
					id1 = new int[] { OreDictionary.getOreID( ( String ) input1 ) };
					id2 = OreDictionary.getOreIDs( ( ItemStack ) input2 );

					if( r.input1 instanceof ItemStack ) rID1 = OreDictionary.getOreIDs( ( ItemStack ) r.input1 );
					else rID1 = new int[] { OreDictionary.getOreID( ( String ) r.input1 ) };
					if( r.input2 instanceof ItemStack ) rID2 = OreDictionary.getOreIDs( ( ItemStack ) r.input2 );
					else rID2 = new int[] { OreDictionary.getOreID( ( String ) r.input2 ) };

					if( Util.checkArrays( id1, rID1 ) ) firstMatch = true;
					if( Util.checkArrays( id2, rID2 ) ) secondMatch = true;
					else if( r.input2 instanceof ItemStack && ( ( ItemStack ) r.input2 ).isItemEqual( ( ItemStack ) input2 ) )
						secondMatch = true;

					if( firstMatch && secondMatch ) {
						if( r.getOutput() != null )
							return r;
					}
				} else if( input2 instanceof String ) {
					id1 = new int[] { OreDictionary.getOreID( ( String ) input1 ) };
					id2 = new int[] { OreDictionary.getOreID( ( String ) input2 ) };

					if( r.input1 instanceof ItemStack ) rID1 = OreDictionary.getOreIDs( ( ItemStack ) r.input1 );
					else rID1 = new int[] { OreDictionary.getOreID( ( String ) r.input1 ) };
					if( r.input2 instanceof ItemStack ) rID2 = OreDictionary.getOreIDs( ( ItemStack ) r.input2 );
					else rID2 = new int[] { OreDictionary.getOreID( ( String ) r.input2 ) };

					if( Util.checkArrays( id1, rID1) ) firstMatch = true;
					if( Util.checkArrays( id2, rID2 ) ) secondMatch = true;

					if( firstMatch && secondMatch ) {
						if( r.getOutput() != null )
							return r;
					}
				}
			}
		}

		return null;
	}

	public static class MultiSmelterRecipe {
		protected Object input1;
		protected Object input2;
		protected Object output;

		public MultiSmelterRecipe( String input1, String input2, ItemStack output ) {
			this.input1 = input1;
			this.input2 = input2;
			this.output = output;
		}

		public MultiSmelterRecipe( ItemStack input1, String input2, ItemStack output ) {
			this.input1 = input1;
			this.input2 = input2;
			this.output = output;
		}

		public MultiSmelterRecipe( String input1, ItemStack input2, ItemStack output ) {
			this.input1 = input1;
			this.input2 = input2;
			this.output = output;
		}

		public MultiSmelterRecipe( String input1, String input2, String output ) {
			this.input1 = input1;
			this.input2 = input2;
			this.output = output;
		}

		public MultiSmelterRecipe( ItemStack input1, String input2, String output ) {
			this.input1 = input1;
			this.input2 = input2;
			this.output = output;
		}

		public MultiSmelterRecipe( String input1, ItemStack input2, String output ) {
			this.input1 = input1;
			this.input2 = input2;
			this.output = output;
		}

		public MultiSmelterRecipe( ItemStack input1, ItemStack input2, ItemStack output ) {
			this.input1 = input1;
			this.input2 = input2;
			this.output = output;
		}

		public Object getInput1() {
			return input1;
		}

		public Object getInput2() {
			return input2;
		}

		public List<ItemStack> getOutput() {
			if( this.output instanceof String ) {
				return OreDictionary.getOres( ( String ) this.output );
			} else {
				ArrayList<ItemStack> result = new ArrayList<ItemStack>();
				result.add( ( ItemStack )output );
				return result;
			}
		}
	}
}
