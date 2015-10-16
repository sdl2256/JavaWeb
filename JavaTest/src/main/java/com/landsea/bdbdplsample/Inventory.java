package com.landsea.bdbdplsample;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.SecondaryKey;

import static com.sleepycat.persist.model.Relationship.*;

/**
 * Created by SDL on 2015/9/17.
 */
@Entity
public class Inventory {
    // Primary key is sku
    @PrimaryKey
    private String sku;

    // Secondary key is the itemName
    @SecondaryKey(relate = MANY_TO_ONE)
    private String itemName;

    private String category;
    private String vendor;
    private int vendorInventory;
    private float vendorPrice;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getVendorInventory() {
        return vendorInventory;
    }

    public void setVendorInventory(int vendorInventory) {
        this.vendorInventory = vendorInventory;
    }

    public float getVendorPrice() {
        return vendorPrice;
    }

    public void setVendorPrice(float vendorPrice) {
        this.vendorPrice = vendorPrice;
    }
}
