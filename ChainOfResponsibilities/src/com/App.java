package com;
import ATM.ATM;
import currency_dispenser.CurrencyDispenser;
import currency_dispenser.DispenserInterface;
public class App {
	public static void main(String[] args) {
		ATM a=new ATM();
		DispenserInterface twoThousandDispenser=new CurrencyDispenser(2000, null);
		twoThousandDispenser.setNextDispenser(new CurrencyDispenser(500, null));
		twoThousandDispenser.setNextDispenser(new CurrencyDispenser(200, null));
		twoThousandDispenser.setNextDispenser(new CurrencyDispenser(100, null));
		a.setCurrencyDispenser(twoThousandDispenser);
		System.out.println(a.getCurrency(2900));
		
	}

}
