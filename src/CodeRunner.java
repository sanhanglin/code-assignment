import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * Main runner class - 
 * create three object pools(fresher, technical lead, product manager)
 * for TelCall. 
 * 
 * @author Henry
 *
 */
public class CodeRunner {

	public static final int NUM_OF_CALLS = 500;
	
	/**
	 * init all pools and run multithreading call
	 * @param args
	 */
	public static void main(String[] args) {
		
		GenericObjectPoolConfig fresherConfig = new GenericObjectPoolConfig();
		GenericObjectPoolConfig TLConfig = new GenericObjectPoolConfig();
		GenericObjectPoolConfig PMConfig = new GenericObjectPoolConfig();
		
		fresherConfig.setMaxTotal(10);
		fresherConfig.setMaxWaitMillis(10);
		
		TLConfig.setMaxTotal(1);
		TLConfig.setMaxWaitMillis(100);
		
		PMConfig.setMaxTotal(1);
		PMConfig.setMaxWaitMillis(-1);
		
		GenericObjectPool<Fresher> fresherPool = new GenericObjectPool<Fresher>(new CallCenterFresherFactory(), fresherConfig);
		GenericObjectPool<TechnicalLead> tlPool = new GenericObjectPool<TechnicalLead>(new CallCenterTLFactory(), TLConfig);
		GenericObjectPool<ProductManager> pmPool = new GenericObjectPool<ProductManager>(new CallCenterPMFactory(), PMConfig);
		
		
		for(int i = 0; i < NUM_OF_CALLS; i++) {
			Thread t = new TelCall(fresherPool, tlPool, pmPool);
			t.start();
		}	
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("fresherPool.getBorrowedCount() = " + fresherPool.getBorrowedCount());
		System.out.println("fresherPool.getReturnedCount() = " + fresherPool.getReturnedCount());
		System.out.println("fresherPool.getNumActive() = " + fresherPool.getNumActive());
		System.out.println("fresherPool.getNumIdle() = " + fresherPool.getNumIdle());

		System.out.println("tlPool.getBorrowedCount() = " + tlPool.getBorrowedCount());
		System.out.println("tlPool.getReturnedCount() = " + tlPool.getReturnedCount());
		System.out.println("tlPool.getNumActive() = " + tlPool.getNumActive());
		System.out.println("tlPool.getNumIdle() = " + tlPool.getNumIdle());
		
		System.out.println("pmPool.getBorrowedCount() = " + pmPool.getBorrowedCount());
		System.out.println("pmPool.getReturnedCount() = " + pmPool.getReturnedCount());
		System.out.println("pmPool.getNumActive() = " + pmPool.getNumActive());
		System.out.println("pmPool.getNumIdle() = " + pmPool.getNumIdle());
		
	}


}
