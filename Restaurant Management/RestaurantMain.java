import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class FoodItem {
    private String name;
    private int price;
    private String foodType;

    public FoodItem(String name, int price, String foodType) {
        this.name = name;
        this.price = price;
        this.foodType = foodType;
    }

    public String toString() {
        return name + " | " + foodType + " | " + price;
    }
}

class Order {
    private static final Random random = new Random();
    private int orderId;
    private int tableNo;
    private FoodItem foodItem;

    public Order(FoodItem foodItem, int tableNo) {
        this.orderId = 1000 + random.nextInt(9000);
        this.foodItem = foodItem;
        this.tableNo = tableNo;
    }

    public int getOrderId() {
        return orderId;
    }

    public FoodItem getFoodItemDetail() {
        return foodItem;
    }

    public int getTableNo() {
        return tableNo;
    }

    public String getOrderedItem() {
        return "----Order----" + "\nOrder Id : " + orderId + "\nTable No : " + tableNo + "\nFood Item : " + foodItem;
    }
}

class Menu {
    List<FoodItem> menuItems = new ArrayList<>();

    public void updateMenuItems(FoodItem dish) {
        menuItems.add(dish);
    }

    public void showMenu() {
        System.out.println("-------MENU-------");
        for (FoodItem f : menuItems) {
            System.out.println(f.toString());
        }
    }
}

class Restaurant {
    List<Order> orderList = new ArrayList<>();
    Menu menu = new Menu();

    public void placeOrder(Order order) {
        orderList.add(order);
    }

    public void showOrderList() {
        System.out.println("-------Order List-------");

        for (Order o : orderList) {
            System.out.println(o.getOrderedItem());
        }
    }

    public void cancelOrder(int orderId) {
        for (Order o : orderList) {
            if (o.getOrderId() == orderId) {
                orderList.remove(o);
                System.out
                        .println("Order cancelled successfully : " + "\nOrder Id : " + o.getOrderId()
                                + "\nItem Detail : "
                                + o.getFoodItemDetail().toString());
                break;
            }
        }
    }

    public Menu getMenu() {
        return menu;
    }

}

public class RestaurantMain {
    public static void main(String[] args) {
        FoodItem dish1 = new FoodItem("Pizza", 500, "Italian");
        FoodItem dish2 = new FoodItem("Pasta", 300, "Italian");
        FoodItem dish3 = new FoodItem("Dal Bati Churma", 800, "Rajasthani");
        FoodItem dish4 = new FoodItem("Paneer Chilly", 400, "Chinese");
        FoodItem dish5 = new FoodItem("Dosa", 700, "South Indian");
        Restaurant hariVedas = new Restaurant();
        hariVedas.menu.updateMenuItems(dish1);
        hariVedas.menu.updateMenuItems(dish2);
        hariVedas.menu.updateMenuItems(dish3);
        hariVedas.menu.updateMenuItems(dish4);
        hariVedas.menu.updateMenuItems(dish5);

        hariVedas.menu.showMenu();

        Order o1 = new Order(dish3, 10);
        hariVedas.placeOrder(o1);
        hariVedas.showOrderList();

    }
}
