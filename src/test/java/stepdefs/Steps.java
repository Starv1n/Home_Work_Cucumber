package stepdefs;

import com.avito.Categories;
import com.avito.ChooseElements;
import com.avito.MoneyFilter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import utilities.Driver;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

public class Steps {

    @ParameterType(".*")
    public Categories categories(String category) {
        return Categories.valueOf(category);
    }

    @ParameterType(".*")
    public MoneyFilter moneyFilter(String filter) {
        return MoneyFilter.valueOf(filter);
    }

    @Before
    public void initDriver() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void closeDriver() {
        Driver.closeDriver();
    }


    @Пусть("открыт ресурс Авито")
    public void открыт_ресурс_авито() {
        Driver.getDriver().get("https://www.avito.ru/");
    }

    @Пусть("в выпадающием списке категорий выбрана {categories}")
    public void в_выпадающием_списке_категорийвыбрана_оргтехника(Categories category) {
        ChooseElements.selectFromList(category.value, ChooseElements.selectCategory());
    }

    @Пусть("^в поле поиска введено значение (.*)$")
    public void в_поле_поиска_введено_значение_принтер(String string) {
        ChooseElements.printInSearchTextField().sendKeys(string);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void кликнуть_по_выпадающему_списку_региона() {
        ChooseElements.clickChooseRegion().click();
    }

    @Тогда("^в поле региона введено значение (.*)$")
    public void в_поле_региона_введено_значение_владивосток(String string) {
        ChooseElements.printInLocationTextField().sendKeys(string + Keys.ENTER);
        ChooseElements.chooseFirstLocationOption().click();
    }

    @Тогда("нажата кнопка показать объявления")
    public void нажата_кнопка_показать_объявления() {
        ChooseElements.clickShowResultsButton().click();
    }

    @Тогда("^открыласть страница результатов по запросу (.*)$")
    public void открыласть_страница_результатов_по_запросу_принтер(String string) throws UnsupportedEncodingException{
        Assert.assertTrue(ChooseElements.checkIfSiteOpened(string));
    }

    @Тогда("активирован чекбокс только с фотографией")
    public void активирован_чекбокс_только_с_фотографией() {
        ChooseElements.clickCheckBoxWithPhoto().click();
    }

    @Тогда("в выпадающем списке сортировки выбрано {moneyFilter}")
    public void в_выпадающем_списке_сортировки_выбрано_дороже(MoneyFilter moneyFilter) {
        ChooseElements.selectFromList(moneyFilter.value, ChooseElements.selectMoneyFilter());
    }

    @Тогда("^в консоль выведено название и цена (\\d+) первых товаров$")
    public void в_консоль_выведено_название_и_цена_первых_товаров(Integer int1) {
        ChooseElements.printNameANdPrice(int1);
    }
}
