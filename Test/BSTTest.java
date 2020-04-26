package Test;

import Main.BST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @org.junit.jupiter.api.Test
    void preorderToString_1() {
        BST b = new BST();

        b.insert(8);
        b.insert(3);
        b.insert(11);
        b.insert(1);
        b.insert(7);
        b.insert(9);
        b.insert(15);
        b.insert(0);

        assertEquals("[8,3,1,0,7,11,9,15]", b.preorderToString());
    }

    @org.junit.jupiter.api.Test
    void postorderToString_1() {
        BST b = new BST();

        b.insert(8);
        b.insert(3);
        b.insert(11);
        b.insert(1);
        b.insert(7);
        b.insert(9);
        b.insert(15);
        b.insert(0);

        assertEquals("[0,1,7,3,9,15,11,8]", b.postorderToString());
    }

    @Test
    void levelorderToString_1() {
        BST b = new BST();

        b.insert(8);
        b.insert(3);
        b.insert(11);
        b.insert(1);
        b.insert(7);
        b.insert(9);
        b.insert(15);
        b.insert(0);

        assertEquals("[8,3,11,1,7,9,15,0]", b.levelorderToString());
    }
}