package ua.itea.queue;

public class Customer implements Runnable {
	private String name = "Customer_";
	private Thread thread;
	private Counter counter;

	public Customer(String name, Counter counter) {
		this.name += name;
		this.counter = counter;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		
		if(counter.isCounterIsClosed()) {
			return;
		}
		
		System.out.println("Customer " + name + " is being serviced...");
		int sleepingTime = 0;
		try {
			Thread.sleep(1000 * (sleepingTime = (int) (Math.random() * 3) + 3));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Customer " + name + " is serviced. Was spent " + sleepingTime + " seconds.\n");
		
		if(Math.random() > 0.5) {
			counter.setCounterIsClosed(true);
			System.out.println("Counter is closed!!!");
		}
	}

	public String getName() {
		return name;
	}

	public Thread getThread() {
		return thread;
	}

}
