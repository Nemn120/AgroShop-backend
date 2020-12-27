package com.agroshop.app.util;

public class WordConstant {
	public WordData titulo() {
		WordData titulo = new WordData();
		titulo.setText1("CONTRATO DE RECOJO Y ENTREGA");
		return titulo;
	}
	
	public WordData parrafo1() {
		WordData parrafo = new WordData();
		parrafo.setText1("Conste por el presente contrato que celebran de una parte como ");
		parrafo.setText2("AGRICULTOR(A) ");
		parrafo.setText3("el(la) Señor(a) $agricultor_nombres$ $agricultor_apellidos$ identificado(a) con ");
		parrafo.setText4("DNI N° $dni_agricultor$ ");
		parrafo.setText5(",con domicilio en la $direccion_agricultor$; y de la otra parte como ");
		parrafo.setText6("EL(LA) CONDUCTOR(A) ");
		parrafo.setText7("el señor(a) $conductor_nombre$ $conductor_apellidos$. Identificado(a) con DNI N° "
				+ "$dni_conductor$  y domiciliado(a) en $direccion_conductor$; quienes convienen de mutuo " + 
				"acuerdo y regulado por las leyes vigentes sobre la materia, en los términos y condiciones siguientes:");
		return parrafo;
	}
	
	public WordData subtituloAntecedente() {
		WordData titulo = new WordData();
		titulo.setText1("ANTECEDENTES:");
		return titulo;
	}
	
	public WordData parrafo2() {
		WordData parrafo = new WordData();
		parrafo.setText1("PRIMERA. - EL(LA) CONDUCTOR(A) ");
		parrafo.setText2("es propietario(a) del vehículo identificado con licencia $licencia_vehiculo$"
				+ "del Registro obtenido del ministerio de trasnportes, cuya especificaciones como color, peso y medidas perimétricas "
				+ "se hallan consignadas en el referido documento registral.");
		return parrafo;
	}
	
	public WordData parrafo3() {
		WordData parrafo = new WordData();
		parrafo.setText1("SEGUNDA. - EL(LA) AGRICULTOR(A) ");
		parrafo.setText2("deja constancia que el producto a entregar al que se refiere la cláusula "
				+ "anterior se encuentra en buen estado de conservación y con la calidad y peso que se especifica en el documento, "
				+ "y sin mayor coste adicional que el productor pueda generar por la adición de otros suministros adicionales.");
		return parrafo;
	}
	
	public WordData subtituloObjContrato() {
		WordData parrafo = new WordData();
		parrafo.setText1("OBJETO DEL CONTRATO:");
		return parrafo;
	}
	
	public WordData parrafo4() {
		WordData parrafo = new WordData();
		parrafo.setText1("TERCERA. - ");
		parrafo.setText2("Mediante el presente contrato ");
		parrafo.setText3("EL(LA) AGRICULTOR(A) ");
		parrafo.setText4("da por aceptado al ");
		parrafo.setText5("CONDUCTOR(A), ");
		parrafo.setText6(" el producto especificado en la cláusula primera para destinarlo únicamente a " + 
				"la dirección consignada de envío, el cual es recibido en perfecto estado de operatividad, conforme a lo señalado en " + 
				"la cláusula segunda. Por su parte, el ");
		parrafo.setText7("CONDUCTOR(A) ");
		parrafo.setText8("se obliga a entregar completamente el producto.");
		parrafo.setText9("EL(LA) CLIENTE(A) y a recibir");
		parrafo.setText10("el monto del salario pactada en la cláusula siguiente, en la forma y oportunidad convenidas.");
		return parrafo;
	}
	
	public WordData subituloFormaOportunidad() {
		WordData parrafo = new WordData();
		parrafo.setText1("SALARIO: FORMA Y OPORTUNIDAD DE PAGO:");
		return parrafo;
	}
	
	public WordData parrafo5() {
		WordData parrafo = new WordData();
		parrafo.setText1("CUARTA. - ");
		parrafo.setText2("Las partes acuerdan que el monto del salario que pagará ");
		parrafo.setText3("EL(LA) AGRICULTOR(A), ");
		parrafo.setText4("en calidad de contraprestación por el servicio de reparto de productos, asciende a la suma de S/."
				+ "$monto_salario$ ($monto_salario_letras$), mensuales, cantidad que será cancelada en dinero, en la forma "
				+ "y oportunidad a que se refiere la cláusula siguiente.");
		return parrafo;
	}
	
