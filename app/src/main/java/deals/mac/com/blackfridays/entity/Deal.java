package deals.mac.com.blackfridays.entity;

import deals.mac.com.blackfridays.R;

public class Deal {
    private String name;
    private int imageResourceId;
    private double price;
    private String details;
    private String productDescription;



    public static final Deal[] deals = {
        new Deal("galaxy", R.drawable.icon),
        new Deal("xperia", R.drawable.icon)

    };

    public Deal(String name, int imageResourceId, double price, String details, String productDescription) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.price = price;
        this.details = details;
        this.productDescription = productDescription;
    }

    private Deal(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return details;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public static Deal[] getDeals() {
        return deals;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
