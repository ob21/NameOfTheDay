package com.obriand.prenomdujour;

import android.provider.BaseColumns;

public class Item implements BaseColumns {
	
    private Item() {}
    
    public static final String ITEM_ID = "ITEM_ID";
    public static final String ITEM_NAME = "ITEM_NAME";
    public static final String ITEM_ORIGIN = "ITEM_ORIGIN";
    public static final String ITEM_FREQUENCY = "ITEM_FREQUENCY";
    public static final String ITEM_GENDER = "ITEM_GENDER";

}
