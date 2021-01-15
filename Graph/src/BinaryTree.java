import java.util.ArrayList;
import java.util.List;

public class BinaryTree extends  Tree{
    private NodeBinaryTree rootNode;

    public BinaryTree() {
        rootNode = null;
    }
    public void insertNode (int value) {
        NodeBinaryTree newNode = new NodeBinaryTree(value);

        if (rootNode == null) {
            rootNode = newNode;
            return;
        }
        else {
            NodeBinaryTree currentNode = rootNode;

            while (true) {
                if (value < rootNode.getValue()) {

                }

            }
        }
    }

//    public List<Integer> traversal() {
//        ArrayList<Integer> array = new ArrayList<>();
//        if (leftBranch != null)
//            array.addAll(leftBranch.traversal());
//        if (value   )
//        return array;
//    }
}
