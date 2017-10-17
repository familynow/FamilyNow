package pages.operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageControllers.ProviderPageManager;
import pages.elements.AddressInformationElement;
import pages.operations.BaseOperation;

public class AddressInformationOperation  extends BaseOperation<AddressInformationElement> {
	public AddressInformationOperation(AddressInformationElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectRentLease(String Rent){
		
		Element.DoYouOwnRentOrLease().selectByVisibleText(Rent);
		
	}
 public void SelectWeponInfo(String WeponInfo){
		
		Element.AreThereWeaponsInHome().selectByVisibleText(WeponInfo);
		
	}
 public void SelectWaterNearYourHome(String WaterNearYourHome){
		
		Element.AreThereBodiesOfWaterNearYourHome().selectByVisibleText(WaterNearYourHome);
		
	}
 
 
 // GetParticipantMenu
   public void ClickTopLevelMenu(String menuName){
		  
	   try {
		Thread.sleep(1000);
		List<WebElement> allElements =  Element.GetTopLevelList();
		int size = allElements.size();

		for (WebElement element: allElements) {
			String test = element.getText();
			
			if(element.getText().contains(menuName)){
		     
			  element.findElement(By.xpath(".//span[@class='progress-circle ticked']")).click();
			  break;
			}
		
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	  }
   public String EnterRequiredField(){
		 SelectRentLease("Own");
	     SelectWeponInfo("Yes");
	     SelectWaterNearYourHome("Yes");
	     Element.State().selectByVisibleText("Alabama");
	     String City = Element.City().getAttribute("value");
	     String Zip =Element.Zip().getAttribute("value");
	     String Address = Element.Addressline1().getAttribute("value")+" "+Element.Addressline2().getAttribute("value")+" "+City+" "+"Alabama"+" "+Zip;
	     return Address;
   }

}
