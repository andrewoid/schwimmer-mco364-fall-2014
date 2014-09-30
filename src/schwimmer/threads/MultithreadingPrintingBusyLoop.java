package schwimmer.threads;

public class MultithreadingPrintingBusyLoop {
	
	public static void main( String args[] ) {
		
		Thread threads[] = new Thread[5];
		for ( int i=0; i<threads.length; i++ ) {
			final int current = i;
			threads[i] = new Thread() {
				public void run() {
					System.out.println(current);
				}
			};
			threads[i].start();
		}
		
		
		// This is a busy loop. 
		// A busy loop is when a program is continually checking for a condition.
		// It is typically considered a bad idea.
		int alive = threads.length;
		while (alive > 0) {
			alive = 0;
			for ( int i=0; i<threads.length; i++ ) {
				if ( threads[i].isAlive() ) {
					alive++;
				}
			}
		}
		
		
		System.out.println("finished");
	}
	
}
