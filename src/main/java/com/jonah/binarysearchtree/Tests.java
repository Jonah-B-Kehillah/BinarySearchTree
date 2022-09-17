/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jonah.binarysearchtree;
import java.util.logging.*;

/**
 *
 * @author jonah
 */
public class Tests {
	
	// code courtesy of https://www.geeksforgeeks.org/logger-warning-method-in-java-with-examples/
	static Logger logger = Logger.getLogger(Tests.class.getName());
	
	static int testNum = 0;
	static int passed  = 0;
	static int failed  = 0;
	
	public static void test(boolean fn) {
		testNum++;
		if (fn) passed++; else {
			failed++;
			logger.warning(String.format("Test #%d failed!", testNum));
		}
	}
	
	public static void main(String[] args){
		
		logger.setLevel(Level.WARNING);
		// call test functions here
		
		// testing constructors
		test(testConstructor1());
		test(testConstructor2());
		test(testConstructor3());
		
		System.out.println(String.format("Tests passed: %d, Tests failed: %d", passed, failed));
		
	}
	
	private static boolean testConstructor1() {
		Tree tree = new Tree();
		return tree.getRoot() == null;
	}
	private static boolean testConstructor2() {
		Tree tree = new Tree(7);
		return tree.getRoot().getValue() == new Node(7).getValue();
	}
	private static boolean testConstructor3() {
		Node node = new Node(12);
		Tree tree = new Tree(node);
		return tree.getRoot() == node;
	}
	
}
