package PageControllers;

import Pages.CpsAddParticipanPage;
import Pages.CpsListParticipantPage;
import Pages.CreateCpsPage;
import Pages.IntakeListPage;
import Pages.LoginPage;
import Pages.MyOrganizerPage;
import Pages.PersonSearchPage;
import Pages.CpsMaltreatmentPage;
import Pages.NonCpsIntakeListPage;
import Pages.CreateNonCpsPage;
import Pages.NonCpsListParticipantPage;
import Pages.NonCpsAddParticipantPage;
import Pages.NonCpsDecisionPage;
import Pages.PersonBasicPage;
import Pages.PersonDemographicPage;
import Pages.PersonContactDetailPage;
import Pages.PersonAddressListPage;
import Pages.AddAdditionalNamePage;
import Pages.ResponsePriorityPage;
import Pages.PriorityQuestionPage;
import Pages.CpsDecisionPage;
import Pages.SafteyAssessmentPage;
import Pages.SafteyPlanListPage;
import Pages.SafteyPlanParticipantPage;
import Pages.CreateGoalPage;
import Pages.AddTaskPage;
import Pages.DiscontinuePage;
import Pages.UserMaintenancePage;
import Pages.AddSecurityUserPage;
import Pages.EmployeeSearchPage;

public class UsfnPageManager {
	
	 private static IntakeListPage _intakePage;
	 public static IntakeListPage IntakeListPage()
     {
		
			 _intakePage = new IntakeListPage();
	    
          return  _intakePage;
     }
	 
	 private static LoginPage _loginPage;
	 public static LoginPage LoginPage()
     {
		 
			 _loginPage = new LoginPage();
	     
          return  _loginPage;
     }
	 
	 private static CreateCpsPage _createCpsPage;
	 public static CreateCpsPage CreateCpsPage()
     {
		
			 _createCpsPage = new CreateCpsPage();
	     
          return  _createCpsPage;
     }
	 
	 private static PersonSearchPage _personSearchPage;
	 public static PersonSearchPage PersonSearchPage()
     {
		 
			 _personSearchPage = new PersonSearchPage();
	    
          return  _personSearchPage;
     }
	 
	 private static MyOrganizerPage _myOrganizerPage;
	 public static MyOrganizerPage MyOrganizerPage()
     {
		 
			 _myOrganizerPage = new MyOrganizerPage();
	      
          return  _myOrganizerPage;
     }
	 
	 private static CpsAddParticipanPage _cpsAddParticipanPage;
	 public static CpsAddParticipanPage CpsAddParticipanPage()
     {
		 
			 _cpsAddParticipanPage = new CpsAddParticipanPage();
	      
          return  _cpsAddParticipanPage;
     }
	 
	 private static CpsListParticipantPage _cpsListParticipantPage;
	 public static CpsListParticipantPage CpsListParticipantPage()
     {
		 
			 _cpsListParticipantPage = new CpsListParticipantPage();
	      
          return  _cpsListParticipantPage;
     }
	 
	 private static CpsMaltreatmentPage _cpsMaltreatmentPage;
	 public static CpsMaltreatmentPage CpsMaltreatmentPage()
     {
		 
		 _cpsMaltreatmentPage = new CpsMaltreatmentPage();
	      
          return  _cpsMaltreatmentPage;
     }
	 
	 private static NonCpsIntakeListPage _nonCpsIntakeListPage;
	 public static NonCpsIntakeListPage NonCpsIntakeListPage()
     {
		 
		 _nonCpsIntakeListPage = new NonCpsIntakeListPage();
	      
          return  _nonCpsIntakeListPage;
     }
	 
	 private static CreateNonCpsPage _createNonCpsPage;
	 public static CreateNonCpsPage CreateNonCpsPage()
     {
		 
		 _createNonCpsPage = new CreateNonCpsPage();
	      
          return  _createNonCpsPage;
     }
	 
	 private static NonCpsListParticipantPage _nonCpsListParticipantPage;
	 public static NonCpsListParticipantPage NonCpsListParticipantPage()
     {
		 
		 _nonCpsListParticipantPage = new NonCpsListParticipantPage();
	      
          return  _nonCpsListParticipantPage;
     }
	 
	 private static NonCpsAddParticipantPage _nonCpsAddParticipantPage;
	 public static NonCpsAddParticipantPage NonCpsAddParticipantPage()
     {
		 
		 _nonCpsAddParticipantPage = new NonCpsAddParticipantPage();
	      
          return  _nonCpsAddParticipantPage;
     }
	 
