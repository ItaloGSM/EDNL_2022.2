package arvore;

import java.util.ArrayList;

public interface IArvore {

	int size();
	int height();
	int height_node(Node x);
	boolean isEmpty();
	
	Node root();
	Node parent(Node x);
	ArrayList<Node> children(Node x);
	
	boolean isInternal(Node x);
	boolean isExternal(Node x);
	boolean isRoot(Node x);
	int depth(Node x);
	
	Object replace(Node x, Object o);
	
}
