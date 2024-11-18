package unitTests;

import issPageClasses.AppointmentCalendarPage;
import issPageClasses.ApptRequestPage;
import issPageClasses.CancelApptPage;
import issPageClasses.ChangeLocationModalPage;
import issPageClasses.EditApptRequestPage;
import issPageClasses.HeaderModalPage;
import issPageClasses.HomePage;
import issPageClasses.MissionActEligibleModalPage;
import issPageClasses.NewApptPage;
import issPageClasses.PatientContactModal;
import issPageClasses.PatientEligibilityModalPage;
import issPageClasses.PatientHeaderModalPage;
import issPageClasses.PatientPage;
import issPageClasses.PatientRecordFlagsModalPage;
import issPageClasses.PreviewPatientLetterModalPage;
import issPageClasses.Resources;
import issPageClasses.SensitiveRecordModalPage;
import issPageClasses.SignOnPage;
import issPageClasses.ViewAppointment;
import issPageClasses.ViewRequestPage;
import platformIndependentCore.scripts.Arguments;
import platformIndependentCore.scripts.TestScript;
import platformIndependentCore.utilities.ConfigProperties;

/**
 * <b>Name :</b> BlackBoxCreateApptDisposition.java
 * <p>
 * <b>Generated :</b> Jun 18, 2024
 * <p>
 * <b>Description :</b>
 * <p>
 *
 * @since Jun 18, 2024
 * @author OITSDCLEWIST
 */
public class BlackBoxCreateApptDisposition extends TestScript {

	/** URL for SSOI login for the active test environment */
	protected static final String BROWSER = ConfigProperties.getValue("BROWSER");

	/**
	 * Main method
	 *
	 * @param args Args
	 */
	public static void main(String[] args) {
		runScript(args);
	}

