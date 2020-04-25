package com.gildedrose.item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SellInCounterTest {

	@Test
	public void aged_brie_sell_in_decreases() {
		Item agedBrieItem = new Item(GildedRose.AGED_BRIE, 1, 0);
		assertEquals(0, SellInCounter.itemSellInValueAfterDay(agedBrieItem));
	}

	@Test
	public void backstage_passes_sell_in_decreases() {
		Item backstagePassesItem = new Item(GildedRose.BACKSTAGE_PASSES, 1, 0);
		assertEquals(0, SellInCounter.itemSellInValueAfterDay(backstagePassesItem));
	}

	@Test
	public void sulfuras_sell_in_constant() {
		Item sulfuras = new Item(GildedRose.SULFURAS, 1, 0);
		assertEquals(1, SellInCounter.itemSellInValueAfterDay(sulfuras));
	}

	@Test
	public void conjured_sell_in_decreases() {
		Item conjured = new Item(GildedRose.CONJURED, 1, 0);
		assertEquals(0, SellInCounter.itemSellInValueAfterDay(conjured));
	}

	@Test
	public void item_sell_in_decreases() {
		Item item = new Item("Any item", 1, 0);
		assertEquals(0, SellInCounter.itemSellInValueAfterDay(item));
	}
}
