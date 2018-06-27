import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class CallCenterTLFactory extends BasePooledObjectFactory<TechnicalLead> {

	@Override
	public TechnicalLead create() throws Exception {
		return new TechnicalLead();
	}

	@Override
	public PooledObject<TechnicalLead> wrap(TechnicalLead t) {
		// TODO Auto-generated method stub
		return new DefaultPooledObject<TechnicalLead>(t);
	}

}
