package com;

import java.util.Objects;

public class MyDoublyLinkedList<T> {
	private Node<T> startNode;

	public Node<T> getStartNode() {
		return startNode;
	}

	public void addEnd(T value) {
		Node<T> node = new Node<T>(value);
		node.setNextNode(null);

		if (Objects.isNull(this.startNode)) {
			node.setPrevNode(null);
			this.startNode = node;
			return;
		}

		Node<T> endNode = this.startNode;
		while (!Objects.isNull(endNode.getNextNode())) {
			endNode = endNode.getNextNode();
		}
		endNode.setNextNode(node);
		node.setPrevNode(endNode);
	}

	public void addFront(T value) {
		Node<T> node = new Node<T>(value);
		node.setNextNode(this.startNode);
		node.setPrevNode(null);
		if (!Objects.isNull(this.startNode)) {
			this.startNode.setPrevNode(node);
		}
		this.startNode = node;
	}

	public void addAfter(Node<T> prevNode, T value) {
		if (Objects.isNull(prevNode)) {
			throw new IllegalStateException("prevNode can not be null.");
		}

		Node<T> node = new Node<T>(value);
		node.setNextNode(prevNode.getNextNode());
		node.setPrevNode(prevNode);
		prevNode.setNextNode(node);
		if (!Objects.isNull(node.getNextNode())) {
			node.getNextNode().setPrevNode(node);
		}
	}

	public void delete(Node<T> node) {
		if (node == this.startNode) {
			if (!Objects.isNull(node.getNextNode())) {
				this.startNode = node.getNextNode();
			} else {
				this.startNode = null;
			}
		}
		if (!Objects.isNull(node.getNextNode())) {
			node.getNextNode().setPrevNode(node.getPrevNode());
		}
		if (!Objects.isNull(node.getPrevNode())) {
			node.getPrevNode().setNextNode(node.getNextNode());
		}

		// Not necessary just to be sure :) we wouldn't want any leaks, isle of
		// isolation rules apply anyways
		node.setNextNode(null);
		node.setPrevNode(null);
		node.setValue(null);
		node = null;
	}
}
