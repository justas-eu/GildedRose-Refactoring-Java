package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityCounterSulfurasTest {

	@Test
	void sulfuras_quality_should_not_change() {
		Item sulfuras = new Item(GildedRose.SULFURAS, 1, 1);
		assertEquals(1, QualityCounter.itemQualityAfterDay(sulfuras));
	}
}
