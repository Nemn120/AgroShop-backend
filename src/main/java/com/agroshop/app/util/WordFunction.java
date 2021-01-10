package com.agroshop.app.util;

import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordFunction {
	
	private WordFunction() {
		
	}

	public static void setearParrafoSubrayadoYNegrita(XWPFRun run, String texto) {
		run.setText(texto);
		run.setFontFamily(Constants.ARIAL_FONT);
		run.setFontSize(12);
		run.setBold(true);
		run.setUnderline(UnderlinePatterns.SINGLE);
	}

	public static void setearParrafoNegrita(XWPFRun run, String texto) {
		run.setText(texto);
		run.setBold(true);
		run.setFontFamily(Constants.ARIAL_FONT);
		run.setFontSize(12);
	}

	public static void setearParrafoNormal(XWPFRun run, String texto) {
		run.setText(texto);
		run.setFontFamily(Constants.ARIAL_FONT);
		run.setFontSize(12);
	}

	public static void setearTitulo(XWPFRun run, String texto) {
		run.setBold(true);
		run.setText(texto);
		run.setFontFamily(Constants.ARIAL_FONT);
		run.setFontSize(15);
	}
}
