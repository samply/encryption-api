package de.samply.encryption.encryptionapi.controller;

import de.samply.encryption.encryptionapi.mapper.EncryptionModelMapper;
import de.samply.project.encryption.api.EncryptionApi;
import de.samply.project.encryption.model.StringRequest;
import de.samply.project.encryption.model.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
public class EncryptionController implements EncryptionApi {
    @Autowired
    private EncryptionService service;

    @Override
    public ResponseEntity<StringResponse> getPublicKeyAsymmetric() {
        String publicKeyAsymmetric = service.getPublicKeyAsymmetric();
        return ResponseEntity.ok(EncryptionModelMapper.stringToStringResponse(publicKeyAsymmetric));
    }

    @Override
    public ResponseEntity<StringResponse> getPrivateKeyAsymmetric() {
        String privateKeyAsymmetric = service.getPrivateKeyAsymmetric();
        return ResponseEntity.ok(EncryptionModelMapper.stringToStringResponse(privateKeyAsymmetric));
    }

    @Override
    public ResponseEntity<StringResponse> setPublicKeyAsymmetricGet(String publicKeyAsymmetric) {
        String response = service.setPublicKeyAsymmetric(publicKeyAsymmetric);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> setPublicKeyAsymmetricPost(@Valid StringRequest request) {
        String publicKeyAsymmetric = EncryptionModelMapper.stringRequestToString(request);
        String response = service.setPublicKeyAsymmetric(publicKeyAsymmetric);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> setPrivateKeyAsymmetricGet(String privateKeyAsymmetric) {
        String response = service.setPrivateKeyAsymmetric(privateKeyAsymmetric);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> setPrivateKeyAsymmetricPost(@Valid StringRequest request) {
        String privateKeyAsymmetric = EncryptionModelMapper.stringRequestToString(request);
        String response = service.setPrivateKeyAsymmetric(privateKeyAsymmetric);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> encryptAsymmetricGet(String string) {
        String response = service.encryptAsymmetric(string);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> encryptAsymmetricPost(@Valid StringRequest request) {
        String string = EncryptionModelMapper.stringRequestToString(request);
        String response = service.encryptAsymmetric(string);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> decryptAsymmetricGet(String string) {
        String response = service.decryptAsymmetric(string);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> decryptAsymmetricPost(@Valid StringRequest request) {
        String string = EncryptionModelMapper.stringRequestToString(request);
        String response = service.decryptAsymmetric(string);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> getKeySymmetric() {
        String keySymmetric = service.getKeySymmetric();
        return ResponseEntity.ok(EncryptionModelMapper.stringToStringResponse(keySymmetric));
    }

    @Override
    public ResponseEntity<StringResponse> setKeySymmetricGet(String keySymmetric) {
        String response = service.setKeySymmetric(keySymmetric);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> setKeySymmetricPost(@Valid StringRequest request) {
        String keySymmetric = EncryptionModelMapper.stringRequestToString(request);
        String response = service.setKeySymmetric(keySymmetric);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> encryptSymmetricGet(String string) {
        String response = service.encryptSymmetric(string);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> encryptSymmetricPost(@Valid StringRequest request) {
        String string = EncryptionModelMapper.stringRequestToString(request);
        String response = service.encryptSymmetric(string);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> decryptSymmetricGet(String string) {
        String response = service.decryptSymmetric(string);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }

    @Override
    public ResponseEntity<StringResponse> decryptSymmetricPost(@Valid StringRequest request) {
        String string = EncryptionModelMapper.stringRequestToString(request);
        String response = service.decryptSymmetric(string);
        StringResponse stringResponse = EncryptionModelMapper.stringToStringResponse(response);
        return ResponseEntity.status(CREATED).body(stringResponse);
    }
}
