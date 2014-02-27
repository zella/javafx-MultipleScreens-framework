package com.zella.mdiframework;

/**
 * 
 * @author Andrey Zelyaev
 */
public interface IControlledScreen {

	// This method will allow the injection of the Parent
	public void setScreenParent(AbstractScreenController screenController);
}
