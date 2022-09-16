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
			}
		} else {
			if(this.left != null) {
				this.left.addNode(new_value);
			} else {
				this.left = new Node(new_value);
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
	
	public Node findSuccessor() { // i.e. second smallest
		if(this.right != null) {
			if(this.right.left == null) return this.right;
			else {
				return this.right.findSmallestChild();
			}
		}
		return this;
	}
	public int findSuccessorValue() {
		if(this.right != null) {
			if(this.right.left == null) return this.right.value;
			else {
				return this.right.findSmallestChildValue();
			}
		}
		return this.value;
	}
	
	public int findSmallestChildValue(){
		if(this.left != null) return this.left.findSmallestChildValue();
		else return this.value;
	}
	public Node findSmallestChild(){
		if(this.left != null) return this.left.findSmallestChild();
		else return this;
	}
	
	public void printWalk() {
		if(this.left != null) this.left.printWalk();
		System.out.println(this.value + " ");
		if(this.right != null) this.right.printWalk();
	}
	public String toString() {
		
		String output = "";
		
		if(this.left != null) output += this.left.toString();
		output += this.value + " ";
		if(this.right != null) output += this.right.toString();
		
		return output.strip();
	}
	
	public int depth() {
		if(left == null && right == null) return 0;
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
