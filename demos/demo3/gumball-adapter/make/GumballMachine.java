
import java.lang.reflect.* ;

public class GumballMachine {

	private int cnt = 0; // inventory
	private int coinValue = 0 ; // cents
	private int cost = 0 ; // configure at setup

	public GumballMachine(int count) {
		this.cnt = count;
	}

	// Display Config
	public void dumpConfig() {
		System.out.println( "Gumball Inventory: " + cnt ) ;
		System.out.println( "Gumball Cost:      " + cost ) ;
		System.out.println( "Coin Value:        " + coinValue ) ;
	}
	
	// Coin Property
	public void setCoinValue( int v ) { coinValue = v ; }
	public int  getCoinValue() { return coinValue ; }
	
	// Configure Cost of a Gumball
	public void setCost( int c ) { cost = c ; }
	public int getCost() { return cost ; }
	
	
	// Insert Coin Helper Method
	public void insertCoinValue( int v ) {
		System.out.println( "Added " + v + " cents...") ;
		setCoinValue(coinValue + v) ;
	}
	
	// Eject Gumball if Available
	public void ejectGumball() {
		if ( coinValue < cost ) {
			System.out.println( "Not Enough Money!" ) ;
			return ;
		}
		if ( cnt > 0 ) {
			cnt-- ;
			System.out.println( "Gumball Ejected!" ) ;
			System.out.println( "Change Return: " + (coinValue - cost) + " cents." ) ;
			coinValue = 0 ;
		}
		else {
			System.out.println( "Sorry! Out of Gumballs." ) ;
		}
	}
	
	// Main Class - Dump Metadata
	public static void main( String args[ ] )
	{
		System.out.println( "***** Class Bytecode Dump *****" ) ;
		GumballMachine m = new GumballMachine(10) ;
		Class gmClass = m.getClass() ;
		Method gmMethods[] = gmClass.getMethods() ;
		for ( int i=0; i <gmMethods.length; i++ )
		{
			Method theMethod = gmMethods[i] ;
			String method = theMethod.toString() ;
			System.out.println( method ) ;
		}
		
	}
	
}
