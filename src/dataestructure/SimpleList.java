package dataestructure;

import java.util.Comparator;

public class SimpleList<E> {
	private NodeList<E> head;
	private Comparator<E> comparator;
	private boolean insert;

	public SimpleList() {
		this.head = null;
		this.comparator = null;
	}
	
	public SimpleList(Comparator<E> comparator) {
		this.head = null;
		this.comparator = comparator;
	}

	public SimpleList(SimpleList<E> list) {
		this.head = list.getHead();
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public boolean isInsert() {
		return insert;
	}
	
	public void setInsert(boolean insert) {
		this.insert = insert;
	}
	
	public int size() {
		int count = 1;
		if(this.head == null) {
			count = 0;
		}else {
		NodeList<E> aux = this.head;
		while (aux.next != null) {
			count++;
			aux = aux.next;
		  }
		}
		return count;
	}

	public void clone(SimpleList<E> list) {
		NodeList<E> actual = list.head;
		while (actual != null) {
			this.add(actual.info);
			actual = actual.next;
		}
	}
	
	public void setHead(NodeList<E> head) {
		this.head = head;
	}

	public void add(E info) {

		if (comparator != null) {
			addSort(info);
		} else {
			if (insert) {
				addHead(info);
			} else {
				addLast(info);
			}
		}

	}

	private void addLast(E info) {
		if (head == null) {
			head = new NodeList<E>(info);
		} else {
			NodeList<E> aux = head;
			while (aux.next != null) {
				aux = aux.next;
			}
			aux.next = (new NodeList<E>(info));
		}
	}
	
	private void addSort(E info) {

		if (this.head != null) {

			NodeList<E> aux = head;
			boolean flag = false;
			while (!flag) {
				if (comparator.compare(aux.info, info) <= 0 && aux.next != null
						&& comparator.compare(aux.next.info, info) >= 0) {
					NodeList<E> nodeAux = aux.next;
					aux.next = new NodeList<>(info);
					aux.next.next = nodeAux;
					flag = true;
				}

				else if (aux.next == null) {
					if (comparator.compare(head.info, info) < 0) {
						addLast(info);
						flag = true;

					} else {
						addHead(info);
						flag = true;

					}
				}
				aux = aux.next;
			}
		} else {
			head = new NodeList<>(info);
		}

	}

	public void addHead(E info) {
		head = new NodeList<E>(info, this.head);
	}

	public NodeList<E> getHead() {
		return head;
	}

	public void eliminateNodes(Comparator<E> comparator, E info) {
		SimpleList<E> list = searchToList(comparator, info);

		for (int i = 0; i < list.size(); i++) {
			eliminateNode(comparator, info);
		}

	}

	public void eliminateNode(Comparator<E> comparator, E data) {
		if (data != null && head != null) {
			if (comparator.compare(this.head.info, data) == 0) {
				this.head = this.head.next;
			} else {
				NodeList<E> aux = this.head.next;
				NodeList<E> previus = this.head;
				while (aux != null) {
					if (comparator.compare(aux.info, data) == 0) {
						previus.next = aux.next;
					}
					previus = aux;
					aux = aux.next;
				}
			}
		}
	}
	
	public void eliminateNode(E data) {
		if (data != null && head != null) {
			if (this.head.info.equals(data)) {
				this.head = this.head.next;
			} else {
				NodeList<E> aux = this.head.next;
				NodeList<E> previus = this.head;
				while (aux != null) {
					if (aux.info.equals(data)) {
						previus.next = aux.next;
					}
					previus = aux;
					aux = aux.next;
				}
			}
		}
	}

	public SimpleList<E> searchToList(Comparator<E> comparator, E ref) {
		NodeList<E> aux = head;
		SimpleList<E> list = new SimpleList<>();
		while (aux != null) {
			if (comparator.compare(aux.getInfo(), ref) == 0) {
				list.add(aux.info);
			}
			aux = aux.next;
		}
		return list;
	}
	
	public E search(Comparator<E> comparator,E ref) {
		NodeList<E> aux = head;
		E info = null;
		while (aux != null) {
			if (comparator.compare(aux.getInfo(), ref) == 0) {
				info = aux.info;
			}
			aux = aux.next;
		}
		return info;
	}

	public boolean isExist(E ref) {
		NodeList<E> aux = head;
		boolean flag = false;
		while (aux != null) {
			if (this.comparator.compare(aux.info, ref) == 0 && !flag) {
				flag = true;
				return true;
			}
			aux = aux.next;
		}
		return false;
	}
	
	public E getElement(E ref) {
		NodeList<E> aux = head;
		boolean flag = false;
		while (aux != null) {
			if (this.comparator.compare(aux.getInfo(), ref) == 0 && !flag) {
				flag = true;
				return aux.info;
			}
			aux = aux.next;
		}
		return null;
	}

	public boolean isOrder() {
		if (comparator == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public Comparator<E> getComparator(){
		return this.comparator;
	}
}
