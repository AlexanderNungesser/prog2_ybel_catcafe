package tree;

import catcafe.FelineOverLord;

public class PostOrderVisitor implements TreeVisitor<FelineOverLord> {

    /**
     * Visit an empty node.
     *
     * @param node to visit
     * @return the result of visiting the node (recursively)
     */
    @Override
    public String visit(Empty<FelineOverLord> node) {
        return "";
    }

    /**
     * Visit a node.
     *
     * @param node to visit
     * @return the result of visiting the node (recursively)
     */
    @Override
    public String visit(Node<FelineOverLord> node) {
        if (node.isEmpty()) {
            return "";
        } else {
            return node.data().toString()
                    + node.leftChild().accept(this)
                    + node.rightChild().accept(this);
        }
    }
}
