import junit.framework.TestCase;


public class TestRectangle extends TestCase {

	public void test_getArea() {
		Rectangle testRect = new Rectangle(5, 10);
		assertEquals(50, testRect.getArea(), 0.1);
	}

	public void test_getPerimeter() {
		Rectangle testRect = new Rectangle(5, 10);
		assertEquals(50, testRect.getPerimeter(), 0.1);
	}
}
