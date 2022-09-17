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
		if (fn) {
			passed++;
			System.out.println(String.format("Test #%d passed", testNum));
		} else {
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
		
		// testing adding nodes
		test(testAdd1());
		test(testAdd2());
		test(testAdd3());
		
		// testing toString, and, by extension, printWalk
		test(testPrintWalk1());
		test(testPrintWalk2());
		
		// testing depth()
		test(testDepth1());
		test(testDepth2());
		test(testDepth3());
		
		// testing findMinimum
		test(testFMinimum1());
		test(testFMinimum2());
		
		//testing search
		test(testSearch1());
		test(testSearch2());
		test(testSearch3());
		
		// testing delete
		test(testDelete1());
		test(testDelete2());
		test(testDelete3());
		test(testDelete4());
		
		// testing findSuccessor
		test(testSuccessor1());
		test(testSuccessor2());
		
		// testing max and min
		test(testMin());
		test(testMax());
		
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
	
	private static boolean testAdd1() {
		Tree tree = new Tree();
		tree.addValue(2);
		return tree.getRoot().getValue() == 2;
	}
	private static boolean testAdd2() {
		Tree tree = new Tree();
		tree.addValue(2);
		tree.addValue(1);
		tree.addValue(3);
		return (
				tree.getRoot().getValue()  == 2 &&
				tree.getRoot().getLChild().getValue() == 1 && 
				tree.getRoot().getRChild().getValue() == 3
				);
	}
	private static boolean testAdd3() {
		Tree tree = new Tree();
		tree.addValue(2);
		tree.addValue(2);
		tree.addValue(1);
		tree.addValue(3);
		tree.addValue(4);
		return (
				tree.getRoot().getValue()  == 2 &&
				tree.getRoot().getLChild().getValue() == 2 && 
				tree.getRoot().getRChild().getValue() == 3 &&
				tree.getRoot().getLChild().getLChild().getValue() == 1 &&
				tree.getRoot().getRChild().getRChild().getValue() == 4
				);
	}
	
	private static boolean testPrintWalk1() {
		Tree tree = new Tree(2);
		tree.addValue(1);
		tree.addValue(3);
		return tree.toString().equalsIgnoreCase("1 2 3");
	}
	private static boolean testPrintWalk2() {
		Tree tree = new Tree();
		return tree.toString().equals("");
	}
	
	private static boolean testDepth1() {
		Tree tree = new Tree();
		return tree.depth() == 0;
	}
	private static boolean testDepth2() {
		Tree tree = new Tree();
		tree.addValue(1);
		return tree.depth() == 1;
	}
	private static boolean testDepth3() {
		Tree tree = new Tree();
		tree.addValue(1);
		tree.addValue(2);
		return tree.depth() == 2;
	}
	
	private static boolean testFMinimum1() {
		Tree tree = new Tree();
		try {
			tree.findMinimum();
			return false;
		} catch (RuntimeException err) {
			return true;
		}
	}
	private static boolean testFMinimum2() {
		Tree tree = new Tree(5);
		tree.addValue(6);
		tree.addValue(8);
		tree.addValue(7);
		tree.addValue(4);
		tree.addValue(2);
		tree.addValue(3);
		tree.addValue(1);
		return tree.findMinimum().getValue() == 1;
	}
	
	private static boolean testSearch1() {
		Tree tree = new Tree();
		return tree.search(12) == null;
	}
	private static boolean testSearch2() {
		Tree tree = new Tree();
		Node n1 = new Node(12);
		Node n2 = new Node(9);
		Node n3 = new Node(17);
		tree.addValue(n1);
		tree.addValue(n2);
		tree.addValue(n3);
		return tree.search(17) == n3;
	}
	private static boolean testSearch3() {
		Tree tree = new Tree(12);
		tree.addValue(12);
		tree.addValue(18);
		tree.addValue(97);
		tree.addValue(6);
		tree.addValue(4);
		tree.addValue(8);
		tree.addValue(11);
		tree.addValue(23);
		tree.addValue(25);
		tree.addValue(22);
		tree.addValue(0);
		return tree.search(11).getValue() == 11;
	}
	
	private static boolean testDelete1() {
		Tree tree = new Tree();
		tree.delete(tree.search(12));
		return tree.toString().equals("");
	}
	private static boolean testDelete2() {
		Tree tree = new Tree(6);
		tree.addValue(4);
		tree.addValue(8);
		tree.delete(tree.search(8));
		return tree.toString().equals("4 6");
	}
	private static boolean testDelete3() {
		Tree tree = new Tree(6);
		tree.addValue(4);
		tree.addValue(3);
		tree.addValue(5);
		tree.addValue(1);
		tree.addValue(7);
		tree.addValue(9);
		tree.addValue(8);
		tree.addValue(12);
		tree.delete(tree.search(4));
		return tree.toString().equals("1 3 5 6 7 8 9 12");
	}
	private static boolean testDelete4() {
		Tree tree = new Tree(6);
		tree.addValue(4);
		tree.addValue(3);
		tree.addValue(5);
		tree.addValue(1);
		tree.addValue(7);
		tree.addValue(9);
		tree.addValue(8);
		tree.addValue(12);
		tree.delete(tree.search(6));
		return tree.toString().equals("1 3 4 5 7 8 9 12") && tree.getRoot().getValue() == 7;
	}
	
	private static boolean testSuccessor1() {
		Tree tree = new Tree();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		tree.addValue(n2);
		tree.addValue(n1);
		tree.addValue(n3);
		Node check = n1.findSuccessor();
		return check == n2;
	}
	private static boolean testSuccessor2() {
		Tree tree = new Tree();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		tree.addValue(n2);
		tree.addValue(n1);
		tree.addValue(n3);
		Node check = n2.findSuccessor();
		return check == n3;
	}
	
	private static boolean testMin() {
		Tree tree = new Tree(2);
		tree.addValue(1);
		tree.addValue(3);
		return tree.findMinimumValue() == 1;
	}
	private static boolean testMax() {
		Tree tree = new Tree(2);
		tree.addValue(1);
		tree.addValue(3);
		return tree.findMaximumValue() == 3;
	}
}