	@Override
	public void testScript(Arguments args) {
		// TODO ENTER SCRIPT CODE HERE

		// page classes used

		HomePage hp = new HomePage();
		ChangeLocationModalPage clmp = new ChangeLocationModalPage();
		PatientHeaderModalPage phmp = new PatientHeaderModalPage();
		SensitiveRecordModalPage srmp = new SensitiveRecordModalPage();
		PatientRecordFlagsModalPage prfmp = new PatientRecordFlagsModalPage();
		PatientEligibilityModalPage pemp = new PatientEligibilityModalPage();
		PatientPage pp = new PatientPage();
		HeaderModalPage hmp = new HeaderModalPage();
		Resources r = new Resources();
		ApptRequestPage arp = new ApptRequestPage();
		SignOnPage sp = new SignOnPage();
		AppointmentCalendarPage acp = new AppointmentCalendarPage();
		NewApptPage nap = new NewApptPage();
		PreviewPatientLetterModalPage pplmp = new PreviewPatientLetterModalPage();
		CancelApptPage cap = new CancelApptPage();
		ViewAppointment va = new ViewAppointment();
		MissionActEligibleModalPage maemp = new MissionActEligibleModalPage();
		ViewRequestPage vrp = new ViewRequestPage();
		PatientContactModal pcm = new PatientContactModal();
		EditApptRequestPage earp = new EditApptRequestPage();
		hp.loadPage();

		sp.clickSignInWithWindowsAuthentication();
		sleep(10);

		hmp.clickBtnFacilityLocation();
		sleep(3);

		// Select desire facility
		clmp.selectFacilityLocationByName("958: 958 Cheyenne VA Medical Center", "958: 958 Cheyenne VA Medical Center");
		sleep(3);

		// verify you are on the right facility
		vpEquals("Verify the Location", "958: 958 Cheyenne VA Medical Center", hmp.readBtnLblFacilityLocation());

		// enter search string to cause name page to appear
		phmp.setSearchPatientInput("TEST,AKASH");
		sleep(5);

		phmp.selectPatientByName("TEST,AKASH");
		sleep(2);

		// Click on Patient Eligibility Acknowledge Button
		pemp.clickBtnPatientEligibilityAcknowledge();
		sleep(2);

		// click on the Patient button
		hmp.clickBtnPatient();

		// Verify the Appointment Requests table is loaded
		vpEquals("Verify the Appointment Requests table is loaded", true, pp.isAppointmentRequestsTablePresent());

		pp.clickBtnAppointmentRequestsNewRequest();
		pp.clickBtnAppointmentRequestsNewRequestAppt();
		sleep(5);

		// Verify and Click the Service Radio Button
		arp.clickBtnService();

		// Verify and Click the Clinic Radio Button
		arp.clickBtnClinic();

		arp.setSearchClinicInput("AUTO BLACKBOX COUNT");
		sleep(5);

		// select the clinic by name
		arp.selectClinicByName("AUTO BLACKBOX COUNT");
		sleep(5);

		// Verify the clinic was selected
		vpEquals("Verify the clinic was selected", "AUTO BLACKBOX COUNT", arp.readDdlClinicSearchSelected());
		sleep(5);

		// Verify Label "Appointment Type" text
		vpEquals("Appointment Type text is displayed on Appointment Request Page", "Appointment Type (*Required)",
				arp.readLblAppointmentType());

		// Verify Label "Requested By" text
		vpEquals("Requested By text is displayed on Appointment Request Page", "Requested By (*Required)",
				arp.readLblRequestedBy());

		// Verify and Click the Provider Radio Button
		arp.clickBtnProvider();

		// Verify and Click the Patient Radio Button
		arp.clickBtnPatient();

		// Verify Comment Label
		vpEquals("Comments is displayed", "Comments", arp.readLblComments());

		// Type Comment
		arp.setComments("BLACKBOX TESTING");

		// Verify typed Comments
		vpEquals("Comments is displayed", "BLACKBOX TESTING", arp.readComments());

		// Verify the Create Request Button
		vpEquals("The Create Request is diplayed and clickable", false, arp.isBtnCreateRequestEnabled());

		if (arp.isBtnCreateRequestEnabled()) {
			arp.clickBtnCreateRequest();
		} else {
			arp.clickBtnCancel();
		}
		sleep(2);

		// Click Appointment Requests Reset Filter Button
		pp.clickBtnAppointmentRequestsResetFilters();
		// sleep statement
		sleep(3);

		// clicking on the action option from the comment section
		pp.clickAppointmentRequestsColumnHeaderActionsMenu("CLINIC/SERVICE");

		// Click from Request Column Select Filter by Request
		pp.clickLstAppointmentRequestsHeaderActionMenuItem("Filter by CLINIC/SERVICE");

		String filter = r.getFilterType("CLINIC/SERVICE");

		// sending data from CSV file
		pp.setAppointmentRequestsColumnHeaderFilterInput("CLINIC/SERVICE", filter, "AUTO BLACKBOX COUNT");

		// sleep statement
		sleep(3);
		// Press escape key
		r.pressEscapeKey();
		sleep(3);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("APPT");
		// sleep(3);
		pp.clickLstAppointmentRequestsActionsMenuItem("Request", "View");
		// sleep statement
		sleep(10);
		// Verify Appointment For Clinic Label from View APPT Request Page
		vpEquals(" Label Appointment For Clinic is displayed on View APPT Request Page", "Appointment For Clinic",
				vrp.readLblAppointmentForClinic());

		// Verify Data Appointment For Clinic from View APPT Request Page
		vpEquals("Appointment For Clinic data is displayed and verified on View APPT Request Page",
				"AUTO BLACKBOX COUNT", vrp.readDataAppointmentForClinic());
		sleep(3);

		// Verify Comment Label from View APPT Request Page
		vpEquals("Comment is displayed on View APPT Request Page", "Comment", vrp.readLblComment());

		// Verify Comment Data from View APPT Request Page
		vpEquals("Comment data is displayed and verified from View APPT Request Page", "NOTE-0207",
				vrp.readDataComment());
		sleep(3);

		// Verify Requested By Provider Label from View APPT Request Page
		vpEquals("Requested By Provider is displayed on View APPT Request Page", "Requested By",
				vrp.readLblRequestedBy());

		// Verify Requested By Data from View PtCSch Request Page
		vpEquals("Requested By data is displayed and verified from View APPT Request Page", "PATIENT",
				vrp.readDataRequestedBy());
		sleep(3);

		// Verify PID Label from View APPT Request Page
		vpEquals("PID is displayed on View APPT Request Page", "PID", vrp.readLblPID());

		// Verify PID Data from View APPT Request Page
		vpEquals("PID data is displayed and verified from View APPT Request Page", "3/21/2024", vrp.readDataPID());
		sleep(3);

		// Verify Appointment Type Label from View APPT Request Page
		vpEquals("Appointment Type is displayed on View APPT Request Page", "Appointment Type",
				vrp.readLblAppointmentType());

		// Verify Appointment Type Data from View APPT Request Page
		vpEquals("Appointment Type data is displayed and verified from View APPT Request Page", "REGULAR",
				vrp.readDataAppointmentType());
		sleep(3);

		// Verify Close button displays
		vpEquals("Close Button is diplayed and clickable", true, vrp.isBtnCloseDisplayed());
		sleep(5);

		// Close the View PtCSch Request Page
		vrp.clickBtnClose();
		sleep(10);
		// Click Appointment Requests Reset Filter Button
		pp.clickBtnAppointmentRequestsResetFilters();
		// sleep statement
		sleep(3);
		// clicking on the action option from the comment section
		pp.clickAppointmentRequestsColumnHeaderActionsMenu("CLINIC/SERVICE");

		// Click from Request Column Select Filter by Request
		pp.clickLstAppointmentRequestsHeaderActionMenuItem("Filter by CLINIC/SERVICE");

		// sending data from CSV file
		pp.setAppointmentRequestsColumnHeaderFilterInput("CLINIC/SERVICE", filter, "AUTO BLACKBOX COUNT");

		// sleep statement
		sleep(3);
		// Press escape key
		r.pressEscapeKey();
		sleep(3);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("APPT");
		pp.clickLstAppointmentRequestsActionsMenuItem("Request", "Edit");
		// sleep statement

		earp.setNotesTextField("BLACKBOXTESTING");
		sleep(10);

		// sleep(3);
		earp.clickBtnSaveChanges();
		sleep(10);

		pp.clickBtnAppointmentRequestsResetFilters();
		// sleep statement
		sleep(3);
		// clicking on the action option from the comment section
		pp.clickAppointmentRequestsColumnHeaderActionsMenu("CLINIC/SERVICE");

		// Click from Request Column Select Filter by Request
		pp.clickLstAppointmentRequestsHeaderActionMenuItem("Filter by CLINIC/SERVICE");

		// sending data from CSV file
		pp.setAppointmentRequestsColumnHeaderFilterInput("CLINIC/SERVICE", filter, "AUTO BLACKBOX COUNT");

		r.pressEscapeKey();
		sleep(3);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("APPT");
		pp.clickLstAppointmentRequestsActionsMenuItem("Disposition", "Removed/Non-VA Care");
		//// sleep statement
		sleep(10);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("APPT");
		pp.clickLstAppointmentRequestsActionsMenuItem("Disposition", "Death");
		// sleep statement
		sleep(15);
		pp.clickBtnAppointmentRequestsResetFilters();
		// sleep statement
		sleep(3);
		// clicking on the action option from the comment section
		pp.clickAppointmentRequestsColumnHeaderActionsMenu("CLINIC/SERVICE");

		// Click from Request Column Select Filter by Request
		pp.clickLstAppointmentRequestsHeaderActionMenuItem("Filter by CLINIC/SERVICE");

		// sending data from CSV file
		pp.setAppointmentRequestsColumnHeaderFilterInput("CLINIC/SERVICE", filter, "AUTO BLACKBOX COUNT");

		r.pressEscapeKey();
		sleep(3);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("APPT");
		pp.clickLstAppointmentRequestsActionsMenuItem("Disposition", "Failure To Respond");
		sleep(15);
		pcm.clickYesButton();
		sleep(10);

		pp.clickAppointmentRequestsActionsRowWithColumnValue("APPT");
		pp.clickLstAppointmentRequestsActionsMenuItem("Disposition", "Removed/No Longer Necessary");
		// sleep statement
		sleep(15);
		pp.clickBtnAppointmentRequestsResetFilters();
		// sleep statement
		sleep(3);
		// clicking on the action option from the comment section
		pp.clickAppointmentRequestsColumnHeaderActionsMenu("CLINIC/SERVICE");

		// Click from Request Column Select Filter by Request
		pp.clickLstAppointmentRequestsHeaderActionMenuItem("Filter by CLINIC/SERVICE");

		// sending data from CSV file
		pp.setAppointmentRequestsColumnHeaderFilterInput("CLINIC/SERVICE", filter, "AUTO BLACKBOX COUNT");

		r.pressEscapeKey();
		sleep(3);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("APPT");
		pp.clickLstAppointmentRequestsActionsMenuItem("Disposition", "Removed/Scheduled-Assigned");
		//// sleep statement
		sleep(10);

		pp.clickBtnAppointmentRequestsResetFilters();
		// sleep statement
		sleep(3);
		// clicking on the action option from the comment section
		pp.clickAppointmentRequestsColumnHeaderActionsMenu("CLINIC/SERVICE");

		// Click from Request Column Select Filter by Request
		pp.clickLstAppointmentRequestsHeaderActionMenuItem("Filter by CLINIC/SERVICE");

		// sending data from CSV file
		pp.setAppointmentRequestsColumnHeaderFilterInput("CLINIC/SERVICE", filter, "AUTO BLACKBOX COUNT");

		r.pressEscapeKey();
		sleep(3);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("APPT");
		pp.clickLstAppointmentRequestsActionsMenuItem("Disposition", "Removed/VA Contract Care");
		//// sleep statement
		sleep(20);
	}

}
