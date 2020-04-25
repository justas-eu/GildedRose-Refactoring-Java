package com.gildedrose.item;

import com.gildedrose.Item;

import static com.gildedrose.GildedRose.SULFURAS;

public class SellInCounter {

	public static int itemSellInValueAfterDay(final Item item) {

		int sellIn = item.sellIn;

		if (!item.name.equals(SULFURAS)) {
			sellIn = sellIn - 1;
		}
		return sellIn;
	}
}
