package de.butatopanto.xmlsig;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/**
 * 
 * @author Markus Flingelli
 *
 */
public class PublicKeyData {
	private String fileName;
	
	public PublicKeyData(String fileName) {
		this.fileName = fileName;
	}

	public PublicKey getPublicKey() throws CertificateException, IOException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream(fileName);
        DataInputStream dis = new DataInputStream(fis);
        byte[] bytes = new byte[dis.available()];
        dis.readFully(bytes);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        return cf.generateCertificate(bais).getPublicKey();
	}
}
