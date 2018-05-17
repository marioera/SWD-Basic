package com.swdbasic.fundamentals;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TestClipBoard {

	public static void main(String[] args) {
		String h = "Hola Mundo";
		StringSelection selection = new StringSelection(h);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
	}
}
