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

			int newQuality = itemQualityAfterDay(items[i]);
			items[i].quality = newQuality;

			int newSellIn = itemSellInValueAfterDay(items[i]);
			items[i].sellIn = newSellIn;
		}
	}

	int itemQualityAfterDay(final Item item) {

		int quality = item.quality;

		if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES)) {
			if (quality > 0) {
				if (!item.name.equals(SULFURAS)) {
					quality = quality - 1;
				}
			}
		} else {
			if (quality < 50) {
				quality = quality + 1;

				if (item.name.equals(BACKSTAGE_PASSES)) {
					if (item.sellIn < 11) {
						if (quality < 50) {
							quality = quality + 1;
						}
					}

					if (item.sellIn < 6) {
						if (quality < 50) {
							quality = quality + 1;
						}
					}
				}
			}
		}

		if (item.sellIn <= 0) {
			if (!item.name.equals(AGED_BRIE)) {
				if (!item.name.equals(BACKSTAGE_PASSES)) {
					if (quality > 0) {
						if (!item.name.equals(SULFURAS)) {
							quality = quality - 1;
						}
					}
				} else {
					quality = quality - quality;
				}
			} else {
				if (quality < 50) {
					quality = quality + 1;
				}
			}
		}
		return quality;
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
