package ua.itea.mine;

import java.util.ArrayList;
import java.util.List;

public class MineMain {

	public static void main(String[] args) {
		Mine mine = new Mine();
		List<Worker> workerList = new ArrayList<>();

		workerList.add(new Worker("1", mine));
		workerList.add(new Worker("2", mine));
		workerList.add(new Worker("3", mine));

		for (int i = 4; i < Integer.MAX_VALUE; i++) {
			if (mine.isMineIsEmpty()) {
				break;
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			workerList.add(new Worker(String.valueOf(i), mine));
		}
	}

}
