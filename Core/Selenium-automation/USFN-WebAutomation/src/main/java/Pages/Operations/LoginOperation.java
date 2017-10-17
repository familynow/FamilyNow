package Pages.Operations;


import General.GetConfigValue;
import PageControllers.UsfnPageManager;
import Pages.Elements.LoginElement;

public class LoginOperation extends BaseOperations<LoginElement>{
	
	public LoginOperation(LoginElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void EnterUserName(String userName){
		
		Element.GetUserId().sendKeys(userName);
	}
	
    public void EnterPassword(String password){
		
		Element.GetPassword().sendKeys(password);
	}
    
    public void ClickLogin(){
    	
    	Element.GetLoginButton().click();
    	
    }
    
    public void Login(String userName, String password)
    {
    	String getUrl = GetConfigValue.GetUrl();
        UsfnPageManager.LoginPage().Navigate(getUrl);
        try {
			Thread.sleep(4000);
       
    	Element.GetUserId().sendKeys(userName);
    	Element.GetPassword().sendKeys(password);
    	Element.GetLoginButton().click();
    	Thread.sleep(5000);
        }
        
    	
    	 catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
    
    public void Login()
    {
    	String getUrl = GetConfigValue.GetUrl();
        UsfnPageManager.LoginPage().Navigate(getUrl);
        try {
			Thread.sleep(4000);
       
    	Element.GetUserId().sendKeys(GetConfigValue.getUserName());
    	Element.GetPassword().sendKeys("qa");
    	Element.GetLoginButton().click();
    	Thread.sleep(5000);
        }
        
    	
    	 catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
	

}
