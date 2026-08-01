package com.github.robsonrjunior.gestao.tickets.security;

import com.github.robsonrjunior.gestao.tickets.model.User;
import com.github.robsonrjunior.gestao.tickets.repository.UserRepository;
import com.github.robsonrjunior.gestao.tickets.service.PasswordHasher;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import java.util.Set;

@ApplicationScoped
public class DatabaseIdentityStore implements IdentityStore {

    @Inject
    private UserRepository repository;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (!(credential instanceof UsernamePasswordCredential upc)) {
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }
        User user = repository.findByUsername(upc.getCaller()).orElse(null);
        if (user == null || !PasswordHasher.check(upc.getPasswordAsString(), user.getPassword())) {
            return CredentialValidationResult.INVALID_RESULT;
        }
        return new CredentialValidationResult(user.getUsername(), Set.of(user.getRole().name()));
    }
}
