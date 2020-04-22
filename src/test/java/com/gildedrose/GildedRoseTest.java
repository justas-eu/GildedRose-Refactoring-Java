package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void aged_brie_quality_should_increase() {
        Item agedBrieItem = new Item(GildedRose.AGED_BRIE, 1, 0);
        GildedRose app = new GildedRose();
        assertEquals(1, app.itemQualityAfterDay(agedBrieItem));
    }

    @Test
    void aged_brie_quality_should_increase_twice_after_sell_in_0() {
        Item agedBrieItem = new Item(GildedRose.AGED_BRIE, 0, 0);
        GildedRose app = new GildedRose();
        assertEquals(2, app.itemQualityAfterDay(agedBrieItem));
    }

}
