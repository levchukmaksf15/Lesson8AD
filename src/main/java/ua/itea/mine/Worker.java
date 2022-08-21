package ua.itea.mine;

public class Worker implements Runnable {

	private static int QNT_OF_GOLD_FOR_ONE_SECOND = 3;

	private String name = "Worker_";
	private Mine mine;
	private int qntOfGold;

	public Worker(String name, Mine mine) {
		this.name += name;
		this.mine = mine;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (!mine.isMineIsEmpty()) {
			qntOfGold += mine.GetGold(QNT_OF_GOLD_FOR_ONE_SECOND);
			System.out.println("\nName: " + name + ";\nGold worker have: " + qntOfGold + ";\nGold in mine: "
					+ mine.getQntOfGold() + ";");
		}

	}

}
