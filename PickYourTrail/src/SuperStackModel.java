
public class SuperStackModel<T extends Number> {
	private static class StackNode<T extends Number> {
	
	private T data;
	private StackNode<T> next;
	
	public StackNode(T data) {
		this.data = data;
	}
	
	}
	
private StackNode<T> top;
private int currentDepth = 0;

public T pop() throws Exception {
	if (top == null) throw new Exception();
	T item = top.data;
	top = top.next; 
	--currentDepth;
	return item;
}

public T push(T item) {
	StackNode<T> t = new StackNode<T>(item); 
	t.next = top;
	top = t;
	++currentDepth;
	return item;
}

public T peek() throws Exception {
	if (top == null) throw new Exception(); 
	return top.data;
}

public T increment(int e, int k) throws Exception {
	// Pure Stack only implementation
	try {
		StackNode<T> temp = (e == currentDepth) ? top : top.next;
		int index = 1;
		while (true) {
			if (temp == null) break;
			
			if (index > currentDepth) break;
			
			if (index + e + ((e == currentDepth) ? 0 : 1) > currentDepth) {
				if (temp.data instanceof Integer) {
				int tempData = (int) temp.data;
				temp.data = (T) new Integer(tempData + k);
				}
			}
			
			if (null != temp) temp = (StackNode<T>) temp.next;
			
			++index;
		}
	} catch (Exception ex) {
		System.out.println(ex);
	}
	return peek();
}

public boolean isEmpty() {
	return top == null;
}

}