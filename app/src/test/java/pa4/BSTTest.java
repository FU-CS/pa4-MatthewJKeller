package pa4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BSTTest {

    @Test
    void testInsert() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        assertEquals(5, bst.root.value);
        assertEquals(3, bst.root.left.value);
        assertEquals(7, bst.root.right.value);
    }

    @Test
    void testDelete() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.delete(3);
        assertNull(bst.root.left);
        bst.delete(5);
        assertEquals(7, bst.root.value);
    }

    @Test
    void testSearch() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        assertTrue(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
        assertFalse(bst.search(4));
    }

    @Test
    void testUpdate() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(10);
        bst.insert(15);
        bst.update(10, 20);
        assertFalse(bst.search(10));
        assertTrue(bst.search(20));
    }

    @Test
    void testInOrder() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assertEquals("2 3 4 5 6 7 8 ", bst.inOrder());
    }

    @Test
    void testSortedArrayToBST() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        BST.Node root = BST.sortedArrayToBST(arr);
        assertEquals(4, root.value);
        assertEquals(2, root.left.value);
        assertEquals(6, root.right.value);
    }

    @Test
    void testLowestCommonAncestor() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assertEquals(3, bst.lowestCommonAncestor(2, 4).value);
        assertEquals(5, bst.lowestCommonAncestor(2, 6).value);
    }

    @Test
    void testInsertEmpty() {
        BST bst = new BST();
        bst.insert(5);
        assertEquals(5, bst.root.value);
    }

    @Test
    void testDeleteEmpty() {
        BST bst = new BST();
        bst.delete(10);
        assertNull(bst.root);
    }

    @Test
    void testSearchEmpty() {
        BST bst = new BST();
        assertFalse(bst.search(10));
    }

    @Test
    void testUpdateEmpty() {
        BST bst = new BST();
        bst.update(10, 20);
        assertFalse(bst.search(20));
    }

    @Test
    void testInOrderTraversalEmpty() {
        BST bst = new BST();
        assertEquals("", bst.inOrder());
    }

    @Test
    void testLowestCommonAncestorEmpty() {
        BST bst = new BST();
        assertNull(bst.lowestCommonAncestor(10, 10));
    }

    @Test
    void testInsertDups() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(5);
        assertEquals(5, bst.root.value);
        assertNull(bst.root.right);
    }

    @Test
    void testDeleteInvalidItem() {
        BST bst = new BST();
        bst.insert(5);
        bst.delete(10);
        assertEquals(5,bst.root.value);
    }

    @Test
    void testSearchInvalidItem() {
        BST bst = new BST();
        bst.insert(5);
        assertFalse(bst.search(10));
    }

    @Test
    void testUpdateInvalidItem() {
        BST bst = new BST();
        bst.insert(5);
        bst.update(10, 20);
        assertTrue(bst.search(5));
    }

    @Test
    void testDeleteRoot() {
        BST bst = new BST();
        bst.insert(5);
        bst.delete(5);
        assertNull(bst.root);
    }

    @Test
    void testInOrderTraversalSingle() {
        BST bst = new BST();
        bst.insert(5);
        assertEquals("5 ", bst.inOrder());
    }

    @Test
    void testLowestCommonAncestorRoot() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        assertEquals(5, bst.lowestCommonAncestor(5, 3).value);
        assertEquals(5, bst.lowestCommonAncestor(5, 7).value);
    }

    @Test
    void testLowestCommonAncestorSameVal() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        assertEquals(3,bst.lowestCommonAncestor(3, 3).value);
    }
}

