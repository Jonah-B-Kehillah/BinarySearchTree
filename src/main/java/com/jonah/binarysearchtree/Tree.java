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
public class Tree {
	
	private Node head;
	
	public Tree(int _value) {
		this.head = new Node(_value);
	}
	public Tree(Node _value) {
		this.head = _value;
	}
	public Tree() {
		this.head = null;
	}
	
	public void addValue(int new_value){
		if(this.head != null){
			this.head.addNode(new_value);
		} else {
			this.head = new Node(new_value);
		}
	}
	public void addValue(Node new_value){
		if(this.head != null){
			this.head.addNode(new_value);
		} else {
			this.head = new_value;
		}
	}
	
	public Node search(int value) {
		if(head == null) return head;
		return head.search(value);
	}
	
	// code taken from Introduction to Algorithms, Third Edition
	/**
	 * Transplants one subtree into another subtree
	 * @param u This is the node that is moved
	 * @param v Node u is transplanted into this node
	 */
	private void transplant(Node u, Node v) {
		if(u.getParent()==null) {
			head = v;
		} else if (u == u.getParent().getLChild()) {
			u.getParent().setLChild(v);
		} else {
			u.getParent().setRChild(v);
		}
		if (v != null) {
			v.setParent(u.getParent());
		}
	}
	public void delete(Node z) {
		if(head == null) return;
		if (z.getLChild() == null) {
			transplant(z, z.getRChild());
		} else if (z.getRChild() == null) {
			transplant(z, z.getLChild());
		} else {
			Node y = z.getRChild().findSmallestChild();
			if(y.getParent() != z) {
				transplant(y, y.getRChild());
				y.setRChild(z.getRChild());
				y.getRChild().setParent(y);
			}
			transplant(z, y);
			y.setLChild(z.getLChild());
			y.getLChild().setParent(y);
			
		}
	}
	// end of code taken from Introduction to Algorithms, Third Edition
	
	public Node findMinimum() throws RuntimeException{
		if(head != null) {return head.findSmallestChild();}
		else throw new RuntimeException("no values exist in the tree");
	}
	public Integer findMinimumValue(){
		if(head != null) {return head.findSmallestChildValue();}
		else return null;
	}
	public Node findMaximum() throws RuntimeException{
		if(head != null) {return head.findGreatestChild();}
		else throw new RuntimeException("no values exist in the tree");
	}
	public Integer findMaximumValue(){
		if(head != null) {return head.findGreatestChildValue();}
		else return null;
	}
	
	/**
	 * Implements Node.depth() for the root of this tree.
	 */
	public int depth() {
		if(this.head == null) return 0;
		return head.depth();
	}
	
	public void printWalk()  {if(this.head != null)        this.head.printWalk(); else System.out.println("");}
	public String toString() {if(this.head != null) return this.head.toString() ; else return "";}
	
	public Node getRoot() {return this.head;}
	public int getRootValue() {return this.head.getValue();}
	
	
	
}
