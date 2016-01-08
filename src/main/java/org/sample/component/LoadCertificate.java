package org.sample.component;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class LoadCertificate {
	
	public Certificate getPublicCertificate(String path) throws IOException, CertificateException {
		return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new FileInputStream(path));
	}
}
