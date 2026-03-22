package org.example.breakoutdrop.Errors.Server;

public class ImpossibleContract extends RuntimeException {
    public ImpossibleContract(String message) {
        super(message);
    }
}
