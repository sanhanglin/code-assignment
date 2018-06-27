import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class CallCenterPMFactory extends BasePooledObjectFactory<ProductManager> {

	@Override
	public ProductManager create() throws Exception {
		return new ProductManager();
	}

	@Override
	public PooledObject<ProductManager> wrap(ProductManager p) {
		return new DefaultPooledObject<ProductManager>(p);
	}

}
