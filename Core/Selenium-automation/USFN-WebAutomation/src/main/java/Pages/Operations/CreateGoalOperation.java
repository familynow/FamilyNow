package Pages.Operations;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import General.Browser;
import PageControllers.UsfnPageManager;
import Pages.Elements.CreateGoalElement;

public class CreateGoalOperation extends BaseOperations<CreateGoalElement> {

	public CreateGoalOperation(CreateGoalElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectHarmFactor(int Index){
		
		WebElement parentDiv = Browser.driver.findElement(By.xpath("//div[@id='harmFactorsPopup']"));
		List<WebElement> li_Collection = parentDiv.findElements(By.xpath("//div[@class='popup-content']//ul/li"));
		li_Collection.get(Index).findElement(By.xpath("label/span")).click();
	}
	
	public List<String> GetHarmFactor(){
		List<String> HarmFactor = new ArrayList<String>();
		WebElement parentDiv = Browser.driver.findElement(By.xpath("//div[@id='harmFactorsPopup']"));
		List<WebElement> li_Collection = parentDiv.findElements(By.xpath("//div[@class='popup-content']//ul/li"));
		int i=0;
		for (WebElement li : li_Collection) {
			
			if(li_Collection.get(i).findElement(By.xpath("label/input[@type='checkbox']")).isSelected()){
			HarmFactor.add(li.getText());
			}
			i++;
			
		}

		return HarmFactor;
		
	}
	
	public List<String> SelectedHarmFactor(){
		List<String> HarmFactor = new ArrayList<String>();
		WebElement parentDiv = Browser.driver.findElement(By.xpath("//form[@id='safetyDecision']//div[@class='section-bordered']//div[@class='vetical-space-md']"));
		List<WebElement> li_Collection = parentDiv.findElements(By.xpath(".//ul/li"));
		for (WebElement li : li_Collection) {
			HarmFactor.add(li.getText());
			
		}

		return HarmFactor;
		
	}
	
	public boolean IsHarmFactorChecked(int Index) {

	
		WebElement parentDiv = Browser.driver.findElement(By.xpath("//div[@id='harmFactorsPopup']"));
		List<WebElement> li_Collection = parentDiv.findElements(By.xpath("//div[@class='popup-content']//ul/li"));
		
		return li_Collection.get(Index).findElement(By.xpath("label/input[@type='checkbox']")).isSelected();
		

	}
	
	 public void NavigateToGoalPage(){
		 
		 try {
			 
				Thread.sleep(1000);
				
				List<WebElement> allElements = Browser.driver.findElements(By.xpath("//div[@id='sidebar']//ul[@class='nav sidebar-menu investigation investigation-page-sidebar ng-scope']/li")); 

				for (WebElement element: allElements) {
					
					if(element.getText().contains("Goals")){
				     
					  element.findElement(By.linkText("Goals")).click();
					  break;
					}
				
				}
				 Thread.sleep(1000);
				Element.AddGoalButton().click();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	 
	 public void NavigateToGoalListPage(){
		 try {
			 
				Thread.sleep(1000);
				
				List<WebElement> allElements = Browser.driver.findElements(By.xpath("//div[@id='sidebar']//ul[@class='nav sidebar-menu investigation investigation-page-sidebar ng-scope']/li")); 

				for (WebElement element: allElements) {
					
					if(element.getText().contains("Goals")){
				     
					  element.findElement(By.linkText("Goals")).click();
					  break;
					}
				
				}
				 Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 
	 }
	 
	 
	 
	 public boolean IsGoalCreated(String Goal,String ColumnValueToBeSearched) {
			boolean planCreated = false;

			   do{
				List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='safetyPlanList']/tbody");
				for (WebElement trElement : tr_collection) {
					if (trElement.getAttribute("class").contains("no-results ng-hide"))
						continue;
					try{
					WebElement cell = trElement.findElement(By.xpath("td[3]"));
					
					if (cell.getText().contains(Goal)) {
						WebElement getParentRow = cell.findElement(By.xpath("./.."));
						if (getParentRow.getText().contains(ColumnValueToBeSearched)) {
							planCreated = true;
							break;

						}
					}
					}
					catch (NoSuchElementException e){
						planCreated = false;
						
					}

				}
				if(planCreated){
					break;
				}
			   }while (PaginationClickNext());
			   NavigateToFirstPage();
			
			return planCreated;

		}
	 
	 public boolean IsTaskCreated(String Task,String ColumnValueToBeSearched) {
			boolean planCreated = false;

			   do{
				List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='taskList']/tbody");
				for (WebElement trElement : tr_collection) {
					if (trElement.getAttribute("class").contains("no-results ng-hide"))
						continue;
					try{
					WebElement cell = trElement.findElement(By.xpath("td[3]"));
					
					if (cell.getText().contains(Task)) {
						WebElement getParentRow = cell.findElement(By.xpath("./.."));
						if (getParentRow.getText().contains(ColumnValueToBeSearched)) {
							planCreated = true;
							break;

						}
					}
					}
					catch (NoSuchElementException e){
						planCreated = false;
						
					}

				}
				if(planCreated){
					break;
				}
			   }while (PaginationClickNext());
			   NavigateToFirstPage();
			
			return planCreated;

		}
	 
	 public boolean IsResponsiblePartiesCreated(String Contact,String ColumnValueToBeSearched) {
			boolean planCreated = false;

			   do{
				List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='responsibleParties']/tbody");
				for (WebElement trElement : tr_collection) {
					if (trElement.getAttribute("class").contains("no-results ng-hide"))
						continue;
					try{
					WebElement cell = trElement.findElement(By.xpath("td[5]"));
					
					if (cell.getText().contains(Contact)) {
						WebElement getParentRow = cell.findElement(By.xpath("./.."));
						if (getParentRow.getText().contains(ColumnValueToBeSearched)) {
							planCreated = true;
							break;

						}
					}
					}
					catch (NoSuchElementException e){
						planCreated = false;
						
					}

				}
				if(planCreated){
					break;
				}
			   }while (PaginationClickNext());
			   NavigateToFirstPage();
			
			return planCreated;

		}
	 
	 
	 
	 public List<String> GetHarmFactorAddressed(String Goal){
			List<String> HarmFactor = new ArrayList<String>();

			  do{
				  List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='safetyPlanList']/tbody");
				  for (WebElement trElement : tr_collection) {
						if (trElement.getAttribute("class").contains("no-results ng-hide"))
							continue;
						WebElement cell = trElement.findElement(By.xpath("td[3]"));
						if (cell.getText().contains(Goal)) {
							WebElement harmFactorRow = trElement.findElement(By.xpath("td[4]"));
							List<WebElement> labels = harmFactorRow.findElements(By.xpath("label"));
							 for (WebElement label : labels) {
									HarmFactor.add(label.getAttribute("tooltip"));
									
								}
							
						}
					 
					  
				  }
				  
			  }while (PaginationClickNext());
		
			  NavigateToFirstPage();

			return HarmFactor;
			
		}
	 
