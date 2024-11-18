package issPageClasses;

import platformIndependentCore.core.AutomatedObject;
import platformIndependentCore.core.Search;

/**
 * <b>Name :</b> PatientContactModal.java
 * <p>
 * <b>Generated :</b> Jul 1, 2024
 * <p>
 * <b>Description :</b>
 * <p>
 *
 * @since Jul 1, 2024
 * @author OITSDCLEWIST
 */
public class PatientContactModal extends IssBase {

	/**
	 * @param args
	 */
	public PatientContactModal() {
	}

	/**
	 * page classes and resources
	 */
	Resources r = new Resources();

	/**
	 * get the Clinic Stop Code Modal form object.
	 *
	 * @return object
	 */
	private AutomatedObject getPatientsContactModal() {
		return getObjectById("contact-attempt-notification-modal");
	}

	/**
	 * get the Sensitive Record Modal form Shadow Root.
	 *
	 * @return object
	 */
	private AutomatedObject getShadowRootSensitiveRecordModal() {
		return getPatientsContactModal();
	}

	/**
	 * @return get close button
	 */
	public AutomatedObject getYesButton() {
		Search search = getSearch();
		search.setShadowRoot(getPatientsContactModal());
		search.addCriteria("css", "#modal-primary-button");

		return getObject(search);
		// return getObjectById("modal-primary-button");
	}

	/**
	 * click close button
	 */
	public void clickYesButton() {
		getYesButton().click();
	}

	/**
	 * @return get close button
	 */
	public AutomatedObject getNoButton() {
		Search search = getSearch();

		search.addCriteria("css", "#modal-secondary-button");

		return getObject(search);
	}

	/**
	 * click close button
	 */
	public void clickNoButton() {
		getNoButton().click();
	}

	/**
	 * @return get close button
	 */
	public AutomatedObject getCloseIcon() {
		Search search = getSearch();

		search.addCriteria("css", "div > button");
		search.setCacheResult(false);
		return getObject(search);
	}

	/**
	 * click close button
	 */
	public void clickCloseIcon() {
		getCloseIcon().click();
	}

}
