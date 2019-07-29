package co.grandcircus;

public class Task {

	private String name;
	private String descript;
	private String date;
	private boolean due;
	private int num;

	public Task(String x, String y, String z, boolean a, int b) {
		this.name = x;
		this.descript = y;
		this.date = z;
		this.due = a;
		this.num = b;

	}

	public String getName() {

		return name;
	}

	public String getDesc() {

		return descript;
	}

	public String getDate() {

		return date;
	}

	public boolean getDue() {

		return due;
	}

	public void setDue1(boolean a) {
		this.due = a;
	}

	public void setNum(int x) {
		this.num = x;
	}

	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		return getNum() + "       Due Date: " + this.getDate() + "       Description: " + this.getDesc()
				+ "       Team Member: " + this.getName() + "       Done?: "
				+ this.getDue();

	}

	public void setDue(boolean b) {
		// TODO Auto-generated method stub

	}

}
