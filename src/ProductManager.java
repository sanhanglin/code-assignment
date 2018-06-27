public class ProductManager extends Employee {

	@Override
	public boolean isTelCallSolved() {
		System.out.println(Thread.currentThread().getId() + " : ----Telephone Call is solved by product manager.");
		return true;
	}
}
