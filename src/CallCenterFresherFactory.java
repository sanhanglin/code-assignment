import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class CallCenterFresherFactory extends BasePooledObjectFactory<Fresher> {

	@Override
	public Fresher create() throws Exception {
		return new Fresher();
	}

	@Override
	public PooledObject<Fresher> wrap(Fresher f) {
		return new DefaultPooledObject<Fresher>(f);
	}

}
