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
	
	Node head;
	
	public Tree(int _value) {
		this.head = new Node(_value);
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
	
}