	 private static NonCpsDecisionPage _nonCpsDecisionPage;
	 public static NonCpsDecisionPage NonCpsDecisionPage()
     {
		 
		 _nonCpsDecisionPage = new NonCpsDecisionPage();
	      
          return  _nonCpsDecisionPage;
     }
	 
	 private static PersonBasicPage _personBasicPage;
	 public static PersonBasicPage PersonBasicPage()
     {
		 
		 _personBasicPage = new PersonBasicPage();
	      
          return  _personBasicPage;
     }
	 
	 private static PersonDemographicPage _personDemographicPage;
	 public static PersonDemographicPage PersonDemographicPage()
     {
		 
		 _personDemographicPage = new PersonDemographicPage();
	      
          return  _personDemographicPage;
     }
	 
	 private static PersonContactDetailPage _personContactDetailPage;
	 public static PersonContactDetailPage PersonContactDetailPage()
     {
		 
		 _personContactDetailPage = new PersonContactDetailPage();
	      
          return  _personContactDetailPage;
      }
	 
	 private static PersonAddressListPage _personAddressListPage;
	 public static PersonAddressListPage PersonAddressListPage()
     {
		 
		 _personAddressListPage = new PersonAddressListPage();
	      
          return  _personAddressListPage;
      }
	 
	 private static AddAdditionalNamePage _addAdditionalNamePage;
	 public static AddAdditionalNamePage AddAdditionalNamePage()
     {
		 
		 _addAdditionalNamePage = new AddAdditionalNamePage();
	      
          return  _addAdditionalNamePage;
      }
	 
	 
	 private static ResponsePriorityPage _responsePriorityPage;
	 public static ResponsePriorityPage ResponsePriorityPage()
     {
		 
		 _responsePriorityPage = new ResponsePriorityPage();
	      
          return  _responsePriorityPage;
      }
	 
	 
	 private static PriorityQuestionPage _priorityQuestionPage;
	 public static PriorityQuestionPage PriorityQuestionPage()
     {
		 
		 _priorityQuestionPage = new PriorityQuestionPage();
	      
          return  _priorityQuestionPage;
      }
	 
	 private static CpsDecisionPage _cpsDecisionPage;
	 public static CpsDecisionPage CpsDecisionPage()
     {
		 
		 _cpsDecisionPage = new CpsDecisionPage();
	      
          return  _cpsDecisionPage;
      }
	 
	 private static SafteyAssessmentPage _safteyAssessmentPage;
	 public static SafteyAssessmentPage SafteyAssessmentPage()
     {
		 
		 _safteyAssessmentPage = new SafteyAssessmentPage();
	      
          return  _safteyAssessmentPage;
      }
	 
	 private static SafteyPlanListPage _safteyPlanListPage;
	 public static SafteyPlanListPage SafteyPlanListPage()
     {
		 
		 _safteyPlanListPage = new SafteyPlanListPage();
	      
          return  _safteyPlanListPage;
      }
	 
	 private static SafteyPlanParticipantPage _safteyPlanParticipantPage;
	 public static SafteyPlanParticipantPage SafteyPlanParticipantPage()
     {
		 
		 _safteyPlanParticipantPage = new SafteyPlanParticipantPage();
	      
          return  _safteyPlanParticipantPage;
      }
	 
	 private static CreateGoalPage _createGoalPage;
	 public static CreateGoalPage CreateGoalPage()
     {
		 
		 _createGoalPage = new CreateGoalPage();
	      
          return  _createGoalPage;
      }
	 
	 private static AddTaskPage _addTaskPage;
	 public static AddTaskPage AddTaskPage()
     {
		 
		 _addTaskPage = new AddTaskPage();
	      
          return  _addTaskPage;
      }
	 
	 private static DiscontinuePage _discontinuePage;
	 public static DiscontinuePage DiscontinuePage()
     {
		 
		 _discontinuePage = new DiscontinuePage();
	      
          return  _discontinuePage;
      }
	 
	 private static UserMaintenancePage _userMaintenancePage;
	 public static UserMaintenancePage UserMaintenancePage()
     {
		 
		 _userMaintenancePage = new UserMaintenancePage();
	      
          return  _userMaintenancePage;
      }
	 
	 private static AddSecurityUserPage _addSecurityUserPage;
	 public static AddSecurityUserPage AddSecurityUserPage()
     {
		 
		 _addSecurityUserPage = new AddSecurityUserPage();
	      
          return  _addSecurityUserPage;
      }
	 
	 private static EmployeeSearchPage _employeeSearchPage;
	 public static EmployeeSearchPage EmployeeSearchPage()
     {
		 
		 _employeeSearchPage = new EmployeeSearchPage();
	      
          return  _employeeSearchPage;
      }
	 
	 //EmployeeSearchPage
	 

}
