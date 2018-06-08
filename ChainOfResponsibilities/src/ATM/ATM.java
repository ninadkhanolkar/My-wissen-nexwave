package ATM;

import currency_dispenser.DispenserInterface;

public class ATM {
	DispenserInterface currencyDispenser;
	public String getCurrency(int currency) {
		StringBuilder builder=new StringBuilder();
		currencyDispenser.getDenominations(currency, builder);
		return builder.toString();
	}
	public void setCurrencyDispenser(DispenserInterface currencyDispenser) {
		this.currencyDispenser = currencyDispenser;
	}
	

}
