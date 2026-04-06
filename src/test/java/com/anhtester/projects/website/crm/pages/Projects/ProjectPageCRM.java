package com.anhtester.projects.website.crm.pages.Projects;

import com.anhtester.common.CommonPageCRM;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class ProjectPageCRM extends CommonPageCRM {

    public ProjectPageCRM() {
    }


    //Project Page Element
    private By searchInput = By.xpath("//input[@type='search']");

    public void searchByValue(String value) {
        WebUI.clearText(searchInput);
        WebUI.setText(searchInput, value);
        WebUI.sleep(1);
    }

}
