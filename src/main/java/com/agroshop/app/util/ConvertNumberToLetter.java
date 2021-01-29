package com.agroshop.app.util;

public class ConvertNumberToLetter {
	private final String[] unidades = { "", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ",
			"nueve " };
	private final String[] decenas = { "diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
			"diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ", "cincuenta ", "sesenta ",
			"setenta ", "ochenta ", "noventa " };
	private final String[] centenas = { "", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ",
			"seiscientos ", "setecientos ", "ochocientos ", "novecientos " };

	public String convertir(String numero, boolean mayusculas) {
		String literal = "";
		String parteDecimal="";
		numero = numero.replace(".", ",");
		if (numero.indexOf(",") == -1) {
			numero = numero + ",00";
		}

		String[] num = numero.split(",");
		parteDecimal = "y " + num[1] + "/100 Nuevos Soles.";
		if (Integer.parseInt(num[0]) == 0) {
			literal = "cero ";
		} else if (Integer.parseInt(num[0]) > 999999) {
			literal = getMillones(num[0]);
		} else if (Integer.parseInt(num[0]) > 999) {
			literal = getMiles(num[0]);
		} else if (Integer.parseInt(num[0]) > 99) {
			literal = getCentenas(num[0]);
		} else if (Integer.parseInt(num[0]) > 9) {
			literal = getDecenas(num[0]);
		} else {
			literal = getUnidades(num[0]);
		}
		if (mayusculas) {
			return (literal + parteDecimal).toUpperCase();
		} else {
			return (literal + parteDecimal);
		}
	}

	private String getUnidades(String numero) {
		String num = numero.substring(numero.length() - 1);
		return unidades[Integer.parseInt(num)];
	}

	private String getDecenas(String num) {
		int n = Integer.parseInt(num);
		if (n < 10) {
			return getUnidades(num);
		} else if (n > 19) {
			String u = getUnidades(num);
			if (u.equals("")) {
				return decenas[Integer.parseInt(num.substring(0, 1)) + 8];
			} else {
				return decenas[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
			}
		} else {
			return decenas[n - 10];
		}
	}

	private String getCentenas(String num) {
		if (Integer.parseInt(num) > 99) {
			if (Integer.parseInt(num) == 100) {
				return "cien ";
			} else {
				return centenas[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
			}
		} else {
			return getDecenas(Integer.parseInt(num) + "");
		}
	}

	private String getMiles(String numero) {
		String c = numero.substring(numero.length() - 3);
		String m = numero.substring(0, numero.length() - 3);
		String n = "";
		if (Integer.parseInt(m) > 0) {
			n = getCentenas(m);
			return n + "mil " + getCentenas(c);
		} else {
			return "" + getCentenas(c);
		}

	}

	private String getMillones(String numero) {
		String miles = numero.substring(numero.length() - 6);
		String millon = numero.substring(0, numero.length() - 6);
		String n = "";
		if (millon.length() > 1) {
			n = getCentenas(millon) + "millones ";
		} else {
			n = getUnidades(millon) + "millon ";
		}
		return n + getMiles(miles);
	}

	public static String convertMonth(int day, int nMonth, int year) {
		String month = null;
		switch (nMonth) {
		case (1):
			month = "Enero";
			break;
		case (2):
			month = "Febrero";
			break;
		case (3):
			month = "Marzo";
			break;
		case (4):
			month = "Abril";
			break;
		case (5):
			month = "Mayo";
			break;
		case (6):
			month = "Junio";
			break;
		case (7):
			month = "Julio";
			break;
		case (8):
			month = "Agosto";
			break;
		case (9):
			month = "Setiembre";
			break;
		case (10):
			month = "Octubre";
			break;
		case (11):
			month = "Noviembre";
			break;
		case (12):
			month = "Diciembre";
			break;
		}
		return day + " de " + month + " del " + year;
	}
}
