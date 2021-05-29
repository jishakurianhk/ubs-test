package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * Create a map of Furniture items to order quantities
     */
	private final HashMap<Furniture, Integer> furnitureItems;
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
    	furnitureItems = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        
    	Integer count = 0;
    	if(furnitureItems.containsKey(type)) {
    		count = furnitureItems.get(type);
    	}
    	furnitureItems.put(type, count + furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
       
    	return new HashMap<Furniture, Integer> (furnitureItems);
    }

    public float getTotalOrderCost() {

    	float totalCost = 0.0f;
    	if(!furnitureItems.isEmpty()) {
    		for(Map.Entry<Furniture, Integer> entry: furnitureItems.entrySet()) {
    			Furniture ftype = entry.getKey();
    			totalCost += (furnitureItems.get(ftype) * ftype.cost());
    		}
    	}
        return totalCost;
    }

    public int getTypeCount(Furniture type) {

    	if(furnitureItems.containsKey(type)) {
    		return furnitureItems.get(type);
    	}
    	
        return 0;
    }

    public float getTypeCost(Furniture type) {

    	if(furnitureItems.containsKey(type)) {
    		return (furnitureItems.get(type) * type.cost());
    	}
    	
        return 0.0f;
    }

    public int getTotalOrderQuantity() {

    	int totalQuantity = 0;
    	if(!furnitureItems.isEmpty()) {
    		
    		for(Map.Entry<Furniture, Integer> entry: furnitureItems.entrySet()) {
    			Furniture ftype = entry.getKey();
    			totalQuantity += (furnitureItems.get(ftype));	
    		}
    	}
    	System.out.println(totalQuantity);
        return totalQuantity;
    }
}