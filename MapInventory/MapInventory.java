import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapInventory {
    public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        if (inventory.get(productId) == null) {
            return -1;
        } else {
            return inventory.get(productId);
        }
    }

    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        List<String> res = new ArrayList<>();
        inventory.forEach((key, value) -> {
            if (value.equals(price)) {
                res.add(key);
            }
        });
        return res;
    }
}