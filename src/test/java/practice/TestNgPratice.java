package practice;

import org.testng.annotations.Test;

public class TestNgPratice {
	@Test
	public void sample()
	{
		System.out.println("hii");
	}
	@Test(invocationCount=2)
	public void createUser()
	{
		System.out.println("created");
	}
	@Test(priority=2)
	public void deleteUser()
	{
		System.out.println("deleted");
	}
	@Test
	public void updateUser()
	{
		System.out.println("updated");
	}

}
