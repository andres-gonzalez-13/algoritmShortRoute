package dataestructure;

public class NodeList<E> {

	protected E info;
	protected NodeList<E> next;

	public NodeList(E info, NodeList<E> next) {
		this.info = info;
		this.next = next;
	}

	public NodeList(E info) {
		this.info = info;
		this.next = null;
	}

	public E getInfo() {
		return info;
	}

	public void setInfo(E info) {
		this.info = info;
	}

	public NodeList<E> getNext() {
		return next;
	}

	public void setNext(NodeList<E> next) {
		this.next = next;
	}

}
