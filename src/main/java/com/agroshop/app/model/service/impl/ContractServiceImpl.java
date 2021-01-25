package com.agroshop.app.model.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.agroshop.app.model.entities.ContractEntity;
import com.agroshop.app.model.entities.PostulationEntity;
import com.agroshop.app.model.repository.IContractRepository;
import com.agroshop.app.model.service.IContractService;
import com.agroshop.app.model.service.IPostulationService;
import com.agroshop.app.util.Constants;
import com.agroshop.app.util.ConvertNumberToLetter;
import com.agroshop.app.util.WordConstant;
import com.agroshop.app.util.WordFunction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractServiceImpl implements IContractService {

	@Autowired
	private IContractRepository repoContract;

	@Autowired
	private IPostulationService postulationService;

	private FileOutputStream out;
	private FileInputStream fis;

	@Override
	@Transactional(readOnly = false)
	public ContractEntity registerContract(ContractEntity contract) {
		contract.setStatus(Constants.STATUS_CONTRACT_GENERATED);
		return repoContract.save(contract);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ContractEntity> getContracts() {
		return repoContract.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean deleteContract(Integer id) {
		if (repoContract.existsById(id)) {
			repoContract.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ContractEntity enableContract(ContractEntity contract) throws Throwable {
		PostulationEntity postulation;
		postulation = postulationService.getOneById(contract.getPostulation().getId());
		postulation.setHaveContract(true);
		contract.setStatus(Constants.STATUS_CONTRACT_NO_GENERATED);
		contract.setCreateDate(LocalDateTime.now());
		contract.setUpdateDate(LocalDateTime.now());
		contract.setExpired(false);
		contract.setIsDeleted(false);
		contract.setId(postulation.getId());

		contract.setPostulation(postulation);
		contract.setEndContract(contract.getEndContract());
		contract.setInitDate(contract.getInitDate());
		contract.setNameContract(contract.getNameContract());
		contract.setTimeContract(contract.getTimeContract());
		
		return contract;
	}

	@Override
	public String createContract(ContractEntity contract) throws IOException {

		String directory = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		String randomUIID = UUID.randomUUID().toString();
		String ruta = directory + separator + Constants.RUTA_CONTRATO + separator + randomUIID + ".docx";

		File file = new File(ruta);
		if (!file.createNewFile()) {
			throw new IOException("No se pudo crear el contrato, la ruta no existe");
		}

		ConvertNumberToLetter convertidor = new ConvertNumberToLetter();
		XWPFDocument documento = new XWPFDocument();

		try {
			out = new FileOutputStream(new File(ruta));
			WordConstant constante = new WordConstant();
			String title = constante.titulo().getText1();
			String prfA1 = constante.parrafo1().getText1();
			String prfA2 = constante.parrafo1().getText2();
			String prfA3 = constante.parrafo1().getText3()
					.replace("$agricultor_nombres$",
							contract.getPostulation().getJobOffer().getOrder().getFarmer().getUser().getName())
					.replace("$agricultor_apellidos$",
							contract.getPostulation().getJobOffer().getOrder().getFarmer().getUser().getLastName());
			String prfA4 = constante.parrafo1().getText4().replace("$dni_agricultor$",
					contract.getPostulation().getJobOffer().getOrder().getFarmer().getUser().getDocumentNumber());
			String prfA5 = constante.parrafo1().getText5().replace("$direccion_agricultor$",
					contract.getPostulation().getJobOffer().getOrder().getFarmer().getUser().getAddress());
			String prfA6 = constante.parrafo1().getText6();
			String prfA7 = constante.parrafo1().getText7()
					.replace("$conductor_nombre$", contract.getPostulation().getDriver().getUser().getName())
					.replace("$conductor_apellidos$", contract.getPostulation().getDriver().getUser().getLastName())
					.replace("$dni_conductor$", contract.getPostulation().getDriver().getUser().getDocumentNumber())
					.replace("$direccion_conductor$", contract.getPostulation().getDriver().getUser().getAddress())
					.replace("$anio_experiencia$", contract.getPostulation().getDriver().getYearsOfExperience());

			String subtitleAntece = constante.subtituloAntecedente().getText1();

			String prfB1 = constante.parrafo2().getText1();
			String prfB2 = constante.parrafo2().getText2().replace("$licencia_vehiculo$",
					contract.getPostulation().getDriver().getDriverLicenseNumber());

			String prfC1 = constante.parrafo3().getText1();
			String prfC2 = constante.parrafo3().getText2();

			String subtitleContrat = constante.subtituloObjContrato().getText1();

			String prfD1 = constante.parrafo4().getText1();
			String prfD2 = constante.parrafo4().getText2();
			String prfD3 = constante.parrafo4().getText3();
			String prfD4 = constante.parrafo4().getText4();
			String prfD5 = constante.parrafo4().getText5();
			String prfD6 = constante.parrafo4().getText6();
			String prfD7 = constante.parrafo4().getText7();
			String prfD8 = constante.parrafo4().getText8();
			String prfD9 = constante.parrafo4().getText9();
			String prfD10 = constante.parrafo4().getText10();

			String subtitleOpPago = constante.subituloFormaOportunidad().getText1();

			String prfE1 = constante.parrafo5().getText1();
			String prfE2 = constante.parrafo5().getText2();
			String prfE3 = constante.parrafo5().getText3();
			String prfE4 = constante.parrafo5().getText4()
					.replace("$monto_salario$", contract.getPostulation().getJobOffer().getShippingCost().toString())
					.replace("$monto_salario_letras$", convertidor
							.convertir(contract.getPostulation().getJobOffer().getShippingCost() + "", true));

			String prfF1 = constante.parrafo6().getText1();
			String prfF2 = constante.parrafo6().getText2();
			String prfF3 = constante.parrafo6().getText3();
			String prfF4 = constante.parrafo6().getText4();
			String prfF5 = constante.parrafo6().getText5()
					.replace("$monto_garantia$", contract.getPostulation().getJobOffer().getShippingCost().toString())
					.replace("$monto_garantia_letras$", convertidor
							.convertir(contract.getPostulation().getJobOffer().getShippingCost() + "", true));
			String prfF6 = constante.parrafo6().getText6();

			String prfG1 = constante.parrafo7().getText1();
			String prfG2 = constante.parrafo7().getText2();
			String prfG3 = constante.parrafo7().getText3();
			String prfG4 = constante.parrafo7().getText4();
			String prfG5 = constante.parrafo7().getText5();

			String date_pay = ConvertNumberToLetter.convertMonth(
					contract.getPostulation().getJobOffer().getOrder().getAttendDate().getDayOfMonth(),
					contract.getPostulation().getJobOffer().getOrder().getAttendDate().getMonthValue(),
					contract.getPostulation().getJobOffer().getOrder().getAttendDate().getYear());

			String prfG6 = constante.parrafo7().getText6().replace("$dia_pago_mes$", date_pay);

			String subtitlePlazoContrat = constante.subtituloPlazoContrato().getText1();

			String prfH1 = constante.parrafo8().getText1();

			String init_contract = ConvertNumberToLetter.convertMonth(contract.getInitDate().getDayOfMonth(),
					contract.getInitDate().getDayOfMonth(), contract.getInitDate().getYear());

			String end_contract = ConvertNumberToLetter.convertMonth(contract.getEndContract().getDayOfMonth(),
					contract.getEndContract().getDayOfMonth(), contract.getEndContract().getYear());

			String prfH2 = constante.parrafo8().getText2()
					.replace("$tiempo_contrato$", contract.getTimeContract().toString())
					.replace("$fecha_contrato_inicio$", init_contract).replace("$fecha_contrato_fin$", end_contract)
					.replace("$monto_costo$", contract.getPostulation().getJobOffer().getShippingCost().toString())
					.replace("$origin$",
							"la región de " + contract.getPostulation().getJobOffer().getOriginRegion()
									+ " provincia de " + contract.getPostulation().getJobOffer().getOriginProvince()
									+ " ubicado en el distrito de "
									+ contract.getPostulation().getJobOffer().getOriginDistrict())
					.replace("$peso$", contract.getPostulation().getJobOffer().getTotalWeight().toString());

			String subtitleObligacion = constante.subtituloObligaciones().getText1();

			String prfI1 = constante.parrafo9().getText1();
			String prfI2 = constante.parrafo9().getText2();

			String prfJ1 = constante.parrafo10().getText1();
			String prfJ2 = constante.parrafo10().getText2();

			String prfK1 = constante.parrafo11().getText1();
			String prfK2 = constante.parrafo11().getText2();
			String prfK3 = constante.parrafo11().getText3();
			String prfK4 = constante.parrafo11().getText4();

			String prfL1Arrendatario = constante.parrafo12ReparacionConductor().getText1();
			String prfL2Arrendatario = constante.parrafo12ReparacionConductor().getText2();

			String prfM1 = constante.parrafo13().getText1();
			String prfM2 = constante.parrafo13().getText2();
			String prfM3 = constante.parrafo13().getText3();
			String prfM4 = constante.parrafo13().getText4();

			String prfN1 = constante.parrafo14().getText1();
			String prfN2 = constante.parrafo14().getText2();

			String subtitleClausPena = constante.subtituloClausulaPena().getText1();

			String prfO1 = constante.parrafo15().getText1();
			String prfO2 = constante.parrafo15().getText2();
			String prfO3 = constante.parrafo15().getText3();
			Double penalidad = contract.getPostulation().getJobOffer().getShippingCost() * 0.1;
			String prfO4 = constante.parrafo15().getText4().replace("$penalidad$", penalidad.toString())
					.replace("$penalidad_letras$", convertidor.convertir(penalidad + "", true));

			String subtitleClausuGarant = constante.subtituloClausulaGarantia().getText1();

			String prfP1 = constante.parrafo16().getText1();
			String prfP2 = constante.parrafo16().getText2();
			String prfP3 = constante.parrafo16().getText3();
			String prfP4 = constante.parrafo16().getText4();

			String subtitleClausuSolConflict = constante.subtituloClausulaSolucionConflicto().getText1();

			String prfQ1 = constante.parrafo17().getText1();
			String prfQ2 = constante.parrafo17().getText2();
			String prfQ3 = constante.parrafo17().getText3();
			String prfQ4 = constante.parrafo17().getText4();

			String firma = constante.firma().getText1();

			XWPFParagraph titulo = documento.createParagraph();
			titulo.setAlignment(ParagraphAlignment.CENTER);
			titulo.setVerticalAlignment(TextAlignment.TOP);
			XWPFRun run = titulo.createRun();
			WordFunction.setearTitulo(run, title);

			XWPFParagraph parrafoA = documento.createParagraph();
			parrafoA.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aA = parrafoA.createRun();
			WordFunction.setearParrafoNormal(aA, prfA1);
			XWPFRun bA = parrafoA.createRun();
			WordFunction.setearParrafoNegrita(bA, prfA2);
			XWPFRun cA = parrafoA.createRun();
			WordFunction.setearParrafoNormal(cA, prfA3);
			XWPFRun dA = parrafoA.createRun();
			WordFunction.setearParrafoNegrita(dA, prfA4);
			XWPFRun eA = parrafoA.createRun();
			WordFunction.setearParrafoNormal(eA, prfA5);
			XWPFRun fA = parrafoA.createRun();
			WordFunction.setearParrafoNegrita(fA, prfA6);
			XWPFRun gA = parrafoA.createRun();
			WordFunction.setearParrafoNormal(gA, prfA7);
			gA.addBreak();

			XWPFParagraph subtituloAntecedente = documento.createParagraph();
			subtituloAntecedente.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun subAnte = subtituloAntecedente.createRun();
			WordFunction.setearParrafoSubrayadoYNegrita(subAnte, subtitleAntece);

			XWPFParagraph parrafoB = documento.createParagraph();
			parrafoB.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aB = parrafoB.createRun();
			WordFunction.setearParrafoNegrita(aB, prfB1);
			XWPFRun bB = parrafoB.createRun();
			WordFunction.setearParrafoNormal(bB, prfB2);

			XWPFParagraph parrafoC = documento.createParagraph();
			parrafoC.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aC = parrafoC.createRun();
			WordFunction.setearParrafoNegrita(aC, prfC1);
			XWPFRun bC = parrafoC.createRun();
			WordFunction.setearParrafoNormal(bC, prfC2);
			bC.addBreak();

			XWPFParagraph subtituloContrato = documento.createParagraph();
			subtituloContrato.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun subCont = subtituloContrato.createRun();
			WordFunction.setearParrafoSubrayadoYNegrita(subCont, subtitleContrat);

			XWPFParagraph parrafoD = documento.createParagraph();
			parrafoD.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aD = parrafoD.createRun();
			WordFunction.setearParrafoNegrita(aD, prfD1);
			XWPFRun bD = parrafoD.createRun();
			WordFunction.setearParrafoNormal(bD, prfD2);
			XWPFRun cD = parrafoD.createRun();
			WordFunction.setearParrafoNegrita(cD, prfD3);
			XWPFRun dD = parrafoD.createRun();
			WordFunction.setearParrafoNormal(dD, prfD4);
			XWPFRun eD = parrafoD.createRun();
			WordFunction.setearParrafoNegrita(eD, prfD5);
			XWPFRun fD = parrafoD.createRun();
			WordFunction.setearParrafoNormal(fD, prfD6);
			XWPFRun gD = parrafoD.createRun();
			WordFunction.setearParrafoNegrita(gD, prfD7);
			XWPFRun hD = parrafoD.createRun();
			WordFunction.setearParrafoNormal(hD, prfD8);
			XWPFRun iD = parrafoD.createRun();
			WordFunction.setearParrafoNegrita(iD, prfD9);
			XWPFRun jD = parrafoD.createRun();
			WordFunction.setearParrafoNormal(jD, prfD10);
			jD.addBreak();

			XWPFParagraph subtituloOportPago = documento.createParagraph();
			subtituloOportPago.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun subOpPago = subtituloOportPago.createRun();
			WordFunction.setearParrafoSubrayadoYNegrita(subOpPago, subtitleOpPago);

			XWPFParagraph parrafoE = documento.createParagraph();
			parrafoE.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aE = parrafoE.createRun();
			WordFunction.setearParrafoNegrita(aE, prfE1);
			XWPFRun bE = parrafoE.createRun();
			WordFunction.setearParrafoNormal(bE, prfE2);
			XWPFRun cE = parrafoE.createRun();
			WordFunction.setearParrafoNegrita(cE, prfE3);
			XWPFRun dE = parrafoE.createRun();
			WordFunction.setearParrafoNormal(dE, prfE4);

			XWPFParagraph parrafoF = documento.createParagraph();
			parrafoF.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aF = parrafoF.createRun();
			WordFunction.setearParrafoNormal(aF, prfF1);
			XWPFRun bF = parrafoF.createRun();
			WordFunction.setearParrafoNegrita(bF, prfF2);
			XWPFRun cF = parrafoF.createRun();
			WordFunction.setearParrafoNormal(cF, prfF3);
			XWPFRun dF = parrafoF.createRun();
			WordFunction.setearParrafoNegrita(dF, prfF4);
			XWPFRun eF = parrafoF.createRun();
			WordFunction.setearParrafoNormal(eF, prfF5);
			XWPFRun fF = parrafoF.createRun();
			WordFunction.setearParrafoNegrita(fF, prfF6);

			XWPFParagraph parrafoG = documento.createParagraph();
			parrafoG.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aG = parrafoG.createRun();
			WordFunction.setearParrafoNegrita(aG, prfG1);
			XWPFRun bG = parrafoG.createRun();
			WordFunction.setearParrafoNormal(bG, prfG2);
			XWPFRun cG = parrafoG.createRun();
			WordFunction.setearParrafoNegrita(cG, prfG3);
			XWPFRun dG = parrafoG.createRun();
			WordFunction.setearParrafoNormal(dG, prfG4);
			XWPFRun eG = parrafoG.createRun();
			WordFunction.setearParrafoNegrita(eG, prfG5);
			XWPFRun fG = parrafoG.createRun();
			WordFunction.setearParrafoNormal(fG, prfG6);
			fG.addBreak();

			XWPFParagraph subtituloPlazoContrato = documento.createParagraph();
			subtituloPlazoContrato.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun subPlzContr = subtituloPlazoContrato.createRun();
			WordFunction.setearParrafoSubrayadoYNegrita(subPlzContr, subtitlePlazoContrat);

			XWPFParagraph parrafoH = documento.createParagraph();
			parrafoH.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aH = parrafoH.createRun();
			WordFunction.setearParrafoNegrita(aH, prfH1);
			XWPFRun bH = parrafoH.createRun();
			WordFunction.setearParrafoNormal(bH, prfH2);
			bH.addBreak();

			XWPFParagraph subtituloOblPartes = documento.createParagraph();
			subtituloOblPartes.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun subOblPart = subtituloOblPartes.createRun();
			WordFunction.setearParrafoSubrayadoYNegrita(subOblPart, subtitleObligacion);

			XWPFParagraph parrafoI = documento.createParagraph();
			parrafoI.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aI = parrafoI.createRun();
			WordFunction.setearParrafoNegrita(aI, prfI1);
			XWPFRun bI = parrafoI.createRun();
			WordFunction.setearParrafoNormal(bI, prfI2);

			XWPFParagraph parrafoJ = documento.createParagraph();
			parrafoJ.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aJ = parrafoJ.createRun();
			WordFunction.setearParrafoNegrita(aJ, prfJ1);
			XWPFRun bJ = parrafoJ.createRun();
			WordFunction.setearParrafoNormal(bJ, prfJ2);

			XWPFParagraph parrafoK = documento.createParagraph();
			parrafoK.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aK = parrafoK.createRun();
			WordFunction.setearParrafoNegrita(aK, prfK1);
			XWPFRun bK = parrafoK.createRun();
			WordFunction.setearParrafoNormal(bK, prfK2);
			XWPFRun cK = parrafoK.createRun();
			WordFunction.setearParrafoNegrita(cK, prfK3);
			XWPFRun dK = parrafoK.createRun();
			WordFunction.setearParrafoNormal(dK, prfK4);

			XWPFParagraph parrafoL = documento.createParagraph();
			parrafoL.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aL = parrafoL.createRun();
			WordFunction.setearParrafoNegrita(aL, prfL1Arrendatario);
			XWPFRun bL = parrafoL.createRun();
			WordFunction.setearParrafoNormal(bL, prfL2Arrendatario);
			XWPFParagraph parrafoM = documento.createParagraph();
			parrafoM.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aM = parrafoM.createRun();
			WordFunction.setearParrafoNegrita(aM, prfM1);
			XWPFRun bM = parrafoM.createRun();
			WordFunction.setearParrafoNormal(bM, prfM2);
			XWPFRun cM = parrafoM.createRun();
			WordFunction.setearParrafoNegrita(cM, prfM3);
			XWPFRun dM = parrafoM.createRun();
			WordFunction.setearParrafoNormal(dM, prfM4);

			XWPFParagraph parrafoN = documento.createParagraph();
			parrafoN.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aN = parrafoN.createRun();
			WordFunction.setearParrafoNegrita(aN, prfN1);
			XWPFRun bN = parrafoN.createRun();
			WordFunction.setearParrafoNormal(bN, prfN2);
			bN.addBreak();

			XWPFParagraph subtituloClausuPenal = documento.createParagraph();
			subtituloClausuPenal.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun subClauPen = subtituloClausuPenal.createRun();
			WordFunction.setearParrafoSubrayadoYNegrita(subClauPen, subtitleClausPena);

			XWPFParagraph parrafoO = documento.createParagraph();
			parrafoO.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aO = parrafoO.createRun();
			WordFunction.setearParrafoNegrita(aO, prfO1);
			XWPFRun bO = parrafoO.createRun();
			WordFunction.setearParrafoNormal(bO, prfO2);
			XWPFRun cO = parrafoO.createRun();
			WordFunction.setearParrafoNegrita(cO, prfO3);
			XWPFRun dO = parrafoO.createRun();
			WordFunction.setearParrafoNormal(dO, prfO4);
			dO.addBreak();

			XWPFParagraph subtituloClausuGarantia = documento.createParagraph();
			subtituloClausuGarantia.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun subClauGara = subtituloClausuGarantia.createRun();
			WordFunction.setearParrafoSubrayadoYNegrita(subClauGara, subtitleClausuGarant);

			XWPFParagraph parrafoP = documento.createParagraph();
			parrafoP.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aP = parrafoP.createRun();
			WordFunction.setearParrafoNegrita(aP, prfP1);
			XWPFRun bP = parrafoP.createRun();
			WordFunction.setearParrafoNormal(bP, prfP2);
			XWPFRun cP = parrafoP.createRun();
			WordFunction.setearParrafoNegrita(cP, prfP3);
			XWPFRun dP = parrafoP.createRun();
			WordFunction.setearParrafoNormal(dP, prfP4);
			dP.addBreak();

			XWPFParagraph subtituloClausuConflicto = documento.createParagraph();
			subtituloClausuConflicto.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun subClauConf = subtituloClausuConflicto.createRun();
			WordFunction.setearParrafoSubrayadoYNegrita(subClauConf, subtitleClausuSolConflict);

			XWPFParagraph parrafoQ = documento.createParagraph();
			parrafoQ.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun aQ = parrafoQ.createRun();
			WordFunction.setearParrafoNegrita(aQ, prfQ1);
			XWPFRun bQ = parrafoQ.createRun();
			WordFunction.setearParrafoNormal(bQ, prfQ2);
			XWPFRun cQ = parrafoQ.createRun();
			WordFunction.setearParrafoNegrita(cQ, prfQ3);
			XWPFRun dQ = parrafoQ.createRun();
			WordFunction.setearParrafoNormal(dQ, prfQ4);
			dQ.addBreak();
			dQ.addBreak();
			dQ.addBreak();
			dQ.addBreak();
			dQ.addBreak();
			dQ.addBreak();
			dQ.addBreak();
			dQ.addBreak();

			XWPFParagraph parrafoFirma = documento.createParagraph();
			parrafoFirma.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun aFirma = parrafoFirma.createRun();
			WordFunction.setearParrafoNegrita(aFirma, firma);
			documento.write(out);

		} catch (Exception e) {
			throw e;
		} finally {
			documento.close();
			out.close();
		}

		return randomUIID;

	}

	@Override
	public byte[] getContract(Integer id) throws Throwable {
		byte[] bArray;
		try {
			ContractEntity contract = findByPostulationId(id);	
			String directorio = System.getProperty("user.dir");
			String separador = System.getProperty("file.separator");
			String ruta = directorio + separador + Constants.RUTA_CONTRATO + separador + contract.getFileContract() + ".docx";
			File archivo = new File(ruta);
			fis = new FileInputStream(archivo);
			bArray = new byte[(int) archivo.length()];
			while(fis.read(bArray) > 0) {
				
			}
		} catch (Exception e) {
			throw e;
		} finally {
			fis.close();
		}
		return bArray;
	}


	public ContractEntity findByPostulationId(Integer postulationId) throws Throwable {
		return repoContract.findByPostulationId(postulationId);
	}

}
