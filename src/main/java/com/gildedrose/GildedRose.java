package com.gildedrose;

class GildedRose {

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

			int newSellIn = itemSellInValueAfterDay(items[i]);
			items[i].sellIn = newSellIn;
		}
	}



	int itemSellInValueAfterDay(final Item item) {

	    int sellIn = item.sellIn;

		if (!item.name.equals(SULFURAS)) {
            sellIn = sellIn - 1;
		}
		return sellIn;
	}

	public void setItems(final Item[] items) {
		this.items = items;
	}
}
