package com.gildedrose.item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityCounterConjuredTest {

	@Test
	void quality_should_decrease_by_two() {
		Item conjuredItem = new Item(GildedRose.CONJURED, 1, 4);
		assertEquals(2, QualityCounter.itemQualityAfterDay(conjuredItem));
	}

	@Test
	void quality_should_decrease_by_four_after_sell_in_0() {
		Item conjuredItem = new Item(GildedRose.CONJURED, 0, 8);
		assertEquals(4, QualityCounter.itemQualityAfterDay(conjuredItem));
	}

	@Test
	void quality_should_not_be_negative() {
		Item conjuredItem = new Item(GildedRose.CONJURED, -1, 0);
		assertEquals(0, QualityCounter.itemQualityAfterDay(conjuredItem));
	}
}
