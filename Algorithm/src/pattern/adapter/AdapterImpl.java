package pattern.adapter;

public class AdapterImpl implements Adapter {
	
	@Override
	public Float twiceOf(Float f) {
		return (float) Math.scalb(f.doubleValue(), 1);
	}

	@Override
	public Float halfOf(Float f) {
		return Math.scalb(f, -1);
	}
	
}
