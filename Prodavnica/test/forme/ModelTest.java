package forme;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {
	
	private Model model;

	@Before
	public void setUp() throws Exception {
		model = new Model();
	}

	@After
	public void tearDown() throws Exception {
		model = null;
	}

	@Test
	public void testIsCellEditable() {
//		Uvek treba da vrati false bez obzira na red/kolonu.
		assertEquals(false, model.isCellEditable(0, 0));
	}

	@Test
	public void testModel() {
		model = new Model();
	}

	@Test
	public void testModelIntInt() {
		model = new Model(0, 0);
	}

	@Test
	public void testModelObjectArrayInt() {
		model = new Model(new String[]{}, 0);
	}

	@Test
	public void testModelObjectArrayArrayObjectArray() {
		model = new Model(new String[][]{}, new String[]{});
	}

	@Test
	public void testModelVectorInt() {
		model = new Model(new String[]{}, 0);
	}

	@Test
	public void testModelVectorVector() {
		model = new Model(new String[][]{}, new String[]{});
	}

}
