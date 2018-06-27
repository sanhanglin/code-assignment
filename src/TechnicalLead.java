import java.util.Random;

public class TechnicalLead extends Employee {

	@Override
	public boolean isTelCallSolved() {
		Random r = new Random();
		boolean res = r.nextBoolean();
		if(res) 
			System.out.println(Thread.currentThread().getId() + " : --Telephone Call is solved by technical lead.");
		else
			System.out.println(Thread.currentThread().getId() + " : --Telephone Call is escalate to product manager.");
		
		return res;
	}
}
