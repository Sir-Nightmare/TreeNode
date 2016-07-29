package com.netcracker.edu.java.tasks;

import java.util.Iterator;

/**
 * Created by Sir Nightmare on 07/29/16.
 */
public class TreeNodeImpl implements TreeNode
{
    /**
     * Returns the parent <code>TreeNode</code>.
     */
    @Override
    public TreeNode getParent() {
        return null;
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

    }

    /**
     * Returns the top of the tree that contains this <code>TreeNode</code>.
     *
     * @return root node or null if the parent of this node is null (i.e. the returned node != this).
     */
    @Override
    public TreeNode getRoot() {
        return null;
    }

    /**
     * Returns false if this <code>TreeNode</code> has non-zero number of children.
     *
     * @return true if the node is a leaf (i.e. does not have child nodes)
     */
    @Override
    public boolean isLeaf() {
        return false;
    }

    /**
     * Returns the number of children which this <code>TreeNode</code> has.
     */
    @Override
    public int getChildCount() {
        return 0;
    }

    /**
     * Returns children <code>TreeNode</code>'s as {@link Iterator}.
     */
    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return null;
    }

    /**
     * Adds the given child to this <code>TreeNode</code> and sets this as the parent to it.
     *
     * @param child
     */
    @Override
    public void addChild(TreeNode child) {

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
        return false;
    }

    /**
     * Returns the "expanded" state of this <code>TreeNode</code>.<br/>
     * By default (unless {@link #setExpanded(boolean)} is called)
     * "expanded" is false (i.e. the node is "collapsed").
     */
    @Override
    public boolean isExpanded() {
        return false;
    }

    /**
     * Sets the "expanded" state to this <code>TreeNode</code> and to all its children, recursively
     *
     * @param expanded true - to expand this tree branch, false - to collapse this tree branch.
     */
    @Override
    public void setExpanded(boolean expanded) {

    }

    /**
     * Returns the user object stored in this <code>TreeNode</code>
     * or <code>null</code> if {@link #setData(Object)} was not called.
     */
    @Override
    public Object getData() {
        return null;
    }

    /**
     * Sets the user data to store in this <code>TreeNode</code>.
     *
     * @param data
     */
    @Override
    public void setData(Object data) {

    }

    /**
     * Returns the string representation of the path from root to this <code>TreeNode</code>.<br/>
     * Path elements are separated by "->".<br/>
     * Each path element is either getData().toString() or "empty" if getData()==null.<br/>
     * For example: "rootNode0->node1->node13->empty" ("rootNode0" is a result of getRoot().getData().toString() in this example).
     */
    @Override
    public String getTreePath() {
        return null;
    }

    /**
     * Finds the (first) node with the given data among the parents' sequence of this <code>TreeNode</code>.
     * By convention, the parents' sequence includes this node itself (i.e. the following may be true: obj.findParent(*) == obj).<br/>
     * Data objects should be compared by equals() method (but if the given data is null then the parent with null data should be returned).
     *
     * @param data the data to find; may be <code>null</code>
     * @return the node found or <code>null</code> if no matching data was found.
     */
    @Override
    public TreeNode findParent(Object data) {
        return null;
    }

    /**
     * Finds the (first) node with the given data among the children of this <code>TreeNode</code>.<br/>
     * Searches it recursively (if some child doesn't have the given data, the children of this child are searched, and so on).<br/>
     * Data objects should be compared by equals() method (but if the given data is null then the child with null data should be returned).
     *
     * @param data the data to find; may be <code>null</code>
     * @return the node found or <code>null</code> if no matching data was found.
     */
    @Override
    public TreeNode findChild(Object data) {
        return null;
    }
}