	public WordData parrafo6() {
		WordData parrafo = new WordData();
		parrafo.setText1("A la firma del presente contrato ");
		parrafo.setText2("EL(LA) AGRICULTOR(A), ");
		parrafo.setText3("entrega al ");
		parrafo.setText4("CONDUCTOR(A) ");
		parrafo.setText5("la suma de S/.$monto_garantia$ ($monto_garantia_letras$) por concepto de garantía del pago, "
				+ "los cuales no generaran intereses ni rentas y serán devueltas a la entrega del bien, "
				+ "previa verificación del cumplimiento de todos los pagos a los que está obligado ");
		parrafo.setText6("el(la) AGRICULTOR(A).");
		return parrafo;
	}
	
	public WordData parrafo7() {
		WordData parrafo = new WordData();
		parrafo.setText1("QUINTA. - ");
		parrafo.setText2("La forma de pago de la renta será por mensualidades adelantadas que el(la) ");
		parrafo.setText3("AGRICULTOR(A) ");
		parrafo.setText4("pagará en la cuenta de ");
		parrafo.setText5("EL(LA) CONDUCTOR(A) ");
		parrafo.setText6("el $dia_pago_mes$ día útil de cada mes.");
		return parrafo;
	}
	
	public WordData subtituloPlazoContrato() {
		WordData parrafo = new WordData();
		parrafo.setText1("PLAZO DEL CONTRATO: ");
		return parrafo;
	}
	
	public WordData parrafo8() {
		WordData parrafo = new WordData();
		parrafo.setText1("SEXTA. - ");
		parrafo.setText2("El plazo del presente contrato es de $tiempo_contrato$ meses, el cual regirá a partir del "
				+ "$fecha_contrato_inicio$ hasta el $fecha_contrato_fin$, a cuyo vencimiento podrá renovarse "
				+ "con el acuerdo de ambas partes, pudiendo variar las condiciones establecidas en el presente "
				+ "contrato, en cuanto al plazo, monto del servicio y uso del mismo.");
		return parrafo;
	}
	
	public WordData subtituloObligaciones() {
		WordData parrafo = new WordData();
		parrafo.setText1("OBLIGACIONES DE LAS PARTES: ");
		return parrafo;
	}
	
	public WordData parrafo9() {
		WordData parrafo = new WordData();
		parrafo.setText1("SÉTIMA. - EL(LA) AGRICULTOR(A) ");
		parrafo.setText2("se obliga a entregar el producto objeto de la prestación para el servicio de envío " + 
				"en la fecha establecida en el presente contrato, la misma que se verificará con la generación del " + 
				"contrato");
		return parrafo;
	}
	
	public WordData parrafo10() {
		WordData parrafo = new WordData();
		parrafo.setText1("OCTAVA. - EL(LA) CONDUCTOR(A) ");
		parrafo.setText2("se obliga a entregar puntualmente el producto destinado al cliente especificado, en la " + 
				"forma, oportunidad y lugar pactados, con sujeción a lo convenido en las cláusulas cuarta y " + 
				"quinta.");
		return parrafo;
	}
	
	public WordData parrafo11() {
		WordData parrafo = new WordData();
		parrafo.setText1("NOVENA. - EL(LA) AGRICULTOR(A) ");
		parrafo.setText2("está obligado a permitir la inspección del producto a enviar por parte del ");
		parrafo.setText3("CONDUCTOR(A), ");
		parrafo.setText4("para cuyo efecto éste deberá cursar previo aviso por escrito, con una anticipación no menor de dos días.");
		return parrafo;
	}
	
	public WordData parrafo12ReparacionArrendatario() {
		WordData parrafo = new WordData();
		parrafo.setText1("DECIMA. - EL(LA) CONDUCTOR(A) ");
		parrafo.setText2("está obligado a efectuar por cuenta y costo " + 
				"propio las reparaciones y mantenimientos que sean necesarios para conservar el vehículo en el " + 
				"mismo estado en que fue contratado.");
		return parrafo;
	}
	
