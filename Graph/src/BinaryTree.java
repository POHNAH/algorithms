import java.util.ArrayList;
import java.util.List;

public class BinaryTree extends  Tree{
    private int value;
    private BinaryTree leftBranch;
    private BinaryTree rightBranch;

    public BinaryTree(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTree getLeftBranch() {
        return leftBranch;
    }

    public void setLeftBranch(BinaryTree leftBranch) {
        this.leftBranch = leftBranch;
    }

    public BinaryTree getRightBranch() {
        return rightBranch;
    }

    public void setRightBranch(BinaryTree rightBranch) {
        this.rightBranch = rightBranch;
    }

    public List<Integer> traversal() {
        ArrayList<Integer> array = new ArrayList<>();
        if (this.getLeftBranch())
        return array;
    }
}
