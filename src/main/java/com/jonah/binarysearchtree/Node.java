/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonah.binarysearchtree;

/**
 *
 * @author jonah
 */
public class Node {
	
	private int value;
	private Node parent;
	private Node left = null;
	private Node right = null;
	
	public Node(int _value) {
		this.value = _value;
	}
	
	public void addNode(int new_value) {
		if(new_value > this.value) {
			if(this.right != null) {
				this.right.addNode(new_value);
			} else {
				this.right = new Node(new_value);
				this.right.setParent(this);
			}
		} else {
			if(this.left != null) {
				this.left.addNode(new_value);
			} else {
				this.left = new Node(new_value);
				this.left.setParent(this);
			}
		}
	}
	public void addNode(Node new_value) {
		int x = new_value.getValue();
		if(x > this.value) {
			if(this.right != null) {
				this.right.addNode(new_value);
			} else {
				this.right = new_value;
				this.right.setParent(this);
			}
		} else {
			if(this.left != null) {
				this.left.addNode(new_value);
			} else {
				this.left = new_value;
				this.left.setParent(this);
			}
		}
	}
	
	public Node search(int _value) {
		if(value == _value) return this;
		else if(_value > this.value && this.right != null) {
			return this.right.search(_value);
		} else if(_value < this.value && this.left != null) {
			return this.left.search(_value);
		}
		return null;
	}
	
	/**
	 * Finds the successor to the node this is called from
	 * @return The node that follows this node when sorted
	 */
	public Node findSuccessor() { // code taken from Introduction to Algorithms, Third Edition
		Node x = this;
		if (this.right != null) {
			return this.right.findSmallestChild();
		}
		Node y = this.parent;
		while (y != null && x == y.getRChild()) {
			x = y;
			y = y.getParent();
		}
		return y;
	}
	public int findSuccessorValue() {
		return this.findSuccessor().getValue();
	}
	
	public int findSmallestChildValue(){
		if(this.left != null) return this.left.findSmallestChildValue();
		else return this.value;
	}
	public Node findSmallestChild(){
		if(this.left != null) return this.left.findSmallestChild();
		else return this;
	}
	public int findGreatestChildValue(){
		if(this.right != null) return this.right.findGreatestChildValue();
		else return this.value;
	}
	public Node findGreatestChild(){
		if(this.right != null) return this.right.findGreatestChild();
		else return this;
	}
	
	public void printWalk() {
		if(this.left != null) this.left.printWalk();
		System.out.println(this.value + " ");
		if(this.right != null) this.right.printWalk();
	}
	public String toString() {
		
		String output = " ";
		
		if(this.left != null) output += this.left.toString() + " ";
		output += this.value + " ";
		if(this.right != null) output += this.right.toString() + " ";
		
		return output.strip();
	}
	
	/**
	 * Finds the height of this node
	 * @return Returns the 'height' of this node. When depth == 1, this node has no children, when depth == 2, this node's direct children have no children, etc. 
	 */
	public int depth() {
		if(left == null && right == null) return 1;
		else if (left  == null) {
			return right.depth() + 1;
		}
		else if (right == null) {
			return left.depth()  + 1;
		}
		else {
			int l =  left.depth();
			int r = right.depth();
			
			return Math.max(l, r) + 1;
			
		}
	}
	
	public int getValue()   {return this.value;}
	public Node getRChild() {return this.right;}
	public Node getLChild() {return this.left;}
	public Node getParent() {return parent;}
	public Integer getLChild_Int() {
		if(this.left != null) return this.left.getValue();
		return null;
	}
	public Integer getRChild_Int() {
		if(this.right != null) return this.right.getValue();
		return null;
	}
	
	public void setParent(Node _parent)   {this.parent = _parent;  }
	public void setRChild(Node new_value) {this.right  = new_value;}
	public void setLChild(Node new_value) {this.left   = new_value;}
	public void setRChild(int new_value)  {this.right  = new Node(new_value);}
	public void setLChild(int new_value)  {this.left   = new Node(new_value);}
	
}
