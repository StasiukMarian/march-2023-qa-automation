package base.pages;

import base.core.PageTools;
import org.openqa.selenium.By;

public class DetailItemPage extends PageTools {
    private final By header = By.xpath("//div[contains(@class, 'inventory_details_name')]");
    private final By description = By.xpath("(//div[contains(@class, 'inventory_details_desc')])[2]");
    private final By price = By.xpath("//div[contains(@class, 'inventory_details_price')]");

    public Item getDetailItem() {
        Item item = new Item();

        item.setName(getElementText(header));
        item.setDescription(getElementText(description));
        item.setPrice(getElementText(price));
        return item;
    }
}
