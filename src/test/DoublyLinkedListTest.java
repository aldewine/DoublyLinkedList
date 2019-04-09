package test;

import java.util.Objects;

import org.junit.jupiter.api.Test;

import com.MyDoublyLinkedList;
import com.Node;

class DoublyLinkedListTest {

	@Test
	void test() {
		MyDoublyLinkedList<String> dLinkedList = new MyDoublyLinkedList<String>();
		dLinkedList.addEnd("A");
		dLinkedList.addEnd("B");
		dLinkedList.addEnd("C");
		iterateOverDoublyLinkedList(dLinkedList.getStartNode());

		dLinkedList.addAfter(dLinkedList.getStartNode(), "2");

		iterateOverDoublyLinkedList(dLinkedList.getStartNode());

		dLinkedList.delete(dLinkedList.getStartNode());

		iterateOverDoublyLinkedList(dLinkedList.getStartNode());
	}

	private void iterateOverDoublyLinkedList(Node node) {
		System.out.println();
		System.out.println("Iterating Forward:");
		Node endNode = null;
		while (!Objects.isNull(node)) {
			System.out.print(node.getValue() + ", ");
			endNode = node;
			node = node.getNextNode();
		}
		System.out.println();
		System.out.println("Iterating backwards:");
		while (!Objects.isNull(endNode)) {
			System.out.print(endNode.getValue() + ", ");
			endNode = endNode.getPrevNode();
		}
	}
}
