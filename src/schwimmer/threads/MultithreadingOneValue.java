package schwimmer.threads;

public class MultithreadingOneValue {

	static class IntegerWrapper {
		int i;
		
		
	}
	
	public static void main( String args[] ) {
		
		final IntegerWrapper wrapper = new IntegerWrapper();
		
		for ( int i=0; i<1000; i++ ) {
			Thread thread = new Thread() {
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
					wrapper.i++;
				}
			};
			thread.start();
		}
		
		System.out.println(wrapper.i);
		
	}
	
}
