package com.gildedrose.item;

import com.gildedrose.Item;

import static com.gildedrose.GildedRose.AGED_BRIE;
import static com.gildedrose.GildedRose.BACKSTAGE_PASSES;
import static com.gildedrose.GildedRose.CONJURED;
import static com.gildedrose.GildedRose.SULFURAS;

public class QualityCounter {

	public static int agedBrieAfterDay(final Item agedBrie) {

		int quality = agedBrie.quality;

		if (quality < 50) {
			quality = quality + 1;
			if (agedBrie.sellIn <= 0) {
				quality = quality + 1;
			}
		}
		return quality;
	}

	public static int backstagePassesAfterDay(final Item backstagePass) {

		int quality = backstagePass.quality;

		if (quality < 50 && backstagePass.sellIn > 0) {
			quality = quality + 1;
			if (backstagePass.sellIn < 11) {
				if (quality < 50) {
					quality = quality + 1;
				}
			}

			if (backstagePass.sellIn < 6) {
				if (quality < 50) {
					quality = quality + 1;
				}
			}
		}
		if (backstagePass.sellIn <= 0) {
			quality = 0;
		}
		return quality;
	}


	private static int sulfurasAfterDay(final Item sulfuras) {
		return sulfuras.quality;
	}

	private static int conjuredAfterDay(final Item conjured) {

		int quality = conjured.quality;

		if (quality < 50) {
			quality = quality - 2;
			if (conjured.sellIn <= 0) {
				quality = quality - 2;
			}
		}
		if (quality < 0) quality = 0;
		return quality;
	}

	public static int itemQualityAfterDay(final Item item) {

		if (item.name.equals(AGED_BRIE)) return agedBrieAfterDay(item);
		if (item.name.equals(BACKSTAGE_PASSES)) return backstagePassesAfterDay(item);
		if (item.name.equals(SULFURAS)) return sulfurasAfterDay(item);
		if (item.name.equals(CONJURED)) return conjuredAfterDay(item);

		int quality = item.quality;
		if (quality > 0) {
			quality = quality - 1;
			if (item.sellIn <= 0) {
				quality = quality - 1;
			}
		}
		return quality;
	}

}
