package com.netcracker.edu.java.tasks;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sir Nightmare on 07/29/16.
 * Class for TreeNode
 */
public class TreeNodeImpl implements TreeNode {


    private TreeNode parent;
    private int numberOfChildren = 0;
    private List<TreeNode> children;
    private boolean isExpanded = false;
    private Object userData;

    public TreeNodeImpl() {
    }

    public TreeNodeImpl(Object userData) {
        this.userData = userData;
    }

    public TreeNodeImpl(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNodeImpl(TreeNode parent, Object userData) {
        this.parent = parent;
        this.userData = userData;
    }


    /**
     * Returns the parent <code>TreeNode</code>.
     */
    @Override
    public TreeNode getParent() {
        return parent;
    }

    /**
     * Sets the parent <code>TreeNode</code>.<br/>
     * Is typically called in {@link #addChild(TreeNode)} and {@link #removeChild(TreeNode)} methods
     * of the parent <code>TreeNode</code> itself.
     *
     * @param parent
     */
    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    /**
     * Returns the top of the tree that contains this <code>TreeNode</code>.
     *
     * @return root node or null if the parent of this node is null (i.e. the returned node != this).
     */
    @Override
    public TreeNode getRoot() {
        if (this.parent == null) {
            return null;
        }
        return parent.getRoot();
    }

    /**
     * Returns false if this <code>TreeNode</code> has non-zero number of children.
     *
     * @return true if the node is a leaf (i.e. does not have child nodes)
     */
    @Override
    public boolean isLeaf() {
        return numberOfChildren == 0;
    }

    /**
     * Returns the number of children which this <code>TreeNode</code> has.
     */
    @Override
    public int getChildCount() {
        return numberOfChildren;
    }

    /**
     * Returns children <code>TreeNode</code>'s as {@link Iterator}.
     */
    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return children.iterator();
    }

    /**
     * Adds the given child to this <code>TreeNode</code> and sets this as the parent to it.
     *
     * @param child
     */
    @Override
    public void addChild(TreeNode child) {
        if (numberOfChildren == 0) {
            children = new ArrayList<TreeNode>();
        }
        children.add(child);
        numberOfChildren++;
        child.setParent(this);
    }

    /**
     * Removes the given child from this <code>TreeNode</code> and (if succeeded)
     * sets null as the parent to it (in order to leave the tree in the consistent state).
     *
     * @param child
     * @return true if succeeded, false if the child was not found
     */
    @Override
    public boolean removeChild(TreeNode child) {
        if (children.contains(child)) {
            children.remove(child);
            child.setParent(null);
            numberOfChildren--;
            return true;
        }
        return false;
    }

    /**
     * Returns the "expanded" state of this <code>TreeNode</code>.<br/>
     * By default (unless {@link #setExpanded(boolean)} is called)
     * "expanded" is false (i.e. the node is "collapsed").
     */
    @Override
    public boolean isExpanded() {

        return isExpanded;
    }

    /**
     * Sets the "expanded" state to this <code>TreeNode</code> and to all its children, recursively
     *
     * @param expanded true - to expand this tree branch, false - to collapse this tree branch.
     */
    @Override
    public void setExpanded(boolean expanded) {
        this.isExpanded = expanded;
        if (this.numberOfChildren != 0) {
            for (TreeNode child : this.children) {
                child.setExpanded(expanded);
            }
        }
    }

    /**
     * Returns the user object stored in this <code>TreeNode</code>
     * or <code>null</code> if {@link #setData(Object)} was not called.
     */
    @Override
    public Object getData() {
        return userData;
    }

    /**
     * Sets the user data to store in this <code>TreeNode</code>.
     *
     * @param data
     */

    public void setData(Object data) {
        this.userData = data;
    }

    /**
     * Returns the string representation of the path from root to this <code>TreeNode</code>.<br/>
     * Path elements are separated by "->".<br/>
     * Each path element is either getData().toString() or "empty" if getData()==null.<br/>
     * For example: "rootNode0->node1->node13->empty" ("rootNode0" is a result of getRoot().getData().toString() in this example).
     */
    @Override
    public String getTreePath() {
        String tempData;

        if (this.userData != null) {
            tempData = this.getData().toString();
        } else {
            tempData = "empty";
        }
        if (parent != null) {
            return parent.getTreePath() + "->" + tempData;
        }
        return tempData;
    }

    /**
     * Finds the (first) node with the given data among the parents' sequence of this <code>TreeNode</code>.
     * By convention, the parents' sequence includes this node itself (i.e. the following may be true: obj.findParent(*) == obj).<br/>
     * Data objects should be compared by equals() method (but if the given data is null then the parent with null data should be returned).
     *
     * @param data the data to find; may be <code>null</code>
     * @return the node found or <code>null</code> if no matching data was found.
     */

    public TreeNode findParent(Object data) {
        if (data == null) {
            if (this.userData == null) {
                return this;
            } else {
                if (this.parent != null) {
                    return parent.findParent(null);
                } else {
                    return null;
                }
            }
        }
        if (this.parent.equals(data)) {
            return this;
        } else {
            if (this.parent != null) {
                return parent.findParent(data);
            } else {
                return null;
            }
        }
    }

    /**
     * Finds the (first) node with the given data among the children of this <code>TreeNode</code>.<br/>
     * Searches it recursively (if some child doesn't have the given data, the children of this child are searched, and so on).<br/>
     * Data objects should be compared by equals() method (but if the given data is null then the child with null data should be returned).
     *
     * @param data the data to find; may be <code>null</code>
     * @return the node found or <code>null</code> if no matching data was found.
     */


    public TreeNode findChild(String data) {
        if (data == null) {
            if (this.userData == null) {
                return this;
            } else {
                if (numberOfChildren != 0) {
                    for (TreeNode child : this.children) {
                        return child.findChild(null);
                    }
                } else {
                    return null;
                }
            }
        }
        if (this.userData.equals(data)) {
            return this;
        } else {
            if (numberOfChildren != 0) {
                for (TreeNode child : this.children) {
                    return child.findChild(data);
                }
            } else {
                return null;
            }
        }
        return null;
    }


    public TreeNode findChild(Object data) {
        if (data == null) {
            if (this.userData == null) {
                return this;
            } else {
                if (numberOfChildren != 0) {
                    for (TreeNode child : this.children) {
                        TreeNode res1 = child.findChild(null);
                        if (res1 != null) {
                            return res1;
                        }
                    }
                } else {
                    return null;
                }
            }
        } else if (this.userData.equals(data)) {
            return this;
        } else {
            if (numberOfChildren != 0) {
                for (TreeNode child : this.children) {
                    TreeNode res1 = child.findChild(data);
                    if (res1 != null) {
                        return res1;
                    }
                }
            } else {
                return null;
            }
        }

        return null;
    }
}
