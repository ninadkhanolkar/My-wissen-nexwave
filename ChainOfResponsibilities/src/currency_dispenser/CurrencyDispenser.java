package currency_dispenser;

public class CurrencyDispenser implements DispenserInterface {
	int denomination;
	DispenserInterface next;

	public CurrencyDispenser(int denomination, DispenserInterface next) {
		super();
		this.denomination = denomination;
		this.next = next;
	}

	/* (non-Javadoc)
	 * @see currency_dispenser.DispenserInterface#getDenominations(int, java.lang.StringBuilder)
	 */
	@Override
	public void getDenominations(int amount, StringBuilder builder) {
		// TODO Auto-generated method stub
		int numNotes = amount / this.denomination;
		int balance = amount % this.denomination;
		if (next == null) {
			if (balance == 0)
				builder.append(numNotes + " x " + denomination);
			else
				builder.append("Invalid amount");
		} else {
			builder.append(numNotes + " x " + denomination + "  ");
			if (balance != 0)
				next.getDenominations(balance, builder);
		}

	}

	/* (non-Javadoc)
	 * @see currency_dispenser.DispenserInterface#setNextDispenser(currency_dispenser.DispenserInterface)
	 */
	@Override
	public void setNextDispenser(DispenserInterface next) {
		if(this.next==null)
		    this.next = next;
		else this.next.setNextDispenser(next);
	}
}
