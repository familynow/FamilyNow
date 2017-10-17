package pageControllers;

import pages.AddressInformationPage;
import pages.ApplicationParticipantPage;
import pages.ApplicationTypePage;
import pages.FosterCarePage;
import pages.MyApplicationPage;
import pages.ReferencePage;
import pages.SupportingDocumentPage;
import pages.LoginPage;
import pages.PreferencesPage;
import pages.ApplicationSummaryPage;
import pages.PersonProfilePage;
import pages.UserListPage;
import pages.RefDataListPage;
import pages.AddRefDataPage;
import pages.InquirySearchPage;

public class ProviderPageManager {
	public static MyApplicationPage _myApplicationPage;
	public static MyApplicationPage MyApplicationPage()
    {
		
		_myApplicationPage = new MyApplicationPage();
         return  _myApplicationPage;
    }
	
	public static ApplicationTypePage _applicationTypePage;
	public static ApplicationTypePage ApplicationTypePage()
    {
		_applicationTypePage = new ApplicationTypePage();
         return  _applicationTypePage;
    }
	
	public static ApplicationParticipantPage _applicationParticipantPage;
	public static ApplicationParticipantPage ApplicationParticipantPage()
    {
		_applicationParticipantPage = new ApplicationParticipantPage();
         return  _applicationParticipantPage;
    }
	
	public static AddressInformationPage _addressInformationPage;
	public static AddressInformationPage AddressInformationPage()
    {
		_addressInformationPage = new AddressInformationPage();
         return  _addressInformationPage;
    }
	
	public static FosterCarePage _fosterCarePage;
	public static FosterCarePage FosterCarePage()
    {
		_fosterCarePage = new FosterCarePage();
         return  _fosterCarePage;
    }
	
	public static ReferencePage _referencePage;
	public static ReferencePage ReferencePage()
    {
		_referencePage = new ReferencePage();
         return  _referencePage;
    }
	
	public static SupportingDocumentPage _supportingDocumentPage;
	public static SupportingDocumentPage SupportingDocumentPage()
    {
		_supportingDocumentPage = new SupportingDocumentPage();
         return  _supportingDocumentPage;
    }
	private static LoginPage _loginPage;
	 public static LoginPage  LoginPage() {
		
		 _loginPage = new LoginPage();
         return  _loginPage;
    }
	 
	 private static PreferencesPage _preferencesPage;
	 public static PreferencesPage  PreferencesPage() {
		
		 _preferencesPage = new PreferencesPage();
         return  _preferencesPage;
    }
	 
	 private static ApplicationSummaryPage _applicationSummaryPage;
	 public static ApplicationSummaryPage  ApplicationSummaryPage() {
		
		 _applicationSummaryPage = new ApplicationSummaryPage();
         return  _applicationSummaryPage;
    }
	 
	 private static PersonProfilePage _personProfilePage;
	 public static PersonProfilePage PersonProfilePage(){
		
		 _personProfilePage = new PersonProfilePage();
          return  _personProfilePage;
     }
	 
	 private static UserListPage _userListPage;
	 public static UserListPage UserListPage(){
		
		 _userListPage = new UserListPage();
          return  _userListPage;
     }
	 
	 private static RefDataListPage _refDataListPage;
	 public static RefDataListPage RefDataListPage(){
		
		 _refDataListPage = new RefDataListPage();
          return  _refDataListPage;
     }
	 
	 private static AddRefDataPage _addRefDataPage;
	 public static AddRefDataPage AddRefDataPage(){
		
		 _addRefDataPage = new AddRefDataPage();
          return  _addRefDataPage;
     }
	 
	 private static InquirySearchPage _inquirySearchPage;
	 public static InquirySearchPage InquirySearchPage(){
		
		 _inquirySearchPage = new InquirySearchPage();
          return  _inquirySearchPage;
     }
	 
	 //
	 
	 

}
