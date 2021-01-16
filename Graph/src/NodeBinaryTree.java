//Узел бинарного дерева. key = -1 если значение узла не задано.
//Когда значение присваивается countNodes увеличивается на один и
//key получет уникальный индекс равный числу узлов.
public class NodeBinaryTree {
    private int key = -1;
    private int value;
    private NodeBinaryTree leftBranch;
    private NodeBinaryTree rightBranch;
    private static int countNodes;

    public NodeBinaryTree(int value) {
        this.value = value;
        ++countNodes;
        this.key = countNodes;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public NodeBinaryTree getLeftBranch() {
        return leftBranch;
    }

    public void setLeftBranch(NodeBinaryTree leftBranch) {
        this.leftBranch = leftBranch;
    }

    public NodeBinaryTree getRightBranch() {
        return rightBranch;
    }

    public void setRightBranch(NodeBinaryTree rightBranch) {
        this.rightBranch = rightBranch;
    }

    @Override
    public String toString() {
        return "Node{key = " +
                key +
                ", value=" + value +
                ", leftChild=" + leftBranch +
                ", rightChild=" + rightBranch +
                '}';
    }

}
