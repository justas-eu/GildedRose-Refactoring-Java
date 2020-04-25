package com.gildedrose;

import com.gildedrose.item.QualityCounter;
import com.gildedrose.item.SellInCounter;

public class GildedRose {

	public static final String AGED_BRIE = "Aged Brie";
	public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

	Item[] items;

	public GildedRose() {};
	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {

			int newQuality = QualityCounter.itemQualityAfterDay(items[i]);
			items[i].quality = newQuality;

			int newSellIn = SellInCounter.itemSellInValueAfterDay(items[i]);
			items[i].sellIn = newSellIn;
		}
	}

	public void setItems(final Item[] items) {
		this.items = items;
	}
}