	public WordData parrafo12ReparacionArrendero() {
		WordData parrafo = new WordData();
		parrafo.setText1("DECIMA. - EL(LA) AGRICULTOR(A) ");
		parrafo.setText2("no está obligado a efectuar por cuenta y costo " + 
				"propio las reparaciones y mantenimientos que sean necesarios para conservar el bien en el " + 
				"mismo estado en que fue contratado.");
		return parrafo;
	}
	
	public WordData parrafo13() {
		WordData parrafo = new WordData();
		parrafo.setText1("DECIMO PRIMERA. - EL(LA) CONDUCTOR(A) ");
		parrafo.setText2("no podrá ceder a terceros el vehivulo materia del presente contrato bojo "
				+ "ningún típo de servicio externo, ni alquilarlo, total o parcialmente, ni ceder su "
				+ "posición contractual, salvo que cuente con el consentimiento expreso y por escrito de ");
		parrafo.setText3("EL(LA) AGRICULTOR(A) ");
		parrafo.setText4("en cuyo caso se suscribirán los documentos que fueren necesarios.");
		return parrafo;
	}
	
	public WordData parrafo14() {
		WordData parrafo = new WordData();
		parrafo.setText1("DECIMO SEGUNDA. - EL(LA) CONDUCTOR(A) ");
		parrafo.setText2("se obliga a desvincularse del agricultor una vez el contrato se ha culminado en la " + 
				"fecha de vencimiento del plazo estipulado en la cláusula sexta de este contrato, salvo " + 
				"renovación del mismo.");
		return parrafo;
	}
	
	public WordData subtituloClausulaPena() {
		WordData parrafo = new WordData();
		parrafo.setText1("CLAUSULA PENAL:");
		return parrafo;
	}
	
	public WordData parrafo15() {
		WordData parrafo = new WordData();
		parrafo.setText1("DECIMO TERCERA. - ");
		parrafo.setText2("En caso de incumplimiento de lo estipulado en la cláusula décimo segunda, ");
		parrafo.setText3("EL(LA) CONDUCTOR(A) ");
		parrafo.setText4("deberá pagar en calidad de penalidad compensatorio un " + 
				"importe ascendente a S/. $penalidad$ ($penalidad_letras$), por cada día de " + 
				"demora en la entrega del producto.");
		return parrafo;
	}
	
	public WordData subtituloClausulaGarantia() {
		WordData parrafo = new WordData();
		parrafo.setText1("CLAUSULA DE GARANTÍA:");
		return parrafo;
	}
	
	public WordData parrafo16() {
		WordData parrafo = new WordData();
		parrafo.setText1("DECIMO CUARTA. - ");
		parrafo.setText2("El mencionado depósito en garantía le será devuelto al ");
		parrafo.setText3("CONDUCTOR(A) ");
		parrafo.setText4("sin intereses o rentas, al vencimiento del presente contrato, siempre que no haya sido renovado, y una vez " + 
				"verificado el estado de envio del producto. Las partes dejan establecido que el "
				+ "depósito en garantía, no podrá ser destinado a cubrir ningún tipo de pago de ningún período.");
		return parrafo;
	}
	
	public WordData subtituloClausulaSolucionConflicto() {
		WordData parrafo = new WordData();
		parrafo.setText1("CLAUSULA DE SOLUCION DE CONFLICTOS:");
		return parrafo;
	}
	
	public WordData parrafo17() {
		WordData parrafo = new WordData();
		parrafo.setText1("DECIMO QUINTA. - ");
		parrafo.setText2("El mencionado depósito en garantía le será devuelto al ");
		parrafo.setText3("CONDUCTOR(A) ");
		parrafo.setText4("sin intereses o rentas, al vencimiento del presente contrato, siempre que no haya sido renovado, y una vez " + 
				"verificado el estado de envío del producto. Las partes dejan establecido que el "
				+ "depósito en garantía, no podrá ser destinado a cubrir ningún tipo de pago de ningún período.");
		return parrafo;
	}
	
	public WordData firma() {
		WordData footer = new WordData();
		footer.setText1("AGRICULTOR                                         CONDUCTOR");
		return footer;
	}
}
