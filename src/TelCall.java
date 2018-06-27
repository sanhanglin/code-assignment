import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * Telephone Call class -
 * call is threading and borrow employees from pool to handle.
 * 
 * @author Henry
 *
 */
public class TelCall extends Thread {
	
	private GenericObjectPool<Fresher> fresherPool;
	private GenericObjectPool<TechnicalLead> tlPool;
	private GenericObjectPool<ProductManager> pmPool;
	
	public TelCall(GenericObjectPool<Fresher> fresherPool, 
			       GenericObjectPool<TechnicalLead> tlPool,
			       GenericObjectPool<ProductManager> pmPool) {
		this.fresherPool = fresherPool;
		this.tlPool = tlPool;
		this.pmPool = pmPool;
	}
	
	@Override
	public void run() {
		
		HandledByFresher();
	
	}	
	
	/**
	 * Handle the call by fresher from pool
	 */
	private void HandledByFresher() {
		Fresher fresher = null;
		try {
			fresher = fresherPool.borrowObject();
			boolean isSolvedByFresher = fresher.isTelCallSolved();
			
			if(!isSolvedByFresher) 
				throw new Exception("Escalate the call");
			
		} catch(Exception e) {
			HandledByTechnicalLead();			
		} finally {
			try {
				if(fresher != null) {
					fresherPool.returnObject(fresher);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Handle the call by technical lead from pool
	 */
	private void HandledByTechnicalLead() {
		TechnicalLead tl = null;
		try {
			tl = tlPool.borrowObject();
			boolean isSolvedByTL = tl.isTelCallSolved();
			
			if(!isSolvedByTL) 
				throw new Exception("Escalate the call");
			
		} catch(Exception e) {
			HandledByProductManager();
		} finally {
			try {
				if(tl != null) {
					tlPool.returnObject(tl);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Handle the call by product manager from pool
	 */
	private void HandledByProductManager() {
		ProductManager pm = null;
		try {
			pm = pmPool.borrowObject();
			pm.isTelCallSolved();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pm != null) {
					pmPool.returnObject(pm);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}
