package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider="getData")
	public void addToCart(String name,int price,int qty,String color,boolean available)
	{
	System.out.println("----"+name+" "+price+" "+qty+" "+color+" "+available+" ---------");	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][5];//.. two data sets of 4 details inside
		 data[0][0]="samsung";
		 data[0][1]=10000;
		 data[0][2]=12;
		 data[0][3]="black";
		 data[0][4]=true;
		 
		 
		 data[1][0]="iphone";
		 data[1][1]=12000;
		 data[1][2]=10;
		 data[1][3]="pink";
		 data[1][4]=false;
		 
		return data;
	}
	
	@Test(dataProvider="laptopData")
	public void addLaptopData(String name,int price,String color)
	{
	System.out.println("----"+name+" "+price+" "+color+"-----");	
	}
	
	
	@DataProvider
	public Object[][] laptopData()
	{
		Object[][] data=new Object[2][3];
		
		data[0][0]="hp";
		data[0][1]=35000;
		data[0][2]="black";
		
		data[1][0]="dell";
		data[1][1]=40000;
		data[1][2]="silver";
		
		return data;
	}

}
