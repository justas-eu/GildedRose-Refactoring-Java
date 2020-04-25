package com.gildedrose.item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityCounterSulfurasTest {

	@Test
	void quality_should_not_change() {
		Item sulfuras = new Item(GildedRose.SULFURAS, 1, 1);
		assertEquals(1, QualityCounter.itemQualityAfterDay(sulfuras));
	}
}
