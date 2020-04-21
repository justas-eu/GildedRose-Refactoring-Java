package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenMasterTest {

	@Test
	public void validate_golden_master_output() throws IOException {

		assertEquals(goldenMasterContent(), originalTestFixture());

	}

	private String goldenMasterContent() throws IOException {
		String path = this.getClass().getClassLoader().getResource("GoldenMasterOutput99Days.txt").getPath();
		String fileContent = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		return fileContent;
	}

	public String originalTestFixture() {

		StringBuilder output = new StringBuilder();
		String newline = "\n";

		output.append("OMGHAI!").append(newline);

		Item[] items = new Item[] {
				new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		int days = 99;

		for (int i = 0; i < days; i++) {
			output.append("-------- day " + i + " --------").append(newline);
			output.append("name, sellIn, quality").append(newline);
			for (Item item : items) {
				output.append(item).append(newline);
			}
			output.append(newline);
			app.updateQuality();
		}

		return output.toString();
	}

}
