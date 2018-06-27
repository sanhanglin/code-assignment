import java.util.Random;

public class Fresher extends Employee {
	
	@Override
	public boolean isTelCallSolved() {
		Random r = new Random();
		boolean res = r.nextBoolean();
		
		if(res) 
			System.out.println(Thread.currentThread().getId() + " : Telephone Call is solved by fresher.");
		else
			System.out.println(Thread.currentThread().getId() + " : Telephone Call is escalate to technical lead.");

		return res;
	}
}
