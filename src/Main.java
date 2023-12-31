import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    static File saveFile = new File("basket.txt");

    public static void main(String[] args) throws FileNotFoundException {
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};

        Basket basket = null;
        if(saveFile.exists()){
            basket = Basket.loadFromTxtFile(saveFile);
        } else {
            basket = new Basket(products,prices);
        }


        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + 1 + ". " + products[i] + " " + prices[i] + " руб/шт");
        }


        basket = new Basket(products, prices);
        basket.addToCart(1, 1);
        basket.addToCart(2,1);
        basket.addToCart(3,1);
        basket.saveTxt(saveFile);
        basket.printCart();



    }
}