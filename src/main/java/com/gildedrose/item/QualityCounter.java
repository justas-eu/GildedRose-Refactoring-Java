package com.gildedrose.item;

import com.gildedrose.Item;

import static com.gildedrose.GildedRose.AGED_BRIE;
import static com.gildedrose.GildedRose.BACKSTAGE_PASSES;
import static com.gildedrose.GildedRose.SULFURAS;

public class QualityCounter {

	public static int itemQualityAfterDay(final Item item) {

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

}
