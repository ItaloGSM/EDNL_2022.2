package skiplist;

public class Quad_node {
	
	private Object elemento;
	private Quad_node prev;
	private Quad_node next;
	private Quad_node up;
	private Quad_node down;
	
	public Quad_node() {
		
	}
	
	public Quad_node(Object elemento) {
		this.elemento = elemento;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	public Quad_node getPrev() {
		return prev;
	}

	public void setPrev(Quad_node prev) {
		this.prev = prev;
	}

	public Quad_node getNext() {
		return next;
	}

	public void setNext(Quad_node next) {
		this.next = next;
	}

	public Quad_node getUp() {
		return up;
	}

	public void setUp(Quad_node up) {
		this.up = up;
	}

	public Quad_node getDown() {
		return down;
	}

	public void setDown(Quad_node down) {
		this.down = down;
	}
	
}