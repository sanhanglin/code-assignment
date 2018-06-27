import java.util.Random;

public abstract class Employee {
	public boolean isTelCallSolved() {
		Random r = new Random();
		return r.nextBoolean();
	}
}
