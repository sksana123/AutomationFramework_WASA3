package practice;

import org.testng.annotations.Test;

public class ReadTheDataFromCmdLine
{
	
	@Test
	public void test()
	{
		String BROWSER=System.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL=System.getProperty("url");
		System.out.print(URL);
		
	}

}