	 public void ClickTaskDeleteIcon(String Task){
			
			boolean clicked = false;
			
			do{
				List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='taskList']/tbody");
				for (WebElement trElement : tr_collection) {
					if (trElement.getAttribute("class").contains("no-results ng-hide"))
						continue;
					WebElement cell = trElement.findElement(By.xpath("td[3]"));
					if (cell.getText().contains(Task)) {
						trElement.findElement(By.xpath("td[6]/span[@tooltip='Delete']")).click();
						clicked = true;
						break;
						
					}
					
				}
				
				if(clicked){
					break;
				}
				
			}while (PaginationClickNext());
			  NavigateToFirstPage();
			
			
		}
	 
	 public void ClickResponsiblePartieskDeleteIcon(String Contact){
			
			boolean clicked = false;
			
			do{
				List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='responsibleParties']/tbody");
				for (WebElement trElement : tr_collection) {
					if (trElement.getAttribute("class").contains("no-results ng-hide"))
						continue;
					WebElement cell = trElement.findElement(By.xpath("td[5]"));
					if (cell.getText().contains(Contact)) {
						trElement.findElement(By.xpath("td[6]//span[@tooltip='Delete']")).click();
						clicked = true;
						break;
						
					}
					
				}
				
				if(clicked){
					break;
				}
				
			}while (PaginationClickNext());
			  NavigateToFirstPage();
			
			
		}
	 
	 public void EditTask(String Task){
			
			boolean clicked = false;
			
			do{
				List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='taskList']/tbody");
				for (WebElement trElement : tr_collection) {
					if (trElement.getAttribute("class").contains("no-results ng-hide"))
						continue;
					WebElement cell = trElement.findElement(By.xpath("td[3]"));
					if (cell.getText().contains(Task)) {
						trElement.findElement(By.xpath("td[1]//span[@tooltip='Edit']")).click();
						clicked = true;
						break;
						
					}
					
				}
				
				if(clicked){
					break;
				}
				
			}while (PaginationClickNext());
			  NavigateToFirstPage();
			
			
		}
	 
	public void DeleteAllGoals() throws InterruptedException {
		do {
			List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='safetyPlanList']/tbody");
			for (WebElement trElement : tr_collection) {
				if (trElement.getAttribute("class").contains("no-results ng-hide"))
					continue;
				trElement.findElement(By.xpath("td[5]/span[@tooltip='Delete']")).click();
				Element.ConfirmationDialoogOKButton().click();
			//	 UsfnPageManager.CreateCpsPage().Operations().ApplyWait(Browser.driver);
				 Thread.sleep(1000);

			}

		} while (PaginationClickNext());

	}
	 
	 public void ClickDeleteIcon(String Goal){
			
			boolean clicked = false;
			
			do{
				List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='safetyPlanList']/tbody");
				for (WebElement trElement : tr_collection) {
					if (trElement.getAttribute("class").contains("no-results ng-hide"))
						continue;
					WebElement cell = trElement.findElement(By.xpath("td[3]"));
					if (cell.getText().contains(Goal)) {
						trElement.findElement(By.xpath("td[5]/span[@tooltip='Delete']")).click();
						clicked = true;
						break;
						
					}
					
				}
				
				if(clicked){
					break;
				}
				
			}while (PaginationClickNext());
			  NavigateToFirstPage();
			
			
		}
	 
	 public void ClickEditIcon(String Goal){
			
			boolean clicked = false;
			
			do{
				List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='safetyPlanList']/tbody");
				for (WebElement trElement : tr_collection) {
					if (trElement.getAttribute("class").contains("no-results ng-hide"))
						continue;
					WebElement cell = trElement.findElement(By.xpath("td[3]"));
					if (cell.getText().contains(Goal)) {
						trElement.findElement(By.xpath("td[1]//span[@tooltip='Edit']")).click();
						clicked = true;
						break;
						
					}
					
				}
				
				if(clicked){
					break;
				}
				
			}while (PaginationClickNext());
			  NavigateToFirstPage();
			
			
		}
		

}
