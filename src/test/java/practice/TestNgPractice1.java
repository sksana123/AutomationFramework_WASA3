package practice;


import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;





public class TestNgPractice1 {
	@Test
	public void sample()
	{
		System.out.println("hii");
	}
	@Test
	public void createUser()
	{
		System.out.println("created");
	//	Assert.fail();
	}
	@Test(dependsOnMethods="createUser")
	
	public void deleteUser()
	{
		System.out.println("deleted");
	}
	@Test(dependsOnMethods={"deleteUser","createUser"})
	public void updateUser()
	{
		System.out.println("updated");
	}


}
