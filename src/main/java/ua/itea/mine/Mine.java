package ua.itea.mine;

public class Mine {
	private int qntOfGold = 1000;
	private boolean mineIsEmpty = false;

	public synchronized int GetGold(int qntOfGold) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (this.qntOfGold - qntOfGold <= 0) {
			int temp = this.qntOfGold;
			this.qntOfGold = 0;
			mineIsEmpty = true;
			return temp;
		}
		this.qntOfGold -= qntOfGold;
		return qntOfGold;
	}

	public int getQntOfGold() {
		return qntOfGold;
	}

	public boolean isMineIsEmpty() {
		return mineIsEmpty;
	}

	public void setMineIsEmpty(boolean mineIsEmpty) {
		this.mineIsEmpty = mineIsEmpty;
	}

}
