package app;

import com.avito.Categories;
import com.avito.Elements;
import com.avito.MoneyFilter;

public class Main {
    public static void main(String[] args) {
        Elements elements = new Elements();

        elements.initDriver();
        elements.openAvito();
        elements.selectCategory(Categories.Оргтехника_и_расходники);
        elements.printInSearchTextField("принтер");
        elements.clickChooseRegion();
        elements.printInLocationTextField("Владивосток");
        elements.clickShowResultsButton();
        elements.clickCheckBoxWithPhoto();
        elements.selectMoneyFilter(MoneyFilter.Дороже);
        elements.printNameANdPrice(3);
        elements.closeDriver();
    }
}
