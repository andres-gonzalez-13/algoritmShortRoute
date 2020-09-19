package dataestructure;

public class Cursor<T> extends SimpleList<T> {

	private NodeList<T> cursor;

	public Cursor(SimpleList<T> simpleList) {
		super(simpleList);
		this.cursor = this.getHead();
	}

	public boolean isLast() {

		return this.cursor.next == null;

	}

	public boolean isOut() {

		return this.cursor == null;

	}

	public void reset() {

		this.cursor = this.getHead();

	}

	public void last() {
		while (cursor.next != null) {
			cursor = cursor.next;
		}
	}

	public T info() {

		return this.cursor.info;

	}

	public T nextReturn() {

		return cursor.next.info;

	}

	public void next() {

		this.cursor = this.cursor.next;

	}

	public T getInfoAndNext() {

		T auxInfo = this.cursor.getInfo();
		this.cursor = this.cursor.next;

		return auxInfo;

	}

}
