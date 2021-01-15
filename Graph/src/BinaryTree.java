import java.util.ArrayList;
import java.util.List;

public class BinaryTree extends  Tree {
    private NodeBinaryTree rootNode;

    public BinaryTree() {
        rootNode = null;
    }

    public BinaryTree(NodeBinaryTree node) {
        rootNode = node;
    }

    public NodeBinaryTree getRootNode() {
        return rootNode;
    }

    public void setRootNode(NodeBinaryTree rootNode) {
        this.rootNode = rootNode;
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
                if (value < currentNode.getValue()) {
                    if (currentNode.getLeftBranch() == null) {
                        currentNode.setLeftBranch(newNode);
                        return;
                    }
                    else {
                        currentNode = currentNode.getLeftBranch();
                        continue;
                    }
                }
                else {
                    if (currentNode.getRightBranch() == null) {
                        currentNode.setRightBranch(newNode);
                        return;
                    }
                    else {
                        currentNode = currentNode.getRightBranch();
                        continue;
                    }
                }
            }
        }
    }

    public List<Integer> traversal() {
        ArrayList<Integer> array = new ArrayList<>();
        BinaryTree binaryTree = new BinaryTree();
        if (rootNode.getLeftBranch() != null) {
            binaryTree.setRootNode(rootNode.getLeftBranch());
            array.addAll(binaryTree.traversal());
        }

        if (rootNode.getKey() != -1)
            array.add(rootNode.getValue());

        if (rootNode.getRightBranch() != null) {
            binaryTree.setRootNode(rootNode.getRightBranch());
            array.addAll(binaryTree.traversal());
        }

        return array;
    }
}
