package online.dwViews;

import io.dropwizard.views.View;

/**
 * Each HTML page that is specified in GameWebPagesResource first needs a class that extends
 * View, which is Dropwizard's internal representation of the page. This then points to a
 * separate file found in the resource directory that contains the actual HTML/Javascript.
 * 
 * Note: The HTML/Javascript file is actually a freemarker file.
 */
public class NewTeamScreenView extends View {

	/**
	 * Simple Constructor method, it simply specifies where the HTML page is to return.
	 */
    public NewTeamScreenView() {
        super("NewTeamScreen.ftl");
    }

}
