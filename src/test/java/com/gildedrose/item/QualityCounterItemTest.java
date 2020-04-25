package com.gildedrose.item;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityCounterItemTest {

	@Test
	void quality_should_decrease() {
		Item item = new Item("Any item", 5, 5);
		assertEquals(4, QualityCounter.itemQualityAfterDay(item));
	}

	@Test
	void quality_should_decrease_by_two_after_sell_in_0() {
		Item item = new Item("Any item", -1, 4);
		assertEquals(2, QualityCounter.itemQualityAfterDay(item));
	}


	@Test
	void quality_should_not_be_negative() {
		Item item = new Item("Any item", -1, 0);
		assertEquals(0, QualityCounter.itemQualityAfterDay(item));
	}
}
