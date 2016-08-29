/**
 * Write a description of class Insert here.
 * 
 * @author Atsushi Igarashi
 * @version 20160824
 */
public class Insert implements BSTVisitorBST
{
    // instance variables - replace the example below with your own
    private int n;

    /**
     * Constructor for objects of class Insert
     */
    public Insert(int _n)
    {
        // initialise instance variables
        n = _n;
    }

    public BinarySearchTree caseLeaf() {
        return new Branch(new Leaf(), n, new Leaf());
    }
    
    public BinarySearchTree caseBranch(BinarySearchTree left, 
                                       int v,
                                       BinarySearchTree right) {
        if (n == v) {
            return new Branch(left, v, right);
        } else if (n < v) {
            BinarySearchTree newLeft = left.accept(new Insert(n));
            return new Branch(newLeft, v, right);
        } else /* n > v */ {
            BinarySearchTree newRight = right.accept(new Insert(n));
            return new Branch(left, v, newRight);
        }
    }
}
