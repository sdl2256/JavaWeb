package com.landsea.bdb;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.ClassCatalog;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.collections.StoredEntrySet;
import com.sleepycat.collections.StoredSortedMap;

/**
 * Created by SDL on 2015/9/17.
 */
public class SampleViews {
    private StoredSortedMap partMap;
    private StoredSortedMap supplierMap;
    private StoredSortedMap shipmentMap;

    public SampleViews(SampleDatabase db) {
        ClassCatalog catalog = db.getClassCatalog();
        EntryBinding partKeyBinding =
                new SerialBinding(catalog, PartKey.class);
        EntryBinding partDataBinding =
                new SerialBinding(catalog, PartData.class);
        EntryBinding supplierKeyBinding =
                new SerialBinding(catalog, SupplierKey.class);
        EntryBinding supplierDataBinding =
                new SerialBinding(catalog, SupplierData.class);
        EntryBinding shipmentKeyBinding =
                new SerialBinding(catalog, ShipmentKey.class);
        EntryBinding shipmentDataBinding =
                new SerialBinding(catalog, ShipmentData.class);

        partMap =
                new StoredSortedMap(db.getPartDatabase(),
                        partKeyBinding, partDataBinding, true);
        supplierMap =
                new StoredSortedMap(db.getSupplierDatabase(),
                        supplierKeyBinding, partDataBinding, true);
        shipmentMap =
                new StoredSortedMap(db.getShipmentDatabase(),
                        shipmentKeyBinding, partDataBinding, true);


    }

    public final StoredSortedMap getPartMap() {
        return partMap;
    }

    public final StoredSortedMap getSupplierMap() {
        return supplierMap;
    }

    public final StoredSortedMap getShipmentMap() {
        return shipmentMap;
    }

    public final StoredEntrySet getPartEntrySet() {
        return (StoredEntrySet) partMap.entrySet();
    }

    public final StoredEntrySet getSupplierEntrySet() {
        return (StoredEntrySet) supplierMap.entrySet();
    }

    public final StoredEntrySet getShipmentEntrySet() {
        return (StoredEntrySet) shipmentMap.entrySet();
    }
}
