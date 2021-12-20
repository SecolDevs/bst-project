package model.logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree<T> {
    private TreeNode<T> root;
    private Comparator<T> comparator;
    private ArrayList<T> out;
    private int cont;

    /**
     * Constructor for BinaryTree
     *
     * @param comparator
     */
    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    /**
     * Returns if the tree is empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Inserts a new node in the tree
     *
     * @param T data to be inserted
     */
    public void addNode(T info) {
        TreeNode<T> node = new TreeNode<>(info);
        if (isEmpty()) {
            root = node;
        } else {
            TreeNode<T> aux = root;
            TreeNode<T> ant = null;
            while (aux != null) {
                ant = aux;
                aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
            }
            if (comparator.compare(info, ant.getInfo()) < 0) {
                ant.setLeft(node);
            } else {
                ant.setRight(node);
            }
        }
    }

    /**
     * Returns a finded tree node
     *
     * @param T data to be finded
     * @return TreeNode
     */
    public TreeNode<T> findNode(T info) {
        TreeNode<T> aux = root;
        while (aux != null) {
            if (comparator.compare(info, aux.getInfo()) == 0) {
                return aux;
            }
            aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
        }
        return null;
    }

    /**
     * Returns a list of the tree in preorder
     *
     * @return ArrayList
     */
    public ArrayList<T> listPresort() {
        out = new ArrayList<>();
        presort(root);

        return out;
    }

    /**
     * Returns a list of the tree in preorder
     *
     * @return ArrayList
     */
    private void presort(TreeNode<T> root) {
        if (root != null) {
            out.add(root.getInfo());
            presort(root.getLeft());
            presort(root.getRight());
        }
    }

    /**
     * Returns a list of the tree in inorder
     *
     * @return ArrayList
     */
    public ArrayList<T> listInsort() {
        out = new ArrayList<>();
        insort(root);
        return out;
    }

    /**
     * Returns a list of the tree in inorder
     *
     * @param TreeNode root of the tree
     * @return ArrayList
     */
    private void insort(TreeNode<T> root) {
        if (root != null) {
            insort(root.getLeft());
            out.add(root.getInfo());
            insort(root.getRight());
        }
    }

    /**
     * Returns a list of the tree in amplitude
     *
     * @return ArrayList
     */
    public ArrayList<T> listAmplitude() {
        out = new ArrayList<>();
        ArrayDeque<TreeNode> tail = new ArrayDeque<>();
        tail.addLast(root);
        while (!tail.isEmpty()) {
            TreeNode<T> aux = tail.pop();
            if (aux.getLeft() != null) {
                tail.addLast(aux.getLeft());
            }
            if (aux.getRight() != null) {
                tail.addLast(aux.getRight());
            }
            out.add(aux.getInfo());
        }
        return out;
    }

    /**
     * Returns if node is a leaf
     *
     * @param TreeNode node to be checked
     * @return boolean
     */
    public boolean isLeaf(TreeNode<T> node) {
        return node.getRight() == null && node.getLeft() == null;
    }

    /**
     * Returns the father of a node
     *
     * @param TreeNode node to be finded
     * @return TreeNode
     */
    public TreeNode<T> findFather(TreeNode<T> node) {
        if (node == root) {
            return null;
        } else {
            TreeNode<T> aux = root;
            while (aux.getLeft() != node && aux.getRight() != node) {
                aux = comparator.compare(node.getInfo(), aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
            }

            return aux;
        }
    }

    /**
     * Returns the level of a node
     *
     * @param TreeNode node to be checked
     * @return int
     */
    public int levelNode(TreeNode<T> node) {
        return node == root ? 0 : levelNode(findFather(node)) + 1;
    }

    /**
     * Returns the height of a node
     *
     * @param TreeNode node to be checked
     * @return int
     */
    public int heigthNode(TreeNode<T> node) {
        cont = 0;
        heigth(node, 0);

        return cont;
    }

    /**
     * Returns the height of a node
     *
     * @param TreeNode node to be checked
     * @param int      counter
     * @return int
     */
    private void heigth(TreeNode<T> node, int i) {
        if (node != null) {
            heigth(node.getLeft(), i + 1);
            cont = i > cont ? i : cont;
            heigth(node.getRight(), i + 1);
        }
    }

    /**
     * Returns the height of the tree
     *
     * @return int
     */
    public int heigthTree() {
        return heigthNode(root);
    }

    /**
     * Returns the grade of a node
     *
     * @param TreeNode node to be checked
     * @return int
     */
    public int getGradeNode(TreeNode<T> node) {
        if (node.getRight() != null && node.getLeft() != null)
            return 2;
        else if (node.getRight() != null || node.getLeft() != null)
            return 1;
        else
            return 0;
    }

    /**
     * Deletes a node
     *
     * @param TreeNode node to be deleted
     * @return T
     */
    public T deleteNode(TreeNode<T> node) {
        switch (getGradeNode(node)) {
            case 0:
                return deleteLeaf(node);
            case 1:
                return deleteWithSon(node);

            default:
                return deleteWithSons(node);
        }
    }

    /**
     * Deletes a node with sons
     *
     * @param TreeNode node to be deleted
     * @return T
     */
    private T deleteWithSons(TreeNode<T> node) {
        T out = node.getInfo();
        TreeNode<T> sustitute = node.getRight();
        TreeNode<T> fatherSustitute = null;
        while (sustitute.getLeft() != null) {
            fatherSustitute = sustitute;
            sustitute = sustitute.getLeft();
        }
        if (fatherSustitute != null) {
            fatherSustitute.setLeft(sustitute.getRight());
            sustitute.setRight(node.getRight());
        }
        sustitute.setLeft(node.getLeft());

        TreeNode<T> father = findFather(node);
        if (father == null) {
            root = sustitute;
        } else if (father.getLeft() == node) {
            father.setLeft(sustitute);
        } else {
            father.setRight(sustitute);
        }

        return out;
    }

    /**
     * Deletes a node with son
     *
     * @param TreeNode node to be deleted
     * @return T
     */
    private T deleteWithSon(TreeNode<T> node) {
        T out = node.getInfo();
        if (node == root) {
            root = root.getLeft() != null ? root.getLeft() : root.getRight();
        } else {
            TreeNode<T> father = findFather(node);
            if (father.getLeft() == node) {
                father.setLeft(node.getLeft() != null ? node.getLeft() : node.getRight());
            } else {
                father.setRight(node.getLeft() != null ? node.getLeft() : node.getRight());
            }
        }
        ///25:36
        return out;
    }

    /**
     * Deletes a leaf
     *
     * @param TreeNode node to be deleted
     * @return T
     */
    private T deleteLeaf(TreeNode<T> node) {
        T out = node.getInfo();

        if (node == root) {
            root = null;
        } else {
            TreeNode<T> father = findFather(node);
            if (father.getLeft() == node) {
                father.setLeft(null);
            } else {
                father.setRight(null);
            }
        }

        return out;
    }

    /**
     * Returns the weight of the tree
     *
     * @return TreeNode
     */
    public int weightTree() {
        return listInsort().size();
    }

}
