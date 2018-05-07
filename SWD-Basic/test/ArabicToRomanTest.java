import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArabicToRomanTest {

	private ArabicToRoman atr;
	
	@Before
	public void setUp() {
		atr = new ArabicToRoman();
	}
	
	@Test
	public void test() {
		Assert.assertEquals("I",  atr.toRoman(1));
		Assert.assertEquals("II",  atr.toRoman(2));
		Assert.assertEquals("III",  atr.toRoman(3));
		Assert.assertEquals("IV",  atr.toRoman(4));
		Assert.assertEquals("V",  atr.toRoman(5));
		Assert.assertEquals("VI",  atr.toRoman(6));
		Assert.assertEquals("VII",  atr.toRoman(7));
		Assert.assertEquals("VIII",  atr.toRoman(8));
		Assert.assertEquals("IX",  atr.toRoman(9));
		Assert.assertEquals("X",  atr.toRoman(10));
		Assert.assertEquals("XXXIX",  atr.toRoman(39));
		Assert.assertEquals("XL",  atr.toRoman(40));
		Assert.assertEquals("MMMDCCCXLVIII",  atr.toRoman(3848));
	}

}
