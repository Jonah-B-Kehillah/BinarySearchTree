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
	public void delete(Node value) {
		if(value.getParent() != null) {
			value.getParent().setLChild(value.getLChild());
		} else {
			this.head = value.getLChild();
		}
		if (value.getLChild() != null) {
			value.getLChild().setParent(value.getParent());
		}
	}
}
