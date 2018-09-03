package adt.avltree;

import org.junit.Test;
import org.junit.Before;

public class StudentAVLTest3 {

	private AVLTree<Integer> avl;

	@Before
	public void setUp() {
		avl = new AVLTreeImpl<>();
	}

	@Test
	public void testRightight() {
		avl.insert(1);
		avl.insert(2);
		avl.insert(3);
	}
}
