package de.butatopanto.xmlsig;

@SuppressWarnings("serial")
public class SignatureNotFound extends RuntimeException {

    public SignatureNotFound() {
        super("Cannot find Signature element.");
    }
}
