package PageControllers;
import Pages.MyComplaintPage;
import Pages.LoginPage;
import Pages.PersonProfilePage;
import Pages.ComplaintParticipantPage;
import Pages.AllegationsPage;
import Pages.SummaryPage;



public class MRPPageManager {
	 private static MyComplaintPage _myComplaintPage;
	 public static MyComplaintPage MyComplaintPage()
     {
		
		 _myComplaintPage = new MyComplaintPage();
          return  _myComplaintPage;
     }
	 
	 private static PersonProfilePage _personProfilePage;
	 public static PersonProfilePage PersonProfilePage(){
		
		 _personProfilePage = new PersonProfilePage();
          return  _personProfilePage;
     }
	 
	 private static ComplaintParticipantPage _complaintParticipantPage;
	 public static ComplaintParticipantPage ComplaintParticipantPage() {
		
		 _complaintParticipantPage = new ComplaintParticipantPage();
          return  _complaintParticipantPage;
     }
	 
	 
	 private static AllegationsPage _allegationsPage;
	 public static AllegationsPage AllegationsPage() {
		
		 _allegationsPage = new AllegationsPage();
          return  _allegationsPage;
     }
	 
	 private static LoginPage _loginPage;
	 public static LoginPage  LoginPage() {
		
		 _loginPage = new LoginPage();
          return  _loginPage;
     }
	 
	 private static SummaryPage _summaryPage;
	 public static SummaryPage  SummaryPage() {
		
		 _summaryPage = new SummaryPage();
          return  _summaryPage;
     }
	 
	 
}
