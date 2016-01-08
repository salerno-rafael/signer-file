package org.sample.component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class Signer {

	private static Logger logger = Logger.getLogger(Signer.class);
	private LoadCertificate certificate;

	public Signer() {
		this.certificate = new LoadCertificate();
	}

	public void singFile(String filePath, String destinatioFile, String certificationPath)	throws IOException, DocumentException, CertificateException, NoSuchAlgorithmException {
		logger.info("starting sign file");
		Security.addProvider(new BouncyCastleProvider());

		PdfReader pdfReader = new PdfReader(filePath);
		logger.info("opening file to sign");
		
		PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(destinatioFile));
		logger.info("adding certificate into file");
		pdfStamper.setEncryption(
				new Certificate[] { certificate.getPublicCertificate(certificationPath) },
				new int[] { PdfWriter.ALLOW_PRINTING }, PdfWriter.STANDARD_ENCRYPTION_128);

		pdfStamper.createXmpMetadata();
		
		logger.info("certificate added in file");
		pdfStamper.close();
	}

}
