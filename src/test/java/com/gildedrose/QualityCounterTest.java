package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityCounterTest {

	@Test
	void aged_brie_quality_should_increase() {
		Item agedBrieItem = new Item(GildedRose.AGED_BRIE, 1, 0);
		GildedRose app = new GildedRose();
		assertEquals(1, QualityCounter.itemQualityAfterDay(agedBrieItem));
	}

	@Test
	void aged_brie_quality_should_increase_twice_after_sell_in_0() {
		Item agedBrieItem = new Item(GildedRose.AGED_BRIE, 0, 0);
		GildedRose app = new GildedRose();
		assertEquals(2, QualityCounter.itemQualityAfterDay(agedBrieItem));
	}

	@Test
	void aged_brie_quality_should_not_gt_50() {
		Item agedBrieItem = new Item(GildedRose.AGED_BRIE, 0, 50);
		GildedRose app = new GildedRose();
		assertEquals(50, QualityCounter.itemQualityAfterDay(agedBrieItem));
	}
}
