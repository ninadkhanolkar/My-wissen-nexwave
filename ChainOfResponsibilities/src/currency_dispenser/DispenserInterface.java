package currency_dispenser;

public interface DispenserInterface {

	void getDenominations(int amount, StringBuilder builder);

	void setNextDispenser(DispenserInterface next);

}