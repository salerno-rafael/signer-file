package org.sample;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import org.sample.component.Signer;
import org.sample.configuration.Parameter;

import com.itextpdf.text.DocumentException;

public class Main {

	public static void main(String[] args)	throws IOException, DocumentException, CertificateException, NoSuchAlgorithmException {
		new Signer().singFile(Parameter.FILE_PATH, Parameter.DESTINATION, Parameter.CERTIFICATE);
	}
}
