package com.gildedrose.item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityCounterBackstagePassesTest {

	@Test
	void quality_should_increase() {
		Item backstagePassesItem = new Item(GildedRose.BACKSTAGE_PASSES, 100, 0);
		assertEquals(1, QualityCounter.itemQualityAfterDay(backstagePassesItem));
	}

	@Test
	void quality_should_increase_3_sell_in_between_0_and_5() {
		Item backstagePassesItem = new Item(GildedRose.BACKSTAGE_PASSES, 1, 0);
		assertEquals(3, QualityCounter.itemQualityAfterDay(backstagePassesItem));
	}

	@Test
	void quality_should_increase_twice_sell_in_between_5_and_10() {
		Item backstagePassesItem = new Item(GildedRose.BACKSTAGE_PASSES, 6, 0);
		assertEquals(2, QualityCounter.itemQualityAfterDay(backstagePassesItem));
	}

	@Test
	void quality_should_be_zero_after_sell_in_zero() {
		Item backstagePassesItem = new Item(GildedRose.BACKSTAGE_PASSES, 0, 10);
		assertEquals(0, QualityCounter.itemQualityAfterDay(backstagePassesItem));
	}

	@Test
	void quality_should_not_gt_50() {
		Item backstagePassesItem = new Item(GildedRose.BACKSTAGE_PASSES, 1, 50);
		assertEquals(50, QualityCounter.itemQualityAfterDay(backstagePassesItem));
	}
}
