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
	
	int value;
	Node left = null;
	Node right = null;
	
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
	
	public int getValue() {return this.value;}
	
}
