package ua.itea.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Counter {
	private static int NUMBER_OF_CUSTOMERS = 5;

	private Queue<Customer> queue = new LinkedList<>();
	private boolean counterIsClosed = false;

	public boolean isCounterIsClosed() {
		return counterIsClosed;
	}

	public void setCounterIsClosed(boolean counterIsClosed) {
		this.counterIsClosed = counterIsClosed;
	}

	public void CreateQueue() {
		Customer tempC = null;
		for (int i = 1; i <= NUMBER_OF_CUSTOMERS; i++) {
			queue.add(tempC = new Customer(String.valueOf(i), this));
			try {
				tempC.getThread().join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
