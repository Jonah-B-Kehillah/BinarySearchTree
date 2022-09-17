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
			Node y = findMinimum();
			if(y.getParent() != z) {
				transplant(y, y.getRChild());
				y.setRChild(z.getLChild());
				y.getRChild().setParent(y);
			}
			transplant(z, y);
			y.setLChild(z.getLChild());
			y.getLChild().setParent(y);
		}
	}
	// end of code taken from Introduction to Algorithms, Third Edition
	
	public Node findMinimum(){
		if(head != null) {return head.findSmallestChild();}
		else return null;
	}
	public Integer findMinimumValue(){
		if(head != null) {return head.findSmallestChildValue();}
		else return null;
	}
	
	public int depth() {
		return head.depth();
	}
	
	public void printWalk() {this.head.printWalk();}
	public String toString() {if(this.head != null) return this.head.toString(); else return null;}
	
	public Node getRoot() {return this.head;}
	public int getRootValue() {return this.head.getValue();}
	
	
	
}
