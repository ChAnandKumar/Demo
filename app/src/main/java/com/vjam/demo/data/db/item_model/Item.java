package com.vjam.demo.data.db.item_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by anand.chandaliya on 27-03-2017.
 */
@Entity(nameInDb = "items")
public class Item {
    /*
    1.Name of the item
    2.Details
    3.Price
    4.Category
    5.Color
    6.Fav
    7.In Stock
    8.Item Id
    9.Trending*/

    /**
     * id
     * item_name
     * item_id
     * item_details
     * item_category
     * item_price
     * item_color
     * is_item_fav
     * is_item_in_stock
     * is_item_trending
     * item_image
     * item_delivery_charges
     * item_avg_rating
     * item_no_of_reviews
     * item_no_of_ratings
     */

    @Expose
    @SerializedName("id")
    @Id(autoincrement = true)
    private Long keyId;

    @Expose
    @SerializedName("item_name")
    @Property(nameInDb = "item_name")
    private String itemName;

    @Expose
    @Unique
    @NotNull
    @SerializedName("item_id")
    @Property(nameInDb = "item_id")
    private String itemId;

    @Expose
    @SerializedName("item_details")
    @Property(nameInDb = "item_details")
    private String itemDetails;

    @Expose
    @SerializedName("item_category")
    @Property(nameInDb = "item_category")
    private String itemCategory;

    @Expose
    @SerializedName("item_price")
    @Property(nameInDb = "item_price")
    private int itemPrice;

    @Expose
    @SerializedName("item_color")
    @Property(nameInDb = "item_color")
    private String itemColor;

    @Expose
    @SerializedName("is_item_fav")
    @Property(nameInDb = "is_item_fav")
    private Boolean isItemFav;

    @Expose
    @SerializedName("is_item_in_stock")
    @Property(nameInDb = "is_item_in_stock")
    private Boolean isItemInStock;

    @Expose
    @SerializedName("is_item_trending")
    @Property(nameInDb = "is_item_trending")
    private String isItemTrending;

    @Expose
    @SerializedName("item_image")
    @Property(nameInDb = "item_image")
    private String itemImage;

    @Expose
    @SerializedName("item_delivery_charges")
    @Property(nameInDb = "item_delivery_charges")
    private String itemDeliveryCharges;

    @Expose
    @SerializedName("item_avg_rating")
    @Property(nameInDb = "item_avg_rating")
    private String itemAvgRating;

    @Expose
    @SerializedName("item_no_of_reviews")
    @Property(nameInDb = "item_no_of_reviews")
    private int itemNoOfReviews;

    @Expose
    @SerializedName("item_no_of_ratings")
    @Property(nameInDb = "item_no_of_ratings")
    private int itemNoOfRatings;

    @Expose
    @SerializedName("item_added_to_cart")
    @Property(nameInDb = "item_added_to_cart")
    private boolean isItemAddedToCart;

    @Expose
    @SerializedName("item_cont_in_cart")
    @Property(nameInDb = "item_cont_in_cart")
    private int itemContInCart;


    @Generated(hash = 165522190)
    public Item(Long keyId, String itemName, @NotNull String itemId, String itemDetails, String itemCategory,
            int itemPrice, String itemColor, Boolean isItemFav, Boolean isItemInStock, String isItemTrending,
            String itemImage, String itemDeliveryCharges, String itemAvgRating, int itemNoOfReviews,
            int itemNoOfRatings, boolean isItemAddedToCart, int itemContInCart) {
        this.keyId = keyId;
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemDetails = itemDetails;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.itemColor = itemColor;
        this.isItemFav = isItemFav;
        this.isItemInStock = isItemInStock;
        this.isItemTrending = isItemTrending;
        this.itemImage = itemImage;
        this.itemDeliveryCharges = itemDeliveryCharges;
        this.itemAvgRating = itemAvgRating;
        this.itemNoOfReviews = itemNoOfReviews;
        this.itemNoOfRatings = itemNoOfRatings;
        this.isItemAddedToCart = isItemAddedToCart;
        this.itemContInCart = itemContInCart;
    }

    

    /*@Generated(hash = 737645935)
    public Item(Long keyId, String itemName, @NotNull String itemId, String itemDetails, String itemCategory,
            int itemPrice, String itemColor, Boolean isItemFav, Boolean isItemInStock, String isItemTrending,
            String itemImage, String itemDeliveryCharges, String itemAvgRating, int itemNoOfReviews,
            int itemNoOfRatings) {
        this.keyId = keyId;
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemDetails = itemDetails;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.itemColor = itemColor;
        this.isItemFav = isItemFav;
        this.isItemInStock = isItemInStock;
        this.isItemTrending = isItemTrending;
        this.itemImage = itemImage;
        this.itemDeliveryCharges = itemDeliveryCharges;
        this.itemAvgRating = itemAvgRating;
        this.itemNoOfReviews = itemNoOfReviews;
        this.itemNoOfRatings = itemNoOfRatings;
    }
*/
    

    /*http://beta.json-generator.com/4knv5Xmnz
       http://www.mocky.io/v2/58da40e30f0000b700d66adc*/

    public Item() {
    }


    public boolean isItemAddedToCart() {
        return isItemAddedToCart;
    }

    public void setItemAddedToCart(boolean itemAddedToCart) {
        isItemAddedToCart = itemAddedToCart;
    }

    public int isItemContInCart() {
        return itemContInCart;
    }

    public void setItemContInCart(int itemContInCart) {
        this.itemContInCart = itemContInCart;
    }

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public Boolean getItemFav() {
        return isItemFav;
    }

    public void setItemFav(Boolean itemFav) {
        isItemFav = itemFav;
    }

    public Boolean getItemInStock() {
        return isItemInStock;
    }

    public void setItemInStock(Boolean itemInStock) {
        isItemInStock = itemInStock;
    }

    public String getIsItemTrending() {
        return isItemTrending;
    }

    public void setIsItemTrending(String isItemTrending) {
        this.isItemTrending = isItemTrending;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemDeliveryCharges() {
        return itemDeliveryCharges;
    }

    public void setItemDeliveryCharges(String itemDeliveryCharges) {
        this.itemDeliveryCharges = itemDeliveryCharges;
    }

    public String getItemAvgRating() {
        return itemAvgRating;
    }

    public void setItemAvgRating(String itemAvgRating) {
        this.itemAvgRating = itemAvgRating;
    }

    public int getItemNoOfReviews() {
        return itemNoOfReviews;
    }

    public void setItemNoOfReviews(int itemNoOfReviews) {
        this.itemNoOfReviews = itemNoOfReviews;
    }

    public int getItemNoOfRatings() {
        return itemNoOfRatings;
    }

    public void setItemNoOfRatings(int itemNoOfRatings) {
        this.itemNoOfRatings = itemNoOfRatings;
    }

    public Boolean getIsItemFav() {
        return this.isItemFav;
    }

    public void setIsItemFav(Boolean isItemFav) {
        this.isItemFav = isItemFav;
    }

    public Boolean getIsItemInStock() {
        return this.isItemInStock;
    }

    public void setIsItemInStock(Boolean isItemInStock) {
        this.isItemInStock = isItemInStock;
    }

    public boolean getIsItemAddedToCart() {
        return this.isItemAddedToCart;
    }

    public void setIsItemAddedToCart(boolean isItemAddedToCart) {
        this.isItemAddedToCart = isItemAddedToCart;
    }

    public int getItemContInCart() {
        return this.itemContInCart;
    }
}
