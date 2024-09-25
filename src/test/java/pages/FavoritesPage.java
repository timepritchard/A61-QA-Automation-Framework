package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavoritesPage extends BasePage {
    public FavoritesPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Elements
    By noFavoritesYetText = By.xpath("//section[@id='favoritesWrapper']//div[@class='text' and contains(., 'No favorites yet.')]");

// Helper methods

    public void removeFavorite(String favorite) {
        By removeLiked = By.xpath("//div[contains(@class, 'song-list-wrap main-scroll-wrap favorites')]//button[contains(@title, 'Unlike') and contains(@title, '" + favorite + "')]");
        findElement(removeLiked).click();
    }

    public boolean newFavoriteAdded(String song) {
        // added the .size so it knows its supposed to not find the element
        try {
            return driver.findElements(By.xpath("//td[contains(text(), '" + song + "')]")).size() > 0;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement noFavoritesYet(){
        return findElement(noFavoritesYetText);
    }
}


